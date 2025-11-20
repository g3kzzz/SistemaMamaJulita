package com.mamajulit.View.Dashboard;

import com.mamajulit.Controller.Dashboard.GestionadorDashboardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GestionadorDashboardView extends JFrame {

    private JPanel sidebar;
    private JPanel contentArea;
    private JLabel userNameLabel;
    private GestionadorDashboardController controller;

    private List<JButton> botonesMenu = new ArrayList<>();
    private JButton botonActivo = null;

    public GestionadorDashboardView(String nombreUsuario) {
        setTitle("Sistema Mama Julita - Panel Usuario Privilegiado");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        sidebar = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0,
                        new Color(29, 41, 57),
                        0, getHeight(),
                        new Color(39, 52, 71));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        sidebar.setPreferredSize(new Dimension(270, getHeight()));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));

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

        userNameLabel = new JLabel(nombreUsuario, SwingConstants.CENTER);
        userNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        userNameLabel.setForeground(Color.WHITE);
        userNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(userNameLabel);

        topPanel.add(Box.createVerticalStrut(15));
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(255, 255, 255, 80));
        topPanel.add(sep);

        // ==============================================================
        //                 MENÚ ACTUALIZADO Y REORDENADO
        // ==============================================================

        JPanel menuPanel = new JPanel(new GridLayout(0, 1, 0, 10));
        menuPanel.setOpaque(false);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(25, 15, 25, 15));

        String[] opciones = {
                "Inicio",
                "Inventario",
                "Órdenes de Recepción",
                "Tickets Pesados",
                "Proveedores",
                "Clientes",
                "Reportes",
                "Usuarios",
                "Configuración"
        };

        for (String texto : opciones) {
            JButton boton = crearBotonMenu(texto);
            botonesMenu.add(boton);
            menuPanel.add(boton);
        }

        // FOOTER
        JPanel footer = new JPanel();
        footer.setOpaque(false);
        footer.setLayout(new BoxLayout(footer, BoxLayout.Y_AXIS));
        footer.setBorder(BorderFactory.createEmptyBorder(20, 15, 25, 15));

        JButton logoutButton = new JButton("Cerrar sesión");
        logoutButton.setBackground(new Color(220, 38, 38));
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

        // AREA DE CONTENIDO
        contentArea = new JPanel(new BorderLayout());
        contentArea.setBackground(new Color(20, 29, 49));

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(245, 245, 245));
        topBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(200, 200, 200)));
        topBar.setPreferredSize(new Dimension(0, 60));

        JLabel topLogoLabel;
        if (logoIcon.getIconWidth() > 0) {
            Image scaledTopLogo = logoIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            topLogoLabel = new JLabel(new ImageIcon(scaledTopLogo));
        } else {
            topLogoLabel = new JLabel("Logo");
        }
        topLogoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Panel de Gestión", SwingConstants.LEFT);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setForeground(new Color(29, 41, 57));
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        JButton perfilButton = new JButton("Mi Perfil");
        perfilButton.setFocusPainted(false);
        perfilButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        perfilButton.setBackground(Color.WHITE);
        perfilButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        perfilButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JPanel leftTopBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
        leftTopBar.setOpaque(false);
        leftTopBar.add(topLogoLabel);
        leftTopBar.add(titulo);

        topBar.add(leftTopBar, BorderLayout.WEST);
        topBar.add(perfilButton, BorderLayout.EAST);

        contentArea.add(topBar, BorderLayout.NORTH);

        add(sidebar, BorderLayout.WEST);
        add(contentArea, BorderLayout.CENTER);

        controller = new GestionadorDashboardController(this);

        if (!botonesMenu.isEmpty()) {
            setBotonActivo(botonesMenu.get(0));
        }

        setVisible(true);
    }

    private JButton crearBotonMenu(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        boton.setForeground(Color.WHITE);
        boton.setBackground(new Color(0, 0, 0, 0));
        boton.setOpaque(false);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 5, 0, 0, new Color(0,0,0,0)),
                BorderFactory.createEmptyBorder(10, 15, 10, 10)
        ));

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (boton != botonActivo) {
                    boton.setBackground(new Color(180, 85, 0));
                    boton.setOpaque(true);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (boton != botonActivo) {
                    boton.setOpaque(false);
                }
            }
        });

        boton.addActionListener(e -> {
            controller.handleMenuClick(texto);
            setBotonActivo(boton);
        });

        return boton;
    }

    private void setBotonActivo(JButton nuevoActivo) {
        for (JButton b : botonesMenu) {
            b.setOpaque(false);
            b.setForeground(Color.WHITE);
            b.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0,5,0,0, new Color(0,0,0,0)),
                    BorderFactory.createEmptyBorder(10,15,10,10)
            ));
        }

        botonActivo = nuevoActivo;
        botonActivo.setBackground(new Color(200, 100, 0));
        botonActivo.setOpaque(true);
        botonActivo.setForeground(Color.WHITE);
        botonActivo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0,5,0,0, new Color(200,100,0)),
                BorderFactory.createEmptyBorder(10,10,10,10)
        ));
    }

    public JPanel getContentArea() { return contentArea; }
    public JLabel getUserNameLabel() { return userNameLabel; }
}
