package com.mamajulit.DAO;

import com.mamajulit.Model.CotizacionProveedor;
import com.mamajulit.Model.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CotizacionProveedorDAO {

    // LISTAR TODOS
    public List<CotizacionProveedor> listar() {
        List<CotizacionProveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM cotizacion_proveedor";
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // BUSCAR
    public List<CotizacionProveedor> buscar(String texto, String ruc, Boolean activa) {
        List<CotizacionProveedor> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM cotizacion_proveedor WHERE 1=1");
        if (texto != null && !texto.isEmpty()) sql.append(" AND genero LIKE ?");
        if (ruc != null && !ruc.isEmpty()) sql.append(" AND ruc = ?");
        if (activa != null) sql.append(" AND activa = ?");
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            int idx = 1;
            if (texto != null && !texto.isEmpty()) ps.setString(idx++, "%" + texto + "%");
            if (ruc != null && !ruc.isEmpty()) ps.setString(idx++, ruc);
            if (activa != null) ps.setBoolean(idx++, activa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // OBTENER POR ID
    public CotizacionProveedor obtenerPorId(int id) {
        String sql = "SELECT * FROM cotizacion_proveedor WHERE id_cotizacion = ?";
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapear(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // INSERTAR
    public boolean insertar(CotizacionProveedor c) {
        String sql = "INSERT INTO cotizacion_proveedor " +
                "(ruc, genero, cantidad_pollos, asignado_minimo, asignado_maximo, precio_maximo, precio_minimo, activa, fecha_registro) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, c.getRuc());
            ps.setString(2, c.getGenero());
            ps.setObject(3, c.getCantidadPollos(), Types.INTEGER);
            ps.setObject(4, c.getAsignadoMinimo(), Types.INTEGER);
            ps.setObject(5, c.getAsignadoMaximo(), Types.INTEGER);
            ps.setObject(6, c.getPrecioMaximo(), Types.FLOAT);
            ps.setObject(7, c.getPrecioMinimo(), Types.FLOAT);
            ps.setBoolean(8, c.getActiva() != null ? c.getActiva() : false);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ACTUALIZAR
    public boolean actualizar(CotizacionProveedor c) {
        String sql = "UPDATE cotizacion_proveedor SET " +
                "ruc = ?, genero = ?, cantidad_pollos = ?, asignado_minimo = ?, asignado_maximo = ?, " +
                "precio_maximo = ?, precio_minimo = ?, activa = ? " +
                "WHERE id_cotizacion = ?";
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, c.getRuc());
            ps.setString(2, c.getGenero());
            ps.setObject(3, c.getCantidadPollos(), Types.INTEGER);
            ps.setObject(4, c.getAsignadoMinimo(), Types.INTEGER);
            ps.setObject(5, c.getAsignadoMaximo(), Types.INTEGER);
            ps.setObject(6, c.getPrecioMaximo(), Types.FLOAT);
            ps.setObject(7, c.getPrecioMinimo(), Types.FLOAT);
            ps.setBoolean(8, c.getActiva() != null ? c.getActiva() : false);
            ps.setInt(9, c.getIdCotizacion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM cotizacion_proveedor WHERE id_cotizacion = ?";
        try (Connection cn = ConexionBD.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // MAPEAR RESULTSET A OBJETO
    private CotizacionProveedor mapear(ResultSet rs) throws SQLException {
        CotizacionProveedor c = new CotizacionProveedor();
        c.setIdCotizacion(rs.getInt("id_cotizacion"));
        c.setRuc(rs.getString("ruc"));
        c.setGenero(rs.getString("genero"));
        c.setCantidadPollos((Integer) rs.getObject("cantidad_pollos"));
        c.setAsignadoMinimo((Integer) rs.getObject("asignado_minimo"));
        c.setAsignadoMaximo((Integer) rs.getObject("asignado_maximo"));
        c.setPrecioMaximo((Float) rs.getObject("precio_maximo"));
        c.setPrecioMinimo((Float) rs.getObject("precio_minimo"));
        c.setActiva(rs.getBoolean("activa"));
        c.setFechaRegistro(rs.getTimestamp("fecha_registro"));
        c.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
        return c;
    }
}
