package com.mamajulit.View.TicketPesado;

import com.mamajulit.Controller.TicketPesado.TicketPesadoActualizarController;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import com.mamajulit.Model.ConexionBD;

public class TicketPesadoActualizarDialog extends JDialog {

    private JTextField txtFechaSalida, txtFechaIngreso, txtMontoTotal, txtPesoPromedio,
            txtGenero, txtCantidad, txtMortalidad, txtDestino, txtMerma;
    private JComboBox<String> cbVehiculo, cbConductor, cbPlantel;
    private final TicketPesadoGestionView parent;
    private final int id_ticket;

    public TicketPesadoActualizarDialog(TicketPesadoGestionView parent,
                                        int id_ticket, String fecha_salida, String fecha_ingreso,
                                        float monto_total, float peso_promedio, String genero_pollo,
                                        int cantidad_pollo, int mortalidad, String destino, float merma,
                                        String placa_vehiculo, String id_conductor, String id_plantel) {

        this.parent = parent;
        this.id_ticket = id_ticket;

        setTitle("Actualizar Ticket Pesado");
        setModal(true);
        setSize(450, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(12, 2, 5, 5));

        txtFechaSalida = new JTextField(fecha_salida);
        txtFechaIngreso = new JTextField(fecha_ingreso);
        txtMontoTotal = new JTextField(String.valueOf(monto_total));
        txtPesoPromedio = new JTextField(String.valueOf(peso_promedio));
        txtGenero = new JTextField(genero_pollo);
        txtCantidad = new JTextField(String.valueOf(cantidad_pollo));
        txtMortalidad = new JTextField(String.valueOf(mortalidad));
        txtDestino = new JTextField(destino);
        txtMerma = new JTextField(String.valueOf(merma));

        cbVehiculo = new JComboBox<>();
        cbConductor = new JComboBox<>();
        cbPlantel = new JComboBox<>();

        llenarComboBox("Vehiculo", "Placa", cbVehiculo, placa_vehiculo);
        llenarComboBox("Conductor", "Nro_Licencia", cbConductor, id_conductor);
        llenarComboBox("Plantel", "Id_plantel", cbPlantel, id_plantel);

        form.add(new JLabel("Fecha Salida:")); form.add(txtFechaSalida);
        form.add(new JLabel("Fecha Ingreso:")); form.add(txtFechaIngreso);
        form.add(new JLabel("Monto Total:")); form.add(txtMontoTotal);
        form.add(new JLabel("Peso Promedio:")); form.add(txtPesoPromedio);
        form.add(new JLabel("Genero Pollo:")); form.add(txtGenero);
        form.add(new JLabel("Cantidad Pollo:")); form.add(txtCantidad);
        form.add(new JLabel("Mortalidad:")); form.add(txtMortalidad);
        form.add(new JLabel("Destino:")); form.add(txtDestino);
        form.add(new JLabel("Merma:")); form.add(txtMerma);
        form.add(new JLabel("Vehiculo:")); form.add(cbVehiculo);
        form.add(new JLabel("Conductor:")); form.add(cbConductor);
        form.add(new JLabel("Plantel:")); form.add(cbPlantel);

        add(form, BorderLayout.CENTER);

        JButton btnGuardar = new JButton("Actualizar");
        btnGuardar.addActionListener(e -> actualizarTicket());
        add(btnGuardar, BorderLayout.SOUTH);
    }

