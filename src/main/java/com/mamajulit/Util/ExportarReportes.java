package com.mamajulit.Util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.zip.*;

public class ExportarReportes {

    // Genera un archivo Excel desde un ResultSet
    public static File generarExcel(ResultSet rs, String nombreArchivo) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reporte");

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Cabecera
        Row headerRow = sheet.createRow(0);
        for (int i = 1; i <= columnCount; i++) {
            Cell cell = headerRow.createCell(i - 1);
            cell.setCellValue(metaData.getColumnLabel(i));
        }

        // Datos
        int rowNum = 1;
        while (rs.next()) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 1; i <= columnCount; i++) {
                row.createCell(i - 1).setCellValue(rs.getString(i));
            }
        }

        File file = new File(nombreArchivo + ".xlsx");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        }
        workbook.close();
        return file;
    }

    // Empaqueta varios archivos en un ZIP
    public static File generarZip(File[] archivos, String nombreZip) throws IOException {
        File zipFile = new File(nombreZip + ".zip");
        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            for (File archivo : archivos) {
                try (FileInputStream fis = new FileInputStream(archivo)) {
                    ZipEntry zipEntry = new ZipEntry(archivo.getName());
                    zos.putNextEntry(zipEntry);

                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                    zos.closeEntry();
                }
            }
        }
        return zipFile;
    }
}
