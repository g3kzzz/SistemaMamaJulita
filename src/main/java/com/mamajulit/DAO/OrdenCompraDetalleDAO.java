package com.mamajulit.DAO;

import com.mamajulit.Model.ConexionBD;
import com.mamajulit.Model.OrdenCompraDetalle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdenCompraDetalleDAO {

    private final ConexionBD conexion = new ConexionBD();

    public boolean insertar(OrdenCompraDetalle d) {
        String sql = "{CALL sp_insertar_orden_compra_detalle(?,?,?,?,?,?,?)}";
        try (CallableStatement cs = conexion.getConnection().prepareCall(sql)) {
            cs.setString(1, d.getIdDetalle());
            cs.setString(2, d.getUnidadSolicitada());
            cs.setInt(3, d.getUnidadEntrega());
            cs.setFloat(4, d.getValorUnitario());
            cs.setFloat(5, d.getImporte());
            cs.setInt(6, d.getIdProducto());
            cs.setString(7, d.getIdOrdenCompra());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(OrdenCompraDetalle d) {
        String sql = "{CALL sp_actualizar_orden_compra_detalle(?,?,?,?,?,?,?)}";
        try (CallableStatement cs = conexion.getConnection().prepareCall(sql)) {
            cs.setString(1, d.getIdDetalle());
            cs.setString(2, d.getUnidadSolicitada());
            cs.setInt(3, d.getUnidadEntrega());
            cs.setFloat(4, d.getValorUnitario());
            cs.setFloat(5, d.getImporte());
            cs.setInt(6, d.getIdProducto());
            cs.setString(7, d.getIdOrdenCompra());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(String id) {
        String sql = "{CALL sp_eliminar_orden_compra_detalle(?)}";
        try (CallableStatement cs = conexion.getConnection().prepareCall(sql)) {
            cs.setString(1, id);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<OrdenCompraDetalle> listar() {
        List<OrdenCompraDetalle> lista = new ArrayList<>();
        String sql = "{CALL sp_listar_orden_compra_detalle()}";
        try (CallableStatement cs = conexion.getConnection().prepareCall(sql)) {
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                OrdenCompraDetalle d = new OrdenCompraDetalle();
                d.setIdDetalle(rs.getString("Id_detalle"));
                d.setUnidadSolicitada(rs.getString("Unidad_solicitada"));
                d.setUnidadEntrega(rs.getInt("Unidad_entrega"));
                d.setValorUnitario(rs.getFloat("Valor_unitario"));
                d.setImporte(rs.getFloat("Importe"));
                d.setIdProducto(rs.getInt("Id_producto"));
                d.setIdOrdenCompra(rs.getString("Id_orden_compra"));
                lista.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<OrdenCompraDetalle> buscar(String filtro) {
        List<OrdenCompraDetalle> lista = new ArrayList<>();
        String sql = "{CALL sp_buscar_orden_compra_detalle(?)}";
        try (CallableStatement cs = conexion.getConnection().prepareCall(sql)) {
            cs.setString(1, filtro);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                OrdenCompraDetalle d = new OrdenCompraDetalle();
                d.setIdDetalle(rs.getString("Id_detalle"));
                d.setIdOrdenCompra(rs.getString("Id_orden_compra"));
                lista.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
