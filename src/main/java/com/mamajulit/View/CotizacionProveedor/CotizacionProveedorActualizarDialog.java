package com.mamajulit.View.CotizacionProveedor;

import com.mamajulit.Controller.CotizacionProveedor.CotizacionProveedorActualizarController;
import com.mamajulit.Controller.CotizacionProveedor.CotizacionProveedorController;
import com.mamajulit.Model.CotizacionProveedor;
import com.mamajulit.Util.ValidationUtil;

import javax.swing.*;
import java.awt.*;

public class CotizacionProveedorActualizarDialog extends JDialog {

    private JComboBox<String> cbRuc;
    private JTextField txtGenero, txtCantidadPollos, txtAsignadoMin, txtAsignadoMax, txtPrecioMax, txtPrecioMin;
    private JCheckBox chkActiva;
    private final CotizacionProveedorGestionView parent;
    private final Integer id;

    public CotizacionProveedorActualizarDialog(Window owner, CotizacionProveedorGestionView parent, Integer id) {
        super(owner, "Actualizar Cotización", ModalityType.APPLICATION_MODAL);
        this.parent = parent;
        this.id = id;
        setSize(520,400);
        setLocationRelativeTo(owner);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); c.insets = new Insets(6,6,6,6); c.fill = GridBagConstraints.HORIZONTAL;
        int row = 0;

        cbRuc = new JComboBox<>();
        txtGenero = new JTextField();
        txtCantidadPollos = new JTextField();
        txtAsignadoMin = new JTextField();
        txtAsignadoMax = new JTextField();
        txtPrecioMax = new JTextField();
        txtPrecioMin = new JTextField();
        chkActiva = new JCheckBox("Activa");

        // layout
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
        JButton btnGuardar = new JButton("Actualizar");
        JButton btnCancelar = new JButton("Cancelar");
        botones.add(btnCancelar); botones.add(btnGuardar);

        btnCancelar.addActionListener(e -> dispose());
        btnGuardar.addActionListener(e -> actualizar());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(form, BorderLayout.CENTER);
        getContentPane().add(botones, BorderLayout.SOUTH);

        // cargar datos existentes
        llenarComboProveedores();
        cargarDatos();
    }

    private void llenarComboProveedores() {
        cbRuc.removeAllItems();
        cbRuc.addItem("");
        try (java.sql.Connection cn = com.mamajulit.Model.ConexionBD.getConnection();
             java.sql.PreparedStatement ps = cn.prepareStatement("SELECT RUC FROM proveedor");
             java.sql.ResultSet rs = ps.executeQuery()) {
            while (rs.next()) cbRuc.addItem(rs.getString("RUC"));
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void cargarDatos() {
        CotizacionProveedorController cctrl = new CotizacionProveedorController();
        CotizacionProveedor c = cctrl.obtener(id);
        if (c == null) {
            JOptionPane.showMessageDialog(this, "Cotización no encontrada."); dispose(); return;
        }
        cbRuc.setSelectedItem(c.getRuc());
        txtGenero.setText(c.getGenero());
        txtCantidadPollos.setText(c.getCantidadPollos() == null ? "" : String.valueOf(c.getCantidadPollos()));
        txtAsignadoMin.setText(c.getAsignadoMinimo() == null ? "" : String.valueOf(c.getAsignadoMinimo()));
        txtAsignadoMax.setText(c.getAsignadoMaximo() == null ? "" : String.valueOf(c.getAsignadoMaximo()));
        txtPrecioMax.setText(c.getPrecioMaximo() == null ? "" : String.valueOf(c.getPrecioMaximo()));
        txtPrecioMin.setText(c.getPrecioMinimo() == null ? "" : String.valueOf(c.getPrecioMinimo()));
        chkActiva.setSelected(Boolean.TRUE.equals(c.getActiva()));
    }

    private void actualizar() {
        // validaciones
        if (!ValidationUtil.isNotEmpty((String)cbRuc.getSelectedItem())) { JOptionPane.showMessageDialog(this,"Selecciona RUC"); return; }
        if (!ValidationUtil.isNotEmpty(txtGenero.getText())) { JOptionPane.showMessageDialog(this,"Género obligatorio"); return; }
        if (!ValidationUtil.isInteger(txtCantidadPollos.getText())) { JOptionPane.showMessageDialog(this,"Cantidad inválida"); return; }
        if (!ValidationUtil.isInteger(txtAsignadoMin.getText())) { JOptionPane.showMessageDialog(this,"Asignado mínimo inválido"); return; }
        if (!ValidationUtil.isInteger(txtAsignadoMax.getText())) { JOptionPane.showMessageDialog(this,"Asignado máximo inválido"); return; }
        if (!ValidationUtil.isFloat(txtPrecioMax.getText())) { JOptionPane.showMessageDialog(this,"Precio máximo inválido"); return; }
        if (!ValidationUtil.isFloat(txtPrecioMin.getText())) { JOptionPane.showMessageDialog(this,"Precio mínimo inválido"); return; }

        int cantidad = Integer.parseInt(txtCantidadPollos.getText().trim());
        int amin = Integer.parseInt(txtAsignadoMin.getText().trim());
        int amax = Integer.parseInt(txtAsignadoMax.getText().trim());
        float pmax = Float.parseFloat(txtPrecioMax.getText().trim());
        float pmin = Float.parseFloat(txtPrecioMin.getText().trim());
        if (amin > amax) { JOptionPane.showMessageDialog(this,"Asignado mínimo no puede ser mayor que máximo"); return; }
        if (pmin > pmax) { JOptionPane.showMessageDialog(this,"Precio mínimo no puede ser mayor que máximo"); return; }

        CotizacionProveedor c = new CotizacionProveedor();
        c.setIdCotizacion(id);
        c.setRuc((String)cbRuc.getSelectedItem());
        c.setGenero(txtGenero.getText().trim());
        c.setCantidadPollos(cantidad);
        c.setAsignadoMinimo(amin);
        c.setAsignadoMaximo(amax);
        c.setPrecioMaximo(pmax);
        c.setPrecioMinimo(pmin);
        c.setActiva(chkActiva.isSelected());

        CotizacionProveedorActualizarController ac = new CotizacionProveedorActualizarController();
        boolean ok = ac.actualizar(c);
        if (ok) {
            JOptionPane.showMessageDialog(this,"Cotización actualizada.");
            parent.refrescar();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,"No se pudo actualizar.");
        }
    }
}
