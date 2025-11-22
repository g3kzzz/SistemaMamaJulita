package com.mamajulit.Controller.GuiaRequerimientos;

import com.mamajulit.Model.GuiaRequerimientos;
import com.mamajulit.View.GuiaRequerimientos.GuiaRequerimientosActualizarDialog;

import javax.swing.*;
import java.util.List;

public class GuiaRequerimientosActualizarController {

    private GuiaRequerimientosActualizarDialog view;
    private com.mamajulit.DAO.GuiaRequerimientosDAO dao;

    public GuiaRequerimientosActualizarController(GuiaRequerimientosActualizarDialog view){
        this.view = view;
        this.dao = new com.mamajulit.DAO.GuiaRequerimientosDAO();
    }

    public void actualizar(int id, String fecha, String hora, String conductor,
                           String plantel, int direccion, String telefono){
        GuiaRequerimientos g = new GuiaRequerimientos();
        g.setIdGuia(id);
        g.setFechaEntrega(java.sql.Date.valueOf(fecha));
        g.setHoraEntrega(java.sql.Time.valueOf(hora));
        g.setIdConductor(conductor);
        g.setIdPlantel(plantel);
        g.setIdDireccion(direccion);
        g.setTelefono(telefono);

        boolean exito = dao.actualizar(g);
        if(exito){
            view.mostrarMensaje("Guía actualizada correctamente");
            view.cerrar();
        } else {
            view.mostrarError("Error al actualizar la guía");
        }
    }

    // ------------------ MÉTODOS PARA LLENAR LOS COMBOBOX ------------------
    public void cargarConductor(JComboBox<String> combo, String valorActual){
        combo.removeAllItems();
        List<String> lista = dao.listarConductor();
        for(String s : lista){
            combo.addItem(s);
        }
        combo.setSelectedItem(valorActual);
    }

    public void cargarPlantel(JComboBox<String> combo, String valorActual){
        combo.removeAllItems();
        List<String> lista = dao.listarPlantel();
        for(String s : lista){
            combo.addItem(s);
        }
        combo.setSelectedItem(valorActual);
    }

    public void cargarDireccion(JComboBox<Integer> combo, int valorActual){
        combo.removeAllItems();
        List<Integer> lista = dao.listarDireccion();
        for(Integer i : lista){
            combo.addItem(i);
        }
        combo.setSelectedItem(valorActual);
    }
}