package com.mamajulit.View.Proveedores;

import com.mamajulit.Controller.Proveedores.ProveedorActualizarController;

import javax.swing.*;
import java.awt.*;

public class ProveedorActualizarDialog extends JDialog {

    private JTextField txtNombre, txtEmail, txtTelefono, txtCalle, txtNumero, txtCiudad;
    private JComboBox<String> cmbEstado;
    private final String rucOriginal;
    private final ProveedorGestionView parent;

    public ProveedorActualizarDialog(
            ProveedorGestionView parent,
            String ruc,
            String nombre,
            String estado,
            String email,
            String telefono,
            String calle,
            String numero,
            String ciudad
    ) {
        this.parent = parent;
        this.rucOriginal = ruc;

        setTitle("Actualizar Proveedor");
        setModal(true);
        setSize(380, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(8, 2, 5, 5));

        txtNombre = new JTextField(nombre);
        cmbEstado = new JComboBox<>(new String[]{"Activo", "Inactivo"});
        cmbEstado.setSelectedIndex(estado.equals("1") ? 0 : 1);
        txtEmail = new JTextField(email);
        txtTelefono = new JTextField(telefono);
        txtCalle = new JTextField(calle);
        txtNumero = new JTextField(numero);
        txtCiudad = new JTextField(ciudad);

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

        JButton btnGuardar = new JButton("Actualizar");
        btnGuardar.addActionListener(e -> actualizarProveedor());
        add(btnGuardar, BorderLayout.SOUTH);
    }

    private boolean validarCampos() {
        String nombre = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String calle = txtCalle.getText().trim();
        String numero = txtNumero.getText().trim();
        String ciudad = txtCiudad.getText().trim();

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

    private void actualizarProveedor() {
        if (!validarCampos()) return;

        ProveedorActualizarController ctrl = new ProveedorActualizarController();
        String estado = cmbEstado.getSelectedItem().equals("Activo") ? "1" : "0";

        boolean ok = ctrl.actualizarProveedor(
                rucOriginal,
                txtNombre.getText().trim(),
                estado,
                txtEmail.getText().trim(),
                txtTelefono.getText().trim(),
                txtCalle.getText().trim(),
                txtNumero.getText().trim(),
                txtCiudad.getText().trim()
        );

        if (ok) {
            JOptionPane.showMessageDialog(this, "Proveedor actualizado correctamente.");
            parent.cargarProveedores();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar proveedor.");
        }
    }
}
