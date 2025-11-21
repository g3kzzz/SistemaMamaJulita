package com.mamajulit.DAO;

import com.mamajulit.Model.ConexionBD;
import com.mamajulit.Model.OrdenCompraCabecera;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdenCompraCabeceraDAO {

    private final ConexionBD conexion = new ConexionBD();

    // INSERTAR
    public boolean insertar(OrdenCompraCabecera c) {
        String sql = "{CALL sp_insertar_orden_compra_cabecera(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (CallableStatement cs = conexion.getConnection().prepareCall(sql)) {
            cs.setString(1, c.getIdOrdenCompra());
            cs.setInt(2, c.getAsignadoMinimo());
            cs.setInt(3, c.getAsignadoMaximo());
            cs.setFloat(4, c.getPrecioMaximo());
            cs.setFloat(5, c.getPrecioMinimo());
            cs.setString(6, c.getPuntoLlegada());

            // Directamente java.sql.Date
            cs.setDate(7, c.getFechaEmision());

            cs.setFloat(8, c.getImporteTotal());
            cs.setFloat(9, c.getTotalIgv());
            cs.setString(10, c.getMontoLetras());
            cs.setFloat(11, c.getTotalCargos());
            cs.setFloat(12, c.getTotalDectsGlobal());
            cs.setString(13, c.getPuntoPartida());
            cs.setFloat(14, c.getSubtotal());
            cs.setInt(15, c.getComNombre());
            cs.setString(16, c.getAreaCompra());
            cs.setString(17, c.getTipoPago());
            cs.setString(18, c.getViaPago());
            cs.setString(19, c.getClaseDocumento());
            cs.setString(20, c.getCentroEntrega());
            cs.setBoolean(21, c.getCancelado());
            cs.setString(22, c.getRuc());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ACTUALIZAR
    public boolean actualizar(OrdenCompraCabecera c) {
        String sql = "{CALL sp_actualizar_orden_compra_cabecera(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (CallableStatement cs = conexion.getConnection().prepareCall(sql)) {
            cs.setString(1, c.getIdOrdenCompra());
            cs.setInt(2, c.getAsignadoMinimo());
            cs.setInt(3, c.getAsignadoMaximo());
            cs.setFloat(4, c.getPrecioMaximo());
            cs.setFloat(5, c.getPrecioMinimo());
            cs.setString(6, c.getPuntoLlegada());

            // Directamente java.sql.Date
            cs.setDate(7, c.getFechaEmision());

            cs.setFloat(8, c.getImporteTotal());
            cs.setFloat(9, c.getTotalIgv());
            cs.setString(10, c.getMontoLetras());
            cs.setFloat(11, c.getTotalCargos());
            cs.setFloat(12, c.getTotalDectsGlobal());
            cs.setString(13, c.getPuntoPartida());
            cs.setFloat(14, c.getSubtotal());
            cs.setInt(15, c.getComNombre());
            cs.setString(16, c.getAreaCompra());
            cs.setString(17, c.getTipoPago());
            cs.setString(18, c.getViaPago());
            cs.setString(19, c.getClaseDocumento());
            cs.setString(20, c.getCentroEntrega());
            cs.setBoolean(21, c.getCancelado());
            cs.setString(22, c.getRuc());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(String id) {
        String sql = "{CALL sp_eliminar_orden_compra_cabecera(?)}";
        try (CallableStatement cs = conexion.getConnection().prepareCall(sql)) {
            cs.setString(1, id);
            cs.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    // LISTAR
    public List<OrdenCompraCabecera> listar() {
        List<OrdenCompraCabecera> lista = new ArrayList<>();
        String sql = "{CALL sp_listar_orden_compra_cabecera()}";
        try (CallableStatement cs = conexion.getConnection().prepareCall(sql)) {
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                OrdenCompraCabecera c = new OrdenCompraCabecera();
                c.setIdOrdenCompra(rs.getString("Id_orden_compra"));
                c.setAsignadoMinimo(rs.getInt("Asignado_minimo"));
                c.setAsignadoMaximo(rs.getInt("Asignado_maximo"));
                c.setPrecioMaximo(rs.getFloat("Precio_maximo"));
                c.setPrecioMinimo(rs.getFloat("Precio_minimo"));
                c.setPuntoLlegada(rs.getString("Punto_llegada"));
                c.setFechaEmision(rs.getDate("Fecha_emision")); // ya java.sql.Date
                c.setImporteTotal(rs.getFloat("Importe_total"));
                c.setTotalIgv(rs.getFloat("Total_igv"));
                c.setMontoLetras(rs.getString("Monto_letras"));
                c.setTotalCargos(rs.getFloat("Total_cargos"));
                c.setTotalDectsGlobal(rs.getFloat("Total_dects_global"));
                c.setPuntoPartida(rs.getString("Punto_partida"));
                c.setSubtotal(rs.getFloat("Subtotal"));
                c.setComNombre(rs.getInt("Com_nombre"));
                c.setAreaCompra(rs.getString("Area_compra"));
                c.setTipoPago(rs.getString("Tipo_pago"));
                c.setViaPago(rs.getString("Via_pago"));
                c.setClaseDocumento(rs.getString("Clase_documento"));
                c.setCentroEntrega(rs.getString("Centro_entrega"));
                c.setCancelado(rs.getBoolean("Cancelado"));
                c.setRuc(rs.getString("RUC"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    // Dentro de OrdenCompraCabeceraDAO
    public List<String> listarIds() {
        List<String> ids = new ArrayList<>();
        String sql = "SELECT Id_orden_compra FROM orden_compra_cabecera";
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ids.add(rs.getString("Id_orden_compra"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

    // BUSCAR
    public List<OrdenCompraCabecera> buscar(String filtro) {
        List<OrdenCompraCabecera> lista = new ArrayList<>();
        String sql = "{CALL sp_buscar_orden_compra_cabecera(?)}";
        try (CallableStatement cs = conexion.getConnection().prepareCall(sql)) {
            cs.setString(1, filtro);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                OrdenCompraCabecera c = new OrdenCompraCabecera();
                c.setIdOrdenCompra(rs.getString("Id_orden_compra"));
                c.setRuc(rs.getString("RUC"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
