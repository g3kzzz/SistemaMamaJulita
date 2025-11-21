package com.mamajulit.Model;

import java.math.BigDecimal;
import java.util.Date;

public class Cotizacion {
    private String idCotizacion;
    private Integer cantidadPollos;
    private Integer asignadoMinimo;
    private Integer asignadoMaximo;
    private BigDecimal precioMaximo;
    private BigDecimal precioMinimo;
    private BigDecimal precioGenero;
    private BigDecimal precioPollo;
    private BigDecimal precioJava;
    private BigDecimal pesoPromedio;
    private Integer cantidadTotal;
    private String estado; // ACTIVA, USADA, VENCIDA
    private String ruc;
    private java.sql.Timestamp fechaRegistro;

    // getters y setters
    public String getIdCotizacion() { return idCotizacion; }
    public void setIdCotizacion(String idCotizacion) { this.idCotizacion = idCotizacion; }

    public Integer getCantidadPollos() { return cantidadPollos; }
    public void setCantidadPollos(Integer cantidadPollos) { this.cantidadPollos = cantidadPollos; }

    public Integer getAsignadoMinimo() { return asignadoMinimo; }
    public void setAsignadoMinimo(Integer asignadoMinimo) { this.asignadoMinimo = asignadoMinimo; }

    public Integer getAsignadoMaximo() { return asignadoMaximo; }
    public void setAsignadoMaximo(Integer asignadoMaximo) { this.asignadoMaximo = asignadoMaximo; }

    public BigDecimal getPrecioMaximo() { return precioMaximo; }
    public void setPrecioMaximo(BigDecimal precioMaximo) { this.precioMaximo = precioMaximo; }

    public BigDecimal getPrecioMinimo() { return precioMinimo; }
    public void setPrecioMinimo(BigDecimal precioMinimo) { this.precioMinimo = precioMinimo; }

    public BigDecimal getPrecioGenero() { return precioGenero; }
    public void setPrecioGenero(BigDecimal precioGenero) { this.precioGenero = precioGenero; }

    public BigDecimal getPrecioPollo() { return precioPollo; }
    public void setPrecioPollo(BigDecimal precioPollo) { this.precioPollo = precioPollo; }

    public BigDecimal getPrecioJava() { return precioJava; }
    public void setPrecioJava(BigDecimal precioJava) { this.precioJava = precioJava; }

    public BigDecimal getPesoPromedio() { return pesoPromedio; }
    public void setPesoPromedio(BigDecimal pesoPromedio) { this.pesoPromedio = pesoPromedio; }

    public Integer getCantidadTotal() { return cantidadTotal; }
    public void setCantidadTotal(Integer cantidadTotal) { this.cantidadTotal = cantidadTotal; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getRuc() { return ruc; }
    public void setRuc(String ruc) { this.ruc = ruc; }

    public java.sql.Timestamp getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(java.sql.Timestamp fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
