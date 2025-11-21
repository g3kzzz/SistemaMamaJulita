package com.mamajulit.Controller.GuiaRequerimientos;

import com.mamajulit.DAO.GuiaRequerimientosDAO;
import com.mamajulit.Model.GuiaRequerimientos;
import com.mamajulit.View.GuiaRequerimientos.GuiaRequerimientosGestionView;

import java.util.List;

public class GuiaRequerimientosGestionController {

    private GuiaRequerimientosGestionView view;
    private GuiaRequerimientosDAO dao;

    public GuiaRequerimientosGestionController(GuiaRequerimientosGestionView view) {
        this.view = view;
        this.dao = new GuiaRequerimientosDAO();
        cargarTabla();
    }

    public void cargarTabla() {
        List<GuiaRequerimientos> lista = dao.listar();
        view.mostrarDatos(lista);
    }

    public void abrirInsertar() {
        view.abrirInsertarDialog();
    }

    public void abrirActualizar(GuiaRequerimientos g) {
        view.abrirActualizarDialog(g);
    }

    public void eliminar(int idGuia) {
        if(dao.eliminar(idGuia)){
            cargarTabla();
        }
    }
}
