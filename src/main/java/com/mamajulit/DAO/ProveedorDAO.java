package com.mamajulit.DAO;

import com.mamajulit.Model.ConexionBD;
import com.mamajulit.Model.Proveedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    // Listar todos los proveedores completos
    public List<Proveedor> listar() {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT RUC, Nombre, Estado, Email, Id_direccion, Telefono FROM proveedor";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setRuc(rs.getString("RUC"));
                p.setNombre(rs.getString("Nombre"));
                p.setEstado(rs.getBoolean("Estado"));
                p.setEmail(rs.getString("Email"));
                p.setIdDireccion(rs.getInt("Id_direccion"));
                p.setTelefono(rs.getString("Telefono"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Listar solo los RUC como Strings (para JComboBox)
    public List<String> listarRUC() {
        List<String> rucs = new ArrayList<>();
        String sql = "SELECT RUC FROM proveedor";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                rucs.add(rs.getString("RUC"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rucs;
    }
}
