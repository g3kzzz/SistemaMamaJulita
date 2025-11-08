package com.mamajulit.View.Dashboard;

import com.mamajulit.Controller.Dashboard.ObservadorDashboardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ObservadorDashboardView extends JFrame {

    private JPanel sidebar;
    private JPanel contentArea;
    private JLabel userNameLabel;
    private ObservadorDashboardController controller;

    public ObservadorDashboardView(String nombreUsuario) {
        // Configuración general
        setTitle("Panel Observador - Mama Julita");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        controller = new ObservadorDashboardController(this);

        // === SIDEBAR ===
        sidebar = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0,
                        new Color(25, 42, 86),
                        0, getHeight(),
                        new Color(70, 60, 130));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        sidebar.setPreferredSize(new Dimension(270, getHeight()));

        // === PANEL SUPERIOR ===
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));

        // Logo
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/logo.png"));
        JLabel logoLabel;
        if (logoIcon.getIconWidth() > 0) {
            Image scaled = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            logoLabel = new JLabel(new ImageIcon(scaled));
        } else {
            logoLabel = new JLabel("Logo", SwingConstants.CENTER);
        }
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(logoLabel);

        // Usuario
        userNameLabel = new JLabel(nombreUsuario, SwingConstants.CENTER);
        userNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        userNameLabel.setForeground(Color.WHITE);
        userNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(userNameLabel);
        topPanel.add(Box.createVerticalStrut(15));

        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(255, 255, 255, 100));
        topPanel.add(sep);

        // === MENÚ ===
        JPanel menuPanel = new JPanel(new GridLayout(0, 1, 0, 10));
        menuPanel.setOpaque(false);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(25, 15, 25, 15));

        String[] opciones = {
                "Dashboard Principal",
                "Inventario",
                "Reportes / Estadísticas"
        };

        for (String texto : opciones) {
            JButton boton = crearBotonMenu(texto);
            menuPanel.add(boton);
        }

        // === FOOTER ===
        JPanel footer = new JPanel();
        footer.setOpaque(false);
        footer.setLayout(new BoxLayout(footer, BoxLayout.Y_AXIS));
        footer.setBorder(BorderFactory.createEmptyBorder(20, 15, 25, 15));

        JButton logoutButton = new JButton("Cerrar sesión");
        logoutButton.setBackground(new Color(255, 127, 36));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.addActionListener(e -> controller.handleLogout());

        footer.add(Box.createVerticalGlue());
        footer.add(logoutButton);

        sidebar.add(topPanel, BorderLayout.NORTH);
        sidebar.add(menuPanel, BorderLayout.CENTER);
        sidebar.add(footer, BorderLayout.SOUTH);

        // === ÁREA PRINCIPAL ===
        contentArea = new JPanel(new BorderLayout());
        contentArea.setBackground(new Color(249, 250, 251));

        // Barra superior
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.WHITE);
        topBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(225, 225, 225)));
        topBar.setPreferredSize(new Dimension(0, 60));

        JLabel titulo = new JLabel("Panel Observador", SwingConstants.LEFT);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setForeground(new Color(25, 42, 86));
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        JLabel rolLabel = new JLabel("Modo lectura", SwingConstants.RIGHT);
        rolLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        rolLabel.setForeground(new Color(120, 120, 120));
        rolLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));

        topBar.add(titulo, BorderLayout.WEST);
        topBar.add(rolLabel, BorderLayout.EAST);
        contentArea.add(topBar, BorderLayout.NORTH);

        // Panel central (bienvenida)
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(230, 230, 230)),
                BorderFactory.createEmptyBorder(30, 40, 30, 40)
        ));

        JLabel bienvenida = new JLabel("Bienvenido al Panel Observador");
        bienvenida.setFont(new Font("Segoe UI", Font.BOLD, 22));
        bienvenida.setForeground(new Color(25, 42, 86));
        bienvenida.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descripcion = new JLabel(
                "<html><div style='text-align:center;'>Visualiza información del sistema sin realizar modificaciones.<br>Accede a reportes, inventarios y métricas generales.</div></html>");
        descripcion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        descripcion.setForeground(new Color(90, 90, 90));
        descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(bienvenida);
        card.add(Box.createVerticalStrut(10));
        card.add(descripcion);

        centerPanel.add(card, new GridBagConstraints());
        contentArea.add(centerPanel, BorderLayout.CENTER);

        // === COMBINAR ===
        add(sidebar, BorderLayout.WEST);
        add(contentArea, BorderLayout.CENTER);

        setVisible(true);
    }

    // === CREACIÓN DE BOTONES DE MENÚ ===
    private JButton crearBotonMenu(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        boton.setBackground(new Color(0, 0, 0, 0)); // Transparente
        boton.setForeground(Color.WHITE);
        boton.setOpaque(false);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

        // Efecto hover
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(new Color(255, 127, 36));
                boton.setOpaque(true);
                boton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setOpaque(false);
                boton.setForeground(Color.WHITE);
            }
        });

        boton.addActionListener(e -> controller.handleMenuClick(texto));
        return boton;
    }

    // === Getters ===
    public JPanel getContentArea() { return contentArea; }
    public JLabel getUserNameLabel() { return userNameLabel; }
}
