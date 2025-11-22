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

    // ------------------ LISTAR CON FILTROS ------------------
    public List<GuiaRequerimientos> listarFiltrando(
            String busqueda,
            String fechaInicio,
            String fechaFin,
            String conductor,
            String plantel,
            Integer direccion,
            String telefono
    ) {
        List<GuiaRequerimientos> lista = new ArrayList<>();
        String sql = "SELECT * FROM Guia_Requerimientos WHERE 1=1";

        if (busqueda != null && !busqueda.isEmpty()) {
            sql += " AND (IdGuia LIKE ? OR Telefono LIKE ?)";
        }
        if (fechaInicio != null && !fechaInicio.isEmpty()) {
            sql += " AND Fecha_entrega >= ?";
        }
        if (fechaFin != null && !fechaFin.isEmpty()) {
            sql += " AND Fecha_entrega <= ?";
        }
        if (conductor != null && !conductor.isEmpty()) {
            sql += " AND Id_conductor = ?";
        }
        if (plantel != null && !plantel.isEmpty()) {
            sql += " AND Id_plantel = ?";
        }
        if (direccion != null) {
            sql += " AND Id_direccion = ?";
        }
        if (telefono != null && !telefono.isEmpty()) {
            sql += " AND Telefono LIKE ?";
        }

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            int paramIndex = 1;
            if (busqueda != null && !busqueda.isEmpty()) {
                ps.setString(paramIndex++, "%" + busqueda + "%");
                ps.setString(paramIndex++, "%" + busqueda + "%");
            }
            if (fechaInicio != null && !fechaInicio.isEmpty()) {
                ps.setDate(paramIndex++, Date.valueOf(fechaInicio));
            }
            if (fechaFin != null && !fechaFin.isEmpty()) {
                ps.setDate(paramIndex++, Date.valueOf(fechaFin));
            }
            if (conductor != null && !conductor.isEmpty()) {
                ps.setString(paramIndex++, conductor);
            }
            if (plantel != null && !plantel.isEmpty()) {
                ps.setString(paramIndex++, plantel);
            }
            if (direccion != null) {
                ps.setInt(paramIndex++, direccion);
            }
            if (telefono != null && !telefono.isEmpty()) {
                ps.setString(paramIndex++, "%" + telefono + "%");
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    GuiaRequerimientos g = new GuiaRequerimientos();
                    g.setIdGuia(rs.getInt("IdGuia"));
                    g.setFechaEntrega(rs.getDate("Fecha_entrega"));
                    g.setHoraEntrega(rs.getTime("Hora_entrega"));
                    g.setIdConductor(rs.getString("Id_conductor"));
                    g.setIdPlantel(rs.getString("Id_plantel"));
                    g.setIdDireccion(rs.getInt("Id_direccion"));
                    g.setTelefono(rs.getString("Telefono"));
                    lista.add(g);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
