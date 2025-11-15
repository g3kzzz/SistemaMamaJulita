package com.mamajulit.View.TicketPesado;

import com.mamajulit.Controller.TicketPesado.TicketPesadoActualizarController;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
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
            e.printStackTrace();
        }
    }

    private void actualizarTicket() {
        TicketPesadoActualizarController ctrl = new TicketPesadoActualizarController();
        boolean ok = ctrl.actualizarTicket(
                id_ticket,
                txtFechaSalida.getText(),
                txtFechaIngreso.getText(),
                Float.parseFloat(txtMontoTotal.getText()),
                Float.parseFloat(txtPesoPromedio.getText()),
                txtGenero.getText(),
                Integer.parseInt(txtCantidad.getText()),
                Integer.parseInt(txtMortalidad.getText()),
                txtDestino.getText(),
                Float.parseFloat(txtMerma.getText()),
                cbVehiculo.getSelectedItem().toString(),
                cbConductor.getSelectedItem().toString(),
                cbPlantel.getSelectedItem().toString(),
                "admin"
        );
        if (ok) {
            JOptionPane.showMessageDialog(this, "Ticket actualizado.");
            parent.cargarTickets();
            dispose();
        }
    }
}
