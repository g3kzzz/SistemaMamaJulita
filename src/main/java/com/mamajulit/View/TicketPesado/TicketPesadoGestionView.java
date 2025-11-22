package com.mamajulit.View.TicketPesado;

import com.mamajulit.Controller.TicketPesado.TicketPesadoGestionController;
import com.mamajulit.Model.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class TicketPesadoGestionView extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;

    // Combos para filtros
    private JComboBox<String> cbVehiculo, cbConductor, cbPlantel;
    private JTextField txtBuscar;

    public TicketPesadoGestionView() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // PANEL SUPERIOR (Filtros + Botones)
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(Color.WHITE);

        // PANEL FILTROS
        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelFiltros.setBackground(Color.WHITE);

        cbVehiculo = new JComboBox<>();
        cbConductor = new JComboBox<>();
        cbPlantel = new JComboBox<>();
        txtBuscar = new JTextField(15);
        txtBuscar.setToolTipText("Buscar en todas las columnas...");

        // Llenar combos desde BD
        llenarComboBox("Vehiculo", "Placa", cbVehiculo, true);
        llenarComboBox("Conductor", "Nro_Licencia", cbConductor, true);
        llenarComboBox("Plantel", "Id_plantel", cbPlantel, true);

        panelFiltros.add(new JLabel("Vehiculo:")); panelFiltros.add(cbVehiculo);
        panelFiltros.add(new JLabel("Conductor:")); panelFiltros.add(cbConductor);
        panelFiltros.add(new JLabel("Plantel:")); panelFiltros.add(cbPlantel);
        panelFiltros.add(new JLabel("Buscar:")); panelFiltros.add(txtBuscar);

        panelSuperior.add(panelFiltros, BorderLayout.NORTH);

        // PANEL BOTONES
        JPanel panelBtns = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBtns.setBackground(Color.WHITE);
        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRefrescar = new JButton("Refrescar");
        panelBtns.add(btnAgregar);
        panelBtns.add(btnActualizar);
        panelBtns.add(btnEliminar);
        panelBtns.add(btnRefrescar);
        panelSuperior.add(panelBtns, BorderLayout.SOUTH);

        add(panelSuperior, BorderLayout.NORTH);

        // TABLA
        modelo = new DefaultTableModel();
        String[] columnas = {"Id", "Fecha Salida", "Fecha Ingreso", "Monto Total", "Peso Promedio",
                "Genero Pollo", "Cantidad Pollo", "Mortalidad", "Destino", "Merma",
                "Placa Vehiculo", "Conductor", "Plantel"};
        for (String col : columnas) modelo.addColumn(col);

        tabla = new JTable(modelo);
        tabla.setRowHeight(25);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // EVENTOS FILTROS
        cbVehiculo.addActionListener(e -> cargarTicketsFiltrados());
        cbConductor.addActionListener(e -> cargarTicketsFiltrados());
        cbPlantel.addActionListener(e -> cargarTicketsFiltrados());

        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                cargarTicketsFiltrados();
            }
        });

        // EVENTOS BOTONES
        btnAgregar.addActionListener(e -> abrirDialogAgregar());
        btnActualizar.addActionListener(e -> abrirDialogActualizar());
        btnEliminar.addActionListener(e -> eliminarTicket());
        btnRefrescar.addActionListener(e -> {
            resetFiltros();
            cargarTicketsFiltrados();
        });

        // Cargar tabla inicial
        cargarTicketsFiltrados();
    }

    private void llenarComboBox(String tabla, String columna, JComboBox<String> combo, boolean agregarTodos) {
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement("SELECT " + columna + " FROM " + tabla);
             ResultSet rs = ps.executeQuery()) {

            if (agregarTodos) combo.addItem("Todos");
            while (rs.next()) {
                combo.addItem(rs.getString(columna));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void resetFiltros() {
        cbVehiculo.setSelectedIndex(0);
        cbConductor.setSelectedIndex(0);
        cbPlantel.setSelectedIndex(0);
        txtBuscar.setText("");
    }

    public void cargarTicketsFiltrados() {
        modelo.setRowCount(0);
        TicketPesadoGestionController ctrl = new TicketPesadoGestionController();
        List<HashMap<String, Object>> lista = ctrl.listarTickets();

        String filtroVehiculo = cbVehiculo.getSelectedItem().toString();
        String filtroConductor = cbConductor.getSelectedItem().toString();
        String filtroPlantel = cbPlantel.getSelectedItem().toString();
        String textoBuscar = txtBuscar.getText().toLowerCase();

        for (HashMap<String, Object> t : lista) {
            boolean pasaFiltro = true;

            if (!filtroVehiculo.equals("Todos") && !t.get("Placa_vehiculo").equals(filtroVehiculo)) pasaFiltro = false;
            if (!filtroConductor.equals("Todos") && !t.get("Id_conductor").equals(filtroConductor)) pasaFiltro = false;
            if (!filtroPlantel.equals("Todos") && !t.get("Id_plantel").equals(filtroPlantel)) pasaFiltro = false;

            if (!textoBuscar.isEmpty()) {
                boolean contiene = false;
                for (String key : t.keySet()) {
                    if (t.get(key) != null && t.get(key).toString().toLowerCase().contains(textoBuscar)) {
                        contiene = true;
                        break;
                    }
                }
                pasaFiltro = pasaFiltro && contiene;
            }

            if (pasaFiltro) {
                modelo.addRow(new Object[]{
                        t.get("Id_ticket"), t.get("Fecha_salida"), t.get("Fecha_ingreso"),
                        t.get("Monto_total"), t.get("Peso_promedio"), t.get("Genero_pollo"),
                        t.get("Cantidad_pollo"), t.get("Mortalidad"), t.get("Destino"),
                        t.get("Merma"), t.get("Placa_vehiculo"), t.get("Id_conductor"), t.get("Id_plantel")
                });
            }
        }
    }

    private void abrirDialogAgregar() {
        TicketPesadoAgregarDialog dialog = new TicketPesadoAgregarDialog(this);
        dialog.setVisible(true);
    }

    private void abrirDialogActualizar() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un ticket.");
            return;
        }
        TicketPesadoActualizarDialog dialog = new TicketPesadoActualizarDialog(
                this,
                Integer.parseInt(modelo.getValueAt(fila, 0).toString()),
                modelo.getValueAt(fila, 1).toString(),
                modelo.getValueAt(fila, 2).toString(),
                Float.parseFloat(modelo.getValueAt(fila, 3).toString()),
                Float.parseFloat(modelo.getValueAt(fila, 4).toString()),
                modelo.getValueAt(fila, 5).toString(),
                Integer.parseInt(modelo.getValueAt(fila, 6).toString()),
                Integer.parseInt(modelo.getValueAt(fila, 7).toString()),
                modelo.getValueAt(fila, 8).toString(),
                Float.parseFloat(modelo.getValueAt(fila, 9).toString()),
                modelo.getValueAt(fila, 10).toString(),
                modelo.getValueAt(fila, 11).toString(),
                modelo.getValueAt(fila, 12).toString()
        );
        dialog.setVisible(true);
    }

    private void eliminarTicket() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un ticket.");
            return;
        }
        int id_ticket = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
        String usuario = "admin"; // Cambiar según usuario logueado
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Eliminar ticket ID: " + id_ticket + "?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;
        com.mamajulit.Controller.TicketPesado.TicketPesadoEliminarController ctrl =
                new com.mamajulit.Controller.TicketPesado.TicketPesadoEliminarController();
        if (ctrl.eliminarTicket(id_ticket, usuario)) {
            JOptionPane.showMessageDialog(this, "Ticket eliminado.");
            cargarTicketsFiltrados();
        }
    }
}
