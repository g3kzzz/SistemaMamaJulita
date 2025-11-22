package com.mamajulit.View.GuiaRequerimientos;

import com.mamajulit.Controller.GuiaRequerimientos.GuiaRequerimientosActualizarController;
import com.mamajulit.Model.GuiaRequerimientos;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GuiaRequerimientosActualizarDialog extends JDialog {

    private JTextField txtFecha, txtHora, txtTelefono;
    private JComboBox<String> cbConductor, cbPlantel;
    private JComboBox<Integer> cbDireccion; // <-- CORREGIDO: usar Integer
    private JButton btnActualizar, btnCancelar;
    private GuiaRequerimientosActualizarController controller;
    private int idGuia;

    public GuiaRequerimientosActualizarDialog(GuiaRequerimientos g) {
        this.controller = new GuiaRequerimientosActualizarController(this);
        this.idGuia = g.getIdGuia();

        setTitle("Actualizar Guía");
        setSize(400, 350);
        setLayout(new GridLayout(8, 2, 5, 5));
        setLocationRelativeTo(null);

        // ----- Campos -----
        add(new JLabel("Fecha (YYYY-MM-DD):"));
        txtFecha = new JTextField(g.getFechaEntrega().toString());
        add(txtFecha);

        add(new JLabel("Hora (HH:MM:SS):"));
        txtHora = new JTextField(g.getHoraEntrega().toString());
        add(txtHora);

        add(new JLabel("Conductor:"));
        cbConductor = new JComboBox<>();
        add(cbConductor);

        add(new JLabel("Plantel:"));
        cbPlantel = new JComboBox<>();
        add(cbPlantel);

        add(new JLabel("Dirección:"));
        cbDireccion = new JComboBox<>(); // <-- CORREGIDO
        add(cbDireccion);

        add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField(g.getTelefono());
        add(txtTelefono);

        // ----- Botones -----
        btnActualizar = new JButton("Actualizar");
        btnCancelar = new JButton("Cancelar");
        add(btnActualizar);
        add(btnCancelar);

        // ----- Cargar datos de combos -----
        controller.cargarConductor(cbConductor, g.getIdConductor());
        controller.cargarPlantel(cbPlantel, g.getIdPlantel());
        controller.cargarDireccion(cbDireccion, g.getIdDireccion()); // Ahora OK con JComboBox<Integer>

        // ----- Eventos -----
        btnActualizar.addActionListener(e -> {
            if (validarCampos()) {
                int idDireccion = (Integer) cbDireccion.getSelectedItem(); // <-- directo, sin parseo

                controller.actualizar(
                        idGuia,
                        txtFecha.getText(),
                        txtHora.getText(),
                        (String) cbConductor.getSelectedItem(),
                        (String) cbPlantel.getSelectedItem(),
                        idDireccion,
                        txtTelefono.getText()
                );
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }

    // ----- Validación completa -----
    private boolean validarCampos() {
        if (txtFecha.getText().isEmpty()) {
            mostrarError("La fecha es obligatoria.");
            return false;
        }
        if (!validarFecha(txtFecha.getText())) {
            mostrarError("Formato de fecha inválido. Debe ser YYYY-MM-DD.");
            return false;
        }

        if (txtHora.getText().isEmpty()) {
            mostrarError("La hora es obligatoria.");
            return false;
        }
        if (!validarHora(txtHora.getText())) {
            mostrarError("Formato de hora inválido. Debe ser HH:MM:SS.");
            return false;
        }

        if (cbConductor.getSelectedItem() == null) {
            mostrarError("Debe seleccionar un conductor.");
            return false;
        }
        if (cbPlantel.getSelectedItem() == null) {
            mostrarError("Debe seleccionar un plantel.");
            return false;
        }
        if (cbDireccion.getSelectedItem() == null) {
            mostrarError("Debe seleccionar una dirección.");
            return false;
        }

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

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void cerrar() {
        dispose();
    }
}
