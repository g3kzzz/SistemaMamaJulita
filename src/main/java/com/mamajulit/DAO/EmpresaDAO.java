package com.mamajulit.DAO;

import com.mamajulit.Model.ConexionBD;
import com.mamajulit.Model.Empresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

    public boolean insertar(Empresa e) {
        String sql = "INSERT INTO empresa (RUC, Nombre, Razon_Social, Id_direccion, Telefono) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getRuc());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getRazonSocial());
            ps.setInt(4, e.getIdDireccion());
            ps.setString(5, e.getTelefono());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Empresa buscarPorRUC(String ruc) {
        String sql = "SELECT * FROM empresa WHERE RUC = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ruc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Empresa(
                        rs.getString("RUC"),
                        rs.getString("Nombre"),
                        rs.getString("Razon_Social"),
                        rs.getInt("Id_direccion"),
                        rs.getString("Telefono")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> listarRUC() {
        List<String> rucs = new ArrayList<>();
        String sql = "SELECT RUC FROM empresa";
        try (Connection conn = ConexionBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) rucs.add(rs.getString("RUC"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rucs;
    }
}
