package com.mamajulit.DAO;

import com.mamajulit.Model.ConexionBD;
import java.sql.*;

public class ReporteDAO {

    private final Connection conn = ConexionBD.getConnection();

    // Reporte de orden de compra con detalle
    public ResultSet obtenerReporteOrdenCompra() throws SQLException {
        String sql = "SELECT oc.Id_orden_compra, oc.Fecha_emision, oc.RUC, oc.Importe_total, "
                + "od.Id_detalle, od.Id_producto, od.Valor_unitario, od.Unidad_solicitada "
                + "FROM orden_compra_cabecera oc "
                + "JOIN orden_compra_detalle od ON oc.Id_orden_compra = od.Id_orden_compra";
        return conn.createStatement().executeQuery(sql);
    }

    // Reporte de proveedores
    public ResultSet obtenerReporteProveedor() throws SQLException {
        String sql = "SELECT * FROM proveedor";
        return conn.createStatement().executeQuery(sql);
    }

    // Reporte de productos
    public ResultSet obtenerReporteProducto() throws SQLException {
        String sql = "SELECT * FROM producto";
        return conn.createStatement().executeQuery(sql);
    }

    // Reporte de ticket pesado
    public ResultSet obtenerReporteTicketPesado() throws SQLException {
        String sql = "SELECT * FROM ticket_pesado";
        return conn.createStatement().executeQuery(sql);
    }

    // Reporte de guía de requerimientos
    public ResultSet obtenerReporteGuiaRequerimientos() throws SQLException {
        String sql = "SELECT * FROM guia_requerimientos";
        return conn.createStatement().executeQuery(sql);
    }

    // Reporte de auditoría orden de compra
    public ResultSet obtenerReporteAuditoriaOrdenCompra() throws SQLException {
        String sql = "SELECT * FROM auditoria_orden_compra";
        return conn.createStatement().executeQuery(sql);
    }
}
