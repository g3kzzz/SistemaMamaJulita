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
        JOptionPane.showMessageDialog(view, "Cerrando sesión del Administrador...");
        System.exit(0);
    }
}
