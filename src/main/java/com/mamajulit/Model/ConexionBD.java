package com.mamajulit.Model;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.*;
import java.sql.*;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConexionBD {

    // ====== CONFIG ======
    private static final String DB_NAME = "MamaJulita";
    private static final int PORT = 3307;
    private static final String HOST = "127.0.0.1";

    private static final Path MARIADB_BIN = Paths.get("mariadb", "bin");
    private static final String MYSQLD_EXE = "mysqld.exe";
    private static final String MYSQLADMIN_EXE = "mysqladmin.exe";

    private static final String RESOURCE_SQL = "/sql/MamaJulita_fixed.sql";
    private static final Path FALLBACK_SQL = Paths.get("MamaJulita_fixed.sql");

    private static final String RESOURCE_PROCEDURES = "/sql/MamaJulita_procedures.sql";
    private static final Path FALLBACK_PROCEDURES = Paths.get("MamaJulita_procedures.sql");

    private static final String ROOT_USER = "root";
    private static final String ROOT_PASS = ""; // cambiar si hay password
    private static final String APP_USER = "admin";
    private static final String APP_PASS = "admin";
    private static final String CONTACTO_USER = "contacto";
    private static final String CONTACTO_PASS = "contacto";
    private static final String TRABAJADOR_USER = "trabajadorcomun";
    private static final String TRABAJADOR_PASS = "trabajador";

    private static final Duration STARTUP_TIMEOUT = Duration.ofSeconds(30);
    private static final Duration STARTUP_RETRY_INTERVAL = Duration.ofMillis(500);

    // ANSI colors
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";

    private static Connection conn = null;
    private static Process mysqldProcess = null;
    private static boolean startedByThisApp = false;

    private static final String URL_SERVER = "jdbc:mysql://" + HOST + ":" + PORT + "/?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String URL_DB = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME + "?useSSL=false&allowPublicKeyRetrieval=true";

    // ---------------- PUBLIC API ----------------
    public static synchronized Connection getConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                System.out.println(CYAN + "[INFO] Reutilizando conexión existente." + RESET);
                return conn;
            }

            if (!isServerListening(HOST, PORT)) {
                System.out.println(YELLOW + "[WARN] MariaDB no responde, arrancando servidor portable..." + RESET);
                startMariaDB();
                startedByThisApp = true;
                Runtime.getRuntime().addShutdownHook(new Thread(ConexionBD::shutdownMariaDB));
            } else {
                System.out.println(GREEN + "[INFO] MariaDB ya estaba corriendo en " + HOST + ":" + PORT + RESET);
            }

            if (!waitForServerStartup(STARTUP_TIMEOUT)) {
                System.err.println(RED + "[ERROR] Timeout esperando que MariaDB arranque." + RESET);
                return null;
            }

            // setup completo usando root
            setupDatabase();

            // conectar finalmente como admin
            try {
                conn = DriverManager.getConnection(URL_DB, APP_USER, APP_PASS);
                System.out.println(GREEN + "[SUCCESS] Conectado como '" + APP_USER + "' a la BD '" + DB_NAME + "'." + RESET);
            } catch (SQLException e) {
                System.err.println(RED + "[ERROR] No se pudo conectar como admin, intentando root..." + RESET);
                conn = DriverManager.getConnection(URL_DB, ROOT_USER, ROOT_PASS);
                System.out.println(YELLOW + "[WARN] Conectado como root (fallback) a '" + DB_NAME + "'." + RESET);
            }

            return conn;

        } catch (Exception e) {
            System.err.println(RED + "[ERROR CRÍTICO] " + e.getMessage() + RESET);
            e.printStackTrace();
            return null;
        }
    }

    // ------------------ SETUP ------------------
    private static void setupDatabase() {
        try (Connection rootConn = DriverManager.getConnection(URL_SERVER, ROOT_USER, ROOT_PASS)) {
            System.out.println(GREEN + "[INFO] Conectado como root para setup." + RESET);

            boolean dbExists = databaseExists(rootConn, DB_NAME);

            if (!dbExists) {
                System.out.println(YELLOW + "[INFO] BD '" + DB_NAME + "' no existe. Creando..." + RESET);
                try (Statement st = rootConn.createStatement()) {
                    st.executeUpdate("CREATE DATABASE " + DB_NAME + " CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci");
                    System.out.println(GREEN + "[SUCCESS] Base de datos creada: " + DB_NAME + RESET);
                }

                // Importar SQL inicial
                System.out.println(CYAN + "[INFO] Importando SQL inicial..." + RESET);
                if (importSqlToDatabase(rootConn, DB_NAME, RESOURCE_SQL, FALLBACK_SQL))
                    System.out.println(GREEN + "[SUCCESS] SQL importado correctamente." + RESET);
                else
                    System.out.println(YELLOW + "[WARN] Falló importación de SQL." + RESET);

                // Importar procedimientos
                if (Files.exists(FALLBACK_PROCEDURES) || ConexionBD.class.getResource(RESOURCE_PROCEDURES) != null) {
                    System.out.println(CYAN + "[INFO] Importando procedimientos almacenados..." + RESET);
                    try (Statement st = rootConn.createStatement()) {
                        st.execute("USE " + DB_NAME);
                    } catch (SQLException e) {
                        System.err.println(RED + "[ERROR] No se pudo seleccionar BD antes de importar procedimientos: " + e.getMessage() + RESET);
                    }
                    if (importSqlToDatabase(rootConn, DB_NAME, RESOURCE_PROCEDURES, FALLBACK_PROCEDURES))
                        System.out.println(GREEN + "[SUCCESS] Procedimientos importados correctamente." + RESET);
                    else
                        System.out.println(YELLOW + "[WARN] Falló importación de procedimientos." + RESET);
                }

            } else {
                System.out.println(GREEN + "[INFO] BD '" + DB_NAME + "' ya existe. Se asume que tablas y procedimientos también existen; no se importa nada." + RESET);
            }

            // Crear/ajustar usuarios siempre, aunque la BD exista
            createApplicationUsers(rootConn);

        } catch (SQLException e) {
            System.err.println(RED + "[ERROR setupDatabase] " + e.getMessage() + RESET);
        }
    }



    // ------------------ IMPORT SQL ------------------
    private static boolean importSqlToDatabase(Connection rootConn, String dbName, String resourcePath, Path fallbackPath) {
        try {
            InputStream is = ConexionBD.class.getResourceAsStream(resourcePath);
            if (is == null && Files.exists(fallbackPath)) is = Files.newInputStream(fallbackPath);
            if (is == null) { System.err.println(YELLOW + "[WARN] No se encontró script SQL: " + resourcePath + RESET); return false; }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is)); Statement st = rootConn.createStatement()) {
                StringBuilder sb = new StringBuilder();
                String line;
                String delimiter = ";";

                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.startsWith("DELIMITER")) {
                        delimiter = line.split("\\s+")[1];
                        continue;
                    }

                    sb.append(line).append("\n");
                    if (line.endsWith(delimiter)) {
                        String sql = sb.toString().trim();
                        try { st.execute(sql); } catch (SQLException e) { System.err.println(RED + "[ERROR SQL] " + e.getMessage() + RESET); }
                        sb.setLength(0);
                    }
                }
                return true;
            }

        } catch (IOException | SQLException e) { System.err.println(RED + "[ERROR importSqlToDatabase] " + e.getMessage() + RESET); return false; }
    }

    // ------------------ UTILS ------------------
    private static boolean isServerListening(String host, int port) {
        try (Socket s = new Socket()) {
            s.connect(new InetSocketAddress(host, port), 300);
            return true;
        } catch (IOException e) { return false; }
    }

    private static boolean waitForServerStartup(Duration timeout) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < timeout.toMillis()) {
            if (isServerListening(HOST, PORT)) return true;
            try { Thread.sleep(STARTUP_RETRY_INTERVAL.toMillis()); } catch (InterruptedException ignored) { Thread.currentThread().interrupt(); }
        }
        return false;
    }

    private static void startMariaDB() throws IOException {
        Path mysqldPath = MARIADB_BIN.resolve(MYSQLD_EXE);
        if (!Files.exists(mysqldPath)) mysqldPath = MARIADB_BIN.resolve("mariadbd.exe");
        if (!Files.exists(mysqldPath)) throw new FileNotFoundException("No se encontró mysqld/mariadbd en: " + MARIADB_BIN.toAbsolutePath());

        ProcessBuilder pb = new ProcessBuilder(mysqldPath.toAbsolutePath().toString(), "--console");
        pb.directory(MARIADB_BIN.toFile());
        pb.redirectErrorStream(true);

        System.out.println(CYAN + "[INFO] Iniciando MariaDB portable..." + RESET);
        mysqldProcess = pb.start();

        Executors.newSingleThreadExecutor().submit(() -> {
            try (BufferedReader r = new BufferedReader(new InputStreamReader(mysqldProcess.getInputStream()))) {
                String line;
                while ((line = r.readLine()) != null) System.out.println("[mariadb] " + line);
            } catch (IOException ignored) {}
        });
    }

    private static void shutdownMariaDB() {
        try {
            if (mysqldProcess != null && mysqldProcess.isAlive()) {
                System.out.println(YELLOW + "[INFO] Deteniendo MariaDB..." + RESET);
                Path mysqladminPath = MARIADB_BIN.resolve(MYSQLADMIN_EXE);
                if (Files.exists(mysqladminPath)) {
                    ProcessBuilder pb = new ProcessBuilder(mysqladminPath.toAbsolutePath().toString(), "-u", ROOT_USER, "-P", String.valueOf(PORT), "shutdown");
                    pb.directory(MARIADB_BIN.toFile());
                    pb.redirectErrorStream(true);
                    Process p = pb.start();
                    p.waitFor(5, TimeUnit.SECONDS);
                }
                if (mysqldProcess.isAlive()) { mysqldProcess.destroy(); mysqldProcess.waitFor(5, TimeUnit.SECONDS); if (mysqldProcess.isAlive()) mysqldProcess.destroyForcibly(); }
                System.out.println(GREEN + "[INFO] MariaDB detenido." + RESET);
            }
        } catch (Exception e) { System.err.println(RED + "[WARN] Error al detener MariaDB: " + e.getMessage() + RESET); }
    }

    private static boolean databaseExists(Connection rootConn, String dbName) {
        try (ResultSet rs = rootConn.getMetaData().getCatalogs()) {
            while (rs.next()) if (rs.getString(1).equalsIgnoreCase(dbName)) return true;
        } catch (SQLException e) { System.err.println(RED + "[ERROR databaseExists] " + e.getMessage() + RESET); }
        return false;
    }

    private static void createApplicationUsers(Connection rootConn) {
        try (Statement st = rootConn.createStatement()) {
            System.out.println(CYAN + "[INFO] Creando/ajustando usuarios..." + RESET);

            // admin
            st.execute("CREATE USER IF NOT EXISTS '" + APP_USER + "'@'localhost' IDENTIFIED BY '" + APP_PASS + "'");
            st.execute("GRANT ALL PRIVILEGES ON *.* TO '" + APP_USER + "'@'localhost' WITH GRANT OPTION");

            // contacto
            st.execute("CREATE USER IF NOT EXISTS '" + CONTACTO_USER + "'@'localhost' IDENTIFIED BY '" + CONTACTO_PASS + "'");
            String[] tablas = {"proveedor","direccion","detalle_proveedor_producto","cotizacion_proveedor","cotizacion_proveedor_historial",
                    "ticket_pesado","guia_requerimientos","orden_compra_cabecera","orden_compra_detalle","orden_recepcion","reporte_compra"};
            for (String t : tablas) st.execute("GRANT SELECT, INSERT, UPDATE, DELETE ON " + DB_NAME + "." + t + " TO '" + CONTACTO_USER + "'@'localhost'");
            st.execute("GRANT SELECT ON " + DB_NAME + ".vw_productos_proveedor TO '" + CONTACTO_USER + "'@'localhost'");

            // trabajadorcomun
            st.execute("CREATE USER IF NOT EXISTS '" + TRABAJADOR_USER + "'@'localhost' IDENTIFIED BY '" + TRABAJADOR_PASS + "'");
            st.execute("GRANT SELECT ON " + DB_NAME + ".* TO '" + TRABAJADOR_USER + "'@'localhost'");

            st.execute("FLUSH PRIVILEGES");
            System.out.println(GREEN + "[SUCCESS] Usuarios creados/ajustados." + RESET);
        } catch (SQLException e) { System.err.println(RED + "[ERROR createApplicationUsers] " + e.getMessage() + RESET); }
    }

    // ------------------ CLOSERS ------------------
    public static void closeConnection() { try { if (conn != null && !conn.isClosed()) conn.close(); } catch (SQLException ignored) {} }

    // ------------------ MAIN PRUEBA ------------------
    public static void main(String[] args) {
        System.out.println(CYAN + "[INFO] Prueba de ConexionBD..." + RESET);
        Connection c = getConnection();
        if (c != null) {
            System.out.println(GREEN + "[SUCCESS] Conexión exitosa." + RESET);
            closeConnection();
        } else {
            System.err.println(RED + "[FAIL] No se pudo establecer conexión." + RESET);
        }
        if (startedByThisApp) shutdownMariaDB();
    }
}
