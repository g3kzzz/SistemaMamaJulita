package com.mamajulit.DAO;

import com.mamajulit.Model.Producto;
import com.mamajulit.Model.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // Listar todos los productos completos
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT Id_producto, Descripcion, Unidad FROM producto";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("Id_producto"));
                p.setDescripcion(rs.getString("Descripcion"));
                p.setUnidad(rs.getString("Unidad"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Nuevo método para listar solo los IDs como Strings
    public List<String> listarIds() {
        List<String> ids = new ArrayList<>();
        String sql = "SELECT Id_producto FROM producto";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                ids.add(String.valueOf(rs.getInt("Id_producto")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ids;
    }
}
