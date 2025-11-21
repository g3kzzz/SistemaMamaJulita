package com.mamajulit.Model;

import java.sql.Timestamp;

public class CotizacionProveedor {
    private Integer idCotizacion; // Id_cotizacion
    private String ruc;
    private String genero;
    private Integer cantidadPollos;
    private Integer asignadoMinimo;
    private Integer asignadoMaximo;
    private Float precioMaximo;
    private Float precioMinimo;
    private Boolean activa;
    private Timestamp fechaCreacion;
    private Timestamp fechaRegistro;

    // getters y setters
    public Integer getIdCotizacion() { return idCotizacion; }
    public void setIdCotizacion(Integer idCotizacion) { this.idCotizacion = idCotizacion; }

    public String getRuc() { return ruc; }
    public void setRuc(String ruc) { this.ruc = ruc; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Integer getCantidadPollos() { return cantidadPollos; }
    public void setCantidadPollos(Integer cantidadPollos) { this.cantidadPollos = cantidadPollos; }

    public Integer getAsignadoMinimo() { return asignadoMinimo; }
    public void setAsignadoMinimo(Integer asignadoMinimo) { this.asignadoMinimo = asignadoMinimo; }

    public Integer getAsignadoMaximo() { return asignadoMaximo; }
    public void setAsignadoMaximo(Integer asignadoMaximo) { this.asignadoMaximo = asignadoMaximo; }

    public Float getPrecioMaximo() { return precioMaximo; }
    public void setPrecioMaximo(Float precioMaximo) { this.precioMaximo = precioMaximo; }

    public Float getPrecioMinimo() { return precioMinimo; }
    public void setPrecioMinimo(Float precioMinimo) { this.precioMinimo = precioMinimo; }

    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }

    public Timestamp getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Timestamp fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Timestamp getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Timestamp fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
