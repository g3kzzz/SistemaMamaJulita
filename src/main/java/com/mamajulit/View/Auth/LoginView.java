package com.mamajulit.View.Auth;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView extends JFrame {

    public JTextField emailField;
    public JPasswordField passField;
    public JLabel messageLabel;
    public JButton loginButton;

    private int mouseX, mouseY;

    public LoginView() {
        setTitle("Sistema de Compras - Mama Julita");
        setSize(900, 550);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);

        // ==== PANEL IZQUIERDO (imagen escalable) ====
        JPanel leftPane = new JPanel() {
            private final Image backgroundImage =
                    new ImageIcon(getClass().getResource("/images/Background1.jpg")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        leftPane.setBounds(0, 0, 400, 550);
        leftPane.setLayout(null);
        add(leftPane);

        // ==== PANEL DERECHO ====
        JPanel rightPane = new JPanel();
        rightPane.setBounds(400, 0, 500, 550);
        rightPane.setBackground(new Color(253, 253, 253));
        rightPane.setLayout(null);
        add(rightPane);

        // ==== BOTONES PERSONALIZADOS ====
        Color bgColor = rightPane.getBackground();
        Color iconColor = new Color(100, 100, 100);
        Color hoverBg = new Color(230, 230, 230);
        Color hoverText = new Color(30, 30, 30);

        JButton closeButton = new JButton("×");
        closeButton.setBounds(470, 10, 20, 20);
        styleFlatButton(closeButton, bgColor, iconColor, hoverBg, hoverText);
        closeButton.addActionListener(e -> System.exit(0));

        JButton minimizeButton = new JButton("–");
        minimizeButton.setBounds(440, 10, 20, 20);
        styleFlatButton(minimizeButton, bgColor, iconColor, hoverBg, hoverText);
        minimizeButton.addActionListener(e -> setState(JFrame.ICONIFIED));

        rightPane.add(closeButton);
        rightPane.add(minimizeButton);

        // ==== PERMITIR ARRASTRAR ====
        MouseAdapter dragListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        };
        rightPane.addMouseListener(dragListener);
        rightPane.addMouseMotionListener(dragListener);

        // ==== LOGO ====
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/logo.png"));
        JLabel logoLabel = new JLabel();
        logoLabel.setBounds(195, 55, 110, 110);
        Image scaledLogo = logoIcon.getImage().getScaledInstance(
                logoLabel.getWidth(),
                logoLabel.getHeight(),
                Image.SCALE_SMOOTH
        );
        logoLabel.setIcon(new ImageIcon(scaledLogo));
        rightPane.add(logoLabel);

        // ==== TÍTULO ====
        JLabel titleLabel = new JLabel("Iniciar Sesión");
        titleLabel.setBounds(170, 190, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(43, 43, 43));
        rightPane.add(titleLabel);

        // ==== CAMPOS CON ETIQUETAS Y FONDO GRIS ====
        Color fieldBg = new Color(245, 245, 245); // plomo suave

        // EMAIL
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 13));
        emailLabel.setForeground(new Color(80, 80, 80));
        emailLabel.setBounds(120, 220, 260, 20);
        rightPane.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(120, 240, 260, 35);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBackground(fieldBg);
        emailField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(200, 200, 200), 1, true),
                new EmptyBorder(5, 8, 5, 8)
        ));
        rightPane.add(emailField);

        // PASSWORD
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Arial", Font.BOLD, 13));
        passLabel.setForeground(new Color(80, 80, 80));
        passLabel.setBounds(120, 285, 260, 20);
        rightPane.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(120, 305, 260, 35);
        passField.setFont(new Font("Arial", Font.PLAIN, 14));
        passField.setBackground(fieldBg);
        passField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(200, 200, 200), 1, true),
                new EmptyBorder(5, 8, 5, 8)
        ));
        rightPane.add(passField);

        // ==== BOTÓN LOGIN ====
        loginButton = new JButton("Ingresar");
        loginButton.setBounds(120, 370, 260, 40);
        loginButton.setBackground(new Color(74, 144, 226));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setBorder(new EmptyBorder(5, 5, 5, 5));
        rightPane.add(loginButton);

        // ==== MENSAJE ====
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setBounds(120, 425, 260, 30);
        messageLabel.setForeground(new Color(204, 0, 0));
        messageLabel.setFont(new Font("Arial", Font.BOLD, 13));
        rightPane.add(messageLabel);

        setVisible(true);
    }

    private void styleFlatButton(JButton button, Color bg, Color fg, Color hoverBg, Color hoverFg) {
        button.setFocusPainted(false);
        button.setBorder(null);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(bg);
        button.setForeground(fg);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setContentAreaFilled(true);
        button.setOpaque(true);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverBg);
                button.setForeground(hoverFg);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bg);
                button.setForeground(fg);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginView::new);
    }
}
