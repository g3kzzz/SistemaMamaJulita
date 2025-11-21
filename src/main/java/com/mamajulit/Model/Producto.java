package com.mamajulit.Model;

public class Producto {

    private int idProducto;
    private String descripcion;
    private String unidad;

    public Producto() {}

    public Producto(int idProducto, String descripcion, String unidad) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.unidad = unidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
