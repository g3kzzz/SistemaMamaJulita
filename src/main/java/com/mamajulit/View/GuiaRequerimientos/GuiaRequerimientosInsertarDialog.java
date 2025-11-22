package com.mamajulit.View.GuiaRequerimientos;

import com.mamajulit.Controller.GuiaRequerimientos.GuiaRequerimientosInsertarController;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GuiaRequerimientosInsertarDialog extends JDialog {

    private JTextField txtFecha, txtHora, txtTelefono;
    private JComboBox<String> cbConductor, cbPlantel;
    private JComboBox<Integer> cbDireccion;
    private JButton btnGuardar, btnCancelar;
    private GuiaRequerimientosInsertarController controller;

    public GuiaRequerimientosInsertarDialog() {
        this.controller = new GuiaRequerimientosInsertarController(this);

        setTitle("Insertar Guía");
        setSize(400,350);
        setLayout(new GridLayout(8,2,5,5));
        setLocationRelativeTo(null);

        // ----- Campos -----
        add(new JLabel("Fecha (YYYY-MM-DD):"));
        txtFecha = new JTextField();
        add(txtFecha);

        add(new JLabel("Hora (HH:MM:SS):"));
        txtHora = new JTextField();
        add(txtHora);

        add(new JLabel("Conductor:"));
        cbConductor = new JComboBox<>();
        add(cbConductor);

        add(new JLabel("Plantel:"));
        cbPlantel = new JComboBox<>();
        add(cbPlantel);

        add(new JLabel("Dirección:"));
        cbDireccion = new JComboBox<>();
        add(cbDireccion);

        add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        add(txtTelefono);

        // ----- Botones -----
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        add(btnGuardar);
        add(btnCancelar);

        // ----- Cargar combos -----
        controller.cargarConductor(cbConductor);
        controller.cargarPlantel(cbPlantel);
        controller.cargarDireccion(cbDireccion);

        // ----- Eventos -----
        btnGuardar.addActionListener(e -> {
            if (validarCampos()) {
                controller.insertar(
                        txtFecha.getText(),
                        txtHora.getText(),
                        (String) cbConductor.getSelectedItem(),
                        (String) cbPlantel.getSelectedItem(),
                        (Integer) cbDireccion.getSelectedItem(),
                        txtTelefono.getText()
                );
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }

    // ----- Validación completa -----
    private boolean validarCampos() {
        // Fecha
        if (txtFecha.getText().isEmpty()) {
            mostrarError("La fecha es obligatoria.");
            return false;
        }
        if (!validarFecha(txtFecha.getText())) {
            mostrarError("Formato de fecha inválido. Debe ser YYYY-MM-DD.");
            return false;
        }

        // Hora
        if (txtHora.getText().isEmpty()) {
            mostrarError("La hora es obligatoria.");
            return false;
        }
        if (!validarHora(txtHora.getText())) {
            mostrarError("Formato de hora inválido. Debe ser HH:MM:SS.");
            return false;
        }

        // Conductor
        if (cbConductor.getSelectedItem() == null) {
            mostrarError("Debe seleccionar un conductor.");
            return false;
        }

        // Plantel
        if (cbPlantel.getSelectedItem() == null) {
            mostrarError("Debe seleccionar un plantel.");
            return false;
        }

        // Dirección
        if (cbDireccion.getSelectedItem() == null) {
            mostrarError("Debe seleccionar una dirección.");
            return false;
        }

        // Teléfono
        if (txtTelefono.getText().isEmpty()) {
            mostrarError("El teléfono es obligatorio.");
            return false;
        }
        if (!txtTelefono.getText().matches("\\d{7,15}")) {
            mostrarError("Teléfono inválido. Debe contener solo números (7 a 15 dígitos).");
            return false;
        }

        return true;
    }

    // ----- Helpers de validación -----
    private boolean validarFecha(String fecha) {
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean validarHora(String hora) {
        try {
            new SimpleDateFormat("HH:mm:ss").parse(hora);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // ----- Mensajes -----
    public void mostrarMensaje(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }

    public void mostrarError(String msg){
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void cerrar(){ dispose(); }
}
