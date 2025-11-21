package com.mamajulit.View.CotizacionProveedor;

import com.mamajulit.Controller.CotizacionProveedor.CotizacionProveedorController;
import com.mamajulit.Controller.CotizacionProveedor.CotizacionProveedorEliminarController;
import com.mamajulit.Model.CotizacionProveedor;
import com.mamajulit.Model.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.List;

public class CotizacionProveedorGestionView extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private final CotizacionProveedorController ctrl = new CotizacionProveedorController();

    public CotizacionProveedorGestionView() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel top = new JPanel(new BorderLayout());
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRefrescar = new JButton("Refrescar");
        botones.add(btnAgregar); botones.add(btnActualizar); botones.add(btnEliminar); botones.add(btnRefrescar);

        JPanel busquedaPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JTextField txtBuscar = new JTextField(20);
        JComboBox<String> cbEstado = new JComboBox<>(new String[] {"TODO","ACTIVA","USADA","VENCIDA"});
        JComboBox<String> cbRuc = new JComboBox<>();
        llenarComboProveedores(cbRuc);
        JButton btnBuscar = new JButton("Buscar");
        busquedaPanel.add(new JLabel("Buscar:")); busquedaPanel.add(txtBuscar);
        busquedaPanel.add(new JLabel("Estado:")); busquedaPanel.add(cbEstado);
        busquedaPanel.add(new JLabel("Proveedor:")); busquedaPanel.add(cbRuc);
        busquedaPanel.add(btnBuscar);

        top.add(botones, BorderLayout.WEST);
        top.add(busquedaPanel, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new Object[]{
                "ID","RUC","Género","Cant.Pollos","Min","Max","Precio Max","Precio Min","Activa","FechaRegistro"
        }, 0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };

        tabla = new JTable(modelo);
        tabla.setRowHeight(26);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // eventos
        btnRefrescar.addActionListener(e -> cargarTodos());
        btnBuscar.addActionListener(e -> buscar(txtBuscar.getText().trim(), (String)cbRuc.getSelectedItem(), (String)cbEstado.getSelectedItem()));
        btnAgregar.addActionListener(e -> abrirInsertar());
        btnActualizar.addActionListener(e -> abrirActualizar());
        btnEliminar.addActionListener(e -> eliminar());

        cargarTodos();
    }

    protected void cargarTodos() {
        modelo.setRowCount(0);
        List<CotizacionProveedor> lista = ctrl.listar();
        for (CotizacionProveedor c : lista) {
            modelo.addRow(new Object[]{
                    c.getIdCotizacion(),
                    c.getRuc(),
                    c.getGenero(),
                    c.getCantidadPollos(),
                    c.getAsignadoMinimo(),
                    c.getAsignadoMaximo(),
                    c.getPrecioMaximo(),
                    c.getPrecioMinimo(),
                    c.getActiva(),
                    c.getFechaRegistro()
            });
        }
    }

    protected void buscar(String texto, String ruc, String estado) {
        modelo.setRowCount(0);
        Boolean activaFilter = null;
        if (!"TODO".equals(estado)) {
            activaFilter = "ACTIVA".equals(estado);
        }
        String rucFilter = (ruc == null || ruc.equals("TODO")) ? "" : ruc;
        List<CotizacionProveedor> lista = ctrl.buscar(texto, rucFilter, activaFilter);
        for (CotizacionProveedor c : lista) {
            modelo.addRow(new Object[]{
                    c.getIdCotizacion(),
                    c.getRuc(),
                    c.getGenero(),
                    c.getCantidadPollos(),
                    c.getAsignadoMinimo(),
                    c.getAsignadoMaximo(),
                    c.getPrecioMaximo(),
                    c.getPrecioMinimo(),
                    c.getActiva(),
                    c.getFechaRegistro()
            });
        }
    }

    private void abrirInsertar() {
        CotizacionProveedorInsertarDialog d = new CotizacionProveedorInsertarDialog(SwingUtilities.getWindowAncestor(this), this);
        d.setVisible(true);
    }

    private void abrirActualizar() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una cotización para actualizar.");
            return;
        }
        Integer id = (Integer) modelo.getValueAt(fila, 0);
        CotizacionProveedorActualizarDialog d = new CotizacionProveedorActualizarDialog(SwingUtilities.getWindowAncestor(this), this, id);
        d.setVisible(true);
    }

    private void eliminar() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una cotización para eliminar.");
            return;
        }
        int id = (Integer) modelo.getValueAt(fila, 0);
        int conf = JOptionPane.showConfirmDialog(this, "Eliminar cotización " + id + " ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf != JOptionPane.YES_OPTION) return;

        CotizacionProveedorEliminarController elim = new CotizacionProveedorEliminarController();
        boolean ok = elim.eliminar(id);
        if (ok) {
            JOptionPane.showMessageDialog(this, "Cotización eliminada.");
            cargarTodos();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar. Revise dependencias o errores.");
        }
    }

    // utilidad: rellenar combo con proveedores
    private void llenarComboProveedores(JComboBox<String> cb) {
        cb.removeAllItems();
        cb.addItem("TODO");
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT RUC FROM proveedor");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) cb.addItem(rs.getString("RUC"));
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // método público que usan dialogs para refrescar
    public void refrescar() { cargarTodos(); }
}
