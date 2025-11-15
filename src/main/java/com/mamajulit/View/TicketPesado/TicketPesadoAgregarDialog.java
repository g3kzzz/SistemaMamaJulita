package com.mamajulit.View.TicketPesado;

import com.mamajulit.Controller.TicketPesado.TicketPesadoAgregarController;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.mamajulit.Model.ConexionBD;

public class TicketPesadoAgregarDialog extends JDialog {

    private JTextField txtFechaSalida, txtFechaIngreso, txtMontoTotal, txtPesoPromedio,
            txtGenero, txtCantidad, txtMortalidad, txtDestino, txtMerma;
    private JComboBox<String> cbVehiculo, cbConductor, cbPlantel;
    private final TicketPesadoGestionView parent;

    public TicketPesadoAgregarDialog(TicketPesadoGestionView parent) {
        this.parent = parent;
        setTitle("Agregar Ticket Pesado");
        setModal(true);
        setSize(450, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(12, 2, 5, 5));

        txtFechaSalida = new JTextField();
        txtFechaIngreso = new JTextField();
        txtMontoTotal = new JTextField();
        txtPesoPromedio = new JTextField();
        txtGenero = new JTextField();
        txtCantidad = new JTextField();
        txtMortalidad = new JTextField();
        txtDestino = new JTextField();
        txtMerma = new JTextField();

        cbVehiculo = new JComboBox<>();
        cbConductor = new JComboBox<>();
        cbPlantel = new JComboBox<>();

        llenarComboBox("Vehiculo", "Placa", cbVehiculo);
        llenarComboBox("Conductor", "Nro_Licencia", cbConductor);
        llenarComboBox("Plantel", "Id_plantel", cbPlantel);

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

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarTicket());
        add(btnGuardar, BorderLayout.SOUTH);
    }

    private void llenarComboBox(String tabla, String columna, JComboBox<String> combo) {
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT " + columna + " FROM " + tabla);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                combo.addItem(rs.getString(columna));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void guardarTicket() {
        TicketPesadoAgregarController ctrl = new TicketPesadoAgregarController();
        boolean ok = ctrl.agregarTicket(
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
            JOptionPane.showMessageDialog(this, "Ticket agregado.");
            parent.cargarTickets();
            dispose();
        }
    }
}
