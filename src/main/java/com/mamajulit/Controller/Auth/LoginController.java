package com.mamajulit.Controller.Auth;

import com.mamajulit.Model.ConexionBD;
import com.mamajulit.View.Auth.LoginView;
import com.mamajulit.View.Dashboard.AdministradorDashboardView;
import com.mamajulit.View.Dashboard.GestionadorDashboardView;
import com.mamajulit.View.Dashboard.ObservadorDashboardView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginController {

    private final LoginView view;

    public LoginController(LoginView view) {
        this.view = view;

        this.view.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String email = view.emailField.getText().trim();
        String pass = new String(view.passField.getPassword()).trim();
        Color naranja = new Color(249, 115, 22);

        if (email.isEmpty() || pass.isEmpty()) {
            view.messageLabel.setForeground(naranja);
            view.messageLabel.setText("Ingrese sus credenciales.");
            return;
        }

        try (Connection conn = ConexionBD.getConnection()) {
            String sql =
                    "SELECT e.Id_empleado, e.Email, e.Cargo, e.NivelAcceso, e.Contrasena, "
                            + "n.Nombre, n.Apellido_Paterno, n.Apellido_Materno "
                            + "FROM Empleado e "
                            + "JOIN Nombre n ON e.Id_nombre = n.Id_nombre "
                            + "WHERE e.Email = ? AND e.Contrasena = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nombreCompleto = rs.getString("Nombre") + " "
                        + rs.getString("Apellido_Paterno") + " "
                        + rs.getString("Apellido_Materno");
                int nivelAcceso = rs.getInt("NivelAcceso");

                view.dispose(); // Cierra el login

                SwingUtilities.invokeLater(() -> {
                    JFrame dashboard;
                    switch (nivelAcceso) {
                        case 0:
                            dashboard = new AdministradorDashboardView(nombreCompleto);
                            break;
                        case 1:
                            dashboard = new GestionadorDashboardView(nombreCompleto);
                            break;
                        case 2:
                            dashboard = new ObservadorDashboardView(nombreCompleto);
                            break;
                        default:
                            view.messageLabel.setForeground(naranja);
                            view.messageLabel.setText("Nivel de acceso no reconocido.");
                            return;
                    }
                    dashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    dashboard.setVisible(true);
                });

            } else {
                view.messageLabel.setForeground(naranja);
                view.messageLabel.setText("Credenciales incorrectas.");
            }

        } catch (SQLException e) {
            view.messageLabel.setForeground(naranja);
            view.messageLabel.setText("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
    }
}
