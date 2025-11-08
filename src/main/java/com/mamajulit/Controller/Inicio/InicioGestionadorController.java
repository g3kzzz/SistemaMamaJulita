package com.mamajulit.Controller.Inicio;

import com.mamajulit.Model.ConexionBD;

import java.sql.*;
import java.util.*;

/**
 * Controlador de la vista InicioGestionador.
 * Trae datos recientes y métricas globales de la base de datos para el dashboard del gestor.
 */
public class InicioGestionadorController {

    /** ------------------ Tickets Pesados Recientes (top 3, por fecha) ------------------ **/
    public List<Map<String, Object>> obtenerTicketsRecientes() {
        String sql = "SELECT Id_ticket, Fecha_salida, Peso_promedio, Cantidad_pollo, Destino, Mortalidad " +
                "FROM Ticket_Pesado " +
                "ORDER BY Fecha_salida DESC " +
                "LIMIT 3";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Órdenes de Recepción Recientes (top 3 por fecha) ------------------ **/
    public List<Map<String, Object>> obtenerOrdenesRecientes() {
        String sql = "SELECT Codigo_recepcion, Descripcion, Cantidad, Fecha, Almacen " +
                "FROM Orden_Recepcion " +
                "ORDER BY Fecha DESC " +
                "LIMIT 3";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Productos Recientes (top 3 por id) ------------------ **/
    public List<Map<String, Object>> obtenerProductosRecientes() {
        String sql = "SELECT Id_producto, Descripcion, Unidad " +
                "FROM Producto " +
                "ORDER BY Id_producto DESC " +
                "LIMIT 3";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Conductores Activos (top 3 por nombre) ------------------ **/
    public List<Map<String, Object>> obtenerConductoresActivos() {
        String sql = "SELECT c.Nro_Licencia, n.Nombre, CONCAT(n.Apellido_Paterno, ' ', n.Apellido_Materno) AS Apellidos, " +
                "d.Calle, d.Ciudad, c.Telefono, c.Estado " +
                "FROM Conductor c " +
                "INNER JOIN Nombre n ON c.Id_nombre = n.Id_nombre " +
                "INNER JOIN Direccion d ON c.Id_direccion = d.Id_direccion " +
                "WHERE c.Estado = 'Activo' " +
                "LIMIT 3";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Cantidad y densidad de jabas por galpón (top 3) ------------------ **/
    public List<Map<String, Object>> obtenerJabasPorGalpon() {
        String sql = "SELECT g.Nombre AS Galpon, " +
                "COALESCE(SUM(j.Cantidad),0) AS Total_jabas, " +
                "COALESCE(AVG(j.Densidad),0) AS Densidad_promedio " +
                "FROM Jaba j " +
                "JOIN Galpon g ON j.Id_galpon = g.Id_galpon " +
                "GROUP BY g.Nombre " +
                "ORDER BY Densidad_promedio DESC " +
                "LIMIT 3";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Órdenes de Compra Activas (top 3) ------------------ **/
    public List<Map<String, Object>> obtenerOrdenesActivas() {
        String sql = "SELECT p.Nombre AS Proveedor, oc.Id_orden_compra, oc.Fecha_emision, oc.Importe_total " +
                "FROM Orden_compra_cabecera oc " +
                "JOIN Proveedor p ON oc.RUC = p.RUC " +
                "WHERE oc.Cancelado = 0 " +
                "ORDER BY oc.Fecha_emision DESC " +
                "LIMIT 3";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Mortalidad por tipo y destino (top 3) ------------------ **/
    public List<Map<String, Object>> obtenerMortalidadPorAve() {
        String sql = "SELECT tp.Genero_pollo AS Tipo, tp.Destino, COALESCE(SUM(tp.Mortalidad),0) AS Total_mortalidad " +
                "FROM Ticket_Pesado tp " +
                "GROUP BY tp.Genero_pollo, tp.Destino " +
                "ORDER BY Total_mortalidad DESC " +
                "LIMIT 3";
        return ejecutarConsulta(sql);
    }

    /** ------------------ Entregas por conductor y vehículo (top 3) ------------------ **/
    public List<Map<String, Object>> obtenerEntregasPorConductorVehiculo() {
        String sql = "SELECT n.Nombre AS Conductor, tp.Placa_vehiculo AS Placa, COUNT(tp.Id_ticket) AS Entregas_realizadas " +
                "FROM Ticket_Pesado tp " +
                "JOIN Conductor c ON tp.Id_conductor = c.Nro_Licencia " +
                "JOIN Nombre n ON c.Id_nombre = n.Id_nombre " +
                "GROUP BY n.Nombre, tp.Placa_vehiculo " +
                "ORDER BY Entregas_realizadas DESC " +
                "LIMIT 3";
        return ejecutarConsulta(sql);
    }

    /** ------------------ MÉTRICAS RESUMEN (para el panel superior) ------------------ **/
    public Map<String, String> obtenerMetricas() {
        Map<String, String> metricas = new LinkedHashMap<>();
        metricas.put("Órdenes activas", String.valueOf(contar("SELECT COUNT(*) FROM Orden_compra_cabecera WHERE Cancelado = 0")));
        metricas.put("Conductores activos", String.valueOf(contar("SELECT COUNT(*) FROM Conductor WHERE Estado = 'Activo'")));
        metricas.put("Productos registrados", String.valueOf(contar("SELECT COUNT(*) FROM Producto")));
        metricas.put("Tickets (últ 7d)", String.valueOf(contar("SELECT COUNT(*) FROM Ticket_Pesado WHERE Fecha_salida >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)")));
        return metricas;
    }

    /** ------------------ Método helper para COUNT(*) ------------------ **/
    private int contar(String sql) {
        try (Connection conn = ConexionBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("[ERROR InicioGestionadorController.contar] " + e.getMessage());
        }
        return 0;
    }

    /** ------------------ Método genérico para ejecutar consultas y devolver resultados (seguro) ------------------ **/
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
                    Object valor = rs.getObject(i);
                    // Manejo de nulos: usar guion medio para visualización
                    if (valor == null) {
                        fila.put(meta.getColumnLabel(i), "—");
                    } else if (valor instanceof java.sql.Date || valor instanceof java.sql.Timestamp) {
                        fila.put(meta.getColumnLabel(i), String.valueOf(valor)); // deja como string
                    } else {
                        fila.put(meta.getColumnLabel(i), valor);
                    }
                }
                resultados.add(fila);
            }

        } catch (SQLException e) {
            System.err.println("[ERROR InicioGestionadorController.ejecutarConsulta] " + e.getMessage());
        }

        return resultados;
    }
}
