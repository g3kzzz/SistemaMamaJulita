package com.mamajulit.Controller.Dashboard;

import com.mamajulit.View.Dashboard.AdministradorDashboardView;
import javax.swing.*;
import java.awt.*;

public class AdministradorDashboardController {

    private AdministradorDashboardView view;

    public AdministradorDashboardController(AdministradorDashboardView view) {
        this.view = view;
    }

    public void handleMenuClick(String opcion) {
        JPanel content = view.getContentArea();
        content.removeAll();

        JLabel label = new JLabel("Has seleccionado: " + opcion, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        content.add(label);

        content.revalidate();
        content.repaint();
    }

    public void handleLogout() {
        // Cierra el dashboard actual
        view.dispose();

        // Forza el cierre de hilos pendientes y crea el login desde cero
        SwingUtilities.invokeLater(() -> {
            com.mamajulit.View.Auth.LoginView loginView = new com.mamajulit.View.Auth.LoginView();
            new com.mamajulit.Controller.Auth.LoginController(loginView); // ⚡ importante: vincular controlador
            loginView.setLocationRelativeTo(null);
            loginView.setVisible(true);
        });
    }


}
