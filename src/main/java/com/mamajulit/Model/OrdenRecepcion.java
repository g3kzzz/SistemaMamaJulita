package com.mamajulit.Model;

import java.sql.Time;
import java.util.Date;

public class OrdenRecepcion {
    private Integer codigoRecepcion;
    private String descripcion;
    private String lote;
    private String tipo;
    private Integer cantidad;
    private Time hora;
    private java.sql.Date fecha;
    private String almacen;
    private Float pesoTotal;
    private String observaciones;
    private Integer emitidoPor;    // Id_empleado
    private Integer entregadoPor;  // Id_empleado
    private Integer idTicket;      // Id_ticket
    private String placaVehiculo;  // Placa

    // getters y setters
    public Integer getCodigoRecepcion() { return codigoRecepcion; }
    public void setCodigoRecepcion(Integer codigoRecepcion) { this.codigoRecepcion = codigoRecepcion; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public java.sql.Time getHora() { return hora; }
    public void setHora(java.sql.Time hora) { this.hora = hora; }
    public java.sql.Date getFecha() { return fecha; }
    public void setFecha(java.sql.Date fecha) { this.fecha = fecha; }
    public String getAlmacen() { return almacen; }
    public void setAlmacen(String almacen) { this.almacen = almacen; }
    public Float getPesoTotal() { return pesoTotal; }
    public void setPesoTotal(Float pesoTotal) { this.pesoTotal = pesoTotal; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public Integer getEmitidoPor() { return emitidoPor; }
    public void setEmitidoPor(Integer emitidoPor) { this.emitidoPor = emitidoPor; }
    public Integer getEntregadoPor() { return entregadoPor; }
    public void setEntregadoPor(Integer entregadoPor) { this.entregadoPor = entregadoPor; }
    public Integer getIdTicket() { return idTicket; }
    public void setIdTicket(Integer idTicket) { this.idTicket = idTicket; }
    public String getPlacaVehiculo() { return placaVehiculo; }
    public void setPlacaVehiculo(String placaVehiculo) { this.placaVehiculo = placaVehiculo; }
}
