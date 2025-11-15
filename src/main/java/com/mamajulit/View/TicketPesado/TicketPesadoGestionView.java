package com.mamajulit.View.TicketPesado;

import com.mamajulit.Controller.TicketPesado.*;
import com.mamajulit.Model.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class TicketPesadoGestionView extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;

    public TicketPesadoGestionView() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // PANEL SUPERIOR (BOTONES)
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

        // TABLA
        modelo = new DefaultTableModel();
        String[] columnas = {"Id", "Fecha Salida", "Fecha Ingreso", "Monto Total", "Peso Promedio",
                "Genero Pollo", "Cantidad Pollo", "Mortalidad", "Destino", "Merma",
                "Placa Vehiculo", "Conductor", "Plantel"};
        for (String col : columnas) modelo.addColumn(col);

        tabla = new JTable(modelo);
        tabla.setRowHeight(25);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        cargarTickets();

        // EVENTOS
        btnAgregar.addActionListener(e -> abrirDialogAgregar());
        btnActualizar.addActionListener(e -> abrirDialogActualizar());
        btnEliminar.addActionListener(e -> eliminarTicket());
        btnRefrescar.addActionListener(e -> cargarTickets());
    }

    protected void cargarTickets() {
        modelo.setRowCount(0);
        TicketPesadoGestionController ctrl = new TicketPesadoGestionController();
        List<HashMap<String, Object>> lista = ctrl.listarTickets();
        for (HashMap<String, Object> t : lista) {
            modelo.addRow(new Object[]{
                    t.get("Id_ticket"), t.get("Fecha_salida"), t.get("Fecha_ingreso"),
                    t.get("Monto_total"), t.get("Peso_promedio"), t.get("Genero_pollo"),
                    t.get("Cantidad_pollo"), t.get("Mortalidad"), t.get("Destino"),
                    t.get("Merma"), t.get("Placa_vehiculo"), t.get("Id_conductor"), t.get("Id_plantel")
            });
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
        TicketPesadoEliminarController ctrl = new TicketPesadoEliminarController();
        if (ctrl.eliminarTicket(id_ticket, usuario)) {
            JOptionPane.showMessageDialog(this, "Ticket eliminado.");
            cargarTickets();
        }
    }
}
