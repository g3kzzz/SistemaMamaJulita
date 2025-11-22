package com.mamajulit.Model;

public class Empresa {
    private String ruc;
    private String nombre;
    private String razonSocial;
    private int idDireccion;
    private String telefono;

    public Empresa() {}

    public Empresa(String ruc, String nombre, String razonSocial, int idDireccion, String telefono) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.idDireccion = idDireccion;
        this.telefono = telefono;
    }

    public String getRuc() { return ruc; }
    public void setRuc(String ruc) { this.ruc = ruc; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }
    public int getIdDireccion() { return idDireccion; }
    public void setIdDireccion(int idDireccion) { this.idDireccion = idDireccion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
