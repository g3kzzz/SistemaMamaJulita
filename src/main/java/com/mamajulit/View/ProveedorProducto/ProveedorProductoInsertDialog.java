package com.mamajulit.View.ProveedorProducto;

import com.mamajulit.Controller.ProveedorProducto.ProveedorProductoInsertarController;
import com.mamajulit.Util.ValidationUtil;

import javax.swing.*;
import java.awt.*;

public class ProveedorProductoInsertDialog extends JDialog {

    private JComboBox<String> cbProducto;
    private JComboBox<String> cbProveedor;
    private JTextField txtCantidad;
    private JTextField txtPrecio;
    private final ProveedorProductoGestionView parent;

    public ProveedorProductoInsertDialog(Window owner, ProveedorProductoGestionView parent) {
        super(owner, "Registrar producto - proveedor", ModalityType.APPLICATION_MODAL);
        this.parent = parent;
        setSize(520, 280);
        setLocationRelativeTo(owner);

        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); c.insets = new Insets(6,6,6,6); c.fill = GridBagConstraints.HORIZONTAL;
        int row=0;

        cbProducto = new JComboBox<>();
        cbProveedor = new JComboBox<>();
        txtCantidad = new JTextField();
        txtPrecio = new JTextField();

        ProveedorProductoGestionView.llenarComboProductos(cbProducto);
        ProveedorProductoGestionView.llenarComboProveedores(cbProveedor);

        c.gridx=0; c.gridy=row; p.add(new JLabel("Producto:"), c);
        c.gridx=1; p.add(cbProducto, c); row++;
        c.gridx=0; c.gridy=row; p.add(new JLabel("Proveedor:"), c);
        c.gridx=1; p.add(cbProveedor, c); row++;
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
    }

    private void guardar() {
        // Validaciones
        if (cbProducto.getSelectedItem() == null) { JOptionPane.showMessageDialog(this,"Selecciona un producto."); return; }
        if (cbProveedor.getSelectedItem() == null) { JOptionPane.showMessageDialog(this,"Selecciona un proveedor."); return; }
        String prodSel = cbProducto.getSelectedItem().toString();
        String provSel = cbProveedor.getSelectedItem().toString();
        int idProducto = Integer.parseInt(prodSel.split(" - ")[0]);
        String ruc = provSel.split(" - ")[0];

        Integer cantidad = null;
        if (ValidationUtil.isNotEmpty(txtCantidad.getText())) {
            if (!ValidationUtil.isInteger(txtCantidad.getText())) { JOptionPane.showMessageDialog(this,"Cantidad inválida."); return; }
            cantidad = Integer.parseInt(txtCantidad.getText());
            if (cantidad < 0) { JOptionPane.showMessageDialog(this,"Cantidad debe ser >= 0."); return; }
        }

        Float precio = null;
        if (ValidationUtil.isNotEmpty(txtPrecio.getText())) {
            if (!ValidationUtil.isFloat(txtPrecio.getText())) { JOptionPane.showMessageDialog(this,"Precio inválido."); return; }
            precio = Float.parseFloat(txtPrecio.getText());
            if (precio < 0) { JOptionPane.showMessageDialog(this,"Precio debe ser >= 0."); return; }
        } else {
            JOptionPane.showMessageDialog(this,"Precio base es obligatorio."); return;
        }

        ProveedorProductoInsertarController ctrl = new ProveedorProductoInsertarController();
        try {
            boolean ok = ctrl.insertar(ruc, idProducto, cantidad, precio, "admin");
            if (ok) { JOptionPane.showMessageDialog(this,"Registrado."); parent.refrescar(); dispose(); }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error: " + ex.getMessage());
        }
    }
}
