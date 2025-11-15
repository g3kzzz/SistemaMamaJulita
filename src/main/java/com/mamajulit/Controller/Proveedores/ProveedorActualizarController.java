package com.mamajulit.Controller.Proveedores;

import com.mamajulit.Model.ConexionBD;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ProveedorActualizarController {

    public boolean actualizarProveedor(
            String ruc, String nombre, String estado,
            String email, String telefono, String calle,
            String numero, String ciudad
    ) {

        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall("{CALL sp_actualizar_proveedor(?,?,?,?,?,?,?,?)}")) {

            cs.setString(1, ruc);
            cs.setString(2, nombre);
            cs.setString(3, estado);
            cs.setString(4, email);
            cs.setString(5, telefono);
            cs.setString(6, calle);
            cs.setString(7, numero);
            cs.setString(8, ciudad);

            cs.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "❌ Error al actualizar proveedor:\n" + e.getMessage());
            return false;
        }
    }
}
