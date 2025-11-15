package com.mamajulit.Controller.Inventario;

import com.mamajulit.Model.ConexionBD;

import java.sql.*;
import java.util.*;

/**
 * Controlador del módulo de Inventario.
 * Gestiona productos, stock actual, órdenes y reportes de compra.
 */
public class InventarioGestionadorController {

    /** ------------------ LISTAR PRODUCTOS ------------------ **/
    public List<Map<String, Object>> listarProductos(String filtro) {
        String sql = "SELECT Id_producto, Descripcion, Unidad " +
                "FROM Producto " +
                "WHERE Descripcion LIKE '%" + filtro + "%' " +
                "ORDER BY Id_producto DESC";
        return ejecutarConsulta(sql);
    }

    /** ------------------ LISTAR PROVEEDORES ------------------ **/
    public List<Map<String, Object>> listarProveedores(String filtro) {
        String sql = "SELECT RUC, Nombre, Telefono, Email, " +
                "CASE WHEN Estado = 1 THEN 'Activo' ELSE 'Inactivo' END AS Estado " +
                "FROM Proveedor " +
                "WHERE Nombre LIKE '%" + filtro + "%' " +
                "ORDER BY Estado DESC, Nombre ASC";
        return ejecutarConsulta(sql);
    }

    /** ------------------ LISTAR ÓRDENES DE COMPRA ------------------ **/
    public List<Map<String, Object>> listarOrdenesCompra(String filtro) {
        String sql = "SELECT oc.Id_orden_compra AS Código, e.Nombre AS Empresa, " +
                "oc.Fecha_emision AS Fecha, oc.Importe_total AS Total, " +
                "CASE WHEN oc.Cancelado = 0 THEN 'Activa' ELSE 'Cancelada' END AS Estado " +
                "FROM Orden_compra_cabecera oc " +
                "JOIN Empresa e ON oc.RUC = e.RUC " +
                "WHERE e.Nombre LIKE '%" + filtro + "%' " +
                "ORDER BY oc.Fecha_emision DESC";
        return ejecutarConsulta(sql);
    }

    /** ------------------ LISTAR REPORTES DE COMPRA ------------------ **/
    public List<Map<String, Object>> listarReportes(String filtro) {
        String sql = "SELECT r.Id_reporte AS Código, e.Nombre AS Empresa, " +
                "r.Precio_total AS Total, r.Fecha_venta AS Fecha, r.Total_jabas AS Jabas " +
                "FROM Reporte_Compra r " +
                "JOIN Empresa e ON r.RUC = e.RUC " +
                "WHERE e.Nombre LIKE '%" + filtro + "%' " +
                "ORDER BY r.Fecha_venta DESC";
        return ejecutarConsulta(sql);
    }

    /** ------------------ CONTAR ELEMENTOS ------------------ **/
    public Map<String, String> obtenerMetricas() {
        Map<String, String> m = new LinkedHashMap<>();
        m.put("Productos registrados", String.valueOf(contar("SELECT COUNT(*) FROM Producto")));
        m.put("Proveedores activos", String.valueOf(contar("SELECT COUNT(*) FROM Proveedor WHERE Estado = 1")));
        m.put("Órdenes activas", String.valueOf(contar("SELECT COUNT(*) FROM Orden_compra_cabecera WHERE Cancelado = 0")));
        m.put("Reportes emitidos", String.valueOf(contar("SELECT COUNT(*) FROM Reporte_Compra")));
        return m;
    }

    /** ------------------ MÉTODOS AUXILIARES ------------------ **/
    private int contar(String sql) {
        try (Connection c = ConexionBD.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.err.println("[ERROR InventarioGestionadorController.contar] " + e.getMessage());
        }
        return 0;
    }

    private List<Map<String, Object>> ejecutarConsulta(String sql) {
        List<Map<String, Object>> data = new ArrayList<>();
        try (Connection c = ConexionBD.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> fila = new LinkedHashMap<>();
                for (int i = 1; i <= cols; i++) {
                    Object val = rs.getObject(i);
                    fila.put(meta.getColumnLabel(i), (val == null) ? "—" : val.toString());
                }
                data.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("[ERROR InventarioGestionadorController.ejecutarConsulta] " + e.getMessage());
        }
        return data;
    }
}
