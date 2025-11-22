package com.mamajulit.Model;

public class OrdenCompraDetalle {
    private String idDetalle;
    private String unidadSolicitada;
    private Integer unidadEntrega;
    private Float valorUnitario;
    private Float importe;
    private Integer idProducto;
    private String idOrdenCompra;

    public OrdenCompraDetalle() {}

    public OrdenCompraDetalle(String idDetalle, String unidadSolicitada, Integer unidadEntrega,
                              Float valorUnitario, Float importe, Integer idProducto, String idOrdenCompra) {
        this.idDetalle = idDetalle;
        this.unidadSolicitada = unidadSolicitada;
        this.unidadEntrega = unidadEntrega;
        this.valorUnitario = valorUnitario;
        this.importe = importe;
        this.idProducto = idProducto;
        this.idOrdenCompra = idOrdenCompra;
    }

    // getters y setters
    public String getIdDetalle() { return idDetalle; }
    public void setIdDetalle(String idDetalle) { this.idDetalle = idDetalle; }

    public String getUnidadSolicitada() { return unidadSolicitada; }
    public void setUnidadSolicitada(String unidadSolicitada) { this.unidadSolicitada = unidadSolicitada; }

    public Integer getUnidadEntrega() { return unidadEntrega; }
    public void setUnidadEntrega(Integer unidadEntrega) { this.unidadEntrega = unidadEntrega; }

    public Float getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(Float valorUnitario) { this.valorUnitario = valorUnitario; }

    public Float getImporte() { return importe; }
    public void setImporte(Float importe) { this.importe = importe; }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getIdOrdenCompra() { return idOrdenCompra; }
    public void setIdOrdenCompra(String idOrdenCompra) { this.idOrdenCompra = idOrdenCompra; }

    public void setCantidad(float cantidad) {
    }

    public void setRucProveedor(String rucProveedor) {
    }
}
