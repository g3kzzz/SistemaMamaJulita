package com.mamajulit.View.OrdenRecepcion;

import com.mamajulit.Controller.OrdenRecepcion.OrdenRecepcionInsertarController;
import com.mamajulit.Model.OrdenRecepcion;
import com.mamajulit.Util.ValidationUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;

public class OrdenRecepcionInsertarDialog extends JDialog {

    private JTextField txtDescripcion, txtLote, txtTipo, txtCantidad, txtHora, txtFecha, txtAlmacen, txtPesoTotal;
    private JTextArea txtObservaciones;
    private JComboBox<Integer> cbEmitidoPor, cbEntregadoPor, cbIdTicket;
    private JComboBox<String> cbPlaca;
    private final OrdenRecepcionGestionView parent;

    public OrdenRecepcionInsertarDialog(Window owner, OrdenRecepcionGestionView parent) {
        super(owner, "Insertar Orden - Recepción", ModalityType.APPLICATION_MODAL);
        this.parent = parent;
        setSize(600, 520);
        setLocationRelativeTo(owner);

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

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardar());
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botones.add(btnCancelar);
        botones.add(btnGuardar);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(form), BorderLayout.CENTER);
        getContentPane().add(botones, BorderLayout.SOUTH);
    }

    private void guardar() {
        // Validaciones de campo obligatorio (según tus SI/NO)
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

        OrdenRecepcionInsertarController ic = new OrdenRecepcionInsertarController();
        boolean ok = ic.insertar(o, "admin"); // reemplaza "admin" por usuario actual
        if (ok) {
            JOptionPane.showMessageDialog(this, "Orden insertada correctamente.");
            parent.cargarTodos();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al insertar la orden. Revisa la consola para más detalles.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
