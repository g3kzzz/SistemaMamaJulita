package com.mamajulit.DAO;

import com.mamajulit.Model.ConexionBD;
import com.mamajulit.Model.GuiaRequerimientos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuiaRequerimientosDAO {

    // ------------------ LISTAR TODAS LAS GUIAS ------------------
    public List<GuiaRequerimientos> listar() {
        List<GuiaRequerimientos> lista = new ArrayList<>();
        String sql = "{CALL sp_listar_guia_requerimientos()}"; // Procedimiento almacenado
        try (Connection con = ConexionBD.getConnection();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                lista.add(new GuiaRequerimientos(
                        rs.getInt("Id_guia"),
                        rs.getDate("Fecha_entrega"),
                        rs.getTime("Hora_entrega"),
                        rs.getString("Id_conductor"),
                        rs.getString("Id_plantel"),
                        rs.getInt("Id_direccion"),
                        rs.getString("Telefono")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // ------------------ INSERTAR ------------------
    public boolean insertar(GuiaRequerimientos g) {
        String sql = "{CALL sp_insertar_guia_requerimientos(?, ?, ?, ?, ?, ?)}";
        try (Connection con = ConexionBD.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setDate(1, g.getFechaEntrega());
            cs.setTime(2, g.getHoraEntrega());
            cs.setString(3, g.getIdConductor());
            cs.setString(4, g.getIdPlantel());
            cs.setInt(5, g.getIdDireccion());
            cs.setString(6, g.getTelefono());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ------------------ ACTUALIZAR ------------------
    public boolean actualizar(GuiaRequerimientos g) {
        String sql = "{CALL sp_actualizar_guia_requerimientos(?, ?, ?, ?, ?, ?, ?)}";
        try (Connection con = ConexionBD.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, g.getIdGuia());
            cs.setDate(2, g.getFechaEntrega());
            cs.setTime(3, g.getHoraEntrega());
            cs.setString(4, g.getIdConductor());
            cs.setString(5, g.getIdPlantel());
            cs.setInt(6, g.getIdDireccion());
            cs.setString(7, g.getTelefono());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ------------------ ELIMINAR ------------------
    public boolean eliminar(int idGuia) {
        String sql = "{CALL sp_eliminar_guia_requerimientos(?)}";
        try (Connection con = ConexionBD.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idGuia);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ------------------ LISTAR FK PARA COMBOBOX ------------------

    public List<String> listarConductor() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT Nro_Licencia FROM conductor WHERE Estado='Activo'";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(rs.getString("Nro_Licencia"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<String> listarPlantel() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT Id_plantel FROM plantel";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(rs.getString("Id_plantel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Integer> listarDireccion() {
        List<Integer> lista = new ArrayList<>();
        String sql = "SELECT Id_direccion FROM direccion";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(rs.getInt("Id_direccion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
