package com.mamajulit.Controller.Inicio;

import com.mamajulit.Model.ConexionBD;

import java.sql.*;
import java.util.*;

/**
 * Controlador de la vista InicioGestionador.
 * Trae datos recientes y estructurados de la base de datos para el dashboard del gestor.
 */
public class InicioGestionador {

    /** ------------------ Tickets Pesados Recientes ------------------ **/
    public List<Map<String, Object>> obtenerTicketsRecientes() {
        String sql = "SELECT Id_ticket, Fecha_salida, Peso_promedio, Cantidad_pollo, Destino, Mortalidad " +
                "FROM Ticket_Pesado ORDER BY Id_ticket DESC LIMIT 5";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Órdenes de Recepción Recientes ------------------ **/
    public List<Map<String, Object>> obtenerOrdenesRecientes() {
        String sql = "SELECT Codigo_recepcion, Descripcion, Cantidad, Fecha, Almacen " +
                "FROM Orden_Recepcion ORDER BY Codigo_recepcion DESC LIMIT 5";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Productos Recientes ------------------ **/
    public List<Map<String, Object>> obtenerProductosRecientes() {
        String sql = "SELECT Id_producto, Descripcion, Unidad FROM Producto ORDER BY Id_producto DESC LIMIT 5";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Conductores Activos ------------------ **/
    public List<Map<String, Object>> obtenerConductoresActivos() {
        String sql = "SELECT c.Nro_Licencia, n.Nombre, CONCAT(n.Apellido_Paterno, ' ', n.Apellido_Materno) AS Apellidos, " +
                "d.Calle, d.Ciudad, c.Telefono, c.Estado " +
                "FROM Conductor c " +
                "INNER JOIN Nombre n ON c.Id_nombre = n.Id_nombre " +
                "INNER JOIN Direccion d ON c.Id_direccion = d.Id_direccion " +
                "WHERE c.Estado = 'Activo'";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Cantidad y densidad de jabas por galpón ------------------ **/
    public List<Map<String, Object>> obtenerJabasPorGalpon() {
        String sql = "SELECT g.Nombre AS Galpon, SUM(j.Cantidad) AS Total_jabas, AVG(j.Densidad) AS Densidad_promedio " +
                "FROM Jaba j " +
                "JOIN Galpon g ON j.Id_galpon = g.Id_galpon " +
                "GROUP BY g.Nombre ORDER BY Densidad_promedio DESC";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Órdenes de compra recientes (promedios) ------------------ **/
    public Map<String, Object> obtenerPromediosOrdenesRecientes() {
        String sql = "SELECT AVG(Asignado_minimo) AS Promedio_minimo, AVG(Asignado_maximo) AS Promedio_maximo, " +
                "MIN(Asignado_minimo) AS Asignacion_minima, MAX(Asignado_maximo) AS Asignacion_maxima " +
                "FROM Orden_compra_cabecera ORDER BY Id_orden_compra DESC LIMIT 5";
        List<Map<String, Object>> lista = ejecutarConsulta(sql);
        return lista.isEmpty() ? new HashMap<>() : lista.get(0);
    }

    /** ------------------ Productos por proveedor ------------------ **/
    public List<Map<String, Object>> obtenerProductosPorProveedor() {
        String sql = "SELECT dp.Id, pr.Nombre AS Proveedor, pro.Descripcion AS Producto, dp.Cantidad " +
                "FROM Detalle_Proveedor_Producto dp " +
                "INNER JOIN Proveedor pr ON pr.RUC = dp.RUC_proveedor " +
                "INNER JOIN Producto pro ON pro.Id_producto = dp.Id_producto";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Órdenes de compra activas ------------------ **/
    public List<Map<String, Object>> obtenerOrdenesActivas() {
        String sql = "SELECT p.Nombre AS Proveedor, oc.Id_orden_compra, oc.Fecha_emision, oc.Importe_total " +
                "FROM Orden_compra_cabecera oc " +
                "JOIN Proveedor p ON oc.RUC = p.RUC " +
                "WHERE oc.Cancelado = 0 " +
                "ORDER BY oc.Fecha_emision DESC";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Mortalidad por tipo y destino de ave ------------------ **/
    public List<Map<String, Object>> obtenerMortalidadPorAve() {
        String sql = "SELECT tp.Genero_pollo AS Producto, tp.Destino, SUM(tp.Mortalidad) AS Total_mortalidad " +
                "FROM Ticket_Pesado tp " +
                "GROUP BY tp.Genero_pollo, tp.Destino " +
                "ORDER BY Total_mortalidad DESC";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Historial de entregas por conductor y vehículo ------------------ **/
    public List<Map<String, Object>> obtenerEntregasPorConductorVehiculo() {
        String sql = "SELECT c.Nro_Licencia, n.Nombre AS Conductor, tp.Placa_vehiculo, COUNT(tp.Id_ticket) AS Entregas_realizadas " +
                "FROM Ticket_Pesado tp " +
                "JOIN Conductor c ON tp.Id_conductor = c.Nro_Licencia " +
                "JOIN Nombre n ON c.Id_nombre = n.Id_nombre " +
                "GROUP BY c.Nro_Licencia, n.Nombre, tp.Placa_vehiculo " +
                "ORDER BY Entregas_realizadas DESC";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Método genérico para ejecutar consultas y devolver resultados ------------------ **/
    public List<Map<String, Object>> ejecutarConsulta(String consulta) {
        List<Map<String, Object>> resultados = new ArrayList<>();

        try (Connection conn = ConexionBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(consulta)) {

            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> fila = new LinkedHashMap<>();
                for (int i = 1; i <= columnas; i++) {
                    fila.put(meta.getColumnLabel(i), rs.getObject(i));
                }
                resultados.add(fila);
            }

        } catch (SQLException e) {
            System.err.println("[ERROR InicioGestionador] Fallo al ejecutar consulta: " + e.getMessage());
        }

        return resultados;
    }
}
