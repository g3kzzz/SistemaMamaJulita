package com.mamajulit.Controller.Proveedores;

import com.mamajulit.Model.ConexionBD;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ProveedorEliminarController {

    public boolean eliminarProveedor(String ruc) {

        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall("{CALL sp_eliminar_proveedor(?)}")) {

            cs.setString(1, ruc);
            cs.execute();
            return true;

        } catch (SQLException e) {

            if (e.getMessage().contains("foreign key")) {
                JOptionPane.showMessageDialog(null,
                        "❌ No se puede eliminar.\nEste proveedor tiene cotizaciones registradas.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "❌ Error al eliminar proveedor:\n" + e.getMessage());
            }

            return false;
        }
    }
}
