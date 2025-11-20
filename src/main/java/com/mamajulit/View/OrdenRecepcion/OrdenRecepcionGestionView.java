package com.mamajulit.View.OrdenRecepcion;

import com.mamajulit.Controller.OrdenRecepcion.OrdenRecepcionGestionController;
import com.mamajulit.Controller.OrdenRecepcion.OrdenRecepcionEliminarController;
import com.mamajulit.Model.OrdenRecepcion;
import com.mamajulit.Model.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.List;

public class OrdenRecepcionGestionView extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private OrdenRecepcionGestionController ctrl = new OrdenRecepcionGestionController();

    public OrdenRecepcionGestionView() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // top panel botones + busqueda
        JPanel top = new JPanel(new BorderLayout());
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRefrescar = new JButton("Refrescar");
        botones.add(btnAgregar); botones.add(btnActualizar); botones.add(btnEliminar); botones.add(btnRefrescar);

        JPanel busquedaPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JTextField txtBuscar = new JTextField(25);
        JButton btnBuscar = new JButton("Buscar");
        busquedaPanel.add(txtBuscar); busquedaPanel.add(btnBuscar);

        top.add(botones, BorderLayout.WEST);
        top.add(busquedaPanel, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);

        // tabla
        modelo = new DefaultTableModel(new Object[]{
                "Código", "Descripción", "Lote", "Tipo", "Cantidad",
                "Hora", "Fecha", "Almacén", "Peso total", "Observ.", "Emitido por",
                "Entregado por", "Id Ticket", "Placa"
        }, 0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };

        tabla = new JTable(modelo);
        tabla.setRowHeight(24);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // eventos
        btnRefrescar.addActionListener(e -> cargarTodos());
        btnBuscar.addActionListener(e -> buscar(txtBuscar.getText().trim()));
        btnAgregar.addActionListener(e -> abrirDialogAgregar());
        btnActualizar.addActionListener(e -> abrirDialogActualizar());
        btnEliminar.addActionListener(e -> eliminarTicket());

        // carga inicial
        cargarTodos();
    }

    protected void cargarTodos() {
        modelo.setRowCount(0);
        List<OrdenRecepcion> lista = ctrl.listar();
        for (OrdenRecepcion o : lista) {
            modelo.addRow(new Object[]{
                    o.getCodigoRecepcion(),
                    o.getDescripcion(),
                    o.getLote(),
                    o.getTipo(),
                    o.getCantidad(),
                    o.getHora(),
                    o.getFecha(),
                    o.getAlmacen(),
                    o.getPesoTotal(),
                    o.getObservaciones(),
                    o.getEmitidoPor(),
                    o.getEntregadoPor(),
                    o.getIdTicket(),
                    o.getPlacaVehiculo()
            });
        }
    }

    protected void buscar(String filtro) {
        modelo.setRowCount(0);
        List<OrdenRecepcion> lista = ctrl.buscar(filtro);
        for (OrdenRecepcion o : lista) {
            modelo.addRow(new Object[]{
                    o.getCodigoRecepcion(),
                    o.getDescripcion(),
                    o.getLote(),
                    o.getTipo(),
                    o.getCantidad(),
                    o.getHora(),
                    o.getFecha(),
                    o.getAlmacen(),
                    o.getPesoTotal(),
                    o.getObservaciones(),
                    o.getEmitidoPor(),
                    o.getEntregadoPor(),
                    o.getIdTicket(),
                    o.getPlacaVehiculo()
            });
        }
    }

    private void abrirDialogAgregar() {
        OrdenRecepcionInsertarDialog d = new OrdenRecepcionInsertarDialog(SwingUtilities.getWindowAncestor(this), this);
        d.setVisible(true);
    }

    private void abrirDialogActualizar() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una orden de recepción.");
            return;
        }
        Integer codigo = (Integer) modelo.getValueAt(fila, 0);
        OrdenRecepcionActualizarDialog d = new OrdenRecepcionActualizarDialog(SwingUtilities.getWindowAncestor(this), this, codigo);
        d.setVisible(true);
    }

    private void eliminarTicket() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una orden para eliminar.");
            return;
        }
        int codigo = (Integer) modelo.getValueAt(fila, 0);
        int conf = JOptionPane.showConfirmDialog(this, "Eliminar orden " + codigo + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf != JOptionPane.YES_OPTION) return;

        OrdenRecepcionEliminarController elimCtrl = new OrdenRecepcionEliminarController();
        boolean ok = elimCtrl.eliminar(codigo, "admin"); // reemplazar por usuario real si tienes
        if (ok) {
            JOptionPane.showMessageDialog(this, "Orden eliminada.");
            cargarTodos();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar. Revise dependencias u errores.");
        }
    }

    // util: cargar datos para combos (empleados,tickets,vehiculos)
    public static void llenarComboEmpleado(JComboBox<Integer> cb) {
        cb.removeAllItems();
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT Id_empleado FROM empleado");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) cb.addItem(rs.getInt("Id_empleado"));
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public static void llenarComboTicket(JComboBox<Integer> cb) {
        cb.removeAllItems();
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT Id_ticket FROM ticket_pesado");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) cb.addItem(rs.getInt("Id_ticket"));
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public static void llenarComboVehiculo(JComboBox<String> cb) {
        cb.removeAllItems();
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT Placa FROM vehiculo");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) cb.addItem(rs.getString("Placa"));
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
