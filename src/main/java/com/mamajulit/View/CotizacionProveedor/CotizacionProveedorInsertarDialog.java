package com.mamajulit.View.CotizacionProveedor;

import com.mamajulit.Controller.CotizacionProveedor.CotizacionProveedorInsertarController;
import com.mamajulit.Model.CotizacionProveedor;
import com.mamajulit.Model.ConexionBD;
import com.mamajulit.Util.ValidationUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class CotizacionProveedorInsertarDialog extends JDialog {

    private JComboBox<String> cbRuc;
    private JTextField txtGenero, txtCantidadPollos, txtAsignadoMin, txtAsignadoMax, txtPrecioMax, txtPrecioMin;
    private JCheckBox chkActiva;
    private final CotizacionProveedorGestionView parent;

    public CotizacionProveedorInsertarDialog(Window owner, CotizacionProveedorGestionView parent) {
        super(owner, "Insertar Cotización", ModalityType.APPLICATION_MODAL);
        this.parent = parent;
        setSize(520,380);
        setLocationRelativeTo(owner);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); c.insets = new Insets(6,6,6,6); c.fill = GridBagConstraints.HORIZONTAL;
        int row = 0;

        cbRuc = new JComboBox<>();
        cargarProveedores(cbRuc);

        txtGenero = new JTextField();
        txtCantidadPollos = new JTextField();
        txtAsignadoMin = new JTextField();
        txtAsignadoMax = new JTextField();
        txtPrecioMax = new JTextField();
        txtPrecioMin = new JTextField();
        chkActiva = new JCheckBox("Activa", true);

        c.gridx=0; c.gridy=row; form.add(new JLabel("Proveedor (RUC):"), c);
        c.gridx=1; c.gridy=row++; form.add(cbRuc, c);

        c.gridx=0; c.gridy=row; form.add(new JLabel("Género:"), c);
        c.gridx=1; c.gridy=row++; form.add(txtGenero, c);

        c.gridx=0; c.gridy=row; form.add(new JLabel("Cantidad pollos:"), c);
        c.gridx=1; c.gridy=row++; form.add(txtCantidadPollos, c);

        c.gridx=0; c.gridy=row; form.add(new JLabel("Asignado mínimo:"), c);
        c.gridx=1; c.gridy=row++; form.add(txtAsignadoMin, c);

        c.gridx=0; c.gridy=row; form.add(new JLabel("Asignado máximo:"), c);
        c.gridx=1; c.gridy=row++; form.add(txtAsignadoMax, c);

        c.gridx=0; c.gridy=row; form.add(new JLabel("Precio máximo:"), c);
        c.gridx=1; c.gridy=row++; form.add(txtPrecioMax, c);

        c.gridx=0; c.gridy=row; form.add(new JLabel("Precio mínimo:"), c);
        c.gridx=1; c.gridy=row++; form.add(txtPrecioMin, c);

        c.gridx=0; c.gridy=row; form.add(new JLabel("Activa:"), c);
        c.gridx=1; c.gridy=row++; form.add(chkActiva, c);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        botones.add(btnCancelar); botones.add(btnGuardar);

        btnCancelar.addActionListener(e -> dispose());
        btnGuardar.addActionListener(e -> guardar());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(form, BorderLayout.CENTER);
        getContentPane().add(botones, BorderLayout.SOUTH);
    }

    private void cargarProveedores(JComboBox<String> cb) {
        cb.removeAllItems();
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT RUC FROM proveedor");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) cb.addItem(rs.getString("RUC"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void guardar() {
        // validaciones
        if (!ValidationUtil.isNotEmpty((String)cbRuc.getSelectedItem())) {
            JOptionPane.showMessageDialog(this, "Selecciona un proveedor (RUC)."); return;
        }
        if (!ValidationUtil.isNotEmpty(txtGenero.getText())) { JOptionPane.showMessageDialog(this,"Género obligatorio"); return; }
        if (!ValidationUtil.isInteger(txtCantidadPollos.getText())) { JOptionPane.showMessageDialog(this,"Cantidad pollos inválida"); return; }
        if (!ValidationUtil.isInteger(txtAsignadoMin.getText())) { JOptionPane.showMessageDialog(this,"Asignado mínimo inválido"); return; }
        if (!ValidationUtil.isInteger(txtAsignadoMax.getText())) { JOptionPane.showMessageDialog(this,"Asignado máximo inválido"); return; }
        if (!ValidationUtil.isFloat(txtPrecioMax.getText())) { JOptionPane.showMessageDialog(this,"Precio máximo inválido"); return; }
        if (!ValidationUtil.isFloat(txtPrecioMin.getText())) { JOptionPane.showMessageDialog(this,"Precio mínimo inválido"); return; }

        int cantidad = Integer.parseInt(txtCantidadPollos.getText().trim());
        int amin = Integer.parseInt(txtAsignadoMin.getText().trim());
        int amax = Integer.parseInt(txtAsignadoMax.getText().trim());
        if (amin > amax) { JOptionPane.showMessageDialog(this,"Asignado mínimo no puede ser mayor que máximo"); return; }
        float pmax = Float.parseFloat(txtPrecioMax.getText().trim());
        float pmin = Float.parseFloat(txtPrecioMin.getText().trim());
        if (pmin > pmax) { JOptionPane.showMessageDialog(this,"Precio mínimo no puede ser mayor que precio máximo"); return; }

        CotizacionProveedor c = new CotizacionProveedor();
        c.setRuc((String)cbRuc.getSelectedItem());
        c.setGenero(txtGenero.getText().trim());
        c.setCantidadPollos(cantidad);
        c.setAsignadoMinimo(amin);
        c.setAsignadoMaximo(amax);
        c.setPrecioMaximo(pmax);
        c.setPrecioMinimo(pmin);
        c.setActiva(chkActiva.isSelected());

        CotizacionProveedorInsertarController ic = new CotizacionProveedorInsertarController();
        boolean ok = ic.insertar(c);
        if (ok) {
            JOptionPane.showMessageDialog(this, "Cotización registrada.");
            parent.refrescar();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar cotización.");
        }
    }
}
