package com.mamajulit.Model;

import java.sql.Date;

public class OrdenCompraCabecera {
    private String idOrdenCompra;
    private Integer asignadoMinimo;
    private Integer asignadoMaximo;
    private Float precioMaximo;
    private Float precioMinimo;
    private String puntoLlegada;
    private Date fechaEmision;
    private Float importeTotal;
    private Float totalIgv;
    private String montoLetras;
    private Float totalCargos;
    private Float totalDectsGlobal;
    private String puntoPartida;
    private Float subtotal;
    private Integer comNombre; // id empleado
    private String areaCompra;
    private String tipoPago;
    private String viaPago;
    private String claseDocumento;
    private String centroEntrega;
    private Boolean cancelado;
    private String ruc;

    public OrdenCompraCabecera() {}

    public OrdenCompraCabecera(String idOrdenCompra, Integer asignadoMinimo, Integer asignadoMaximo,
                               Float precioMaximo, Float precioMinimo, String puntoLlegada,
                               Date fechaEmision, Float importeTotal, Float totalIgv, String montoLetras,
                               Float totalCargos, Float totalDectsGlobal, String puntoPartida, Float subtotal,
                               Integer comNombre, String areaCompra, String tipoPago, String viaPago,
                               String claseDocumento, String centroEntrega, Boolean cancelado, String ruc) {
        this.idOrdenCompra = idOrdenCompra;
        this.asignadoMinimo = asignadoMinimo;
        this.asignadoMaximo = asignadoMaximo;
        this.precioMaximo = precioMaximo;
        this.precioMinimo = precioMinimo;
        this.puntoLlegada = puntoLlegada;
        this.fechaEmision = fechaEmision;
        this.importeTotal = importeTotal;
        this.totalIgv = totalIgv;
        this.montoLetras = montoLetras;
        this.totalCargos = totalCargos;
        this.totalDectsGlobal = totalDectsGlobal;
        this.puntoPartida = puntoPartida;
        this.subtotal = subtotal;
        this.comNombre = comNombre;
        this.areaCompra = areaCompra;
        this.tipoPago = tipoPago;
        this.viaPago = viaPago;
        this.claseDocumento = claseDocumento;
        this.centroEntrega = centroEntrega;
        this.cancelado = cancelado;
        this.ruc = ruc;
    }

    // getters y setters (por brevedad, sólo algunos; añade el resto si los necesitas)
    public String getIdOrdenCompra() { return idOrdenCompra; }
    public void setIdOrdenCompra(String idOrdenCompra) { this.idOrdenCompra = idOrdenCompra; }

    public Integer getAsignadoMinimo() { return asignadoMinimo; }
    public void setAsignadoMinimo(Integer asignadoMinimo) { this.asignadoMinimo = asignadoMinimo; }

    public Integer getAsignadoMaximo() { return asignadoMaximo; }
    public void setAsignadoMaximo(Integer asignadoMaximo) { this.asignadoMaximo = asignadoMaximo; }

    public Float getPrecioMaximo() { return precioMaximo; }
    public void setPrecioMaximo(Float precioMaximo) { this.precioMaximo = precioMaximo; }

    public Float getPrecioMinimo() { return precioMinimo; }
    public void setPrecioMinimo(Float precioMinimo) { this.precioMinimo = precioMinimo; }

    public String getPuntoLlegada() { return puntoLlegada; }
    public void setPuntoLlegada(String puntoLlegada) { this.puntoLlegada = puntoLlegada; }

    public Date getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(Date fechaEmision) { this.fechaEmision = fechaEmision; }

    public Float getImporteTotal() { return importeTotal; }
    public void setImporteTotal(Float importeTotal) { this.importeTotal = importeTotal; }

    public Float getTotalIgv() { return totalIgv; }
    public void setTotalIgv(Float totalIgv) { this.totalIgv = totalIgv; }

    public String getMontoLetras() { return montoLetras; }
    public void setMontoLetras(String montoLetras) { this.montoLetras = montoLetras; }

    public Float getTotalCargos() { return totalCargos; }
    public void setTotalCargos(Float totalCargos) { this.totalCargos = totalCargos; }

    public Float getTotalDectsGlobal() { return totalDectsGlobal; }
    public void setTotalDectsGlobal(Float totalDectsGlobal) { this.totalDectsGlobal = totalDectsGlobal; }

    public String getPuntoPartida() { return puntoPartida; }
    public void setPuntoPartida(String puntoPartida) { this.puntoPartida = puntoPartida; }

    public Float getSubtotal() { return subtotal; }
    public void setSubtotal(Float subtotal) { this.subtotal = subtotal; }

    public Integer getComNombre() { return comNombre; }
    public void setComNombre(Integer comNombre) { this.comNombre = comNombre; }

    public String getAreaCompra() { return areaCompra; }
    public void setAreaCompra(String areaCompra) { this.areaCompra = areaCompra; }

    public String getTipoPago() { return tipoPago; }
    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }

    public String getViaPago() { return viaPago; }
    public void setViaPago(String viaPago) { this.viaPago = viaPago; }

    public String getClaseDocumento() { return claseDocumento; }
    public void setClaseDocumento(String claseDocumento) { this.claseDocumento = claseDocumento; }

    public String getCentroEntrega() { return centroEntrega; }
    public void setCentroEntrega(String centroEntrega) { this.centroEntrega = centroEntrega; }

    public Boolean getCancelado() { return cancelado; }
    public void setCancelado(Boolean cancelado) { this.cancelado = cancelado; }

    public String getRuc() { return ruc; }
    public void setRuc(String ruc) { this.ruc = ruc; }
}
