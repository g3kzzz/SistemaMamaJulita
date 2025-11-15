package com.mamajulit.View.Inventario;

import com.mamajulit.Controller.Inventario.InventarioGestionadorController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

/**
 * Vista del módulo de Inventario.
 * Muestra productos, proveedores, órdenes y reportes con buscador dinámico.
 */
public class InventarioGestionador extends JPanel {

    private final InventarioGestionadorController controller;
    private JTextField txtBuscar;
    private JPanel resultadosPanel;

    public InventarioGestionador() {
        this.controller = new InventarioGestionadorController();
        setLayout(new BorderLayout());
        setBackground(new Color(249, 250, 251));

        JLabel titulo = new JLabel("Inventario", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(18, 10, 10, 10));
        add(titulo, BorderLayout.NORTH);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setOpaque(false);
        container.setBorder(BorderFactory.createEmptyBorder(10, 12, 12, 12));

        // 1) Barra de búsqueda
        JPanel barraBusqueda = crearBarraBusqueda();
        container.add(barraBusqueda);
        container.add(Box.createVerticalStrut(14));

        // 2) Métricas resumen
        container.add(crearPanelMetricas(controller.obtenerMetricas()));
        container.add(Box.createVerticalStrut(14));

        // 3) Resultados dinámicos
        resultadosPanel = new JPanel();
        resultadosPanel.setLayout(new BoxLayout(resultadosPanel, BoxLayout.Y_AXIS));
        resultadosPanel.setOpaque(false);

        actualizarResultados("");

        container.add(resultadosPanel);

        JScrollPane scroll = new JScrollPane(container);
        scroll.getVerticalScrollBar().setUnitIncrement(14);
        scroll.setBorder(null);
        add(scroll, BorderLayout.CENTER);
    }

    /** ------------------ COMPONENTES ------------------ **/
    private JPanel crearBarraBusqueda() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setOpaque(false);

        txtBuscar = new JTextField();
        txtBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtBuscar.setToolTipText("Buscar productos, proveedores u órdenes...");
        txtBuscar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 210, 210)),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));

        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                actualizarResultados(txtBuscar.getText().trim());
            }
        });

        panel.add(txtBuscar, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearPanelMetricas(Map<String, String> metricas) {
        int cols = Math.max(1, metricas.size());
        JPanel panel = new JPanel(new GridLayout(1, cols, 12, 0));
        panel.setOpaque(false);
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

    private JPanel crearSeccionTabla(String titulo, List<Map<String, Object>> datos) {
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

        DefaultTableModel model = new DefaultTableModel() {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };

        Map<String, Object> first = datos.get(0);
        for (String c : first.keySet()) model.addColumn(c);
        for (Map<String, Object> fila : datos) model.addRow(fila.values().toArray());

        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setRowHeight(26);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoCreateRowSorter(true);

        JScrollPane sp = new JScrollPane(table);
        sp.setBorder(null);
        panel.add(sp, BorderLayout.CENTER);
        return panel;
    }

    /** ------------------ ACTUALIZAR RESULTADOS ------------------ **/
    private void actualizarResultados(String filtro) {
        resultadosPanel.removeAll();

        resultadosPanel.add(crearSeccionTabla("Productos (" + filtro + ")", controller.listarProductos(filtro)));
        resultadosPanel.add(Box.createVerticalStrut(10));

        resultadosPanel.add(crearSeccionTabla("Proveedores", controller.listarProveedores(filtro)));
        resultadosPanel.add(Box.createVerticalStrut(10));

        resultadosPanel.add(crearSeccionTabla("Órdenes de Compra", controller.listarOrdenesCompra(filtro)));
        resultadosPanel.add(Box.createVerticalStrut(10));

        resultadosPanel.add(crearSeccionTabla("Reportes de Compra", controller.listarReportes(filtro)));

        resultadosPanel.revalidate();
        resultadosPanel.repaint();
    }
}
