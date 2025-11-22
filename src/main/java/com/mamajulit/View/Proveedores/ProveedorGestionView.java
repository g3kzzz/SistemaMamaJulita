package com.mamajulit.View.Proveedores;

import com.mamajulit.Controller.Proveedores.ProveedorActualizarController;
import com.mamajulit.Controller.Proveedores.ProveedorAgregarController;
import com.mamajulit.Controller.Proveedores.ProveedorEliminarController;
import com.mamajulit.Model.ConexionBD;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorGestionView extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JTextField txtBuscar;
    private JComboBox<String> filterEstado;

    public ProveedorGestionView() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // --------------------------------------------------
        // PANEL SUPERIOR: BOTONES + BUSQUEDA + FILTROS
        // --------------------------------------------------
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botonesPanel.setBackground(Color.WHITE);
        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRefrescar = new JButton("Refrescar");
        botonesPanel.add(btnAgregar);
        botonesPanel.add(btnActualizar);
        botonesPanel.add(btnEliminar);
        botonesPanel.add(btnRefrescar);

        JPanel filtrosPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        filtrosPanel.setBackground(Color.WHITE);
        txtBuscar = new JTextField(20);
        filterEstado = new JComboBox<>();
        filterEstado.addItem("Todos");
        filterEstado.addItem("Activo");
        filterEstado.addItem("Inactivo");
        filtrosPanel.add(new JLabel("Buscar:"));
        filtrosPanel.add(txtBuscar);
        filtrosPanel.add(new JLabel("Estado:"));
        filtrosPanel.add(filterEstado);

        topPanel.add(botonesPanel, BorderLayout.WEST);
        topPanel.add(filtrosPanel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // --------------------------------------------------
        // TABLA
        // --------------------------------------------------
        modelo = new DefaultTableModel(new Object[]{
                "RUC", "Nombre", "Estado", "Email", "Teléfono",
                "Calle", "Número", "Ciudad"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tabla = new JTable(modelo);
        tabla.setRowHeight(25);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // --------------------------------------------------
        // EVENTOS
        // --------------------------------------------------
        btnAgregar.addActionListener(e -> abrirDialogAgregar());
        btnActualizar.addActionListener(e -> abrirDialogActualizar());
        btnEliminar.addActionListener(e -> eliminarProveedor());
        btnRefrescar.addActionListener(e -> cargarProveedores());

        // búsqueda dinámica
        txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { buscar(); }
            @Override public void removeUpdate(DocumentEvent e) { buscar(); }
            @Override public void changedUpdate(DocumentEvent e) { buscar(); }
        });

        // filtro por estado
        filterEstado.addActionListener(e -> buscar());

        // carga inicial
        cargarProveedores();
    }

    // ==============================================================
    // CARGAR PROVEEDORES
    // ==============================================================
    protected void cargarProveedores() {
        modelo.setRowCount(0);

        String sql = "{CALL sp_listar_proveedores()}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            List<Object[]> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(new Object[]{
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

            modelo.setRowCount(0);
            for (Object[] fila : lista) {
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "❌ Error al cargar proveedores:\n" + e.getMessage());
        }
    }

    // ==============================================================
    // BUSCAR CON FILTROS
    // ==============================================================
    private void buscar() {
        String filtro = txtBuscar.getText().trim().toLowerCase();
        String estadoFiltro = filterEstado.getSelectedItem().toString();

        modelo.setRowCount(0);

        String sql = "{CALL sp_listar_proveedores()}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                String ruc = rs.getString("RUC");
                String nombre = rs.getString("Nombre");
                String estado = rs.getString("Estado").equals("1") ? "Activo" : "Inactivo";
                String email = rs.getString("Email");
                String telefono = rs.getString("Telefono");
                String calle = rs.getString("Calle");
                String numero = rs.getString("Numero");
                String ciudad = rs.getString("Ciudad");

                boolean cumpleFiltroTexto = ruc.toLowerCase().contains(filtro)
                        || nombre.toLowerCase().contains(filtro)
                        || email.toLowerCase().contains(filtro)
                        || telefono.toLowerCase().contains(filtro)
                        || calle.toLowerCase().contains(filtro)
                        || numero.toLowerCase().contains(filtro)
                        || ciudad.toLowerCase().contains(filtro);

                boolean cumpleFiltroEstado = estadoFiltro.equals("Todos") || estado.equals(estadoFiltro);

                if (cumpleFiltroTexto && cumpleFiltroEstado) {
                    modelo.addRow(new Object[]{ruc, nombre, estado, email, telefono, calle, numero, ciudad});
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "❌ Error en búsqueda:\n" + e.getMessage());
        }
    }

    // ==============================================================
    // ABRIR DIALOGOS CRUD
    // ==============================================================
    private void abrirDialogAgregar() {
        ProveedorAgregarDialog dialog = new ProveedorAgregarDialog(this);
        dialog.setVisible(true);
    }

    private void abrirDialogActualizar() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un proveedor.");
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

    private void eliminarProveedor() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un proveedor.");
            return;
        }

        String ruc = modelo.getValueAt(fila, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar proveedor con RUC: " + ruc + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        ProveedorEliminarController ctrl = new ProveedorEliminarController();
        if (ctrl.eliminarProveedor(ruc)) {
            JOptionPane.showMessageDialog(this, "Proveedor eliminado correctamente.");
            cargarProveedores();
        }
    }
}
