package com.mamajulit.Model;

import java.sql.Date;
import java.sql.Time;

public class GuiaRequerimientos {
    private int idGuia;
    private Date fechaEntrega;
    private Time horaEntrega;
    private String idConductor;
    private String idPlantel;
    private int idDireccion;
    private String telefono;

    public GuiaRequerimientos() {}

    public GuiaRequerimientos(int idGuia, Date fechaEntrega, Time horaEntrega, String idConductor, String idPlantel, int idDireccion, String telefono) {
        this.idGuia = idGuia;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.idConductor = idConductor;
        this.idPlantel = idPlantel;
        this.idDireccion = idDireccion;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getIdGuia() { return idGuia; }
    public void setIdGuia(int idGuia) { this.idGuia = idGuia; }
    public Date getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(Date fechaEntrega) { this.fechaEntrega = fechaEntrega; }
    public Time getHoraEntrega() { return horaEntrega; }
    public void setHoraEntrega(Time horaEntrega) { this.horaEntrega = horaEntrega; }
    public String getIdConductor() { return idConductor; }
    public void setIdConductor(String idConductor) { this.idConductor = idConductor; }
    public String getIdPlantel() { return idPlantel; }
    public void setIdPlantel(String idPlantel) { this.idPlantel = idPlantel; }
    public int getIdDireccion() { return idDireccion; }
    public void setIdDireccion(int idDireccion) { this.idDireccion = idDireccion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
