package com.mamajulit.View.Inicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InicioGestionadorView extends JPanel {

    public JTable tablaProductos;
    public JTable tablaTickets;

    public InicioGestionadorView() {
        setLayout(new BorderLayout());
        setBackground(new Color(249, 250, 251));

        // Título
        JLabel titulo = new JLabel("Panel de Inicio - Gestor", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(new Color(25, 42, 86));
        titulo.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        add(titulo, BorderLayout.NORTH);

        // Panel central
        JPanel panelCentral = new JPanel(new GridLayout(1,2,20,0));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));
        panelCentral.setBackground(new Color(249, 250, 251));

        // === Tabla de productos/jabas ===
        tablaProductos = new JTable();
        tablaProductos.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID Producto", "Descripción", "Unidad", "Cantidad en Jabas"}
        ));
        JScrollPane scrollProductos = new JScrollPane(tablaProductos);
        scrollProductos.setBorder(BorderFactory.createTitledBorder("Resumen de Inventario"));
        panelCentral.add(scrollProductos);

        // === Tabla de tickets pesados (solo seguimiento) ===
        tablaTickets = new JTable();
        tablaTickets.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID Ticket", "Fecha Salida", "Peso Promedio", "Placa Vehículo"}
        ));
        JScrollPane scrollTickets = new JScrollPane(tablaTickets);
        scrollTickets.setBorder(BorderFactory.createTitledBorder("Tickets Pesados Recientes"));
        panelCentral.add(scrollTickets);

        add(panelCentral, BorderLayout.CENTER);
    }
}
