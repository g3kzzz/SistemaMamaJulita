package com.mamajulit.View.ProveedorProducto;

import com.mamajulit.Controller.ProveedorProducto.ProveedorProductoGestionController;
import com.mamajulit.Controller.ProveedorProducto.ProveedorProductoEliminarController;
import com.mamajulit.Model.DetalleProveedorProducto;
import com.mamajulit.Model.ConexionBD;
import com.mamajulit.Util.ValidationUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.List;

public class ProveedorProductoGestionView extends JPanel {

    private final ProveedorProductoGestionController ctrl = new ProveedorProductoGestionController();
    private JTable tabla;
    private DefaultTableModel modelo;
    private JTextField txtFiltro;

    public ProveedorProductoGestionView() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Top: botones + busqueda + combo filtros (proveedor/producto)
        JPanel top = new JPanel(new BorderLayout());
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRefrescar = new JButton("Refrescar");
        botones.add(btnAgregar); botones.add(btnEditar); botones.add(btnEliminar); botones.add(btnRefrescar);

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        txtFiltro = new JTextField(25);
        JButton btnBuscar = new JButton("Buscar");
        right.add(txtFiltro); right.add(btnBuscar);

        top.add(botones, BorderLayout.WEST);
        top.add(right, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);

        // Tabla
        modelo = new DefaultTableModel(new Object[]{"Id","Producto","Unidad","Proveedor (RUC)","Nombre Proveedor","Cantidad","Precio base"},0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        tabla = new JTable(modelo);
        tabla.setRowHeight(26);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Eventos
        btnRefrescar.addActionListener(e -> cargarTodos());
        btnBuscar.addActionListener(e -> buscar(txtFiltro.getText().trim()));
        btnAgregar.addActionListener(e -> abrirInsertar());
        btnEditar.addActionListener(e -> abrirEditar());
        btnEliminar.addActionListener(e -> eliminar());

        // carga inicial
        cargarTodos();
    }

    private void cargarTodos() {
        modelo.setRowCount(0);
        List<DetalleProveedorProducto> lista = ctrl.listar();
        for (DetalleProveedorProducto d : lista) {
            modelo.addRow(new Object[]{
                    d.getId(),
                    d.getDescripcionProducto(),
                    d.getUnidad(),
                    d.getRucProveedor(),
                    d.getNombreProveedor(),
                    d.getCantidad(),
                    d.getPrecioBase()
            });
        }
    }

    private void buscar(String filtro) {
        modelo.setRowCount(0);
        List<DetalleProveedorProducto> lista = ctrl.buscar(filtro);
        for (DetalleProveedorProducto d : lista) {
            modelo.addRow(new Object[]{
                    d.getId(),
                    d.getDescripcionProducto(),
                    d.getUnidad(),
                    d.getRucProveedor(),
                    d.getNombreProveedor(),
                    d.getCantidad(),
                    d.getPrecioBase()
            });
        }
    }

    private void abrirInsertar() {
        ProveedorProductoInsertDialog d = new ProveedorProductoInsertDialog(SwingUtilities.getWindowAncestor(this), this);
        d.setVisible(true);
    }

    private void abrirEditar() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) { JOptionPane.showMessageDialog(this,"Selecciona un registro."); return; }
        Integer id = (Integer) modelo.getValueAt(fila, 0);
        ProveedorProductoEditDialog d = new ProveedorProductoEditDialog(SwingUtilities.getWindowAncestor(this), this, id);
        d.setVisible(true);
    }

    private void eliminar() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) { JOptionPane.showMessageDialog(this,"Selecciona un registro."); return; }
        int id = (Integer) modelo.getValueAt(fila,0);
        int conf = JOptionPane.showConfirmDialog(this, "Eliminar detalle ID "+id+"?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf != JOptionPane.YES_OPTION) return;

        ProveedorProductoEliminarController elimCtrl = new ProveedorProductoEliminarController();
        try {
            boolean ok = elimCtrl.eliminar(id, "admin"); // reemplazar por usuario real
            if (ok) { JOptionPane.showMessageDialog(this,"Eliminado."); cargarTodos(); }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al eliminar: " + ex.getMessage());
        }
    }

    // utiles para llenar combo en diálogos
    public static void llenarComboProductos(JComboBox<String> cb) {
        cb.removeAllItems();
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT Id_producto, Descripcion FROM producto");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) cb.addItem(rs.getInt("Id_producto") + " - " + rs.getString("Descripcion"));
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public static void llenarComboProveedores(JComboBox<String> cb) {
        cb.removeAllItems();
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT RUC, Nombre FROM proveedor");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) cb.addItem(rs.getString("RUC") + " - " + rs.getString("Nombre"));
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // Exponer métodos para que diálogos refresquen
    public void refrescar() { cargarTodos(); }
}
