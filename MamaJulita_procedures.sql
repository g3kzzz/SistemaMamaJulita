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

CREATE PROCEDURE `sp_listar_ticket_pesado`()
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