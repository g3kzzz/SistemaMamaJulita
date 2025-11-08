package com.mamajulit.View.Inicio;

import com.mamajulit.Controller.Inicio.InicioGestionadorController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Panel de inicio del gestor. Muestra métricas y tablas (top 3) organizadas y compactas.
 */
public class InicioGestionador extends JPanel {

    private final InicioGestionadorController controller;

    public InicioGestionador() {
        this.controller = new InicioGestionadorController();
        setLayout(new BorderLayout());
        setBackground(new Color(249, 250, 251));

        // Título principal
        JLabel titulo = new JLabel("Inicio", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(18, 10, 10, 10));
        add(titulo, BorderLayout.NORTH);

        // Contenedor central con scroll si es necesario
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setOpaque(false);
        container.setBorder(BorderFactory.createEmptyBorder(8, 12, 12, 12));

        // 1) Panel de métricas (cards)
        container.add(crearPanelMetricas(controller.obtenerMetricas()));
        container.add(Box.createVerticalStrut(14));

        // 2) Secciones de tablas (top 3)
        container.add(crearSeccionTablaCompacta("Últimos Tickets Pesados", controller.obtenerTicketsRecientes()));
        container.add(Box.createVerticalStrut(10));

        container.add(crearSeccionTablaCompacta("Órdenes de Recepción (Recientes)", controller.obtenerOrdenesRecientes()));
        container.add(Box.createVerticalStrut(10));

        container.add(crearSeccionTablaCompacta("Productos incorporados (Recientes)", controller.obtenerProductosRecientes()));
        container.add(Box.createVerticalStrut(10));

        // Adicionales
        container.add(crearSeccionTablaCompacta("Conductores activos (Top 3)", controller.obtenerConductoresActivos()));
        container.add(Box.createVerticalStrut(10));

        container.add(crearSeccionTablaCompacta("Jabas por Galpón (Top 3)", controller.obtenerJabasPorGalpon()));
        container.add(Box.createVerticalStrut(10));

        container.add(crearSeccionTablaCompacta("Órdenes de Compra Activas (Top 3)", controller.obtenerOrdenesActivas()));
        container.add(Box.createVerticalStrut(10));

        container.add(crearSeccionTablaCompacta("Mortalidad por Tipo / Destino (Top 3)", controller.obtenerMortalidadPorAve()));
        container.add(Box.createVerticalStrut(10));

        container.add(crearSeccionTablaCompacta("Entregas por Conductor y Placa (Top 3)", controller.obtenerEntregasPorConductorVehiculo()));

        JScrollPane scroll = new JScrollPane(container);
        scroll.getVerticalScrollBar().setUnitIncrement(14);
        scroll.setBorder(null);
        add(scroll, BorderLayout.CENTER);
    }

    /**
     * Crea tarjetas de métricas horizontales.
     */
    private JPanel crearPanelMetricas(Map<String, String> metricas) {
        int cols = Math.max(1, metricas.size());
        JPanel panel = new JPanel(new GridLayout(1, cols, 12, 0));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        for (Map.Entry<String, String> e : metricas.entrySet()) {
            JPanel card = new JPanel(new BorderLayout());
            card.setBackground(Color.WHITE);
            card.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(220, 220, 220)),
                    BorderFactory.createEmptyBorder(10, 12, 10, 12)
            ));

            JLabel t = new JLabel(e.getKey(), SwingConstants.CENTER);
            t.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            t.setForeground(new Color(90, 90, 90));

            JLabel v = new JLabel(e.getValue(), SwingConstants.CENTER);
            v.setFont(new Font("Segoe UI", Font.BOLD, 20));
            v.setForeground(new Color(25, 42, 86));

            card.add(t, BorderLayout.NORTH);
            card.add(v, BorderLayout.CENTER);

            panel.add(card);
        }
        return panel;
    }

    /**
     * Crea una sección compacta con título y tabla no editable mostrando máximo 3 filas.
     */
    private JPanel crearSeccionTablaCompacta(String titulo, List<Map<String, Object>> datos) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(titulo),
                BorderFactory.createEmptyBorder(6, 6, 6, 6)
        ));

        if (datos == null || datos.isEmpty()) {
            JLabel vacio = new JLabel("No hay datos", SwingConstants.CENTER);
            vacio.setForeground(Color.GRAY);
            vacio.setFont(new Font("Segoe UI", Font.ITALIC, 12));
            panel.add(vacio, BorderLayout.CENTER);
            return panel;
        }

        // Modelo no editable
        DefaultTableModel model = new DefaultTableModel() {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };

        // Columnas según la primera fila
        Map<String, Object> first = datos.get(0);
        for (String c : first.keySet()) model.addColumn(c);

        // Añade filas (ya vienen limitadas a 3 desde el controller)
        for (Map<String, Object> row : datos) {
            Object[] vals = row.values().toArray();
            // Convertir posibles objetos Date/Timestamp a string
            for (int i = 0; i < vals.length; i++) {
                if (vals[i] instanceof java.sql.Date || vals[i] instanceof java.sql.Timestamp) {
                    vals[i] = String.valueOf(vals[i]);
                }
            }
            model.addRow(vals);
        }

        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoCreateRowSorter(true);

        // Ajustar ancho y altura compacta
        table.setPreferredScrollableViewportSize(new Dimension(900, Math.min(3, model.getRowCount()) * 26 + 24));
        JScrollPane sp = new JScrollPane(table);
        sp.setBorder(null);
        panel.add(sp, BorderLayout.CENTER);
        return panel;
    }
}