    private void llenarComboBox(String tabla, String columna, JComboBox<String> combo, String seleccionado) {
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT " + columna + " FROM " + tabla);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                combo.addItem(rs.getString(columna));
            }
            combo.setSelectedItem(seleccionado);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al llenar combo: " + e.getMessage());
        }
    }

    private void actualizarTicket() {
        StringBuilder errores = new StringBuilder();
        LocalDate fechaSalida = null, fechaIngreso = null;
        float montoTotal = 0, pesoPromedio = 0, merma = 0;
        int cantidad = 0, mortalidad = 0;

        // Validaciones de campos vacíos
        if (txtFechaSalida.getText().isBlank()) errores.append("Fecha de salida es obligatoria.\n");
        if (txtFechaIngreso.getText().isBlank()) errores.append("Fecha de ingreso es obligatoria.\n");
        if (txtMontoTotal.getText().isBlank()) errores.append("Monto total es obligatorio.\n");
        if (txtPesoPromedio.getText().isBlank()) errores.append("Peso promedio es obligatorio.\n");
        if (txtGenero.getText().isBlank()) errores.append("Genero pollo es obligatorio.\n");
        if (txtCantidad.getText().isBlank()) errores.append("Cantidad pollo es obligatoria.\n");
        if (txtMortalidad.getText().isBlank()) errores.append("Mortalidad es obligatoria.\n");
        if (txtDestino.getText().isBlank()) errores.append("Destino es obligatorio.\n");
        if (txtMerma.getText().isBlank()) errores.append("Merma es obligatoria.\n");

        // Validaciones de ComboBox
        if (cbVehiculo.getSelectedItem() == null) errores.append("Vehiculo debe seleccionarse.\n");
        if (cbConductor.getSelectedItem() == null) errores.append("Conductor debe seleccionarse.\n");
        if (cbPlantel.getSelectedItem() == null) errores.append("Plantel debe seleccionarse.\n");

        // Validaciones de números
        try { montoTotal = Float.parseFloat(txtMontoTotal.getText()); } catch(Exception e) { errores.append("Monto total inválido.\n"); }
        try { pesoPromedio = Float.parseFloat(txtPesoPromedio.getText()); } catch(Exception e) { errores.append("Peso promedio inválido.\n"); }
        try { cantidad = Integer.parseInt(txtCantidad.getText()); } catch(Exception e) { errores.append("Cantidad inválida.\n"); }
        try { mortalidad = Integer.parseInt(txtMortalidad.getText()); } catch(Exception e) { errores.append("Mortalidad inválida.\n"); }
        try { merma = Float.parseFloat(txtMerma.getText()); } catch(Exception e) { errores.append("Merma inválida.\n"); }

        // Validaciones de fechas
        try { fechaSalida = LocalDate.parse(txtFechaSalida.getText()); } catch(DateTimeParseException e) { errores.append("Fecha salida inválida (YYYY-MM-DD).\n"); }
        try { fechaIngreso = LocalDate.parse(txtFechaIngreso.getText()); } catch(DateTimeParseException e) { errores.append("Fecha ingreso inválida (YYYY-MM-DD).\n"); }

        LocalDate hoy = LocalDate.now();
        if (fechaSalida != null && fechaSalida.isAfter(hoy)) errores.append("Fecha de salida no puede ser mayor a hoy.\n");
        if (fechaIngreso != null && fechaIngreso.isAfter(hoy)) errores.append("Fecha de ingreso no puede ser mayor a hoy.\n");
        if (fechaSalida != null && fechaIngreso != null && fechaSalida.isBefore(fechaIngreso)) errores.append("Fecha de salida no puede ser menor a fecha de ingreso.\n");

        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(this, errores.toString(), "Errores de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            TicketPesadoActualizarController ctrl = new TicketPesadoActualizarController();
            boolean ok = ctrl.actualizarTicket(
                    id_ticket,
                    txtFechaSalida.getText(),
                    txtFechaIngreso.getText(),
                    montoTotal,
                    pesoPromedio,
                    txtGenero.getText(),
                    cantidad,
                    mortalidad,
                    txtDestino.getText(),
                    merma,
                    cbVehiculo.getSelectedItem().toString(),
                    cbConductor.getSelectedItem().toString(),
                    cbPlantel.getSelectedItem().toString(),
                    "admin"
            );
            if (ok) {
                JOptionPane.showMessageDialog(this, "Ticket actualizado.");
                parent.cargarTicketsFiltrados();
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar ticket: " + e.getMessage());
        }
    }
}
