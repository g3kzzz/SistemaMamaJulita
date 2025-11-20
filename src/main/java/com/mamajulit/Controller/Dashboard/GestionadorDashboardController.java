package com.mamajulit.Controller.Dashboard;

import com.mamajulit.View.Auth.LoginView;
import com.mamajulit.View.Dashboard.GestionadorDashboardView;
import com.mamajulit.View.Inicio.InicioGestionador;
import com.mamajulit.View.Inventario.InventarioGestionador; // <-- Asegúrate de tener esta importación
import com.mamajulit.View.Proveedores.ProveedorGestionView;

import com.mamajulit.View.Inventario.InventarioGestionador;
import com.mamajulit.View.TicketPesado.TicketPesadoGestionView;

import javax.swing.*;
import java.awt.*;

public class GestionadorDashboardController {

    private final GestionadorDashboardView view;

    public GestionadorDashboardController(GestionadorDashboardView view) {
        this.view = view;
        mostrarInicio(); // Al iniciar el dashboard, cargamos la vista de inicio
    }

    /** ------------------ CLICK EN EL MENÚ ------------------ **/
    public void handleMenuClick(String opcion) {
        JPanel nuevoPanel;

        switch (opcion) {
            case "Inicio":
                nuevoPanel = new InicioGestionador();
                break;
            case "Inventario":
                nuevoPanel = new InventarioGestionador();
                break;
            case "Proveedores":
                nuevoPanel = new ProveedorGestionView();
                break;
            case "Tickets Pesados":
                nuevoPanel = new TicketPesadoGestionView();
                break;
            case "Órdenes de Recepción":
                nuevoPanel = new com.mamajulit.View.OrdenRecepcion.OrdenRecepcionGestionView();
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
        JPanel inicio = new InicioGestionador();
        actualizarContentArea(inicio);
    }

    /** ------------------ NUEVA FUNCIÓN: REDIRIGIR A INVENTARIO ------------------ **/
    public void redirigirAInventario() {
        JPanel inventario = new InicioGestionador();
        actualizarContentArea(inventario);
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
