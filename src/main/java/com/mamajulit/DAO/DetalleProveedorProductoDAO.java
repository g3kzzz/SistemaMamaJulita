package com.mamajulit.DAO;

import com.mamajulit.Model.DetalleProveedorProducto;
import com.mamajulit.Model.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleProveedorProductoDAO {

    public List<DetalleProveedorProducto> listar() {
        List<DetalleProveedorProducto> lista = new ArrayList<>();
        String sql = "{CALL sp_listar_detalle_proveedor_producto()}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                DetalleProveedorProducto d = mapRow(rs);
                lista.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<DetalleProveedorProducto> buscar(String filtro) {
        List<DetalleProveedorProducto> lista = new ArrayList<>();
        String sql = "{CALL sp_buscar_detalle_proveedor_producto(?)}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setString(1, filtro);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) lista.add(mapRow(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insertar(String ruc, int idProducto, Integer cantidad, Float precioBase, String usuario) throws SQLException {
        String sql = "{CALL sp_registrar_producto_proveedor(?,?,?,? , ?)}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setString(1, ruc);
            cs.setInt(2, idProducto);
            if (cantidad != null) cs.setInt(3, cantidad); else cs.setNull(3, Types.INTEGER);
            if (precioBase != null) cs.setFloat(4, precioBase); else cs.setNull(4, Types.FLOAT);
            cs.setString(5, usuario);

            cs.execute();
            return true;
        } catch (SQLException e) {
            // re-lanzamos para que controller/mvc lo muestre con e.getMessage()
            throw e;
        }
    }

    public boolean actualizar(int idDetalle, Integer cantidad, Float precioBase, String usuario) throws SQLException {
        String sql = "{CALL sp_actualizar_producto_proveedor(?,?,?,?)}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setInt(1, idDetalle);
            if (cantidad != null) cs.setInt(2, cantidad); else cs.setNull(2, Types.INTEGER);
            if (precioBase != null) cs.setFloat(3, precioBase); else cs.setNull(3, Types.FLOAT);
            cs.setString(4, usuario);

            cs.execute();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    public boolean eliminar(int idDetalle, String usuario) throws SQLException {
        String sql = "{CALL sp_eliminar_producto_proveedor(?,?)}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setInt(1, idDetalle);
            cs.setString(2, usuario);
            cs.execute();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    private DetalleProveedorProducto mapRow(ResultSet rs) throws SQLException {
        DetalleProveedorProducto d = new DetalleProveedorProducto();
        d.setId(rs.getInt("Id"));
        d.setIdProducto(rs.getInt("Id_producto"));
        d.setDescripcionProducto(rs.getString("Producto_descripcion"));
        d.setUnidad(rs.getString("Unidad"));
        d.setRucProveedor(rs.getString("RUC_proveedor"));
        d.setNombreProveedor(rs.getString("Nombre_proveedor"));
        int cant = rs.getInt("Cantidad");
        d.setCantidad(rs.wasNull() ? null : cant);
        float precio = rs.getFloat("Precio_base");
        d.setPrecioBase(rs.wasNull() ? null : precio);
        return d;
    }
}
