package com.mamajulit.View.Proveedores;

import com.mamajulit.Controller.Proveedores.ProveedorActualizarController;

import javax.swing.*;
import java.awt.*;

public class ProveedorActualizarDialog extends JDialog {

    private JTextField txtNombre, txtEstado, txtEmail, txtTelefono, txtCalle, txtNumero, txtCiudad;
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
        txtEstado = new JTextField(estado);
        txtEmail = new JTextField(email);
        txtTelefono = new JTextField(telefono);
        txtCalle = new JTextField(calle);
        txtNumero = new JTextField(numero);
        txtCiudad = new JTextField(ciudad);

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

        JButton btnGuardar = new JButton("Actualizar");
        btnGuardar.addActionListener(e -> actualizarProveedor());
        add(btnGuardar, BorderLayout.SOUTH);
    }

    private void actualizarProveedor() {

        ProveedorActualizarController ctrl = new ProveedorActualizarController();

        boolean ok = ctrl.actualizarProveedor(
                rucOriginal,
                txtNombre.getText(),
                txtEstado.getText(),
                txtEmail.getText(),
                txtTelefono.getText(),
                txtCalle.getText(),
                txtNumero.getText(),
                txtCiudad.getText()
        );

        if (ok) {
            JOptionPane.showMessageDialog(this, "Proveedor actualizado.");
            parent.cargarProveedores();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar proveedor.");
        }
    }
}
