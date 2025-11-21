package com.mamajulit.Model;

public class DetalleProveedorProducto {
    private Integer id;
    private Integer idProducto;
    private String descripcionProducto;
    private String unidad;
    private String rucProveedor;
    private String nombreProveedor;
    private Integer cantidad;
    private Float precioBase;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getDescripcionProducto() { return descripcionProducto; }
    public void setDescripcionProducto(String descripcionProducto) { this.descripcionProducto = descripcionProducto; }

    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }

    public String getRucProveedor() { return rucProveedor; }
    public void setRucProveedor(String rucProveedor) { this.rucProveedor = rucProveedor; }

    public String getNombreProveedor() { return nombreProveedor; }
    public void setNombreProveedor(String nombreProveedor) { this.nombreProveedor = nombreProveedor; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Float getPrecioBase() { return precioBase; }
    public void setPrecioBase(Float precioBase) { this.precioBase = precioBase; }
}
