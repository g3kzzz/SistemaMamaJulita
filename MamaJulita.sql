-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: mamajulita
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `auditoria_cotizacionproveedor`
--

drop database if exists mamajulita;
create database mamajulita;
use mamajulita;

DROP TABLE IF EXISTS `auditoria_cotizacionproveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditoria_cotizacionproveedor` (
  `Id_auditoria` int NOT NULL AUTO_INCREMENT,
  `Id_cotizacion` varchar(30) DEFAULT NULL,
  `Accion` varchar(20) DEFAULT NULL,
  `Fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Usuario` varchar(100) DEFAULT NULL,
  `Datos_antes` text,
  `Datos_despues` text,
  PRIMARY KEY (`Id_auditoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria_cotizacionproveedor`
--

LOCK TABLES `auditoria_cotizacionproveedor` WRITE;
/*!40000 ALTER TABLE `auditoria_cotizacionproveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditoria_cotizacionproveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditoria_detalleproveedorproducto`
--

DROP TABLE IF EXISTS `auditoria_detalleproveedorproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditoria_detalleproveedorproducto` (
  `Id_auditoria` int NOT NULL AUTO_INCREMENT,
  `Id_detalle` int DEFAULT NULL,
  `Accion` varchar(20) DEFAULT NULL,
  `Fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Usuario` varchar(100) DEFAULT NULL,
  `Datos_antes` text,
  `Datos_despues` text,
  PRIMARY KEY (`Id_auditoria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria_detalleproveedorproducto`
--

LOCK TABLES `auditoria_detalleproveedorproducto` WRITE;
/*!40000 ALTER TABLE `auditoria_detalleproveedorproducto` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditoria_detalleproveedorproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditoria_orden_compra`
--

DROP TABLE IF EXISTS `auditoria_orden_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditoria_orden_compra` (
  `Id_auditoria` int NOT NULL AUTO_INCREMENT,
  `Fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Usuario` varchar(100) DEFAULT NULL,
  `Id_orden_compra` varchar(20) DEFAULT NULL,
  `Accion` varchar(20) DEFAULT NULL,
  `Mensaje` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`Id_auditoria`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria_orden_compra`
--

LOCK TABLES `auditoria_orden_compra` WRITE;
/*!40000 ALTER TABLE `auditoria_orden_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditoria_orden_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditoria_ordenrecepcion`
--

DROP TABLE IF EXISTS `auditoria_ordenrecepcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditoria_ordenrecepcion` (
  `Id_auditoria` int NOT NULL AUTO_INCREMENT,
  `Codigo_recepcion` int DEFAULT NULL,
  `Accion` varchar(20) DEFAULT NULL,
  `Fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Usuario` varchar(100) DEFAULT NULL,
  `Datos_antes` text,
  `Datos_despues` text,
  PRIMARY KEY (`Id_auditoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria_ordenrecepcion`
--

LOCK TABLES `auditoria_ordenrecepcion` WRITE;
/*!40000 ALTER TABLE `auditoria_ordenrecepcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditoria_ordenrecepcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditoria_proveedor`
--

DROP TABLE IF EXISTS `auditoria_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditoria_proveedor` (
  `id_auditoria` int NOT NULL AUTO_INCREMENT,
  `accion` varchar(20) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `descripcion` text,
  PRIMARY KEY (`id_auditoria`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria_proveedor`
--

LOCK TABLES `auditoria_proveedor` WRITE;
/*!40000 ALTER TABLE `auditoria_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditoria_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditoria_proveedor_producto`
--

DROP TABLE IF EXISTS `auditoria_proveedor_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditoria_proveedor_producto` (
  `id_auditoria` int NOT NULL AUTO_INCREMENT,
  `accion` varchar(20) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `descripcion` text,
  PRIMARY KEY (`id_auditoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria_proveedor_producto`
--

LOCK TABLES `auditoria_proveedor_producto` WRITE;
/*!40000 ALTER TABLE `auditoria_proveedor_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditoria_proveedor_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditoria_ticketpesado`
--

DROP TABLE IF EXISTS `auditoria_ticketpesado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditoria_ticketpesado` (
  `Id_auditoria` int NOT NULL AUTO_INCREMENT,
  `Id_ticket` int DEFAULT NULL,
  `Accion` varchar(20) DEFAULT NULL,
  `alterno` varchar(19) DEFAULT NULL,
  `Fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Usuario` varchar(50) DEFAULT NULL,
  `Datos_antes` text,
  `Datos_despues` text,
  PRIMARY KEY (`Id_auditoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria_ticketpesado`
--

LOCK TABLES `auditoria_ticketpesado` WRITE;
/*!40000 ALTER TABLE `auditoria_ticketpesado` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditoria_ticketpesado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conductor`
--

DROP TABLE IF EXISTS `conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conductor` (
  `Nro_Licencia` varchar(20) NOT NULL,
  `Id_nombre` int DEFAULT NULL,
  `Estado` varchar(50) DEFAULT NULL,
  `Id_direccion` int DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Nro_Licencia`),
  KEY `Id_nombre` (`Id_nombre`),
  KEY `Id_direccion` (`Id_direccion`),
  CONSTRAINT `conductor_ibfk_1` FOREIGN KEY (`Id_nombre`) REFERENCES `nombre` (`Id_nombre`),
  CONSTRAINT `conductor_ibfk_2` FOREIGN KEY (`Id_direccion`) REFERENCES `direccion` (`Id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conductor`
--

LOCK TABLES `conductor` WRITE;
/*!40000 ALTER TABLE `conductor` DISABLE KEYS */;
/*!40000 ALTER TABLE `conductor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cotizacion_proveedor`
--

DROP TABLE IF EXISTS `cotizacion_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cotizacion_proveedor` (
  `Id_cotizacion` int NOT NULL AUTO_INCREMENT,
  `RUC` varchar(20) NOT NULL,
  `Genero` varchar(50) NOT NULL,
  `Cantidad_pollos` int NOT NULL,
  `Asignado_minimo` int NOT NULL,
  `Asignado_maximo` int NOT NULL,
  `Precio_maximo` float NOT NULL,
  `Precio_minimo` float NOT NULL,
  `Activa` tinyint(1) DEFAULT '0',
  `Fecha_creacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_registro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id_cotizacion`),
  KEY `idx_cot_prov_ruc` (`RUC`),
  KEY `idx_cot_prov_activa` (`Activa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotizacion_proveedor`
--

LOCK TABLES `cotizacion_proveedor` WRITE;
/*!40000 ALTER TABLE `cotizacion_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `cotizacion_proveedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_cotizacion_proveedor_update` BEFORE UPDATE ON `cotizacion_proveedor` FOR EACH ROW BEGIN
    SET NEW.fecha_registro = CURRENT_TIMESTAMP;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `cotizacion_proveedor_historial`
--

DROP TABLE IF EXISTS `cotizacion_proveedor_historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cotizacion_proveedor_historial` (
  `Id_historial` int NOT NULL AUTO_INCREMENT,
  `Id_cotizacion` int DEFAULT NULL,
  `Accion` enum('INSERT','UPDATE','DELETE') DEFAULT NULL,
  `Fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `Usuario` varchar(100) DEFAULT NULL,
  `Detalle` text,
  PRIMARY KEY (`Id_historial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotizacion_proveedor_historial`
--

LOCK TABLES `cotizacion_proveedor_historial` WRITE;
/*!40000 ALTER TABLE `cotizacion_proveedor_historial` DISABLE KEYS */;
/*!40000 ALTER TABLE `cotizacion_proveedor_historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_proveedor_producto`
--

DROP TABLE IF EXISTS `detalle_proveedor_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_proveedor_producto` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Id_orden_compra` varchar(20) DEFAULT NULL,
  `Id_producto` int DEFAULT NULL,
  `RUC_proveedor` varchar(20) DEFAULT NULL,
  `Cantidad` int DEFAULT NULL,
  `Precio_base` float DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_orden_compra` (`Id_orden_compra`),
  KEY `Id_producto` (`Id_producto`),
  KEY `RUC_proveedor` (`RUC_proveedor`),
  CONSTRAINT `detalle_proveedor_producto_ibfk_1` FOREIGN KEY (`Id_orden_compra`) REFERENCES `orden_compra_cabecera` (`Id_orden_compra`),
  CONSTRAINT `detalle_proveedor_producto_ibfk_2` FOREIGN KEY (`Id_producto`) REFERENCES `producto` (`Id_producto`),
  CONSTRAINT `detalle_proveedor_producto_ibfk_3` FOREIGN KEY (`RUC_proveedor`) REFERENCES `proveedor` (`RUC`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_proveedor_producto`
--

LOCK TABLES `detalle_proveedor_producto` WRITE;
/*!40000 ALTER TABLE `detalle_proveedor_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_proveedor_producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_aud_detalle_proveedor_insert` AFTER INSERT ON `detalle_proveedor_producto` FOR EACH ROW BEGIN
    INSERT INTO Auditoria_DetalleProveedorProducto (Id_detalle, Accion, Usuario, Datos_despues)
    VALUES (NEW.Id, 'INSERT', USER(),
            CONCAT('RUC=', NEW.RUC_proveedor, ', Id_producto=', NEW.Id_producto, ', Cantidad=', IFNULL(CAST(NEW.Cantidad AS CHAR),''), ', Precio_base=', IFNULL(CAST(NEW.Precio_base AS CHAR),'')));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_auditar_producto_proveedor` AFTER UPDATE ON `detalle_proveedor_producto` FOR EACH ROW BEGIN
    INSERT INTO auditoria_proveedor_producto(accion, usuario, descripcion)
    VALUES(
        'UPDATE',
        'sistema',
        CONCAT('Cambio de Precio_base: ', OLD.Precio_base,
               ' -> ', NEW.Precio_base,
               ' (ID=', NEW.Id, ')')
    );
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_aud_detalle_proveedor_update` AFTER UPDATE ON `detalle_proveedor_producto` FOR EACH ROW BEGIN
    INSERT INTO Auditoria_DetalleProveedorProducto (Id_detalle, Accion, Usuario, Datos_antes, Datos_despues)
    VALUES (NEW.Id, 'UPDATE', USER(),
            CONCAT('RUC=', OLD.RUC_proveedor, ', Id_producto=', OLD.Id_producto, ', Cantidad=', IFNULL(CAST(OLD.Cantidad AS CHAR),''), ', Precio_base=', IFNULL(CAST(OLD.Precio_base AS CHAR),'')),
            CONCAT('RUC=', NEW.RUC_proveedor, ', Id_producto=', NEW.Id_producto, ', Cantidad=', IFNULL(CAST(NEW.Cantidad AS CHAR),''), ', Precio_base=', IFNULL(CAST(NEW.Precio_base AS CHAR),'')));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_aud_detalle_proveedor_delete` AFTER DELETE ON `detalle_proveedor_producto` FOR EACH ROW BEGIN
    INSERT INTO Auditoria_DetalleProveedorProducto (Id_detalle, Accion, Usuario, Datos_antes)
    VALUES (OLD.Id, 'DELETE', USER(),
            CONCAT('RUC=', OLD.RUC_proveedor, ', Id_producto=', OLD.Id_producto, ', Cantidad=', IFNULL(CAST(OLD.Cantidad AS CHAR),''), ', Precio_base=', IFNULL(CAST(OLD.Precio_base AS CHAR),'')));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccion` (
  `Id_direccion` int NOT NULL AUTO_INCREMENT,
  `Calle` varchar(100) DEFAULT NULL,
  `Numero` varchar(10) DEFAULT NULL,
  `Ciudad` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id_direccion`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `Id_empleado` int NOT NULL AUTO_INCREMENT,
  `Id_nombre` int DEFAULT NULL,
  `Cargo` varchar(100) DEFAULT NULL,
  `NivelAcceso` int DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Contrasena` varchar(255) NOT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_empleado`),
  UNIQUE KEY `Email` (`Email`),
  KEY `Id_nombre` (`Id_nombre`),
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`Id_nombre`) REFERENCES `nombre` (`Id_nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (11,11,'Gestor',1,'genaro@g3k.com','12345678',NULL);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `RUC` varchar(20) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Razon_Social` varchar(150) DEFAULT NULL,
  `Id_direccion` int DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`RUC`),
  KEY `Id_direccion` (`Id_direccion`),
  CONSTRAINT `empresa_ibfk_1` FOREIGN KEY (`Id_direccion`) REFERENCES `direccion` (`Id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `galpon`
--

DROP TABLE IF EXISTS `galpon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `galpon` (
  `Id_galpon` varchar(20) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Capacidad` int DEFAULT NULL,
  `Estado` varchar(50) DEFAULT NULL,
  `Id_plantel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_galpon`),
  KEY `Id_plantel` (`Id_plantel`),
  CONSTRAINT `galpon_ibfk_1` FOREIGN KEY (`Id_plantel`) REFERENCES `plantel` (`Id_plantel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galpon`
--

LOCK TABLES `galpon` WRITE;
/*!40000 ALTER TABLE `galpon` DISABLE KEYS */;
/*!40000 ALTER TABLE `galpon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guia_requerimientos`
--

DROP TABLE IF EXISTS `guia_requerimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guia_requerimientos` (
  `Id_guia` int NOT NULL AUTO_INCREMENT,
  `Fecha_entrega` date DEFAULT NULL,
  `Hora_entrega` time DEFAULT NULL,
  `Id_conductor` varchar(20) DEFAULT NULL,
  `Id_plantel` varchar(20) DEFAULT NULL,
  `Id_direccion` int DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_guia`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guia_requerimientos`
--

LOCK TABLES `guia_requerimientos` WRITE;
/*!40000 ALTER TABLE `guia_requerimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `guia_requerimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jaba`
--

DROP TABLE IF EXISTS `jaba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jaba` (
  `Id_jaba` varchar(20) NOT NULL,
  `Densidad` float DEFAULT NULL,
  `Cantidad` int DEFAULT NULL,
  `Id_galpon` varchar(20) DEFAULT NULL,
  `Id_producto` int DEFAULT NULL,
  PRIMARY KEY (`Id_jaba`),
  KEY `Id_galpon` (`Id_galpon`),
  KEY `Id_producto` (`Id_producto`),
  CONSTRAINT `jaba_ibfk_1` FOREIGN KEY (`Id_galpon`) REFERENCES `galpon` (`Id_galpon`),
  CONSTRAINT `jaba_ibfk_2` FOREIGN KEY (`Id_producto`) REFERENCES `producto` (`Id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jaba`
--

LOCK TABLES `jaba` WRITE;
/*!40000 ALTER TABLE `jaba` DISABLE KEYS */;
/*!40000 ALTER TABLE `jaba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nombre`
--

DROP TABLE IF EXISTS `nombre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nombre` (
  `Id_nombre` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  `Apellido_Paterno` varchar(100) DEFAULT NULL,
  `Apellido_Materno` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id_nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nombre`
--

LOCK TABLES `nombre` WRITE;
/*!40000 ALTER TABLE `nombre` DISABLE KEYS */;
INSERT INTO `nombre` VALUES (11,'Genaro','Huamani','Chuquimamani');
/*!40000 ALTER TABLE `nombre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_compra_cabecera`
--

DROP TABLE IF EXISTS `orden_compra_cabecera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_compra_cabecera` (
  `Id_orden_compra` varchar(20) NOT NULL,
  `Asignado_minimo` int DEFAULT NULL,
  `Asignado_maximo` int DEFAULT NULL,
  `Precio_maximo` float DEFAULT NULL,
  `Precio_minimo` float DEFAULT NULL,
  `Punto_llegada` varchar(100) DEFAULT NULL,
  `Fecha_emision` date DEFAULT NULL,
  `Importe_total` float DEFAULT NULL,
  `Total_igv` float DEFAULT NULL,
  `Monto_letras` varchar(200) DEFAULT NULL,
  `Total_cargos` float DEFAULT NULL,
  `Total_dects_global` float DEFAULT NULL,
  `Punto_partida` varchar(100) DEFAULT NULL,
  `Subtotal` float DEFAULT NULL,
  `Com_nombre` int DEFAULT NULL,
  `Area_compra` varchar(100) DEFAULT NULL,
  `Tipo_pago` varchar(50) DEFAULT NULL,
  `Via_pago` varchar(50) DEFAULT NULL,
  `Clase_documento` varchar(50) DEFAULT NULL,
  `Centro_entrega` varchar(100) DEFAULT NULL,
  `Cancelado` tinyint(1) DEFAULT NULL,
  `RUC` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_orden_compra`),
  KEY `RUC` (`RUC`),
  KEY `Com_nombre` (`Com_nombre`),
  CONSTRAINT `orden_compra_cabecera_ibfk_1` FOREIGN KEY (`RUC`) REFERENCES `empresa` (`RUC`),
  CONSTRAINT `orden_compra_cabecera_ibfk_2` FOREIGN KEY (`Com_nombre`) REFERENCES `empleado` (`Id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_compra_cabecera`
--

LOCK TABLES `orden_compra_cabecera` WRITE;
/*!40000 ALTER TABLE `orden_compra_cabecera` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden_compra_cabecera` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_aud_ins_orden_compra` AFTER INSERT ON `orden_compra_cabecera` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Usuario, Accion, Mensaje)
    VALUES (USER(), 'INSERT_TRIGGER', CONCAT('Trigger: insert cabecera ', NEW.Id_orden_compra));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_after_insert_orden_compra_cabecera` AFTER INSERT ON `orden_compra_cabecera` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Id_orden_compra, Accion, Fecha)
    VALUES (NEW.Id_orden_compra, 'INSERT_CABECERA', NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_aud_upd_orden_compra` AFTER UPDATE ON `orden_compra_cabecera` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Usuario, Accion, Mensaje)
    VALUES (USER(), 'UPDATE_TRIGGER', CONCAT('Trigger: update cabecera ', NEW.Id_orden_compra));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_after_update_orden_compra_cabecera` AFTER UPDATE ON `orden_compra_cabecera` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Id_orden_compra, Accion, Fecha)
    VALUES (NEW.Id_orden_compra, 'UPDATE_CABECERA', NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_before_delete_orden_compra_cabecera` BEFORE DELETE ON `orden_compra_cabecera` FOR EACH ROW BEGIN
    IF (SELECT COUNT(*) FROM orden_compra_detalle WHERE Id_orden_compra = OLD.Id_orden_compra) > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'NO SE PUEDE ELIMINAR: LA ORDEN DE COMPRA TIENE DETALLES ASOCIADOS';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_aud_del_orden_compra` AFTER DELETE ON `orden_compra_cabecera` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Usuario, Accion, Mensaje)
    VALUES (USER(), 'DELETE_TRIGGER', CONCAT('Trigger: delete cabecera ', OLD.Id_orden_compra));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_after_delete_orden_compra_cabecera` AFTER DELETE ON `orden_compra_cabecera` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Id_orden_compra, Accion, Fecha)
    VALUES (OLD.Id_orden_compra, 'DELETE_CABECERA', NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `orden_compra_detalle`
--

DROP TABLE IF EXISTS `orden_compra_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_compra_detalle` (
  `Id_detalle` varchar(20) NOT NULL,
  `Unidad_solicitada` varchar(50) NOT NULL,
  `Unidad_entrega` int NOT NULL,
  `Valor_unitario` float NOT NULL,
  `Importe` float NOT NULL,
  `Id_producto` int NOT NULL,
  `Id_orden_compra` varchar(20) NOT NULL,
  PRIMARY KEY (`Id_detalle`),
  KEY `fk_det_prod` (`Id_producto`),
  KEY `fk_det_orden` (`Id_orden_compra`),
  CONSTRAINT `fk_det_orden` FOREIGN KEY (`Id_orden_compra`) REFERENCES `orden_compra_cabecera` (`Id_orden_compra`),
  CONSTRAINT `fk_det_prod` FOREIGN KEY (`Id_producto`) REFERENCES `producto` (`Id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_compra_detalle`
--

LOCK TABLES `orden_compra_detalle` WRITE;
/*!40000 ALTER TABLE `orden_compra_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden_compra_detalle` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_aud_ins_orden_detalle` AFTER INSERT ON `orden_compra_detalle` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Usuario, Accion, Mensaje)
    VALUES (USER(), 'INSERT_TRIGGER_DET', CONCAT('Trigger: insert detalle ', NEW.Id_detalle, ' orden ', NEW.Id_orden_compra));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_after_insert_orden_compra_detalle` AFTER INSERT ON `orden_compra_detalle` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Id_orden_compra, Accion, Fecha)
    VALUES (NEW.Id_orden_compra, CONCAT('INSERT_DETALLE ', NEW.Id_detalle), NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_aud_upd_orden_detalle` AFTER UPDATE ON `orden_compra_detalle` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Usuario, Accion, Mensaje)
    VALUES (USER(), 'UPDATE_TRIGGER_DET', CONCAT('Trigger: update detalle ', NEW.Id_detalle));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_after_update_orden_compra_detalle` AFTER UPDATE ON `orden_compra_detalle` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Id_orden_compra, Accion, Fecha)
    VALUES (NEW.Id_orden_compra, CONCAT('UPDATE_DETALLE ', NEW.Id_detalle), NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_aud_del_orden_detalle` AFTER DELETE ON `orden_compra_detalle` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Usuario, Accion, Mensaje)
    VALUES (USER(), 'DELETE_TRIGGER_DET', CONCAT('Trigger: delete detalle ', OLD.Id_detalle));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_after_delete_orden_compra_detalle` AFTER DELETE ON `orden_compra_detalle` FOR EACH ROW BEGIN
    INSERT INTO auditoria_orden_compra(Id_orden_compra, Accion, Fecha)
    VALUES (OLD.Id_orden_compra, CONCAT('DELETE_DETALLE ', OLD.Id_detalle), NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `orden_recepcion`
--

DROP TABLE IF EXISTS `orden_recepcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_recepcion` (
  `Codigo_recepcion` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(200) DEFAULT NULL,
  `Lote` varchar(50) DEFAULT NULL,
  `Tipo` varchar(50) DEFAULT NULL,
  `Cantidad` int DEFAULT NULL,
  `Hora` time DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Almacen` varchar(100) DEFAULT NULL,
  `Peso_total` float DEFAULT NULL,
  `Observaciones` text,
  `Emitido_por` int DEFAULT NULL,
  `Entregado_por` int DEFAULT NULL,
  `Id_ticket` int DEFAULT NULL,
  `Placa_vehiculo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Codigo_recepcion`),
  KEY `Emitido_por` (`Emitido_por`),
  KEY `Entregado_por` (`Entregado_por`),
  KEY `Placa_vehiculo` (`Placa_vehiculo`),
  KEY `orden_recepcion_ibfk_3` (`Id_ticket`),
  CONSTRAINT `orden_recepcion_ibfk_1` FOREIGN KEY (`Emitido_por`) REFERENCES `empleado` (`Id_empleado`),
  CONSTRAINT `orden_recepcion_ibfk_2` FOREIGN KEY (`Entregado_por`) REFERENCES `empleado` (`Id_empleado`),
  CONSTRAINT `orden_recepcion_ibfk_3` FOREIGN KEY (`Id_ticket`) REFERENCES `ticket_pesado` (`Id_ticket`) ON DELETE CASCADE,
  CONSTRAINT `orden_recepcion_ibfk_4` FOREIGN KEY (`Placa_vehiculo`) REFERENCES `vehiculo` (`Placa`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_recepcion`
--

LOCK TABLES `orden_recepcion` WRITE;
/*!40000 ALTER TABLE `orden_recepcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden_recepcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plantel`
--

DROP TABLE IF EXISTS `plantel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plantel` (
  `Id_plantel` varchar(20) NOT NULL,
  `Nombre_plantel` varchar(100) DEFAULT NULL,
  `Responsable` int DEFAULT NULL,
  `Id_direccion` int DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_plantel`),
  KEY `Responsable` (`Responsable`),
  KEY `Id_direccion` (`Id_direccion`),
  CONSTRAINT `plantel_ibfk_1` FOREIGN KEY (`Responsable`) REFERENCES `nombre` (`Id_nombre`),
  CONSTRAINT `plantel_ibfk_2` FOREIGN KEY (`Id_direccion`) REFERENCES `direccion` (`Id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plantel`
--

LOCK TABLES `plantel` WRITE;
/*!40000 ALTER TABLE `plantel` DISABLE KEYS */;
/*!40000 ALTER TABLE `plantel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `Id_producto` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(150) DEFAULT NULL,
  `Unidad` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `RUC` varchar(20) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Estado` tinyint(1) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Id_direccion` int DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`RUC`),
  KEY `Id_direccion` (`Id_direccion`),
  CONSTRAINT `proveedor_ibfk_1` FOREIGN KEY (`Id_direccion`) REFERENCES `direccion` (`Id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_auditoria_proveedor` AFTER INSERT ON `proveedor` FOR EACH ROW BEGIN
    INSERT INTO Auditoria_Proveedor (accion, usuario, descripcion)
    VALUES ('INSERT', USER(), CONCAT('Nuevo proveedor: ', NEW.Nombre));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_auditoria_proveedor_insert` AFTER INSERT ON `proveedor` FOR EACH ROW BEGIN
    INSERT INTO Auditoria_Proveedor (accion, usuario, descripcion)
    VALUES ('INSERT', USER(), CONCAT('Se agregó proveedor: ', NEW.Nombre, ' (RUC: ', NEW.RUC, ')'));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_auditoria_proveedor_update` AFTER UPDATE ON `proveedor` FOR EACH ROW BEGIN
    INSERT INTO Auditoria_Proveedor (accion, usuario, descripcion)
    VALUES ('UPDATE', USER(), CONCAT('Se modificó proveedor: ', NEW.Nombre, ' (RUC: ', NEW.RUC, ')'));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_auditoria_proveedor_delete` AFTER DELETE ON `proveedor` FOR EACH ROW BEGIN
    INSERT INTO Auditoria_Proveedor (accion, usuario, descripcion)
    VALUES ('DELETE', USER(), CONCAT('Se eliminó proveedor: ', OLD.Nombre, ' (RUC: ', OLD.RUC, ')'));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `reporte_compra`
--

DROP TABLE IF EXISTS `reporte_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reporte_compra` (
  `Id_reporte` int NOT NULL AUTO_INCREMENT,
  `Precio_total` float DEFAULT NULL,
  `Fecha_venta` date DEFAULT NULL,
  `Total_jabas` int DEFAULT NULL,
  `RUC` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_reporte`),
  KEY `RUC` (`RUC`),
  CONSTRAINT `reporte_compra_ibfk_1` FOREIGN KEY (`RUC`) REFERENCES `empresa` (`RUC`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporte_compra`
--

LOCK TABLES `reporte_compra` WRITE;
/*!40000 ALTER TABLE `reporte_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `reporte_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_pesado`
--
ALTER TABLE orden_recepcion DROP FOREIGN KEY orden_recepcion_ibfk_3;

DROP TABLE IF EXISTS `ticket_pesado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_pesado` (
  `Id_ticket` int NOT NULL AUTO_INCREMENT,
  `Fecha_salida` date DEFAULT NULL,
  `Fecha_ingreso` date DEFAULT NULL,
  `Monto_total` float DEFAULT NULL,
  `Peso_promedio` float DEFAULT NULL,
  `Genero_pollo` varchar(50) DEFAULT NULL,
  `Cantidad_pollo` int DEFAULT NULL,
  `Mortalidad` int DEFAULT NULL,
  `Destino` varchar(100) DEFAULT NULL,
  `Merma` float DEFAULT NULL,
  `Placa_vehiculo` varchar(20) DEFAULT NULL,
  `Id_conductor` varchar(20) DEFAULT NULL,
  `Id_plantel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_ticket`),
  KEY `Placa_vehiculo` (`Placa_vehiculo`),
  KEY `Id_conductor` (`Id_conductor`),
  KEY `Id_plantel` (`Id_plantel`),
  CONSTRAINT `ticket_pesado_ibfk_1` FOREIGN KEY (`Placa_vehiculo`) REFERENCES `vehiculo` (`Placa`),
  CONSTRAINT `ticket_pesado_ibfk_2` FOREIGN KEY (`Id_conductor`) REFERENCES `conductor` (`Nro_Licencia`),
  CONSTRAINT `ticket_pesado_ibfk_3` FOREIGN KEY (`Id_plantel`) REFERENCES `plantel` (`Id_plantel`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_pesado`
--

LOCK TABLES `ticket_pesado` WRITE;
/*!40000 ALTER TABLE `ticket_pesado` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket_pesado` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_aud_ticket_insert` AFTER INSERT ON `ticket_pesado` FOR EACH ROW BEGIN
    INSERT INTO Auditoria_TicketPesado(
        Id_ticket, Accion, Usuario, Datos_despues
    ) VALUES (
        NEW.Id_ticket,
        'INSERT',
        USER(),
        CONCAT(
            'Fecha_salida=', NEW.Fecha_salida,
            ', Fecha_ingreso=', NEW.Fecha_ingreso,
            ', Monto_total=', NEW.Monto_total,
            ', Peso_promedio=', NEW.Peso_promedio,
            ', Genero_pollo=', NEW.Genero_pollo,
            ', Cantidad_pollo=', NEW.Cantidad_pollo,
            ', Mortalidad=', NEW.Mortalidad,
            ', Destino=', NEW.Destino,
            ', Merma=', NEW.Merma,
            ', Placa_vehiculo=', NEW.Placa_vehiculo,
            ', Id_conductor=', NEW.Id_conductor,
            ', Id_plantel=', NEW.Id_plantel
        )
    );
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_aud_ticket_update` AFTER UPDATE ON `ticket_pesado` FOR EACH ROW BEGIN
    INSERT INTO Auditoria_TicketPesado(
        Id_ticket, Accion, Usuario, Datos_antes, Datos_despues
    ) VALUES (
        NEW.Id_ticket,
        'UPDATE',
        USER(),
        CONCAT(
            'Fecha_salida=', OLD.Fecha_salida,
            ', Fecha_ingreso=', OLD.Fecha_ingreso,
            ', Monto_total=', OLD.Monto_total,
            ', Peso_promedio=', OLD.Peso_promedio,
            ', Genero_pollo=', OLD.Genero_pollo,
            ', Cantidad_pollo=', OLD.Cantidad_pollo,
            ', Mortalidad=', OLD.Mortalidad,
            ', Destino=', OLD.Destino,
            ', Merma=', OLD.Merma,
            ', Placa_vehiculo=', OLD.Placa_vehiculo,
            ', Id_conductor=', OLD.Id_conductor,
            ', Id_plantel=', OLD.Id_plantel
        ),
        CONCAT(
            'Fecha_salida=', NEW.Fecha_salida,
            ', Fecha_ingreso=', NEW.Fecha_ingreso,
            ', Monto_total=', NEW.Monto_total,
            ', Peso_promedio=', NEW.Peso_promedio,
            ', Genero_pollo=', NEW.Genero_pollo,
            ', Cantidad_pollo=', NEW.Cantidad_pollo,
            ', Mortalidad=', NEW.Mortalidad,
            ', Destino=', NEW.Destino,
            ', Merma=', NEW.Merma,
            ', Placa_vehiculo=', NEW.Placa_vehiculo,
            ', Id_conductor=', NEW.Id_conductor,
            ', Id_plantel=', NEW.Id_plantel
        )
    );
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_aud_ticket_delete` AFTER DELETE ON `ticket_pesado` FOR EACH ROW BEGIN
    INSERT INTO Auditoria_TicketPesado(
        Id_ticket, Accion, Usuario, Datos_antes
    ) VALUES (
        OLD.Id_ticket,
        'DELETE',
        USER(),
        CONCAT(
            'Fecha_salida=', OLD.Fecha_salida,
            ', Fecha_ingreso=', OLD.Fecha_ingreso,
            ', Monto_total=', OLD.Monto_total,
            ', Peso_promedio=', OLD.Peso_promedio,
            ', Genero_pollo=', OLD.Genero_pollo,
            ', Cantidad_pollo=', OLD.Cantidad_pollo,
            ', Mortalidad=', OLD.Mortalidad,
            ', Destino=', OLD.Destino,
            ', Merma=', OLD.Merma,
            ', Placa_vehiculo=', OLD.Placa_vehiculo,
            ', Id_conductor=', OLD.Id_conductor,
            ', Id_plantel=', OLD.Id_plantel
        )
    );
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `Placa` varchar(20) NOT NULL,
  `Color` varchar(50) DEFAULT NULL,
  `Tipo` varchar(50) DEFAULT NULL,
  `Modelo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Placa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_productos_proveedor`
--

DROP TABLE IF EXISTS `vw_productos_proveedor`;
/*!50001 DROP VIEW IF EXISTS `vw_productos_proveedor`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_productos_proveedor` AS SELECT 
 1 AS `Id`,
 1 AS `Id_producto`,
 1 AS `Descripcion`,
 1 AS `Unidad`,
 1 AS `RUC_proveedor`,
 1 AS `Precio_base`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'mamajulita'
--

--
-- Dumping routines for database 'mamajulita'
--
/*!50003 DROP FUNCTION IF EXISTS `fn_conductor_existe` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_conductor_existe`(p_id_conductor VARCHAR(20)) RETURNS tinyint(1)
    DETERMINISTIC
BEGIN
    DECLARE v_count INT;
    SELECT COUNT(*) INTO v_count FROM conductor WHERE Id_conductor = p_id_conductor;
    RETURN v_count > 0;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizar_cotizacion_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_cotizacion_proveedor`(
    IN p_Id_cotizacion INT,
    IN p_RUC VARCHAR(20),
    IN p_Genero VARCHAR(50),
    IN p_Cantidad_pollos INT,
    IN p_Asignado_minimo INT,
    IN p_Asignado_maximo INT,
    IN p_Precio_maximo FLOAT,
    IN p_Precio_minimo FLOAT
)
BEGIN
    UPDATE cotizacion_proveedor
    SET RUC = p_RUC,
        Genero = p_Genero,
        Cantidad_pollos = p_Cantidad_pollos,
        Asignado_minimo = p_Asignado_minimo,
        Asignado_maximo = p_Asignado_maximo,
        Precio_maximo = p_Precio_maximo,
        Precio_minimo = p_Precio_minimo
    WHERE Id_cotizacion = p_Id_cotizacion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizar_guia_requerimientos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_guia_requerimientos`(
    IN p_Id_guia INT,
    IN p_Fecha_entrega DATE,
    IN p_Hora_entrega TIME,
    IN p_Id_conductor VARCHAR(20),
    IN p_Id_plantel VARCHAR(20),
    IN p_Id_direccion INT,
    IN p_Telefono VARCHAR(20)
)
BEGIN
    UPDATE guia_requerimientos
    SET Fecha_entrega = p_Fecha_entrega,
        Hora_entrega = p_Hora_entrega,
        Id_conductor = p_Id_conductor,
        Id_plantel = p_Id_plantel,
        Id_direccion = p_Id_direccion,
        Telefono = p_Telefono
    WHERE Id_guia = p_Id_guia;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizar_orden_compra_cabecera` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_orden_compra_cabecera`(
    IN p_Id_orden_compra    VARCHAR(20),
    IN p_Asignado_minimo    INT,
    IN p_Asignado_maximo    INT,
    IN p_Precio_maximo      FLOAT,
    IN p_Precio_minimo      FLOAT,
    IN p_Punto_llegada      VARCHAR(100),
    IN p_Fecha_emision      DATE,
    IN p_Importe_total      FLOAT,
    IN p_Total_igv          FLOAT,
    IN p_Monto_letras       VARCHAR(200),
    IN p_Total_cargos       FLOAT,
    IN p_Total_dects_global FLOAT,
    IN p_Punto_partida      VARCHAR(100),
    IN p_Subtotal           FLOAT,
    IN p_Com_nombre         INT,
    IN p_Area_compra        VARCHAR(100),
    IN p_Tipo_pago          VARCHAR(50),
    IN p_Via_pago           VARCHAR(50),
    IN p_Clase_documento    VARCHAR(50),
    IN p_Centro_entrega     VARCHAR(100),
    IN p_Cancelado          TINYINT,
    IN p_RUC                VARCHAR(20)
)
BEGIN
    UPDATE orden_compra_cabecera
    SET
        Asignado_minimo     = p_Asignado_minimo,
        Asignado_maximo     = p_Asignado_maximo,
        Precio_maximo       = p_Precio_maximo,
        Precio_minimo       = p_Precio_minimo,
        Punto_llegada       = p_Punto_llegada,
        Fecha_emision       = p_Fecha_emision,
        Importe_total       = p_Importe_total,
        Total_igv           = p_Total_igv,
        Monto_letras        = p_Monto_letras,
        Total_cargos        = p_Total_cargos,
        Total_dects_global  = p_Total_dects_global,
        Punto_partida       = p_Punto_partida,
        Subtotal            = p_Subtotal,
        Com_nombre          = p_Com_nombre,
        Area_compra         = p_Area_compra,
        Tipo_pago           = p_Tipo_pago,
        Via_pago            = p_Via_pago,
        Clase_documento     = p_Clase_documento,
        Centro_entrega      = p_Centro_entrega,
        Cancelado           = p_Cancelado,
        RUC                 = p_RUC
    WHERE Id_orden_compra = p_Id_orden_compra;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizar_orden_compra_detalle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_orden_compra_detalle`(
    IN p_Id_detalle        VARCHAR(20),
    IN p_Unidad_solicitada VARCHAR(50),
    IN p_Unidad_entrega    INT,
    IN p_Valor_unitario    FLOAT,
    IN p_Importe           FLOAT,
    IN p_Id_producto       INT,
    IN p_Id_orden_compra   VARCHAR(20)
)
BEGIN
    UPDATE orden_compra_detalle
    SET
        Unidad_solicitada = p_Unidad_solicitada,
        Unidad_entrega    = p_Unidad_entrega,
        Valor_unitario    = p_Valor_unitario,
        Importe           = p_Importe,
        Id_producto       = p_Id_producto,
        Id_orden_compra   = p_Id_orden_compra
    WHERE Id_detalle = p_Id_detalle;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizar_orden_recepcion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_orden_recepcion`(
    IN p_Codigo_recepcion INT,
    IN p_Descripcion VARCHAR(200),
    IN p_Lote VARCHAR(50),
    IN p_Tipo VARCHAR(50),
    IN p_Cantidad INT,
    IN p_Hora TIME,
    IN p_Fecha DATE,
    IN p_Almacen VARCHAR(100),
    IN p_Peso_total FLOAT,
    IN p_Observaciones TEXT,
    IN p_Emitido_por INT,
    IN p_Entregado_por INT,
    IN p_Id_ticket INT,
    IN p_Placa_vehiculo VARCHAR(20),
    IN p_Usuario VARCHAR(100)
)
BEGIN
    DECLARE v_antes TEXT;

    SELECT CONCAT(
        'Descripcion=', IFNULL(Descripcion,''), ', Lote=', IFNULL(Lote,''), ', Tipo=', IFNULL(Tipo,''), 
        ', Cantidad=', IFNULL(CAST(Cantidad AS CHAR),''), ', Hora=', IFNULL(CAST(Hora AS CHAR),''), ', Fecha=', IFNULL(CAST(Fecha AS CHAR),''), 
        ', Almacen=', IFNULL(Almacen,''), ', Peso_total=', IFNULL(CAST(Peso_total AS CHAR),''), ', Observaciones=', IFNULL(Observaciones,''), 
        ', Emitido_por=', IFNULL(CAST(Emitido_por AS CHAR),''), ', Entregado_por=', IFNULL(CAST(Entregado_por AS CHAR),''), 
        ', Id_ticket=', IFNULL(CAST(Id_ticket AS CHAR),''), ', Placa_vehiculo=', IFNULL(Placa_vehiculo,'')
    ) INTO v_antes
    FROM orden_recepcion
    WHERE Codigo_recepcion = p_Codigo_recepcion
    LIMIT 1;

    UPDATE orden_recepcion
    SET
        Descripcion = p_Descripcion,
        Lote = p_Lote,
        Tipo = p_Tipo,
        Cantidad = p_Cantidad,
        Hora = p_Hora,
        Fecha = p_Fecha,
        Almacen = p_Almacen,
        Peso_total = p_Peso_total,
        Observaciones = p_Observaciones,
        Emitido_por = p_Emitido_por,
        Entregado_por = p_Entregado_por,
        Id_ticket = p_Id_ticket,
        Placa_vehiculo = p_Placa_vehiculo
    WHERE Codigo_recepcion = p_Codigo_recepcion;

    INSERT INTO Auditoria_OrdenRecepcion(
        Codigo_recepcion, Accion, Usuario, Datos_antes, Datos_despues
    ) VALUES (
        p_Codigo_recepcion,
        'UPDATE',
        p_Usuario,
        v_antes,
        CONCAT(
            'Descripcion=', IFNULL(p_Descripcion,''), ', Lote=', IFNULL(p_Lote,''), ', Tipo=', IFNULL(p_Tipo,''), 
            ', Cantidad=', IFNULL(CAST(p_Cantidad AS CHAR),''), ', Hora=', IFNULL(CAST(p_Hora AS CHAR),''), ', Fecha=', IFNULL(CAST(p_Fecha AS CHAR),''), 
            ', Almacen=', IFNULL(p_Almacen,''), ', Peso_total=', IFNULL(CAST(p_Peso_total AS CHAR),''), ', Observaciones=', IFNULL(p_Observaciones,''), 
            ', Emitido_por=', IFNULL(CAST(p_Emitido_por AS CHAR),''), ', Entregado_por=', IFNULL(CAST(p_Entregado_por AS CHAR),''), 
            ', Id_ticket=', IFNULL(CAST(p_Id_ticket AS CHAR),''), ', Placa_vehiculo=', IFNULL(p_Placa_vehiculo,'')
        )
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizar_producto_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_producto_proveedor`(
    IN p_id_detalle INT,
    IN p_cantidad INT,
    IN p_precio_base FLOAT,
    IN p_usuario VARCHAR(100)
)
BEGIN
    DECLARE v_exists INT;
    DECLARE v_antes TEXT;

    SELECT COUNT(*) INTO v_exists FROM detalle_proveedor_producto WHERE Id = p_id_detalle;
    IF v_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Detalle no existe';
    END IF;

    IF p_cantidad IS NOT NULL AND p_cantidad < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cantidad inv�lida';
    END IF;

    IF p_precio_base IS NOT NULL AND p_precio_base < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Precio base inv�lido';
    END IF;

    SELECT CONCAT('RUC=', RUC_proveedor, ', Id_producto=', Id_producto, ', Cantidad=', IFNULL(CAST(Cantidad AS CHAR),''), ', Precio_base=', IFNULL(CAST(Precio_base AS CHAR),'')) INTO v_antes
    FROM detalle_proveedor_producto WHERE Id = p_id_detalle LIMIT 1;

    UPDATE detalle_proveedor_producto
    SET Cantidad = p_cantidad, Precio_base = p_precio_base
    WHERE Id = p_id_detalle;

    INSERT INTO Auditoria_DetalleProveedorProducto (Id_detalle, Accion, Usuario, Datos_antes, Datos_despues)
    VALUES (p_id_detalle, 'UPDATE', p_usuario, v_antes,
            CONCAT('Cantidad=', IFNULL(CAST(p_cantidad AS CHAR),''), ', Precio_base=', IFNULL(CAST(p_precio_base AS CHAR),'')));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizar_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_proveedor`(
    IN p_ruc VARCHAR(20),
    IN p_nombre VARCHAR(100),
    IN p_estado VARCHAR(10),
    IN p_email VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_calle VARCHAR(100),
    IN p_numero VARCHAR(20),
    IN p_ciudad VARCHAR(100)
)
BEGIN
    DECLARE v_id_direccion INT;

    -- Obtener la dirección actual asociada del proveedor
    SELECT Id_direccion INTO v_id_direccion
    FROM Proveedor
    WHERE RUC = p_ruc;

    -- Actualizar tabla Direccion
    UPDATE Direccion
    SET Calle = p_calle,
        Numero = p_numero,
        Ciudad = p_ciudad
    WHERE Id_direccion = v_id_direccion;

    -- Actualizar tabla Proveedor
    UPDATE Proveedor
    SET Nombre = p_nombre,
        Estado = (p_estado = '1'),  -- convierte "1" => true
        Email = p_email,
        Telefono = p_telefono
    WHERE RUC = p_ruc;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizar_ticket_pesado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_ticket_pesado`(
    IN p_Id_ticket INT,
    IN p_Fecha_salida DATE,
    IN p_Fecha_ingreso DATE,
    IN p_Monto_total FLOAT,
    IN p_Peso_promedio FLOAT,
    IN p_Genero_pollo VARCHAR(50),
    IN p_Cantidad_pollo INT,
    IN p_Mortalidad INT,
    IN p_Destino VARCHAR(100),
    IN p_Merma FLOAT,
    IN p_Placa_vehiculo VARCHAR(20),
    IN p_Id_conductor VARCHAR(20),
    IN p_Id_plantel VARCHAR(20),
    IN p_Usuario VARCHAR(50)
)
BEGIN
    DECLARE v_antes TEXT;
    SELECT CONCAT(
        'Fecha_salida=', Fecha_salida, ', Fecha_ingreso=', Fecha_ingreso,
        ', Monto_total=', Monto_total, ', Peso_promedio=', Peso_promedio,
        ', Genero_pollo=', Genero_pollo, ', Cantidad_pollo=', Cantidad_pollo,
        ', Mortalidad=', Mortalidad, ', Destino=', Destino, ', Merma=', Merma,
        ', Placa_vehiculo=', Placa_vehiculo, ', Id_conductor=', Id_conductor,
        ', Id_plantel=', Id_plantel
    ) INTO v_antes
    FROM Ticket_Pesado
    WHERE Id_ticket = p_Id_ticket;

    UPDATE Ticket_Pesado
    SET Fecha_salida = p_Fecha_salida,
        Fecha_ingreso = p_Fecha_ingreso,
        Monto_total = p_Monto_total,
        Peso_promedio = p_Peso_promedio,
        Genero_pollo = p_Genero_pollo,
        Cantidad_pollo = p_Cantidad_pollo,
        Mortalidad = p_Mortalidad,
        Destino = p_Destino,
        Merma = p_Merma,
        Placa_vehiculo = p_Placa_vehiculo,
        Id_conductor = p_Id_conductor,
        Id_plantel = p_Id_plantel
    WHERE Id_ticket = p_Id_ticket;

    INSERT INTO Auditoria_TicketPesado(
        Id_ticket, Accion, Usuario, Datos_antes, Datos_despues
    ) VALUES (
        p_Id_ticket, 'UPDATE', p_Usuario, v_antes,
        CONCAT(
            'Fecha_salida=', p_Fecha_salida, ', Fecha_ingreso=', p_Fecha_ingreso,
            ', Monto_total=', p_Monto_total, ', Peso_promedio=', p_Peso_promedio,
            ', Genero_pollo=', p_Genero_pollo, ', Cantidad_pollo=', p_Cantidad_pollo,
            ', Mortalidad=', p_Mortalidad, ', Destino=', p_Destino, ', Merma=', p_Merma,
            ', Placa_vehiculo=', p_Placa_vehiculo, ', Id_conductor=', p_Id_conductor,
            ', Id_plantel=', p_Id_plantel
        )
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscar_cotizaciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_cotizaciones`(
    IN p_buscar VARCHAR(200),
    IN p_producto VARCHAR(100),
    IN p_ruc VARCHAR(20),
    IN p_activa TINYINT
)
BEGIN
    SELECT
        Id_cotizacion, RUC, Producto, Cantidad_pollos, Asignado_minimo, Asignado_maximo,
        Precio_minimo, Precio_maximo, Precio_base, Fecha_emision, Activa, Observaciones, Created_by, Created_at
    FROM cotizacion_proveedor
    WHERE
        (p_buscar IS NULL OR p_buscar = '' OR
            Id_cotizacion LIKE CONCAT('%', p_buscar, '%') OR
            RUC LIKE CONCAT('%', p_buscar, '%') OR
            Producto LIKE CONCAT('%', p_buscar, '%'))
    AND (p_producto IS NULL OR p_producto = '' OR Producto = p_producto)
    AND (p_ruc IS NULL OR p_ruc = '' OR RUC = p_ruc)
    AND (p_activa IS NULL OR p_activa NOT IN (0,1) OR Activa = p_activa)
    ORDER BY Fecha_emision DESC, Id_cotizacion DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscar_cotizacion_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_cotizacion_proveedor`(IN p_Busqueda VARCHAR(50))
BEGIN
    SELECT * FROM cotizacion_proveedor
    WHERE RUC LIKE CONCAT('%', p_Busqueda, '%')
       OR Genero LIKE CONCAT('%', p_Busqueda, '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscar_detalle_proveedor_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_detalle_proveedor_producto`(IN p_buscar VARCHAR(200))
BEGIN
    SELECT d.Id, d.Id_orden_compra, d.Id_producto, p.Descripcion AS Producto_descripcion, p.Unidad,
           d.RUC_proveedor, prov.Nombre AS Nombre_proveedor, d.Cantidad, d.Precio_base
    FROM detalle_proveedor_producto d
    LEFT JOIN producto p ON p.Id_producto = d.Id_producto
    LEFT JOIN proveedor prov ON prov.RUC = d.RUC_proveedor
    WHERE p.Descripcion LIKE CONCAT('%', p_buscar, '%')
       OR prov.Nombre LIKE CONCAT('%', p_buscar, '%')
       OR d.RUC_proveedor LIKE CONCAT('%', p_buscar, '%')
       OR CAST(d.Id AS CHAR) LIKE CONCAT('%', p_buscar, '%')
       OR CAST(d.Id_producto AS CHAR) LIKE CONCAT('%', p_buscar, '%')
    ORDER BY d.Id DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscar_orden_compra_cabecera` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_orden_compra_cabecera`(IN p_filtro VARCHAR(50))
BEGIN
    SELECT * FROM orden_compra_cabecera
    WHERE Id_orden_compra LIKE CONCAT('%', p_filtro, '%')
       OR RUC LIKE CONCAT('%', p_filtro, '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscar_orden_compra_detalle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_orden_compra_detalle`(IN p_filtro VARCHAR(50))
BEGIN
    SELECT * FROM orden_compra_detalle
    WHERE Id_detalle LIKE CONCAT('%', p_filtro, '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscar_orden_recepcion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_orden_recepcion`(IN p_buscar VARCHAR(200))
BEGIN
    SELECT
        Codigo_recepcion,
        Descripcion,
        Lote,
        Tipo,
        Cantidad,
        Hora,
        Fecha,
        Almacen,
        Peso_total,
        Observaciones,
        Emitido_por,
        Entregado_por,
        Id_ticket,
        Placa_vehiculo
    FROM orden_recepcion
    WHERE
        p_buscar IS NULL OR p_buscar = ''
        OR CAST(Codigo_recepcion AS CHAR) LIKE CONCAT('%', p_buscar, '%')
        OR Descripcion LIKE CONCAT('%', p_buscar, '%')
        OR Lote LIKE CONCAT('%', p_buscar, '%')
        OR Tipo LIKE CONCAT('%', p_buscar, '%')
        OR CAST(Cantidad AS CHAR) LIKE CONCAT('%', p_buscar, '%')
        OR Almacen LIKE CONCAT('%', p_buscar, '%')
        OR Observaciones LIKE CONCAT('%', p_buscar, '%')
        OR Placa_vehiculo LIKE CONCAT('%', p_buscar, '%')
    ORDER BY Codigo_recepcion DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_eliminar_cotizacion_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_cotizacion_proveedor`(IN p_Id_cotizacion INT)
BEGIN
    DELETE FROM cotizacion_proveedor WHERE Id_cotizacion = p_Id_cotizacion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_eliminar_guia_requerimientos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_guia_requerimientos`(
    IN p_Id_guia INT
)
BEGIN
    DELETE FROM guia_requerimientos
    WHERE Id_guia = p_Id_guia;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_eliminar_orden_compra_cabecera` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_orden_compra_cabecera`(IN p_Id_orden_compra VARCHAR(20))
BEGIN
    DELETE FROM orden_compra_cabecera
    WHERE Id_orden_compra = p_Id_orden_compra;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_eliminar_orden_compra_detalle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_orden_compra_detalle`(IN p_Id_detalle VARCHAR(20))
BEGIN
    DELETE FROM orden_compra_detalle
    WHERE Id_detalle = p_Id_detalle;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_eliminar_orden_recepcion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_orden_recepcion`(
    IN p_Codigo_recepcion INT,
    IN p_Usuario VARCHAR(100)
)
BEGIN
    DECLARE v_antes TEXT;

    SELECT CONCAT(
        'Descripcion=', IFNULL(Descripcion,''), ', Lote=', IFNULL(Lote,''), ', Tipo=', IFNULL(Tipo,''), 
        ', Cantidad=', IFNULL(CAST(Cantidad AS CHAR),''), ', Hora=', IFNULL(CAST(Hora AS CHAR),''), ', Fecha=', IFNULL(CAST(Fecha AS CHAR),''), 
        ', Almacen=', IFNULL(Almacen,''), ', Peso_total=', IFNULL(CAST(Peso_total AS CHAR),''), ', Observaciones=', IFNULL(Observaciones,''), 
        ', Emitido_por=', IFNULL(CAST(Emitido_por AS CHAR),''), ', Entregado_por=', IFNULL(CAST(Entregado_por AS CHAR),''), 
        ', Id_ticket=', IFNULL(CAST(Id_ticket AS CHAR),''), ', Placa_vehiculo=', IFNULL(Placa_vehiculo,'')
    ) INTO v_antes
    FROM orden_recepcion
    WHERE Codigo_recepcion = p_Codigo_recepcion
    LIMIT 1;

    DELETE FROM orden_recepcion WHERE Codigo_recepcion = p_Codigo_recepcion;

    INSERT INTO Auditoria_OrdenRecepcion(
        Codigo_recepcion, Accion, Usuario, Datos_antes
    ) VALUES (
        p_Codigo_recepcion,
        'DELETE',
        p_Usuario,
        v_antes
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_eliminar_producto_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_producto_proveedor`(
    IN p_id_detalle INT,
    IN p_usuario VARCHAR(100)
)
BEGIN
    DECLARE v_exists INT;
    DECLARE v_antes TEXT;

    SELECT COUNT(*) INTO v_exists FROM detalle_proveedor_producto WHERE Id = p_id_detalle;
    IF v_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Detalle no existe';
    END IF;

    SELECT CONCAT('RUC=', RUC_proveedor, ', Id_producto=', Id_producto, ', Cantidad=', IFNULL(CAST(Cantidad AS CHAR),''), ', Precio_base=', IFNULL(CAST(Precio_base AS CHAR),'')) INTO v_antes
    FROM detalle_proveedor_producto WHERE Id = p_id_detalle LIMIT 1;

    DELETE FROM detalle_proveedor_producto WHERE Id = p_id_detalle;

    INSERT INTO Auditoria_DetalleProveedorProducto (Id_detalle, Accion, Usuario, Datos_antes)
    VALUES (p_id_detalle, 'DELETE', p_usuario, v_antes);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_eliminar_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_proveedor`(
    IN p_RUC VARCHAR(15)
)
BEGIN
    DELETE FROM Proveedor WHERE RUC = p_RUC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_eliminar_ticket_pesado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_ticket_pesado`(
    IN p_Id_ticket INT,
    IN p_Usuario VARCHAR(50)
)
BEGIN
    DECLARE v_antes TEXT;
    SELECT CONCAT(
        'Fecha_salida=', Fecha_salida, ', Fecha_ingreso=', Fecha_ingreso,
        ', Monto_total=', Monto_total, ', Peso_promedio=', Peso_promedio,
        ', Genero_pollo=', Genero_pollo, ', Cantidad_pollo=', Cantidad_pollo,
        ', Mortalidad=', Mortalidad, ', Destino=', Destino, ', Merma=', Merma,
        ', Placa_vehiculo=', Placa_vehiculo, ', Id_conductor=', Id_conductor,
        ', Id_plantel=', Id_plantel
    ) INTO v_antes
    FROM Ticket_Pesado
    WHERE Id_ticket = p_Id_ticket;

    -- Nota: si hay FK en otras tablas, este DELETE puede fallar. 
    -- Para evitar error, debes eliminar primero dependencias o usar ON DELETE CASCADE
    DELETE FROM Ticket_Pesado WHERE Id_ticket = p_Id_ticket;

    INSERT INTO Auditoria_TicketPesado(
        Id_ticket, Accion, Usuario, Datos_antes
    ) VALUES (
        p_Id_ticket, 'DELETE', p_Usuario, v_antes
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_historial_cotizaciones_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_historial_cotizaciones_proveedor`(
    IN p_RUC VARCHAR(20),
    IN p_Producto VARCHAR(100)
)
BEGIN
    SELECT * FROM cotizacion_proveedor
    WHERE (p_RUC IS NULL OR p_RUC = '' OR RUC = p_RUC)
      AND (p_Producto IS NULL OR p_Producto = '' OR Producto = p_Producto)
    ORDER BY Fecha_emision DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertar_cotizacion_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_cotizacion_proveedor`(
    IN p_RUC VARCHAR(20),
    IN p_Genero VARCHAR(50),
    IN p_Cantidad_pollos INT,
    IN p_Asignado_minimo INT,
    IN p_Asignado_maximo INT,
    IN p_Precio_maximo FLOAT,
    IN p_Precio_minimo FLOAT
)
BEGIN
    INSERT INTO cotizacion_proveedor
    (RUC, Genero, Cantidad_pollos, Asignado_minimo, Asignado_maximo, Precio_maximo, Precio_minimo)
    VALUES
    (p_RUC, p_Genero, p_Cantidad_pollos, p_Asignado_minimo, p_Asignado_maximo, p_Precio_maximo, p_Precio_minimo);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertar_guia_requerimientos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_guia_requerimientos`(
    IN p_Fecha_entrega DATE,
    IN p_Hora_entrega TIME,
    IN p_Id_conductor VARCHAR(20),
    IN p_Id_plantel VARCHAR(20),
    IN p_Id_direccion INT,
    IN p_Telefono VARCHAR(20)
)
BEGIN
    INSERT INTO guia_requerimientos(
        Fecha_entrega, Hora_entrega, Id_conductor, Id_plantel, Id_direccion, Telefono
    ) VALUES (
        p_Fecha_entrega, p_Hora_entrega, p_Id_conductor, p_Id_plantel, p_Id_direccion, p_Telefono
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertar_orden_compra_cabecera` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_orden_compra_cabecera`(
    IN p_Id_orden_compra    VARCHAR(20),
    IN p_Asignado_minimo    INT,
    IN p_Asignado_maximo    INT,
    IN p_Precio_maximo      FLOAT,
    IN p_Precio_minimo      FLOAT,
    IN p_Punto_llegada      VARCHAR(100),
    IN p_Fecha_emision      DATE,
    IN p_Importe_total      FLOAT,
    IN p_Total_igv          FLOAT,
    IN p_Monto_letras       VARCHAR(200),
    IN p_Total_cargos       FLOAT,
    IN p_Total_dects_global FLOAT,
    IN p_Punto_partida      VARCHAR(100),
    IN p_Subtotal           FLOAT,
    IN p_Com_nombre         INT,
    IN p_Area_compra        VARCHAR(100),
    IN p_Tipo_pago          VARCHAR(50),
    IN p_Via_pago           VARCHAR(50),
    IN p_Clase_documento    VARCHAR(50),
    IN p_Centro_entrega     VARCHAR(100),
    IN p_Cancelado          TINYINT,
    IN p_RUC                VARCHAR(20)
)
BEGIN
    INSERT INTO orden_compra_cabecera(
        Id_orden_compra,
        Asignado_minimo,
        Asignado_maximo,
        Precio_maximo,
        Precio_minimo,
        Punto_llegada,
        Fecha_emision,
        Importe_total,
        Total_igv,
        Monto_letras,
        Total_cargos,
        Total_dects_global,
        Punto_partida,
        Subtotal,
        Com_nombre,
        Area_compra,
        Tipo_pago,
        Via_pago,
        Clase_documento,
        Centro_entrega,
        Cancelado,
        RUC
    ) VALUES (
        p_Id_orden_compra,
        p_Asignado_minimo,
        p_Asignado_maximo,
        p_Precio_maximo,
        p_Precio_minimo,
        p_Punto_llegada,
        p_Fecha_emision,
        p_Importe_total,
        p_Total_igv,
        p_Monto_letras,
        p_Total_cargos,
        p_Total_dects_global,
        p_Punto_partida,
        p_Subtotal,
        p_Com_nombre,
        p_Area_compra,
        p_Tipo_pago,
        p_Via_pago,
        p_Clase_documento,
        p_Centro_entrega,
        p_Cancelado,
        p_RUC
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertar_orden_compra_detalle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_orden_compra_detalle`(
    IN p_Id_detalle        VARCHAR(20),
    IN p_Unidad_solicitada VARCHAR(50),
    IN p_Unidad_entrega    INT,
    IN p_Valor_unitario    FLOAT,
    IN p_Importe           FLOAT,
    IN p_Id_producto       INT,
    IN p_Id_orden_compra   VARCHAR(20)
)
BEGIN
    INSERT INTO orden_compra_detalle(
        Id_detalle,
        Unidad_solicitada,
        Unidad_entrega,
        Valor_unitario,
        Importe,
        Id_producto,
        Id_orden_compra
    ) VALUES (
        p_Id_detalle,
        p_Unidad_solicitada,
        p_Unidad_entrega,
        p_Valor_unitario,
        p_Importe,
        p_Id_producto,
        p_Id_orden_compra
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertar_orden_recepcion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_orden_recepcion`(
    IN p_Descripcion VARCHAR(200),
    IN p_Lote VARCHAR(50),
    IN p_Tipo VARCHAR(50),
    IN p_Cantidad INT,
    IN p_Hora TIME,
    IN p_Fecha DATE,
    IN p_Almacen VARCHAR(100),
    IN p_Peso_total FLOAT,
    IN p_Observaciones TEXT,
    IN p_Emitido_por INT,
    IN p_Entregado_por INT,
    IN p_Id_ticket INT,
    IN p_Placa_vehiculo VARCHAR(20),
    IN p_Usuario VARCHAR(100)
)
BEGIN
    INSERT INTO orden_recepcion (
        Descripcion, Lote, Tipo, Cantidad, Hora, Fecha,
        Almacen, Peso_total, Observaciones, Emitido_por,
        Entregado_por, Id_ticket, Placa_vehiculo
    ) VALUES (
        p_Descripcion, p_Lote, p_Tipo, p_Cantidad, p_Hora, p_Fecha,
        p_Almacen, p_Peso_total, p_Observaciones, p_Emitido_por,
        p_Entregado_por, p_Id_ticket, p_Placa_vehiculo
    );

    INSERT INTO Auditoria_OrdenRecepcion(
        Codigo_recepcion, Accion, Usuario, Datos_despues
    ) VALUES (
        LAST_INSERT_ID(),
        'INSERT',
        p_Usuario,
        CONCAT(
            'Descripcion=', IFNULL(p_Descripcion,''), ', Lote=', IFNULL(p_Lote,''), ', Tipo=', IFNULL(p_Tipo,''), 
            ', Cantidad=', IFNULL(CAST(p_Cantidad AS CHAR),''), ', Hora=', IFNULL(CAST(p_Hora AS CHAR),''), ', Fecha=', IFNULL(CAST(p_Fecha AS CHAR),''), 
            ', Almacen=', IFNULL(p_Almacen,''), ', Peso_total=', IFNULL(CAST(p_Peso_total AS CHAR),''), ', Observaciones=', IFNULL(p_Observaciones,''), 
            ', Emitido_por=', IFNULL(CAST(p_Emitido_por AS CHAR),''), ', Entregado_por=', IFNULL(CAST(p_Entregado_por AS CHAR),''), 
            ', Id_ticket=', IFNULL(CAST(p_Id_ticket AS CHAR),''), ', Placa_vehiculo=', IFNULL(p_Placa_vehiculo,'')
        )
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertar_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_proveedor`(
    IN p_ruc VARCHAR(20),
    IN p_nombre VARCHAR(100),
    IN p_estado VARCHAR(10),
    IN p_email VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_calle VARCHAR(100),
    IN p_numero VARCHAR(20),
    IN p_ciudad VARCHAR(100)
)
BEGIN
    DECLARE v_id_direccion INT;

    -- Insertar dirección
    INSERT INTO Direccion (Calle, Numero, Ciudad)
    VALUES (p_calle, p_numero, p_ciudad);

    SET v_id_direccion = LAST_INSERT_ID();

    -- Insertar proveedor
    INSERT INTO Proveedor (RUC, Nombre, Estado, Email, Telefono, Id_direccion)
    VALUES (
        p_ruc,
        p_nombre,
        (p_estado = '1'),  -- Convierte '1' a TRUE, '0' a FALSE
        p_email,
        p_telefono,
        v_id_direccion
    );

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertar_ticket_pesado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_ticket_pesado`(
    IN p_Fecha_salida DATE,
    IN p_Fecha_ingreso DATE,
    IN p_Monto_total FLOAT,
    IN p_Peso_promedio FLOAT,
    IN p_Genero_pollo VARCHAR(50),
    IN p_Cantidad_pollo INT,
    IN p_Mortalidad INT,
    IN p_Destino VARCHAR(100),
    IN p_Merma FLOAT,
    IN p_Placa_vehiculo VARCHAR(20),
    IN p_Id_conductor VARCHAR(20),
    IN p_Id_plantel VARCHAR(20),
    IN p_Usuario VARCHAR(50)
)
BEGIN
    INSERT INTO Ticket_Pesado(
        Fecha_salida, Fecha_ingreso, Monto_total, Peso_promedio, Genero_pollo,
        Cantidad_pollo, Mortalidad, Destino, Merma, Placa_vehiculo, Id_conductor, Id_plantel
    ) VALUES (
        p_Fecha_salida, p_Fecha_ingreso, p_Monto_total, p_Peso_promedio, p_Genero_pollo,
        p_Cantidad_pollo, p_Mortalidad, p_Destino, p_Merma, p_Placa_vehiculo, p_Id_conductor, p_Id_plantel
    );

    INSERT INTO Auditoria_TicketPesado(
        Id_ticket, Accion, Usuario, Datos_despues
    ) VALUES (
        LAST_INSERT_ID(), 'INSERT', p_Usuario,
        CONCAT(
            'Fecha_salida=', p_Fecha_salida, ', Fecha_ingreso=', p_Fecha_ingreso,
            ', Monto_total=', p_Monto_total, ', Peso_promedio=', p_Peso_promedio,
            ', Genero_pollo=', p_Genero_pollo, ', Cantidad_pollo=', p_Cantidad_pollo,
            ', Mortalidad=', p_Mortalidad, ', Destino=', p_Destino, ', Merma=', p_Merma,
            ', Placa_vehiculo=', p_Placa_vehiculo, ', Id_conductor=', p_Id_conductor,
            ', Id_plantel=', p_Id_plantel
        )
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_cotizacion_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_cotizacion_proveedor`()
BEGIN
    SELECT * FROM cotizacion_proveedor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_detalle_por_orden` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_detalle_por_orden`(IN p_Id_orden_compra VARCHAR(20))
BEGIN
    SELECT * FROM orden_compra_detalle WHERE Id_orden_compra = p_Id_orden_compra;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_detalle_proveedor_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_detalle_proveedor_producto`()
BEGIN
    SELECT d.Id, d.Id_orden_compra, d.Id_producto, p.Descripcion AS Producto_descripcion, p.Unidad,
           d.RUC_proveedor, prov.Nombre AS Nombre_proveedor, d.Cantidad, d.Precio_base
    FROM detalle_proveedor_producto d
    LEFT JOIN producto p ON p.Id_producto = d.Id_producto
    LEFT JOIN proveedor prov ON prov.RUC = d.RUC_proveedor
    ORDER BY d.Id DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_guia_requerimientos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_guia_requerimientos`()
BEGIN
    SELECT * FROM guia_requerimientos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_orden_compra_cabecera` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_orden_compra_cabecera`()
BEGIN
    SELECT * FROM orden_compra_cabecera;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_orden_compra_detalle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_orden_compra_detalle`()
BEGIN
    SELECT * FROM orden_compra_detalle;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_orden_recepcion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_orden_recepcion`()
BEGIN
    SELECT
        Codigo_recepcion,
        Descripcion,
        Lote,
        Tipo,
        Cantidad,
        Hora,
        Fecha,
        Almacen,
        Peso_total,
        Observaciones,
        Emitido_por,
        Entregado_por,
        Id_ticket,
        Placa_vehiculo
    FROM orden_recepcion
    ORDER BY Codigo_recepcion DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_proveedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_proveedores`()
BEGIN
    SELECT 
        p.RUC,
        p.Nombre,
        p.Estado,
        p.Email,
        p.Telefono,
        d.Calle,
        d.Numero,
        d.Ciudad
    FROM Proveedor p
    INNER JOIN Direccion d ON p.Id_direccion = d.Id_direccion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_tickets_pesado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_tickets_pesado`(
    IN p_buscar VARCHAR(100)
)
BEGIN
    SELECT 
        tp.id_ticket,
        tp.ruc,
        tp.destino,
        tp.placa,
        tp.conductor,
        tp.fecha_registro,
        tp.peso_bruto,
        tp.peso_tara,
        tp.peso_neto,
        tp.observacion
    FROM ticket_pesado tp
    WHERE 
        p_buscar IS NULL 
        OR p_buscar = ''
        OR tp.id_ticket LIKE CONCAT('%', p_buscar, '%')
        OR tp.ruc LIKE CONCAT('%', p_buscar, '%')
        OR tp.destino LIKE CONCAT('%', p_buscar, '%')
        OR tp.placa LIKE CONCAT('%', p_buscar, '%')
        OR tp.conductor LIKE CONCAT('%', p_buscar, '%')
        OR tp.fecha_registro LIKE CONCAT('%', p_buscar, '%')
        OR tp.observacion LIKE CONCAT('%', p_buscar, '%')
    ORDER BY tp.id_ticket DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_listar_ticket_pesado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_ticket_pesado`()
BEGIN
    SELECT * FROM Ticket_Pesado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_marcar_cotizacion_activa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_marcar_cotizacion_activa`(IN p_Id_cotizacion INT)
BEGIN
    UPDATE cotizacion_proveedor SET Activa = FALSE;
    UPDATE cotizacion_proveedor SET Activa = TRUE WHERE Id_cotizacion = p_Id_cotizacion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_obtener_cotizacion_activa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtener_cotizacion_activa`()
BEGIN
    SELECT * FROM cotizacion_proveedor WHERE Activa = TRUE LIMIT 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_orden_compra_cabecera_buscar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_orden_compra_cabecera_buscar`(
    IN p_id VARCHAR(20)
)
BEGIN
    SELECT *
    FROM orden_compra_cabecera
    WHERE Id_orden_compra = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_orden_compra_cabecera_insertar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_orden_compra_cabecera_insertar`(
    IN p_id_orden_compra VARCHAR(20),
    IN p_asignado_minimo INT,
    IN p_asignado_maximo INT,
    IN p_precio_maximo FLOAT,
    IN p_precio_minimo FLOAT,
    IN p_punto_llegada VARCHAR(100),
    IN p_fecha_emision DATE,
    IN p_importe_total FLOAT,
    IN p_total_igv FLOAT,
    IN p_monto_letras VARCHAR(200),
    IN p_total_cargos FLOAT,
    IN p_total_dects_global FLOAT,
    IN p_punto_partida VARCHAR(100),
    IN p_subtotal FLOAT,
    IN p_com_nombre INT,
    IN p_area_compra VARCHAR(100),
    IN p_tipo_pago VARCHAR(50),
    IN p_via_pago VARCHAR(50),
    IN p_clase_documento VARCHAR(50),
    IN p_centro_entrega VARCHAR(100),
    IN p_cancelado TINYINT(1),
    IN p_ruc VARCHAR(20)
)
BEGIN
    INSERT INTO orden_compra_cabecera (
        Id_orden_compra, Asignado_minimo, Asignado_maximo,
        Precio_maximo, Precio_minimo, Punto_llegada,
        Fecha_emision, Importe_total, Total_igv,
        Monto_letras, Total_cargos, Total_dects_global,
        Punto_partida, Subtotal, Com_nombre,
        Area_compra, Tipo_pago, Via_pago,
        Clase_documento, Centro_entrega, Cancelado, RUC
    )
    VALUES (
        p_id_orden_compra, p_asignado_minimo, p_asignado_maximo,
        p_precio_maximo, p_precio_minimo, p_punto_llegada,
        p_fecha_emision, p_importe_total, p_total_igv,
        p_monto_letras, p_total_cargos, p_total_dects_global,
        p_punto_partida, p_subtotal, p_com_nombre,
        p_area_compra, p_tipo_pago, p_via_pago,
        p_clase_documento, p_centro_entrega, p_cancelado, p_ruc
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_orden_compra_cabecera_listar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_orden_compra_cabecera_listar`()
BEGIN
    SELECT *
    FROM orden_compra_cabecera;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_orden_compra_detalle_insertar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_orden_compra_detalle_insertar`(
    IN p_id_detalle VARCHAR(20),
    IN p_unidad_solicitada VARCHAR(50),
    IN p_unidad_entrega INT,
    IN p_valor_unitario FLOAT,
    IN p_importe FLOAT,
    IN p_id_producto INT,
    IN p_id_orden_compra VARCHAR(20)
)
BEGIN
    INSERT INTO orden_compra_detalle (
        Id_detalle, Unidad_solicitada, Unidad_entrega,
        Valor_unitario, Importe, Id_producto, Id_orden_compra
    )
    VALUES (
        p_id_detalle, p_unidad_solicitada, p_unidad_entrega,
        p_valor_unitario, p_importe, p_id_producto, p_id_orden_compra
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_orden_compra_detalle_listar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_orden_compra_detalle_listar`(
    IN p_id_orden_compra VARCHAR(20)
)
BEGIN
    SELECT *
    FROM orden_compra_detalle
    WHERE Id_orden_compra = p_id_orden_compra;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registrar_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_producto`(
    IN p_descripcion VARCHAR(150),
    IN p_unidad VARCHAR(5)
)
BEGIN
    INSERT INTO producto (Descripcion, Unidad)
    VALUES (p_descripcion, p_unidad);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registrar_producto_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_producto_proveedor`(
    IN p_ruc VARCHAR(20),
    IN p_id_producto INT,
    IN p_cantidad INT,
    IN p_precio_base FLOAT,
    IN p_usuario VARCHAR(100)
)
BEGIN
    
    IF NOT EXISTS(SELECT 1 FROM proveedor WHERE RUC = p_ruc) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Proveedor no existe';
    END IF;

    
    IF NOT EXISTS(SELECT 1 FROM producto WHERE Id_producto = p_id_producto) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Producto no existe';
    END IF;

    
    IF p_cantidad IS NOT NULL AND p_cantidad < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cantidad inv�lida';
    END IF;

    
    IF p_precio_base IS NOT NULL AND p_precio_base < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Precio base inv�lido';
    END IF;

    
    IF EXISTS(SELECT 1 FROM detalle_proveedor_producto WHERE RUC_proveedor = p_ruc AND Id_producto = p_id_producto) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El producto ya est� registrado para este proveedor';
    END IF;

    INSERT INTO detalle_proveedor_producto (Id_producto, RUC_proveedor, Cantidad, Precio_base)
    VALUES (p_id_producto, p_ruc, p_cantidad, p_precio_base);

    INSERT INTO Auditoria_DetalleProveedorProducto (Id_detalle, Accion, Usuario, Datos_despues)
    VALUES (LAST_INSERT_ID(), 'INSERT', p_usuario,
            CONCAT('RUC=', p_ruc, ', Id_producto=', p_id_producto, ', Cantidad=', IFNULL(CAST(p_cantidad AS CHAR),''), ', Precio_base=', IFNULL(CAST(p_precio_base AS CHAR),'')));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `vw_productos_proveedor`
--

/*!50001 DROP VIEW IF EXISTS `vw_productos_proveedor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_productos_proveedor` AS select `d`.`Id` AS `Id`,`p`.`Id_producto` AS `Id_producto`,`p`.`Descripcion` AS `Descripcion`,`p`.`Unidad` AS `Unidad`,`d`.`RUC_proveedor` AS `RUC_proveedor`,`d`.`Precio_base` AS `Precio_base` from (`detalle_proveedor_producto` `d` join `producto` `p` on((`p`.`Id_producto` = `d`.`Id_producto`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-21 12:46:50






DROP TABLE IF EXISTS `ticket_pesado`;
CREATE TABLE `ticket_pesado` (
  `Id_ticket` int NOT NULL AUTO_INCREMENT,
  `Fecha_salida` date DEFAULT NULL,
  `Fecha_ingreso` date DEFAULT NULL,
  `Monto_total` float DEFAULT NULL,
  `Peso_promedio` float DEFAULT NULL,
  `Genero_pollo` varchar(50) DEFAULT NULL,
  `Cantidad_pollo` int DEFAULT NULL,
  `Mortalidad` int DEFAULT NULL,
  `Destino` varchar(100) DEFAULT NULL,
  `Merma` float DEFAULT NULL,
  `Placa_vehiculo` varchar(20) DEFAULT NULL,
  `Id_conductor` varchar(20) DEFAULT NULL,
  `Id_plantel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_ticket`),
  KEY `Placa_vehiculo` (`Placa_vehiculo`),
  KEY `Id_conductor` (`Id_conductor`),
  KEY `Id_plantel` (`Id_plantel`),
  CONSTRAINT `ticket_pesado_ibfk_1` FOREIGN KEY (`Placa_vehiculo`) REFERENCES `vehiculo` (`Placa`),
  CONSTRAINT `ticket_pesado_ibfk_2` FOREIGN KEY (`Id_conductor`) REFERENCES `conductor` (`Nro_Licencia`),
  CONSTRAINT `ticket_pesado_ibfk_3` FOREIGN KEY (`Id_plantel`) REFERENCES `plantel` (`Id_plantel`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--


INSERT INTO `nombre` (Id_nombre, Nombre, Apellido_Paterno, Apellido_Materno) VALUES
(12,'Alonso','Gonzalez','Perez'),
(13,'Renata','Lopez','Martinez'),
(14,'Mateo','Ramirez','Torres'),
(15,'Isabella','Sanchez','Diaz'),
(16,'Sebastian','Vargas','Rojas'),
(17,'Antonella','Morales','Castillo'),
(18,'Bruno','Fernandez','Gil'),
(19,'Luciana','Herrera','Mendoza'),
(20,'Gael','Cruz','Suarez'),
(21,'Adriana','Flores','Ortega'),
(22,'Thiago','Reyes','Alvarez'),
(23,'Camila','Campos','Navarro'),
(24,'Iker','Dominguez','Rios'),
(25,'Rafael','Paredes','Salazar'),
(26,'Zoe','Cabrera','Fuentes'),
(27,'Emilio','Gutierrez','Vega'),
(29,'Joaquin','Quispe','Huaman'),
(30,'Danna','Tapia','Loayza');

-- Insertar 30 registros adicionales
INSERT INTO `nombre` (Nombre, Apellido_Paterno, Apellido_Materno) VALUES
('Joaquin','Yato','Marroquin'),
('Sofia','Mendoza','Lara'),
('Diego','Cordero','Vega'),
('Valeria','Pinto','Salas'),
('Luis','Campos','Ramos'),
('Andrea','Torres','Gonzales'),
('Miguel','Vega','Paredes'),
('Natalia','Huaman','Quispe'),
('Daniel','Cruz','Alvarado'),
('Paola','Rojas','Diaz'),
('Victor','Navarro','Sanchez'),
('Carla','Morales','Huerta'),
('Javier','Reyes','Lopez'),
('Gabriela','Vargas','Soto'),
('Esteban','Ramirez','Marin'),
('Camilo','Fernandez','Cruz'),
('Mariana','Flores','Valdez'),
('Adan','Ortega','Gil'),
('Valentina','Salazar','Quispe'),
('Fernando','Cabrera','Loayza'),
('Elena','Castillo','Vargas'),
('Ricardo','Alvarez','Rios'),
('Monica','Diaz','Torres'),
('Alex','Paredes','Rojas'),
('Paula','Suarez','Navarro'),
('Santiago','Gil','Cruz'),
('Isabel','Huerta','Morales'),
('Andres','Marin','Salas'),
('Claudia','Vega','Ramirez');


INSERT INTO Direccion (Calle, Numero, Ciudad) VALUES
('Av. Los Héroes','1201','Lima'),
('Calle Los Olivos','118','Callao'),
('Jr. Bolognesi','945','Lima'),
('Av. Industrial','380','Callao'),
('Calle Las Gardenias','72','Lima'),
('Av. Separadora','1420','Lima'),
('Jr. Callao','255','Callao'),
('Av. La Marina','5120','Lima'),
('Calle Las Violetas','63','Callao'),
('Av. Angamos','2301','Lima'),
('Calle Los Nogales','41','Callao'),
('Av. San Borja Norte','701','Lima'),
('Av. República de Panamá','3570','Lima'),
('Calle Los Cedros','88','Callao'),
('Av. Javier Prado','5601','Lima'),
('Calle Los Laureles','134','Callao'),
('Av. Arequipa','4890','Lima'),
('Calle Unión','27','Callao'),
('Av. Canadá','2105','Lima'),
('Calle Central','19','Callao'),
 ('Jr. Tacna','666','Callao'),
('Calle Libertad','777','Lima'),
('Av. La Paz','888','Lima'),
('Jr. Amazonas','101','Lima'),
('Av. Brasil','202','Callao'),
('Calle San Martín','303','Lima'),
('Jr. Puno','404','Callao'),
('Av. Grau','505','Lima'),
('Calle Bolívar','606','Callao'),
('Av. Tacna','707','Lima'),
('Calle Junín','808','Callao'),
('Av. Huánuco','909','Lima'),
('Calle Piura','1010','Callao'),
('Av. Loreto','1111','Lima'),
('Calle Amazonas','1212','Callao'),
('Jr. Lima','1313','Lima'),
('Av. Ayacucho','1414','Callao'),
('Calle Cajamarca','1515','Lima'),
('Av. Huancavelica','1616','Callao'),
('Jr. Cuzco','1717','Lima'),
('Calle Tacna','1818','Callao'),
('Av. Puno','1919','Lima'),
('Calle Iquitos','2020','Callao'),
('Av. Moquegua','2121','Lima'),
('Calle Huaraz','2222','Callao'),
('Jr. Arequipa','2323','Lima'),
('Av. Chiclayo','2424','Callao'),
('Calle Trujillo','2525','Lima'),
('Jr. Cusco','2626','Callao'),
('Av. Pisco','2727','Lima'),
('Calle Sullana','2828','Callao'),
('Jr. Tacna','2929','Lima'),
('Av. Chachapoyas','3030','Callao'),
('Calle Tumbes','3131','Lima'),
('Av. Cajamarca','3232','Callao'),
('Jr. Lima Norte','3333','Lima'),
('Calle Amazonas Sur','3434','Callao'),
('Av. Arequipa Sur','3535','Lima'),
('Calle Loreto','3636','Callao'),
('Jr. Huánuco','3737','Lima'),
('Av. Puno Oeste','3838','Callao'),
('Calle Iquitos Norte','3939','Lima'),
('Jr. Moquegua','4040','Callao');







INSERT INTO Vehiculo (Placa, Color, Tipo, Modelo) VALUES
('CAA-101','Blanco','Camion','Mercedes Benz Atego'),
('CBB-202','Rojo','Camioneta','Toyota Hilux SRV'),
('CCC-303','Gris','Camion','IVECO Daily'),
('CDD-404','Azul','Camioneta','Chevrolet Colorado'),
('CEE-505','Negro','Camion','Hino 500'),
('CFF-606','Verde','Camioneta','Nissan Navara'),
('CGG-707','Plata','Camion','Volvo FL'),
('CHH-808','Blanco','Camioneta','Ford Ranger Limited'),
('CII-909','Amarillo','Camion','Fuso Fighter'),
('CJJ-010','Rojo','Camioneta','Mitsubishi L200 Sportero'),
('CKK-111','Azul','Camion','Scania P310'),
('CLL-222','Negro','Camioneta','VW Amarok V6'),
('CMM-333','Gris','Camion','Isuzu NQR'),
('CNN-444','Blanco','Camioneta','Great Wall Wingle'),
('COO-555','Plata','Camion','Nissan UD Condor'),
('CPP-666','Rojo','Camioneta','JAC T8 Pro'),
('CQQ-777','Verde','Camion','FAW Tiger'),
('CRR-888','Blanco','Camioneta','Maxus T60'),
('CSS-999','Azul','Camion','MAN TGM'),
('CTT-000','Negro','Camioneta','Peugeot Landtrek');
INSERT INTO Conductor (Nro_Licencia, Id_nombre, Estado, Id_direccion, Telefono) VALUES
('L99011',39,'Activo',42,'987220011'),
('L99012',40,'Inactivo',43,'987220012'),
('L99013',41,'Activo',44,'987220013'),
('L99014',42,'Activo',45,'987220014'),
('L99015',43,'Activo',46,'987220015'),
('L99016',44,'Inactivo',47,'987220016'),
('L99017',45,'Activo',48,'987220017'),
('L99018',46,'Activo',49,'987220018'),
('L99019',47,'Activo',50,'987220019'),
('L99020',48,'Activo',51,'987220020');



INSERT INTO Empresa (RUC, Nombre, Razon_Social, Id_direccion, Telefono) VALUES
('20401234561','Avícola Pacífico','Avícola Pacífico SAC',31,'054-210001'),
('20411234562','Granja Santa Ana','Granja Santa Ana SAC',32,'054-210002'),
('20421234563','Pollera Andina','Pollera Andina SAC',33,'054-210003'),
('20431234564','Agro Avícola Sur','Agro Avícola Sur SAC',34,'054-210004'),
('20441234565','Suministros Avícolas','Suministros Avícolas SRL',35,'054-210005'),
('20451234566','Proveedora Lima','Proveedora Lima SAC',36,'054-210006'),
('20461234567','Granjas Huayco','Granjas Huayco SAC',37,'054-210007'),
('20471234568','Distribuciones Avem','Distribuciones Avem SRL',38,'054-210008'),
('20481234569','Avícola El Molino','Avícola El Molino SAC',39,'054-210009'),
('20491234560','Agro NorPerú','Agro NorPerú SAC',40,'054-210010'),
('20501234561','Avícola San José','Avícola San José SAC',41,'054-210011'),
('20511234562','Granjas La Estrella','Granjas La Estrella SAC',42,'054-210012'),
('20521234563','Proveeduría Central','Proveeduría Central SRL',43,'054-210013'),
('20531234564','Avícola Buenavista','Avícola Buenavista SAC',44,'054-210014'),
('20541234565','Mayorista del Sur','Mayorista del Sur SAC',45,'054-210015'),
('20551234566','Granja Los Olivos','Granja Los Olivos SAC',46,'054-210016'),
('20561234567','Avícola Santa Rosa','Avícola Santa Rosa SAC',47,'054-210017'),
('20571234568','Distribuidora Andina','Distribuidora Andina SRL',48,'054-210018'),
('20581234569','Agro Inka','Agro Inka SAC',49,'054-210019'),
('20591234560','Avícola Metropolitana','Avícola Metropolitana SAC',50,'054-210020');
INSERT INTO Proveedor (RUC, Nombre, Estado, Email, Id_direccion, Telefono) VALUES
('11123456781','Avícola San Martín',1,'contacto@sanmartin.com',24,'054-211111'),
('11123456782','Granja El Paraíso',1,'ventas@elparaiso.com',25,'054-211222'),
('11123456783','Avícola Los Andes',1,'info@avicolaandes.com',26,'054-211333'),
('11123456784','Proveedora Avícola Norte',1,'comercial@avicolonorte.com',27,'054-211444'),
('11123456785','Granjas Delicia',1,'contacto@granjasdelicia.com',28,'054-211555'),
('11123456786','Avícola La Molina',1,'ventas@avicolamolina.com',29,'054-211666'),
('11123456787','AgroAvícola Pachacamac',1,'info@agropacha.com',30,'054-211777'),
('11123456788','Distribuciones Gallos',1,'ventas@dgallos.com',31,'054-211888'),
('11123456789','Granja Santa Rosa',1,'contacto@gsantarosa.com',32,'054-211999'),
('11123456780','Avícola Maranga',1,'info@avicolamaranga.com',33,'054-212000'),
('11234567891','Huevos Selectos',1,'ventas@hselectos.com',34,'054-212111'),
('11234567892','Pollos Andinos',1,'contacto@pollosandinos.com',35,'054-212222'),
('11234567893','Proveedora El Prado',1,'info@proveedoraelprado.com',36,'054-212333'),
('11234567894','Agro Avícola Central',1,'ventas@agrocentral.com',37,'054-212444'),
('11234567895','Granjas Valle Verde',1,'contacto@valleverde.com',38,'054-212555'),
('11234567896','Avícola Buen Amanecer',1,'info@bamanecer.com',39,'054-212666'),
('11234567897','Suministros Avícolas Sur',1,'ventas@sumavisur.com',40,'054-212777'),
('11234567898','Distribuidora Pluma',1,'contacto@plumadistrib.com',41,'054-212888'),
('11234567899','Avícola San José',1,'info@avicolasanjose.com',42,'054-212999'),
('11234567890','Granja La Campiña',1,'ventas@lacampigna.com',43,'054-213000');

INSERT INTO empleado (Id_nombre, Cargo, Email, Telefono, Contrasena, NivelAcceso) VALUES
(12,'Jefe de Calidad','alonso@empresa.com','987300012','12345678',2),
(13,'Analista de Compras','renata@empresa.com','987300013','12345678',2),
(14,'Coordinador de Logística','mateo@empresa.com','987300014','12345678',2),
(15,'Asistente Administrativo','isabella@empresa.com','987300015','12345678',2),
(16,'Planificador de Producción','sebastian@empresa.com','987300016','12345678',2),
(17,'Auxiliar de Almacén','antonella@empresa.com','987300017','12345678',2),
(18,'Inspector de Seguridad','bruno@empresa.com','987300018','12345678',2),
(19,'Analista de Datos','luciana@empresa.com','987300019','12345678',2),
(20,'Chofer','gael@empresa.com','987300020','12345678',2),
(21,'Jefe de Almacén','adriana@empresa.com','987300021','12345678',2),
(22,'Técnico de Mantenimiento','thiago@empresa.com','987300022','12345678',2),
(23,'Gestor de Proveedores','camila.campos@empresa.com','987300023','12345678',1),
(24,'Encargado de Expedición','iker@empresa.com','987300024','12345678',2),
(25,'Contador de Costos','rafael@empresa.com','987300025','12345678',1),
(26,'Asistente de RRHH','zoe@empresa.com','987300026','12345678',2),
(27,'Coordinador de Turno','emilio@empresa.com','987300027','12345678',1),
(29,'Operador Logístico','joaquin@empresa.com','987300029','12345678',1),
(30,'Vigilante','danna@empresa.com','987300030','12345678',1);

INSERT INTO Plantel (Id_plantel, Nombre_plantel, Responsable, Id_direccion, Telefono) VALUES
('PL011','Plantel Trujillo',12,24,'054-111011'),
('PL012','Plantel Chiclayo',13,25,'054-121212'),
('PL013','Plantel Ica',14,26,'054-131313'),
('PL014','Plantel Tacna',15,27,'054-141414'),
('PL015','Plantel Chimbote',16,28,'054-151515'),
('PL016','Plantel Puno',17,29,'054-161616'),
('PL017','Plantel Ilo',18,30,'054-171717'),
('PL018','Plantel Puerto Maldonado',19,31,'054-181818'),
('PL019','Plantel Nazca',20,32,'054-191919'),
('PL020','Plantel Huaraz',21,33,'054-202020'),
('PL021','Plantel Juliaca',22,34,'054-212121'),
('PL022','Plantel Sullana',23,35,'054-222222'),
('PL023','Plantel Pucallpa',24,36,'054-232323'),
('PL024','Plantel Moyobamba',25,37,'054-242424'),
('PL025','Plantel Abancay',26,38,'054-252525'),
('PL026','Plantel Ayacucho',27,39,'054-262626'),
('PL027','Plantel Cajamarca',29,40,'054-272727'),
('PL028','Plantel Tarapoto',30,41,'054-282828');



INSERT INTO Galpon (Id_galpon, Nombre, Capacidad, Estado, Id_plantel) VALUES
('G011','Galpon 11',1000,'Activo','PL011'),
('G012','Galpon 12',1200,'Activo','PL012'),
('G013','Galpon 13',900,'Activo','PL013'),
('G014','Galpon 14',1100,'Inactivo','PL014'),
('G015','Galpon 15',950,'Activo','PL015'),
('G016','Galpon 16',1300,'Activo','PL016'),
('G017','Galpon 17',800,'Activo','PL017'),
('G018','Galpon 18',1000,'Inactivo','PL018'),
('G019','Galpon 19',1150,'Activo','PL019'),
('G020','Galpon 20',1050,'Activo','PL020'),
('G021','Galpon 21',980,'Activo','PL021'),
('G022','Galpon 22',1230,'Activo','PL022'),
('G023','Galpon 23',910,'Inactivo','PL023'),
('G024','Galpon 24',1115,'Activo','PL024'),
('G025','Galpon 25',1020,'Activo','PL025'),
('G026','Galpon 26',1275,'Activo','PL026'),
('G027','Galpon 27',860,'Activo','PL027'),
('G028','Galpon 28',990,'Inactivo','PL028');


INSERT INTO Producto (Descripcion, Unidad) VALUES
('Gallina Hembra', 'kg'),
('Gallo', 'kg'),
('Pollito de Gallina','kg'),
('Gallina para Engorde', 'kg'),
('Gallina Vieja', 'kg'),
('Pato Adulto', 'kg'),
('Pato Joven', 'kg'),
('Pavo Adulto', 'kg'),
('Pavo Joven', 'kg'),
('Pavo de Engorde', 'kg');



INSERT INTO Guia_Requerimientos (Fecha_entrega, Id_conductor, Hora_entrega, Id_plantel, Id_direccion, Telefono) VALUES
('2025-10-26','L12345','08:15:00','PL001',11,'987650011'),
('2025-10-26','L67890','09:05:00','PL002',12,'987650012'),
('2025-10-26','L11122','10:20:00','PL003',13,'987650013'),
('2025-10-26','L33344','11:10:00','PL004',14,'987650014'),
('2025-10-26','L55566','12:00:00','PL005',15,'987650015'),
('2025-10-26','L77788','13:05:00','PL006',16,'987650016'),
('2025-10-26','L99900','14:25:00','PL007',17,'987650017'),
('2025-10-26','L11223','15:40:00','PL008',18,'987650018'),
('2025-10-26','L33445','16:30:00','PL009',19,'987650019'),
('2025-10-26','L55667','17:10:00','PL010',20,'987650020'),
('2025-10-27','L12345','08:00:00','PL002',1,'987650021'),
('2025-10-27','L67890','09:10:00','PL004',2,'987650022'),
('2025-10-27','L11122','10:15:00','PL006',3,'987650023'),
('2025-10-27','L33344','11:45:00','PL008',4,'987650024'),
('2025-10-27','L55566','12:40:00','PL010',5,'987650025'),
('2025-10-27','L77788','13:35:00','PL001',6,'987650026'),
('2025-10-27','L99900','14:55:00','PL003',7,'987650027'),
('2025-10-27','L11223','15:50:00','PL005',8,'987650028'),
('2025-10-27','L33445','16:20:00','PL007',9,'987650029'),
('2025-10-27','L55667','17:25:00','PL009',10,'987650030');

INSERT INTO Ticket_Pesado  
(Fecha_salida, Fecha_ingreso, Monto_total, Peso_promedio, Genero_pollo, Cantidad_pollo, Mortalidad, Destino, Merma, Placa_vehiculo, Id_conductor, Id_plantel) 
VALUES
('2025-10-26','2025-10-26',1510,2.6,'Gallina Hembra',520,5,'PL002',2.0,'CAA-101','L99011','PL011'),
('2025-10-26','2025-10-26',1990,3.0,'Gallo',410,1,'PL003',1.1,'CBB-202','L99012','PL012'),
('2025-10-26','2025-10-26',1810,2.7,'Pollito de Gallina',590,3,'PL004',1.4,'CCC-303','L99013','PL013'),
('2025-10-26','2025-10-26',1620,2.5,'Gallina para Engorde',455,4,'PL005',1.2,'CDD-404','L99014','PL014'),
('2025-10-26','2025-10-26',1715,2.8,'Gallina Vieja',310,1,'PL006',1.3,'CEE-505','L99015','PL015'),
('2025-10-26','2025-10-26',1560,2.6,'Pato Adulto',360,2,'PL007',1.0,'CFF-606','L99016','PL016'),
('2025-10-26','2025-10-26',1665,2.9,'Pato Joven',405,1,'PL008',1.2,'CGG-707','L99017','PL017'),
('2025-10-26','2025-10-26',1915,3.2,'Pavo Adulto',255,1,'PL009',1.1,'CHH-808','L99018','PL018'),
('2025-10-26','2025-10-26',1760,2.9,'Pavo Joven',305,2,'PL010',1.4,'CII-909','L99019','PL019'),
('2025-10-26','2025-10-26',1860,3.0,'Pavo de Engorde',330,1,'PL001',1.3,'CJJ-010','L99020','PL020'),
('2025-10-27','2025-10-27',1505,2.5,'Gallina Hembra',510,4,'PL003',1.2,'CKK-111','L99011','PL011'),
('2025-10-27','2025-10-27',1980,3.1,'Gallo',420,1,'PL005',1.0,'CLL-222','L99012','PL012'),
('2025-10-27','2025-10-27',1825,2.8,'Pollito de Gallina',605,2,'PL007',1.4,'CMM-333','L99013','PL013'),
('2025-10-27','2025-10-27',1630,2.6,'Gallina para Engorde',460,3,'PL009',1.2,'CNN-444','L99014','PL014'),
('2025-10-27','2025-10-27',1720,2.7,'Gallina Vieja',320,1,'PL001',1.1,'COO-555','L99015','PL015'),
('2025-10-27','2025-10-27',1575,2.6,'Pato Adulto',365,1,'PL002',1.0,'CPP-666','L99016','PL016'),
('2025-10-27','2025-10-27',1670,2.8,'Pato Joven',410,2,'PL004',1.3,'CQQ-777','L99017','PL017'),
('2025-10-27','2025-10-27',1920,3.1,'Pavo Adulto',260,1,'PL006',1.1,'CRR-888','L99018','PL018'),
('2025-10-27','2025-10-27',1770,3.0,'Pavo Joven',310,1,'PL008',1.2,'CSS-999','L99019','PL019'),
('2025-10-27','2025-10-27',1875,3.2,'Pavo de Engorde',335,1,'PL010',1.3,'CTT-000','L99020','PL020');

INSERT INTO Orden_Recepcion 
(Descripcion, Lote, Tipo, Cantidad, Hora, Fecha, Almacen, Peso_total, Observaciones, Emitido_por, Entregado_por, Id_ticket, Placa_vehiculo) VALUES
('Recepcion de Gallinas Hembra','L011','Ave',520,'08:40:00','2025-10-26','Almacen Central',1260,'Sin observaciones',11,12,11,'CAA-101'),
('Recepcion de Gallos','L012','Ave',410,'09:35:00','2025-10-26','Almacen Sur',1210,'Sin observaciones',12,13,12,'CBB-202'),
('Recepcion de Pollitos','L013','Ave',605,'10:20:00','2025-10-26','Almacen Norte',1695,'Sin observaciones',13,14,13,'CCC-303'),
('Recepcion de Gallinas Engorde','L014','Ave',455,'11:25:00','2025-10-26','Almacen Este',1180,'Sin observaciones',14,15,14,'CDD-404'),
('Recepcion de Gallina Vieja','L015','Ave',310,'12:15:00','2025-10-26','Almacen Oeste',820,'Sin observaciones',15,16,15,'CEE-505'),
('Recepcion de Patos Adultos','L016','Ave',360,'13:20:00','2025-10-26','Almacen Callao',880,'Sin observaciones',16,17,16,'CFF-606'),
('Recepcion de Patos Jovenes','L017','Ave',405,'14:25:00','2025-10-26','Almacen Lima',1135,'Sin observaciones',17,18,17,'CGG-707'),
('Recepcion de Pavos Adultos','L018','Ave',255,'15:30:00','2025-10-26','Almacen Arequipa',780,'Sin observaciones',18,19,18,'CHH-808'),
('Recepcion de Pavos Jovenes','L019','Ave',305,'16:35:00','2025-10-26','Almacen Piura',845,'Sin observaciones',19,20,19,'CII-909'),
('Recepcion de Pavos Engorde','L020','Ave',330,'17:35:00','2025-10-26','Almacen Cusco',900,'Sin observaciones',20,11,20,'CJJ-010'),
('Recepcion de Gallinas Hembra','L021','Ave',510,'08:45:00','2025-10-27','Almacen Central',1255,'Sin observaciones',11,13,21,'CKK-111'),
('Recepcion de Gallos','L022','Ave',420,'09:40:00','2025-10-27','Almacen Sur',1225,'Sin observaciones',12,14,22,'CLL-222'),
('Recepcion de Pollitos','L023','Ave',615,'10:35:00','2025-10-27','Almacen Norte',1710,'Sin observaciones',13,15,23,'CMM-333'),
('Recepcion de Gallinas Engorde','L024','Ave',460,'11:45:00','2025-10-27','Almacen Este',1185,'Sin observaciones',14,16,24,'CNN-444'),
('Recepcion de Gallina Vieja','L025','Ave',320,'12:25:00','2025-10-27','Almacen Oeste',830,'Sin observaciones',15,17,25,'COO-555'),
('Recepcion de Patos Adultos','L026','Ave',365,'13:15:00','2025-10-27','Almacen Callao',885,'Sin observaciones',16,18,26,'CPP-666'),
('Recepcion de Patos Jovenes','L027','Ave',410,'14:10:00','2025-10-27','Almacen Lima',1140,'Sin observaciones',17,19,27,'CQQ-777'),
('Recepcion de Pavos Adultos','L028','Ave',260,'15:20:00','2025-10-27','Almacen Arequipa',785,'Sin observaciones',18,20,28,'CRR-888'),
('Recepcion de Pavos Jovenes','L029','Ave',310,'16:10:00','2025-10-27','Almacen Piura',850,'Sin observaciones',19,11,29,'CSS-999'),
('Recepcion de Pavos Engorde','L030','Ave',335,'17:15:00','2025-10-27','Almacen Cusco',905,'Sin observaciones',20,12,30,'CTT-000');


INSERT INTO Reporte_Compra (Precio_total, Fecha_venta, Total_jabas, RUC) VALUES
(1520.00,'2025-10-26',52,'20401234561'),
(2010.00,'2025-10-26',41,'20411234562'),
(1825.00,'2025-10-26',61,'20421234563'),
(1610.00,'2025-10-26',46,'20431234564'),
(1710.00,'2025-10-26',31,'20441234565'),
(1565.00,'2025-10-26',36,'20451234566'),
(1660.00,'2025-10-26',42,'20461234567'),
(1910.00,'2025-10-26',26,'20471234568'),
(1765.00,'2025-10-26',33,'20481234569'),
(1865.00,'2025-10-26',34,'20491234560'),
(1530.00,'2025-10-27',53,'20501234561'),
(2030.00,'2025-10-27',43,'20511234562'),
(1830.00,'2025-10-27',62,'20521234563'),
(1620.00,'2025-10-27',47,'20531234564'),
(1725.00,'2025-10-27',32,'20541234565'),
(1570.00,'2025-10-27',37,'20551234566'),
(1675.00,'2025-10-27',41,'20561234567'),
(1925.00,'2025-10-27',27,'20571234568'),
(1770.00,'2025-10-27',34,'20581234569'),
(1875.00,'2025-10-27',35,'20591234560');

INSERT INTO Cotizacion_Proveedor (RUC, Genero, Cantidad_pollos, Asignado_minimo, Asignado_maximo, Precio_maximo, Precio_minimo) VALUES
('20401234561','Gallina Hembra',510,400,620,15.2,12.2),
('20411234562','Gallo',420,350,460,16.1,13.1),
('20421234563','Pollito',580,500,700,14.7,12.6),
('20431234564','Gallina Engorde',460,400,520,15.6,13.4),
('20441234565','Gallina Vieja',320,250,360,17.1,14.2),
('20451234566','Pato Adulto',370,300,420,16.6,13.6),
('20461234567','Pato Joven',410,350,470,15.3,12.7),
('20471234568','Pavo Adulto',270,200,310,18.2,15.0),
('20481234569','Pavo Joven',305,250,355,17.6,14.6),
('20491234560','Pavo Engorde',330,280,380,16.4,13.9),
('20501234561','Gallina Hembra',520,420,640,15.4,12.5),
('20511234562','Gallo',430,360,480,16.3,13.2),
('20521234563','Pollito',590,520,720,14.8,12.7),
('20531234564','Gallina Engorde',470,410,530,15.7,13.5),
('20541234565','Gallina Vieja',335,260,370,17.2,14.3),
('20551234566','Pato Adulto',380,320,430,16.7,13.7),
('20561234567','Pato Joven',415,360,475,15.5,12.8),
('20571234568','Pavo Adulto',285,220,315,18.3,15.1),
('20581234569','Pavo Joven',310,260,360,17.7,14.7),
('20591234560','Pavo Engorde',340,290,390,16.5,14.0);


INSERT INTO Jaba (Id_jaba, Densidad, Cantidad, Id_galpon, Id_producto) VALUES
('J011',10.2,52,'G011',11),
('J012',8.1,41,'G012',12),
('J013',12.4,62,'G013',13),
('J014',9.3,46,'G014',14),
('J015',7.6,31,'G015',15),
('J016',8.7,36,'G016',16),
('J017',9.8,42,'G017',17),
('J018',6.4,26,'G018',18),
('J019',7.5,33,'G019',19),
('J020',8.9,34,'G020',20),
('J021',10.1,53,'G011',11),
('J022',8.0,43,'G012',12),
('J023',12.6,63,'G013',13),
('J024',9.1,47,'G014',14),
('J025',7.8,32,'G015',15),
('J026',8.5,37,'G016',16),
('J027',9.6,41,'G017',17),
('J028',6.7,27,'G018',18),
('J029',7.4,34,'G019',19),
('J030',8.8,35,'G020',20);

INSERT INTO Orden_compra_cabecera 
(Id_orden_compra, Asignado_minimo, Asignado_maximo, Precio_maximo, Precio_minimo, Punto_llegada, Fecha_emision, Importe_total, Total_igv, Monto_letras, Total_cargos, Total_dects_global, Punto_partida, Subtotal, Com_nombre, Area_compra, Tipo_pago, Via_pago, Clase_documento, Centro_entrega, Cancelado, RUC) 
VALUES
('OC021',300,480,16.0,13.0,'Planta Central','2025-10-27',1620,270,'Mil Seiscientos Veinte con 00/100',42,12,'Almacen Central',1480,12,'Aves','Contado','Transferencia','Factura','Centro Central',0,'20401234561'),
('OC022',340,520,16.6,13.4,'Planta Sur','2025-10-27',1718,288,'Mil Setecientos Dieciocho con 00/100',44,15,'Almacen Sur',1520,13,'Aves','Crédito','Cheque','Factura','Centro Sur',0,'20411234562'),
('OC023',360,560,17.1,14.1,'Planta Norte','2025-10-27',1839,306,'Mil Ochocientos Treinta y Nueve con 00/100',50,18,'Almacen Norte',1585,14,'Aves','Contado','Transferencia','Factura','Centro Norte',0,'20421234563'),
('OC024',310,500,15.9,12.9,'Planta Este','2025-10-27',1590,270,'Mil Quinientos Noventa con 00/100',36,14,'Almacen Este',1320,15,'Aves','Contado','Efectivo','Factura','Centro Este',0,'20431234564'),
('OC025',420,620,17.6,14.6,'Planta Oeste','2025-10-27',1988,324,'Mil Novecientos Ochenta y Ocho con 00/100',58,15,'Almacen Oeste',1646,16,'Aves','Crédito','Cheque','Factura','Centro Oeste',0,'20441234565'),
('OC026',330,520,16.3,13.3,'Planta Callao','2025-10-27',1672,288,'Mil Seiscientos Setenta y Dos con 00/100',43,11,'Almacen Callao',1441,17,'Aves','Contado','Transferencia','Factura','Centro Callao',0,'20451234566'),
('OC027',350,560,16.9,13.9,'Planta Lima','2025-10-27',1762,297,'Mil Setecientos Sesenta y Dos con 00/100',45,16,'Almacen Lima',1524,18,'Aves','Contado','Efectivo','Factura','Centro Lima',0,'20461234567'),
('OC028',370,600,17.3,14.3,'Planta Arequipa','2025-10-27',1875,315,'Mil Ochocientos Setenta y Cinco con 00/100',53,17,'Almacen Arequipa',1590,19,'Aves','Crédito','Cheque','Factura','Centro Arequipa',0,'20471234568'),
('OC029',390,620,17.9,14.9,'Planta Piura','2025-10-27',1964,333,'Mil Novecientos Sesenta y Cuatro con 00/100',57,16,'Almacen Piura',1631,20,'Aves','Contado','Transferencia','Factura','Centro Piura',0,'20481234569'),
('OC030',410,640,18.2,15.2,'Planta Cusco','2025-10-27',2056,342,'Dos Mil Cincuenta y Seis con 00/100',61,20,'Almacen Cusco',1694,21,'Aves','Contado','Efectivo','Factura','Centro Cusco',0,'20491234560'),
('OC031',300,470,16.1,13.1,'Planta Central','2025-10-28',1610,270,'Mil Seiscientos Diez con 00/100',40,10,'Almacen Central',1470,22,'Aves','Contado','Transferencia','Factura','Centro Central',0,'20501234561'),
('OC032',335,515,16.4,13.4,'Planta Sur','2025-10-28',1702,288,'Mil Setecientos Dos con 00/100',43,12,'Almacen Sur',1479,23,'Aves','Crédito','Cheque','Factura','Centro Sur',0,'20511234562'),
('OC033',355,555,17.0,14.0,'Planta Norte','2025-10-28',1824,306,'Mil Ochocientos Veinticuatro con 00/100',49,14,'Almacen Norte',1569,24,'Aves','Contado','Transferencia','Factura','Centro Norte',0,'20521234563'),
('OC034',315,495,15.8,12.8,'Planta Este','2025-10-28',1582,270,'Mil Quinientos Ochenta y Dos con 00/100',35,13,'Almacen Este',1312,25,'Aves','Contado','Efectivo','Factura','Centro Este',0,'20531234564'),
('OC035',425,605,17.4,14.4,'Planta Oeste','2025-10-28',1970,324,'Mil Novecientos Setenta con 00/100',56,14,'Almacen Oeste',1630,26,'Aves','Crédito','Cheque','Factura','Centro Oeste',0,'20541234565'),
('OC036',345,525,16.5,13.5,'Planta Callao','2025-10-28',1693,288,'Mil Seiscientos Noventa y Tres con 00/100',46,12,'Almacen Callao',1465,27,'Aves','Contado','Transferencia','Factura','Centro Callao',0,'20551234566'),
('OC037',365,565,16.7,13.7,'Planta Lima','2025-10-28',1751,297,'Mil Setecientos Cincuenta y Uno con 00/100',45,15,'Almacen Lima',1511,28,'Aves','Contado','Efectivo','Factura','Centro Lima',0,'20561234567'),
('OC038',385,585,17.1,14.1,'Planta Arequipa','2025-10-28',1868,315,'Mil Ochocientos Sesenta y Ocho con 00/100',52,16,'Almacen Arequipa',1584,29,'Aves','Crédito','Cheque','Factura','Centro Arequipa',0,'20571234568'),
('OC039',405,605,17.5,14.5,'Planta Piura','2025-10-28',1970,320,'Mil Novecientos Setenta con 00/100',55,17,'Almacen Piura',1620,12,'Aves','Contado','Transferencia','Factura','Centro Piura',0,'20581234569'),
('OC040',420,630,18.0,15.0,'Planta Cusco','2025-10-28',2100,350,'Dos Mil Cien con 00/100',60,18,'Almacen Cusco',1680,13,'Aves','Contado','Efectivo','Factura','Centro Cusco',0,'20591234560'),
('OC041',310,500,16.2,13.2,'Planta Central','2025-10-29',1625,272,'Mil Seiscientos Veinticinco con 00/100',41,12,'Almacen Central',1450,14,'Aves','Contado','Transferencia','Factura','Centro Central',0,'20401234561'),
('OC042',335,515,16.7,13.7,'Planta Sur','2025-10-29',1720,288,'Mil Setecientos Veinte con 00/100',44,13,'Almacen Sur',1500,15,'Aves','Crédito','Cheque','Factura','Centro Sur',0,'20411234562'),
('OC043',360,560,17.2,14.2,'Planta Norte','2025-10-29',1850,305,'Mil Ochocientos Cincuenta con 00/100',50,15,'Almacen Norte',1570,16,'Aves','Contado','Transferencia','Factura','Centro Norte',0,'20421234563'),
('OC044',320,500,15.9,12.9,'Planta Este','2025-10-29',1600,270,'Mil Seiscientos con 00/100',36,12,'Almacen Este',1325,17,'Aves','Contado','Efectivo','Factura','Centro Este',0,'20431234564'),
('OC045',430,610,17.6,14.6,'Planta Oeste','2025-10-29',1985,324,'Mil Novecientos Ochenta y Cinco con 00/100',58,15,'Almacen Oeste',1640,18,'Aves','Crédito','Cheque','Factura','Centro Oeste',0,'20441234565'),
('OC046',340,520,16.4,13.4,'Planta Callao','2025-10-29',1680,288,'Mil Seiscientos Ochenta con 00/100',44,12,'Almacen Callao',1455,19,'Aves','Contado','Transferencia','Factura','Centro Callao',0,'20451234566'),
('OC047',355,555,16.9,13.9,'Planta Lima','2025-10-29',1755,297,'Mil Setecientos Cincuenta y Cinco con 00/100',46,14,'Almacen Lima',1525,20,'Aves','Contado','Efectivo','Factura','Centro Lima',0,'20461234567'),
('OC048',375,585,17.3,14.3,'Planta Arequipa','2025-10-29',1880,315,'Mil Ochocientos Ochenta con 00/100',52,16,'Almacen Arequipa',1595,21,'Aves','Crédito','Cheque','Factura','Centro Arequipa',0,'20471234568'),
('OC049',395,615,17.8,14.8,'Planta Piura','2025-10-29',1965,333,'Mil Novecientos Sesenta y Cinco con 00/100',57,16,'Almacen Piura',1635,22,'Aves','Contado','Transferencia','Factura','Centro Piura',0,'20481234569'),
('OC050',410,640,18.2,15.2,'Planta Cusco','2025-10-29',2050,342,'Dos Mil Cincuenta con 00/100',61,20,'Almacen Cusco',1690,23,'Aves','Contado','Efectivo','Factura','Centro Cusco',0,'20491234560');

INSERT INTO Orden_compra_detalle 
(Id_detalle, Unidad_solicitada, Unidad_entrega, Valor_unitario, Importe, Id_producto, Id_orden_compra)
VALUES
('OD021','Unidad',500,18.2,9100,11,'OC021'),
('OD022','Unidad',430,19.8,8514,12,'OC022'),
('OD023','Unidad',640,17.2,11008,13,'OC023'),
('OD024','Unidad',490,16.1,7889,14,'OC024'),
('OD025','Unidad',710,15.9,11289,15,'OC025'),
('OD026','Unidad',470,18.0,8460,16,'OC026'),
('OD027','Unidad',560,17.6,9856,17,'OC027'),
('OD028','Unidad',590,17.9,10561,18,'OC028'),
('OD029','Unidad',605,18.3,11072,19,'OC029'),
('OD030','Unidad',615,16.8,10332,20,'OC030'),
('OD031','Unidad',495,18.0,8910,11,'OC031'),
('OD032','Unidad',445,19.2,8544,12,'OC032'),
('OD033','Unidad',655,17.1,11201,13,'OC033'),
('OD034','Unidad',505,15.9,8029,14,'OC034'),
('OD035','Unidad',720,16.2,11664,15,'OC035'),
('OD036','Unidad',480,18.4,8832,16,'OC036'),
('OD037','Unidad',575,17.3,9948,17,'OC037'),
('OD038','Unidad',610,17.6,10736,18,'OC038'),
('OD039','Unidad',590,18.1,10679,19,'OC039'),
('OD040','Unidad',625,17.0,10625,20,'OC040'),
('OD041','Unidad',630,17.8,11214,11,'OC041'),
('OD042','Unidad',640,18.2,11648,12,'OC042'),
('OD043','Unidad',645,17.9,11545,13,'OC043'),
('OD044','Unidad',655,18.5,12117,14,'OC044'),
('OD045','Unidad',660,18.0,11880,15,'OC045'),
('OD046','Unidad',665,18.3,12179,16,'OC046'),
('OD047','Unidad',670,17.7,11859,17,'OC047'),
('OD048','Unidad',675,18.1,12218,18,'OC048'),
('OD049','Unidad',680,18.4,12512,19,'OC049'),
('OD050','Unidad',685,18.5,12672,20,'OC050');

INSERT INTO Detalle_Proveedor_Producto
(Id_orden_compra, Id_producto, RUC_proveedor, Cantidad)
VALUES
-- OC021 a OC040
('OC021',11,'11123456789',500),
('OC022',12,'11123456780',430),
('OC023',13,'11123456781',640),
('OC024',14,'11123456782',490),
('OC025',15,'11123456783',710),
('OC026',16,'11123456784',470),
('OC027',17,'11123456785',560),
('OC028',18,'11123456786',590),
('OC029',19,'11123456787',605),
('OC030',20,'11123456788',615),
('OC031',11,'11123456789',495),
('OC032',12,'11123456780',445),
('OC033',13,'11123456781',655),
('OC034',14,'11123456782',505),
('OC035',15,'11123456783',720),
('OC036',16,'11123456784',480),
('OC037',17,'11123456785',575),
('OC038',18,'11123456786',610),
('OC039',19,'11123456787',590),
('OC040',20,'11123456788',625),

-- OC041 a OC050
('OC041',11,'11123456789',510),
('OC042',12,'11123456780',435),
('OC043',13,'11123456781',645),
('OC044',14,'11123456782',500),
('OC045',15,'11123456783',725),
('OC046',16,'11123456784',485),
('OC047',17,'11123456785',570),
('OC048',18,'11123456786',615),
('OC049',19,'11123456787',595),
('OC050',20,'11123456788',630);
