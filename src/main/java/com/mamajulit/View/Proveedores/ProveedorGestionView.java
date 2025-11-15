package com.mamajulit.View.Proveedores;

import com.mamajulit.Controller.Proveedores.ProveedorAgregarController;
import com.mamajulit.Controller.Proveedores.ProveedorActualizarController;
import com.mamajulit.Controller.Proveedores.ProveedorEliminarController;
import com.mamajulit.Model.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ProveedorGestionView extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;

    public ProveedorGestionView() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // --------------------------------------------------
        // PANEL SUPERIOR (BOTONES)
        // --------------------------------------------------
        JPanel panelBtns = new JPanel(new FlowLayout());
        panelBtns.setBackground(Color.WHITE);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRefrescar = new JButton("Refrescar");

        panelBtns.add(btnAgregar);
        panelBtns.add(btnActualizar);
        panelBtns.add(btnEliminar);
        panelBtns.add(btnRefrescar);

        add(panelBtns, BorderLayout.NORTH);

        // --------------------------------------------------
        // TABLA
        // --------------------------------------------------
        modelo = new DefaultTableModel();
        modelo.addColumn("RUC");
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado");
        modelo.addColumn("Email");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Calle");
        modelo.addColumn("Número");
        modelo.addColumn("Ciudad");

        tabla = new JTable(modelo);
        tabla.setRowHeight(25);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        cargarProveedores();

        // --------------------------------------------------
        // BOTONES CRUD
        // --------------------------------------------------
        btnAgregar.addActionListener(e -> abrirDialogAgregar());
        btnActualizar.addActionListener(e -> abrirDialogActualizar());
        btnEliminar.addActionListener(e -> eliminarProveedor());
        btnRefrescar.addActionListener(e -> cargarProveedores());
    }


    // ==============================================================
    //                 CARGAR PROVEEDORES EN TABLA
    // ==============================================================
    protected void cargarProveedores() {
        modelo.setRowCount(0);

        String sql = "{CALL sp_listar_proveedores()}";

        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                modelo.addRow(new Object[]{
                        rs.getString("RUC"),
                        rs.getString("Nombre"),
                        rs.getString("Estado"),
                        rs.getString("Email"),
                        rs.getString("Telefono"),
                        rs.getString("Calle"),
                        rs.getString("Numero"),
                        rs.getString("Ciudad")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "❌ Error al cargar proveedores:\n" + e.getMessage());
        }
    }


    // ==============================================================
    //                       AGREGAR (DIÁLOGO)
    // ==============================================================
    private void abrirDialogAgregar() {
        ProveedorAgregarDialog dialog = new ProveedorAgregarDialog(this);
        dialog.setVisible(true);
    }


    // ==============================================================
    //                       ACTUALIZAR (DIÁLOGO)
    // ==============================================================
    private void abrirDialogActualizar() {

        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un proveedor de la tabla.");
            return;
        }

        String ruc = modelo.getValueAt(fila, 0).toString();

        ProveedorActualizarDialog dialog = new ProveedorActualizarDialog(
                this,
                ruc,
                modelo.getValueAt(fila, 1).toString(),
                modelo.getValueAt(fila, 2).toString(),
                modelo.getValueAt(fila, 3).toString(),
                modelo.getValueAt(fila, 4).toString(),
                modelo.getValueAt(fila, 5).toString(),
                modelo.getValueAt(fila, 6).toString(),
                modelo.getValueAt(fila, 7).toString()
        );

        dialog.setVisible(true);
    }


    // ==============================================================
    //                       ELIMINAR PROVEEDOR
    // ==============================================================
    private void eliminarProveedor() {

        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un proveedor.");
            return;
        }

        String ruc = modelo.getValueAt(fila, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Eliminar proveedor con RUC: " + ruc + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) return;

        ProveedorEliminarController ctrl = new ProveedorEliminarController();

        if (ctrl.eliminarProveedor(ruc)) {
            JOptionPane.showMessageDialog(this, "Proveedor eliminado correctamente.");
            cargarProveedores();
        }
    }
}
