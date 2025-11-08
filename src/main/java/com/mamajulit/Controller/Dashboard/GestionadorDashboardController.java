package com.mamajulit.Controller.Dashboard;

import com.mamajulit.View.Auth.LoginView;
import com.mamajulit.View.Dashboard.GestionadorDashboardView;
import com.mamajulit.View.Inicio.InicioGestionador;

import javax.swing.*;
import java.awt.*;

public class GestionadorDashboardController {

    private final GestionadorDashboardView view;

    public GestionadorDashboardController(GestionadorDashboardView view) {
        this.view = view;

        // Al iniciar el dashboard, cargamos la vista de inicio
        mostrarInicio();
    }

    /** ------------------ CLICK EN EL MENÚ ------------------ **/
    public void handleMenuClick(String opcion) {
        JPanel nuevoPanel;

        switch (opcion) {
            case "Inicio":
                nuevoPanel = new InicioGestionador(); // CORREGIDO: simplemente usar el JPanel
                break;

            default:
                nuevoPanel = new JPanel(new BorderLayout());
                nuevoPanel.setBackground(Color.WHITE);
                JLabel label = new JLabel("Has abierto: " + opcion, SwingConstants.CENTER);
                label.setFont(new Font("Segoe UI", Font.BOLD, 20));
                nuevoPanel.add(label, BorderLayout.CENTER);
                break;
        }

        actualizarContentArea(nuevoPanel);
    }

    /** ------------------ MUESTRA INICIO ------------------ **/
    private void mostrarInicio() {
        JPanel inicio = new InicioGestionador(); // CORREGIDO
        actualizarContentArea(inicio);
    }

    /** ------------------ PLACEHOLDER ------------------ **/
    private void mostrarPlaceholder(String texto) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        JLabel label = new JLabel("Has abierto: " + texto, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(label, BorderLayout.CENTER);

        actualizarContentArea(panel);
    }

    /** ------------------ ACTUALIZA ÁREA DE CONTENIDO ------------------ **/
    private void actualizarContentArea(JPanel panel) {
        view.getContentArea().removeAll();
        view.getContentArea().add(panel, BorderLayout.CENTER);
        view.getContentArea().revalidate();
        view.getContentArea().repaint();
    }

    /** ------------------ CIERRE DE SESIÓN ------------------ **/
    public void handleLogout() {
        view.dispose(); // Cierra la ventana actual

        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            new com.mamajulit.Controller.Auth.LoginController(loginView);
            loginView.setLocationRelativeTo(null);
            loginView.setVisible(true);
        });
    }
}
