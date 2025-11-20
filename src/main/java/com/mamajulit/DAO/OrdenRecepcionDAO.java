package com.mamajulit.DAO;

import com.mamajulit.Model.OrdenRecepcion;
import com.mamajulit.Model.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdenRecepcionDAO {

    // LISTAR
    public List<OrdenRecepcion> listar() {
        List<OrdenRecepcion> lista = new ArrayList<>();
        String sql = "{CALL sp_listar_orden_recepcion()}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                lista.add(mapFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("ERROR listar OrdenRecepcion: " + e.getMessage());
        }
        return lista;
    }

    // BUSCAR
    public List<OrdenRecepcion> buscar(String filtro) {
        List<OrdenRecepcion> lista = new ArrayList<>();
        String sql = "{CALL sp_buscar_orden_recepcion(?)}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setString(1, filtro);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) lista.add(mapFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("ERROR buscar OrdenRecepcion: " + e.getMessage());
        }
        return lista;
    }

    // INSERTAR
    public boolean insertar(OrdenRecepcion o, String usuario) {
        String sql = "{CALL sp_insertar_orden_recepcion(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setString(1, o.getDescripcion());
            cs.setString(2, o.getLote());
            cs.setString(3, o.getTipo());
            if (o.getCantidad() != null) cs.setInt(4, o.getCantidad()); else cs.setNull(4, Types.INTEGER);
            cs.setTime(5, o.getHora());
            cs.setDate(6, o.getFecha());
            cs.setString(7, o.getAlmacen());
            if (o.getPesoTotal() != null) cs.setFloat(8, o.getPesoTotal()); else cs.setNull(8, Types.FLOAT);
            cs.setString(9, o.getObservaciones());
            if (o.getEmitidoPor() != null) cs.setInt(10, o.getEmitidoPor()); else cs.setNull(10, Types.INTEGER);
            if (o.getEntregadoPor() != null) cs.setInt(11, o.getEntregadoPor()); else cs.setNull(11, Types.INTEGER);
            if (o.getIdTicket() != null) cs.setInt(12, o.getIdTicket()); else cs.setNull(12, Types.INTEGER);
            cs.setString(13, o.getPlacaVehiculo());
            cs.setString(14, usuario);

            cs.execute();
            return true;
        } catch (SQLIntegrityConstraintViolationException fk) {
            System.err.println("FK violation al insertar orden: " + fk.getMessage());
            return false;
        } catch (SQLException e) {
            System.err.println("Error SQL insertar orden: " + e.getMessage());
            return false;
        }
    }

    // ACTUALIZAR
    public boolean actualizar(OrdenRecepcion o, String usuario) {
        String sql = "{CALL sp_actualizar_orden_recepcion(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setInt(1, o.getCodigoRecepcion());
            cs.setString(2, o.getDescripcion());
            cs.setString(3, o.getLote());
            cs.setString(4, o.getTipo());
            if (o.getCantidad() != null) cs.setInt(5, o.getCantidad()); else cs.setNull(5, Types.INTEGER);
            cs.setTime(6, o.getHora());
            cs.setDate(7, o.getFecha());
            cs.setString(8, o.getAlmacen());
            if (o.getPesoTotal() != null) cs.setFloat(9, o.getPesoTotal()); else cs.setNull(9, Types.FLOAT);
            cs.setString(10, o.getObservaciones());
            if (o.getEmitidoPor() != null) cs.setInt(11, o.getEmitidoPor()); else cs.setNull(11, Types.INTEGER);
            if (o.getEntregadoPor() != null) cs.setInt(12, o.getEntregadoPor()); else cs.setNull(12, Types.INTEGER);
            if (o.getIdTicket() != null) cs.setInt(13, o.getIdTicket()); else cs.setNull(13, Types.INTEGER);
            cs.setString(14, o.getPlacaVehiculo());
            cs.setString(15, usuario);

            cs.execute();
            return true;
        } catch (SQLIntegrityConstraintViolationException fk) {
            System.err.println("FK violation al actualizar orden: " + fk.getMessage());
            return false;
        } catch (SQLException e) {
            System.err.println("Error SQL actualizar orden: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(int codigoRecepcion, String usuario) {
        String sql = "{CALL sp_eliminar_orden_recepcion(?,?)}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setInt(1, codigoRecepcion);
            cs.setString(2, usuario);
            cs.execute();
            return true;
        } catch (SQLIntegrityConstraintViolationException fk) {
            System.err.println("No se puede eliminar la orden por dependencia FK: " + fk.getMessage());
            return false;
        } catch (SQLException e) {
            System.err.println("Error SQL eliminar orden: " + e.getMessage());
            return false;
        }
    }

    private OrdenRecepcion mapFromResultSet(ResultSet rs) throws SQLException {
        OrdenRecepcion o = new OrdenRecepcion();
        o.setCodigoRecepcion(rs.getInt("Codigo_recepcion"));
        o.setDescripcion(rs.getString("Descripcion"));
        o.setLote(rs.getString("Lote"));
        o.setTipo(rs.getString("Tipo"));
        int cantidad = rs.getInt("Cantidad");
        o.setCantidad(rs.wasNull() ? null : cantidad);
        o.setHora(rs.getTime("Hora"));
        o.setFecha(rs.getDate("Fecha"));
        o.setAlmacen(rs.getString("Almacen"));
        float peso = rs.getFloat("Peso_total");
        o.setPesoTotal(rs.wasNull() ? null : peso);
        o.setObservaciones(rs.getString("Observaciones"));
        int emitido = rs.getInt("Emitido_por");
        o.setEmitidoPor(rs.wasNull() ? null : emitido);
        int entregado = rs.getInt("Entregado_por");
        o.setEntregadoPor(rs.wasNull() ? null : entregado);
        int idticket = rs.getInt("Id_ticket");
        o.setIdTicket(rs.wasNull() ? null : idticket);
        o.setPlacaVehiculo(rs.getString("Placa_vehiculo"));
        return o;
    }
}
