package com.mamajulit.View.ProveedorProducto;

import com.mamajulit.Controller.ProveedorProducto.ProveedorProductoActualizarController;
import com.mamajulit.Model.ConexionBD;
import com.mamajulit.Util.ValidationUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ProveedorProductoEditDialog extends JDialog {

    private JTextField txtCantidad;
    private JTextField txtPrecio;
    private final ProveedorProductoGestionView parent;
    private final int idDetalle;

    public ProveedorProductoEditDialog(Window owner, ProveedorProductoGestionView parent, int idDetalle) {
        super(owner, "Editar detalle proveedor - producto", ModalityType.APPLICATION_MODAL);
        this.parent = parent;
        this.idDetalle = idDetalle;
        setSize(420,220);
        setLocationRelativeTo(owner);

        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); c.insets = new Insets(6,6,6,6); c.fill = GridBagConstraints.HORIZONTAL;
        int row=0;

        txtCantidad = new JTextField();
        txtPrecio = new JTextField();

        c.gridx=0; c.gridy=row; p.add(new JLabel("Cantidad:"), c);
        c.gridx=1; p.add(txtCantidad, c); row++;
        c.gridx=0; c.gridy=row; p.add(new JLabel("Precio base:"), c);
        c.gridx=1; p.add(txtPrecio, c); row++;

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        JPanel bot = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bot.add(btnCancelar); bot.add(btnGuardar);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p, BorderLayout.CENTER);
        getContentPane().add(bot, BorderLayout.SOUTH);

        btnCancelar.addActionListener(e -> dispose());
        btnGuardar.addActionListener(e -> guardar());

        cargarDatos();
    }

    private void cargarDatos() {
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT Cantidad, Precio_base FROM detalle_proveedor_producto WHERE Id = ?")) {
            ps.setInt(1, idDetalle);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int cant = rs.getInt("Cantidad");
                    if (!rs.wasNull()) txtCantidad.setText(String.valueOf(cant));
                    float pre = rs.getFloat("Precio_base");
                    if (!rs.wasNull()) txtPrecio.setText(String.valueOf(pre));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Error al cargar: "+e.getMessage());
        }
    }

    private void guardar() {
        Integer cantidad = null;
        Float precio = null;

        if (ValidationUtil.isNotEmpty(txtCantidad.getText())) {
            if (!ValidationUtil.isInteger(txtCantidad.getText())) { JOptionPane.showMessageDialog(this,"Cantidad inválida."); return; }
            cantidad = Integer.parseInt(txtCantidad.getText());
            if (cantidad < 0) { JOptionPane.showMessageDialog(this,"Cantidad debe ser >=0"); return; }
        }

        if (!ValidationUtil.isNotEmpty(txtPrecio.getText())) { JOptionPane.showMessageDialog(this,"Precio requerido."); return; }
        if (!ValidationUtil.isFloat(txtPrecio.getText())) { JOptionPane.showMessageDialog(this,"Precio inválido."); return; }
        precio = Float.parseFloat(txtPrecio.getText());
        if (precio < 0) { JOptionPane.showMessageDialog(this,"Precio debe ser >=0"); return; }

        ProveedorProductoActualizarController ctrl = new ProveedorProductoActualizarController();
        try {
            boolean ok = ctrl.actualizar(idDetalle, cantidad, precio, "admin");
            if (ok) { JOptionPane.showMessageDialog(this,"Actualizado."); parent.refrescar(); dispose(); }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al actualizar: " + ex.getMessage());
        }
    }
}
