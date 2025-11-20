package com.mamajulit.View.OrdenRecepcion;

import com.mamajulit.Controller.OrdenRecepcion.OrdenRecepcionActualizarController;
import com.mamajulit.Model.OrdenRecepcion;
import com.mamajulit.Model.ConexionBD;
import com.mamajulit.Util.ValidationUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class OrdenRecepcionActualizarDialog extends JDialog {

    private JTextField txtDescripcion, txtLote, txtTipo, txtCantidad, txtHora, txtFecha, txtAlmacen, txtPesoTotal;
    private JTextArea txtObservaciones;
    private JComboBox<Integer> cbEmitidoPor, cbEntregadoPor, cbIdTicket;
    private JComboBox<String> cbPlaca;
    private final OrdenRecepcionGestionView parent;
    private final int codigo;

    public OrdenRecepcionActualizarDialog(Window owner, OrdenRecepcionGestionView parent, int codigo) {
        super(owner, "Actualizar Orden - Recepción", ModalityType.APPLICATION_MODAL);
        this.parent = parent;
        this.codigo = codigo;
        setSize(600, 520);
        setLocationRelativeTo(owner);

        // inicializar componentes (igual que insert)
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6,6,6,6);
        c.fill = GridBagConstraints.HORIZONTAL;

        txtDescripcion = new JTextField();
        txtLote = new JTextField();
        txtTipo = new JTextField();
        txtCantidad = new JTextField();
        txtHora = new JTextField(); // formato HH:mm:ss
        txtFecha = new JTextField(); // formato yyyy-MM-dd
        txtAlmacen = new JTextField();
        txtPesoTotal = new JTextField();
        txtObservaciones = new JTextArea(4, 20);

        cbEmitidoPor = new JComboBox<>();
        cbEntregadoPor = new JComboBox<>();
        cbIdTicket = new JComboBox<>();
        cbPlaca = new JComboBox<>();

        OrdenRecepcionGestionView.llenarComboEmpleado(cbEmitidoPor);
        OrdenRecepcionGestionView.llenarComboEmpleado(cbEntregadoPor);
        OrdenRecepcionGestionView.llenarComboTicket(cbIdTicket);
        OrdenRecepcionGestionView.llenarComboVehiculo(cbPlaca);

        int row = 0;
        c.gridx = 0; c.gridy = row; form.add(new JLabel("Descripción:"), c);
        c.gridx = 1; c.gridy = row++; form.add(txtDescripcion, c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Lote:"), c);
        c.gridx = 1; c.gridy = row++; form.add(txtLote, c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Tipo:"), c);
        c.gridx = 1; c.gridy = row++; form.add(txtTipo, c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Cantidad:"), c);
        c.gridx = 1; c.gridy = row++; form.add(txtCantidad, c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Hora (HH:mm:ss):"), c);
        c.gridx = 1; c.gridy = row++; form.add(txtHora, c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Fecha (yyyy-MM-dd):"), c);
        c.gridx = 1; c.gridy = row++; form.add(txtFecha, c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Almacén:"), c);
        c.gridx = 1; c.gridy = row++; form.add(txtAlmacen, c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Peso Total:"), c);
        c.gridx = 1; c.gridy = row++; form.add(txtPesoTotal, c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Observaciones:"), c);
        c.gridx = 1; c.gridy = row++; form.add(new JScrollPane(txtObservaciones), c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Emitido por (Id_empleado):"), c);
        c.gridx = 1; c.gridy = row++; form.add(cbEmitidoPor, c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Entregado por (Id_empleado):"), c);
        c.gridx = 1; c.gridy = row++; form.add(cbEntregadoPor, c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Id Ticket (Id_ticket):"), c);
        c.gridx = 1; c.gridy = row++; form.add(cbIdTicket, c);

        c.gridx = 0; c.gridy = row; form.add(new JLabel("Placa Vehículo:"), c);
        c.gridx = 1; c.gridy = row++; form.add(cbPlaca, c);

        JButton btnGuardar = new JButton("Actualizar");
        btnGuardar.addActionListener(e -> actualizar());
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botones.add(btnCancelar);
        botones.add(btnGuardar);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(form), BorderLayout.CENTER);
        getContentPane().add(botones, BorderLayout.SOUTH);

        cargarDatos();
    }

    private void cargarDatos() {
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT * FROM orden_recepcion WHERE Codigo_recepcion = ?")) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    txtDescripcion.setText(rs.getString("Descripcion"));
                    txtLote.setText(rs.getString("Lote"));
                    txtTipo.setText(rs.getString("Tipo"));
                    txtCantidad.setText(rs.getString("Cantidad") == null ? "" : String.valueOf(rs.getInt("Cantidad")));
                    Time hora = rs.getTime("Hora");
                    txtHora.setText(hora == null ? "" : hora.toString());
                    Date fecha = rs.getDate("Fecha");
                    txtFecha.setText(fecha == null ? "" : fecha.toString());
                    txtAlmacen.setText(rs.getString("Almacen"));
                    txtPesoTotal.setText(rs.getString("Peso_total") == null ? "" : String.valueOf(rs.getFloat("Peso_total")));
                    txtObservaciones.setText(rs.getString("Observaciones"));
                    Integer emitido = rs.getInt("Emitido_por");
                    if (!rs.wasNull()) cbEmitidoPor.setSelectedItem(emitido);
                    Integer entregado = rs.getInt("Entregado_por");
                    if (!rs.wasNull()) cbEntregadoPor.setSelectedItem(entregado);
                    Integer idticket = rs.getInt("Id_ticket");
                    if (!rs.wasNull()) cbIdTicket.setSelectedItem(idticket);
                    String placa = rs.getString("Placa_vehiculo");
                    if (placa != null) cbPlaca.setSelectedItem(placa);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró la orden seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizar() {
        // Validaciones obligatorias (misma lógica que insert)
        if (!ValidationUtil.isNotEmpty(txtDescripcion.getText())) {
            JOptionPane.showMessageDialog(this, "La descripción es obligatoria.", "Validación", JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }
        if (!ValidationUtil.isNotEmpty(txtLote.getText())) {
            JOptionPane.showMessageDialog(this, "El lote es obligatorio.", "Validación", JOptionPane.WARNING_MESSAGE);
            txtLote.requestFocus();
            return;
        }
        if (!ValidationUtil.isNotEmpty(txtTipo.getText())) {
            JOptionPane.showMessageDialog(this, "El tipo es obligatorio.", "Validación", JOptionPane.WARNING_MESSAGE);
            txtTipo.requestFocus();
            return;
        }
        if (!ValidationUtil.isInteger(txtCantidad.getText())) {
            JOptionPane.showMessageDialog(this, "La cantidad es obligatoria y debe ser un número entero.", "Validación", JOptionPane.WARNING_MESSAGE);
            txtCantidad.requestFocus();
            return;
        }
        if (!ValidationUtil.isValidTime(txtHora.getText())) {
            JOptionPane.showMessageDialog(this, "La hora es obligatoria y debe tener formato HH:mm:ss.", "Validación", JOptionPane.WARNING_MESSAGE);
            txtHora.requestFocus();
            return;
        }
        if (!ValidationUtil.isValidDate(txtFecha.getText())) {
            JOptionPane.showMessageDialog(this, "La fecha es obligatoria y debe tener formato yyyy-MM-dd.", "Validación", JOptionPane.WARNING_MESSAGE);
            txtFecha.requestFocus();
            return;
        }
        if (!ValidationUtil.isNotEmpty(txtAlmacen.getText())) {
            JOptionPane.showMessageDialog(this, "El almacén es obligatorio.", "Validación", JOptionPane.WARNING_MESSAGE);
            txtAlmacen.requestFocus();
            return;
        }
        if (!ValidationUtil.isFloat(txtPesoTotal.getText())) {
            JOptionPane.showMessageDialog(this, "El peso total es obligatorio y debe ser numérico.", "Validación", JOptionPane.WARNING_MESSAGE);
            txtPesoTotal.requestFocus();
            return;
        }
        if (cbEmitidoPor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona quién emitió la orden.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cbEntregadoPor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona quién entregó la orden.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cbIdTicket.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona el ticket asociado.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cbPlaca.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona la placa del vehículo.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        OrdenRecepcion o = new OrdenRecepcion();
        o.setCodigoRecepcion(codigo);
        o.setDescripcion(txtDescripcion.getText().trim());
        o.setLote(txtLote.getText().trim());
        o.setTipo(txtTipo.getText().trim());
        o.setCantidad(Integer.parseInt(txtCantidad.getText().trim()));
        o.setHora(Time.valueOf(txtHora.getText().trim()));
        o.setFecha(java.sql.Date.valueOf(txtFecha.getText().trim()));
        o.setAlmacen(txtAlmacen.getText().trim());
        o.setPesoTotal(Float.parseFloat(txtPesoTotal.getText().trim()));
        o.setObservaciones(txtObservaciones.getText().trim().isEmpty() ? null : txtObservaciones.getText().trim());
        o.setEmitidoPor((Integer) cbEmitidoPor.getSelectedItem());
        o.setEntregadoPor((Integer) cbEntregadoPor.getSelectedItem());
        o.setIdTicket((Integer) cbIdTicket.getSelectedItem());
        o.setPlacaVehiculo((String) cbPlaca.getSelectedItem());

        OrdenRecepcionActualizarController ac = new OrdenRecepcionActualizarController();
        boolean ok = ac.actualizar(o, "admin");
        if (ok) {
            JOptionPane.showMessageDialog(this, "Orden actualizada.");
            parent.cargarTodos();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar. Ver consola para más detalles.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
