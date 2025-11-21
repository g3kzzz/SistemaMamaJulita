package com.mamajulit.View.GuiaRequerimientos;

import com.mamajulit.Controller.GuiaRequerimientos.GuiaRequerimientosActualizarController;
import com.mamajulit.Model.GuiaRequerimientos;

import javax.swing.*;
import java.awt.*;

public class GuiaRequerimientosActualizarDialog extends JDialog {

    private JTextField txtFecha, txtHora, txtTelefono;
    private JComboBox<String> cbConductor, cbPlantel;
    private JComboBox<Integer> cbDireccion;
    private JButton btnActualizar, btnCancelar;
    private GuiaRequerimientosActualizarController controller;
    private int idGuia;

    public GuiaRequerimientosActualizarDialog(GuiaRequerimientos g){
        this.controller = new GuiaRequerimientosActualizarController(this);
        this.idGuia = g.getIdGuia();

        setTitle("Actualizar Guía");
        setSize(400,300);
        setLayout(new GridLayout(7,2));

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

        add(new JLabel("Direccion:"));
        cbDireccion = new JComboBox<>();
        add(cbDireccion);

        add(new JLabel("Telefono:"));
        txtTelefono = new JTextField(g.getTelefono());
        add(txtTelefono);

        btnActualizar = new JButton("Actualizar");
        btnCancelar = new JButton("Cancelar");
        add(btnActualizar); add(btnCancelar);

        // Llenar los JComboBox con datos de BD y seleccionar los actuales
        controller.cargarConductor(cbConductor, g.getIdConductor());
        controller.cargarPlantel(cbPlantel, g.getIdPlantel());
        controller.cargarDireccion(cbDireccion, g.getIdDireccion());

        btnActualizar.addActionListener(e -> controller.actualizar(
                idGuia,
                txtFecha.getText(),
                txtHora.getText(),
                (String) cbConductor.getSelectedItem(),
                (String) cbPlantel.getSelectedItem(),
                (Integer) cbDireccion.getSelectedItem(),
                txtTelefono.getText()
        ));

        btnCancelar.addActionListener(e -> dispose());
    }

    public void mostrarMensaje(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }

    public void mostrarError(String msg){
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void cerrar(){ dispose(); }
}
