package com.mamajulit.Controller.GuiaRequerimientos;

import com.mamajulit.DAO.GuiaRequerimientosDAO;
import com.mamajulit.Model.GuiaRequerimientos;
import com.mamajulit.Util.ValidationUtil;
import com.mamajulit.View.GuiaRequerimientos.GuiaRequerimientosInsertarDialog;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class GuiaRequerimientosInsertarController {

    private GuiaRequerimientosInsertarDialog dialog;
    private GuiaRequerimientosDAO dao;

    public GuiaRequerimientosInsertarController(GuiaRequerimientosInsertarDialog dialog){
        this.dialog = dialog;
        this.dao = new GuiaRequerimientosDAO();
    }

    // Métodos para llenar JComboBox
    public void cargarConductor(JComboBox<String> combo) {
        combo.removeAllItems();
        List<String> lista = dao.listarConductor();
        for(String c : lista){
            combo.addItem(c);
        }
    }

    public void cargarPlantel(JComboBox<String> combo) {
        combo.removeAllItems();
        List<String> lista = dao.listarPlantel();
        for(String p : lista){
            combo.addItem(p);
        }
    }

    public void cargarDireccion(JComboBox<Integer> combo) {
        combo.removeAllItems();
        List<Integer> lista = dao.listarDireccion();
        for(Integer d : lista){
            combo.addItem(d);
        }
    }

    // Método para insertar nueva guía
    public void insertar(String fecha, String hora, String conductor, String plantel, Integer direccion, String telefono) {
        if(!ValidationUtil.isValidDate(fecha) || !ValidationUtil.isValidTime(hora) || !ValidationUtil.isNotEmpty(conductor)){
            dialog.mostrarError("Datos inválidos");
            return;
        }

        GuiaRequerimientos g = new GuiaRequerimientos();
        g.setFechaEntrega(Date.valueOf(fecha));
        g.setHoraEntrega(Time.valueOf(hora));
        g.setIdConductor(conductor);
        g.setIdPlantel(plantel);
        g.setIdDireccion(direccion);
        g.setTelefono(telefono);

        if(dao.insertar(g)){
            dialog.mostrarMensaje("Insertado correctamente");
            dialog.cerrar();
        } else {
            dialog.mostrarError("Error al insertar la guía");
        }
    }
}
