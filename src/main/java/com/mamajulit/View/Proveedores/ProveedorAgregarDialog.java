package com.mamajulit.View.Proveedores;

import com.mamajulit.Controller.Proveedores.ProveedorAgregarController;

import javax.swing.*;
import java.awt.*;

public class ProveedorAgregarDialog extends JDialog {

    private JTextField txtRuc, txtNombre, txtEmail, txtTelefono, txtCalle, txtNumero, txtCiudad;
    private JComboBox<String> cmbEstado;
    private final ProveedorGestionView parent;

    public ProveedorAgregarDialog(ProveedorGestionView parent) {
        this.parent = parent;

        setTitle("Agregar Proveedor");
        setModal(true);
        setSize(380, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(9, 2, 5, 5));

        txtRuc = new JTextField();
        txtNombre = new JTextField();
        cmbEstado = new JComboBox<>(new String[]{"Activo", "Inactivo"});
        txtEmail = new JTextField();
        txtTelefono = new JTextField();
        txtCalle = new JTextField();
        txtNumero = new JTextField();
        txtCiudad = new JTextField();

        form.add(new JLabel("RUC:"));
        form.add(txtRuc);

        form.add(new JLabel("Nombre:"));
        form.add(txtNombre);

        form.add(new JLabel("Estado:"));
        form.add(cmbEstado);

        form.add(new JLabel("Email:"));
        form.add(txtEmail);

        form.add(new JLabel("Teléfono:"));
        form.add(txtTelefono);

        form.add(new JLabel("Calle:"));
        form.add(txtCalle);

        form.add(new JLabel("Número:"));
        form.add(txtNumero);

        form.add(new JLabel("Ciudad:"));
        form.add(txtCiudad);

        add(form, BorderLayout.CENTER);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarProveedor());
        add(btnGuardar, BorderLayout.SOUTH);
    }

    private boolean validarCampos() {
        String ruc = txtRuc.getText().trim();
        String nombre = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String calle = txtCalle.getText().trim();
        String numero = txtNumero.getText().trim();
        String ciudad = txtCiudad.getText().trim();

        if (ruc.isEmpty() || !ruc.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(this, "RUC obligatorio y debe tener 11 dígitos.");
            return false;
        }

        if (nombre.isEmpty() || nombre.length() < 3) {
            JOptionPane.showMessageDialog(this, "Nombre obligatorio y mínimo 3 caracteres.");
            return false;
        }

        if (!email.isEmpty() && !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this, "Email inválido.");
            return false;
        }

        if (!telefono.isEmpty() && !telefono.matches("\\d{6,15}")) {
            JOptionPane.showMessageDialog(this, "Teléfono inválido (solo números, mínimo 6 dígitos).");
            return false;
        }

        if (calle.isEmpty() || numero.isEmpty() || ciudad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Calle, Número y Ciudad son obligatorios.");
            return false;
        }

        return true;
    }

    private void guardarProveedor() {
        if (!validarCampos()) return;

        ProveedorAgregarController ctrl = new ProveedorAgregarController();
        String estado = cmbEstado.getSelectedItem().equals("Activo") ? "1" : "0";

        boolean ok = ctrl.agregarProveedor(
                txtRuc.getText().trim(),
                txtNombre.getText().trim(),
                estado,
                txtEmail.getText().trim(),
                txtTelefono.getText().trim(),
                txtCalle.getText().trim(),
                txtNumero.getText().trim(),
                txtCiudad.getText().trim()
        );

        if (ok) {
            JOptionPane.showMessageDialog(this, "Proveedor agregado correctamente.");
            parent.cargarProveedores();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar proveedor.");
        }
    }
}
