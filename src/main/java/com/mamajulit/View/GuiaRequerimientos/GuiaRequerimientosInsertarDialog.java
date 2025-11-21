package com.mamajulit.View.GuiaRequerimientos;

import com.mamajulit.Controller.GuiaRequerimientos.GuiaRequerimientosInsertarController;

import javax.swing.*;
import java.awt.*;

public class GuiaRequerimientosInsertarDialog extends JDialog {

    private JTextField txtFecha, txtHora, txtTelefono;
    private JComboBox<String> cbConductor, cbPlantel;
    private JComboBox<Integer> cbDireccion;
    private JButton btnGuardar, btnCancelar;
    private GuiaRequerimientosInsertarController controller;

    public GuiaRequerimientosInsertarDialog() {
        this.controller = new GuiaRequerimientosInsertarController(this);

        setTitle("Insertar Guía");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2));
        setLocationRelativeTo(null); // Centrar ventana

        // Fecha
        add(new JLabel("Fecha (YYYY-MM-DD):"));
        txtFecha = new JTextField();
        add(txtFecha);

        // Hora
        add(new JLabel("Hora (HH:MM:SS):"));
        txtHora = new JTextField();
        add(txtHora);

        // Conductor (FK)
        add(new JLabel("Conductor:"));
        cbConductor = new JComboBox<>();
        add(cbConductor);

        // Plantel (FK)
        add(new JLabel("Plantel:"));
        cbPlantel = new JComboBox<>();
        add(cbPlantel);

        // Direccion (FK)
        add(new JLabel("Direccion:"));
        cbDireccion = new JComboBox<>();
        add(cbDireccion);

        // Telefono
        add(new JLabel("Telefono:"));
        txtTelefono = new JTextField();
        add(txtTelefono);

        // Botones
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        add(btnGuardar);
        add(btnCancelar);

        // Cargar datos en JComboBox desde el DAO a través del controller
        controller.cargarConductor(cbConductor);
        controller.cargarPlantel(cbPlantel);
        controller.cargarDireccion(cbDireccion);

        // Eventos de los botones
        btnGuardar.addActionListener(e -> controller.insertar(
                txtFecha.getText(),
                txtHora.getText(),
                (String) cbConductor.getSelectedItem(),
                (String) cbPlantel.getSelectedItem(),
                (Integer) cbDireccion.getSelectedItem(),
                txtTelefono.getText()
        ));

        btnCancelar.addActionListener(e -> dispose());
    }

    // Métodos para mostrar mensajes al usuario
    public void mostrarMensaje(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }

    public void mostrarError(String msg){
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void cerrar(){ dispose(); }
}
