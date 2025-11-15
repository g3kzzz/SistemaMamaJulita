package com.mamajulit.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // ====== Configuración de conexión ======
    private static final String URL =
            "jdbc:mysql://localhost:3306/MamaJulita?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "GK270523.";


    private static Connection connection = null;

    // ====== Colores ANSI ======
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";

    // ====== Método para obtener conexión ======
    public static Connection getConnection() {
        try {
            // Verifica si la conexión está cerrada o nula antes de reutilizarla
            if (connection == null || connection.isClosed()) {
                // Cargar el driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println(GREEN + "[SUCCESS] Conexión establecida con la base de datos." + RESET);
            } else {
                System.out.println(CYAN + "[INFO] Conexión reutilizada (ya existe una instancia activa)." + RESET);
            }
        } catch (ClassNotFoundException e) {
            System.err.println(YELLOW + "[WARN] Driver JDBC de MySQL no encontrado." + RESET);
            System.err.println(RED + "[ERROR] Asegúrate de tener el archivo 'mysql-connector-j.jar' dentro de la carpeta /lib y agregado al classpath." + RESET);
        } catch (SQLException e) {
            System.err.println(RED + "[ERROR] No se pudo conectar a la base de datos." + RESET);
            System.err.println(CYAN + "        Causa: " + e.getMessage() + RESET);
        }
        return connection;
    }


    // ====== Método para cerrar conexión ======
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println(GREEN + "[SUCCESS] Conexión cerrada correctamente." + RESET);
            } catch (SQLException e) {
                System.err.println(RED + "[ERROR] Falló al cerrar la conexión: " + e.getMessage() + RESET);
            }
        } else {
            System.out.println(YELLOW + "[WARN] No hay conexión activa que cerrar." + RESET);
        }
    }

    // ====== Método de prueba ======
    public static void main(String[] args) {
        System.out.println(CYAN + "[INFO] Iniciando prueba de conexión con la base de datos..." + RESET);
        Connection conn = ConexionBD.getConnection();
        if (conn != null) {
            System.out.println(GREEN + "[SUCCESS] Prueba completada correctamente." + RESET);
            ConexionBD.closeConnection();
        } else {
            System.err.println(RED + "[ERROR] No se pudo establecer conexión. Revisa las credenciales o el driver." + RESET);
        }
    }
}
