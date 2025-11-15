package com.mamajulit.View.Proveedores;

import com.mamajulit.Controller.Proveedores.ProveedorAgregarController;

import javax.swing.*;
import java.awt.*;

public class ProveedorAgregarDialog extends JDialog {

    private JTextField txtRuc, txtNombre, txtEstado, txtEmail, txtTelefono, txtCalle, txtNumero, txtCiudad;
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
        txtEstado = new JTextField();
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
        form.add(txtEstado);

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

    private void guardarProveedor() {
        // Validación
        if (txtRuc.getText().isEmpty() || txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "RUC y Nombre son obligatorios.");
            return;
        }

        // Llamar al controller
        ProveedorAgregarController ctrl = new ProveedorAgregarController();
        boolean ok = ctrl.agregarProveedor(
                txtRuc.getText(),
                txtNombre.getText(),
                txtEstado.getText(),
                txtEmail.getText(),
                txtTelefono.getText(),
                txtCalle.getText(),
                txtNumero.getText(),
                txtCiudad.getText()
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
