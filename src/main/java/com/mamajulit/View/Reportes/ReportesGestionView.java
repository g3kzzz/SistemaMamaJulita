package com.mamajulit.View.Reportes;

import com.mamajulit.DAO.ReporteDAO;
import com.mamajulit.Util.ExportarReportes;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.sql.ResultSet;

public class ReportesGestionView extends JPanel {

    private JButton btnOC, btnProveedor, btnProducto, btnTicket, btnGuia, btnAuditoria, btnExportarTodo;

    public ReportesGestionView() {
        setLayout(new GridLayout(7, 1, 10, 10));

        btnOC = new JButton("Exportar Orden de Compra");
        btnProveedor = new JButton("Exportar Proveedores");
        btnProducto = new JButton("Exportar Productos");
        btnTicket = new JButton("Exportar Tickets Pesados");
        btnGuia = new JButton("Exportar Guías Requerimientos");
        btnAuditoria = new JButton("Exportar Auditoría OC");
        btnExportarTodo = new JButton("Exportar Todo en ZIP");

        add(btnOC);
        add(btnProveedor);
        add(btnProducto);
        add(btnTicket);
        add(btnGuia);
        add(btnAuditoria);
        add(btnExportarTodo);

        btnOC.addActionListener(e -> exportarExcel("OC"));
        btnProveedor.addActionListener(e -> exportarExcel("PROVEEDOR"));
        btnProducto.addActionListener(e -> exportarExcel("PRODUCTO"));
        btnTicket.addActionListener(e -> exportarExcel("TICKET"));
        btnGuia.addActionListener(e -> exportarExcel("GUIA"));
        btnAuditoria.addActionListener(e -> exportarExcel("AUDITORIA"));
        btnExportarTodo.addActionListener(e -> exportarTodoZip());
    }

    private void exportarExcel(String tipo) {
        try {
            ReporteDAO dao = new ReporteDAO();
            ResultSet rs = switch (tipo) {
                case "OC" -> dao.obtenerReporteOrdenCompra();
                case "PROVEEDOR" -> dao.obtenerReporteProveedor();
                case "PRODUCTO" -> dao.obtenerReporteProducto();
                case "TICKET" -> dao.obtenerReporteTicketPesado();
                case "GUIA" -> dao.obtenerReporteGuiaRequerimientos();
                case "AUDITORIA" -> dao.obtenerReporteAuditoriaOrdenCompra();
                default -> null;
            };
            if (rs != null) {
                File excel = ExportarReportes.generarExcel(rs, "Reporte_" + tipo);
                JOptionPane.showMessageDialog(this, "Archivo generado: " + excel.getAbsolutePath());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar reporte: " + ex.getMessage());
        }
    }

    private void exportarTodoZip() {
        try {
            ReporteDAO dao = new ReporteDAO();
            File[] archivos = new File[]{
                    ExportarReportes.generarExcel(dao.obtenerReporteOrdenCompra(), "Reporte_OC"),
                    ExportarReportes.generarExcel(dao.obtenerReporteProveedor(), "Reporte_PROVEEDOR"),
                    ExportarReportes.generarExcel(dao.obtenerReporteProducto(), "Reporte_PRODUCTO"),
                    ExportarReportes.generarExcel(dao.obtenerReporteTicketPesado(), "Reporte_TICKET"),
                    ExportarReportes.generarExcel(dao.obtenerReporteGuiaRequerimientos(), "Reporte_GUIA"),
                    ExportarReportes.generarExcel(dao.obtenerReporteAuditoriaOrdenCompra(), "Reporte_AUDITORIA")
            };
            File zip = ExportarReportes.generarZip(archivos, "Reportes_MamaJulita");

            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(new File("Reportes_MamaJulita.zip"));
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                Files.copy(zip.toPath(), chooser.getSelectedFile().toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "ZIP exportado correctamente.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar ZIP: " + ex.getMessage());
        }
    }
}
