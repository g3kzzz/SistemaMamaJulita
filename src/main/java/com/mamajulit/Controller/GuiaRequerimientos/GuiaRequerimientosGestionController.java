package com.mamajulit.Controller.GuiaRequerimientos;

import com.mamajulit.DAO.GuiaRequerimientosDAO;
import com.mamajulit.Model.GuiaRequerimientos;
import com.mamajulit.View.GuiaRequerimientos.GuiaRequerimientosGestionView;

import javax.swing.JComboBox;
import java.util.List;

public class GuiaRequerimientosGestionController {

    private GuiaRequerimientosGestionView view;
    private GuiaRequerimientosDAO dao;

    public GuiaRequerimientosGestionController(GuiaRequerimientosGestionView view) {
        this.view = view;
        this.dao = new GuiaRequerimientosDAO();
        cargarTabla();
    }

    // ------------------- Tabla -------------------
    public void cargarTabla() {
        List<GuiaRequerimientos> lista = dao.listar();
        view.mostrarDatos(lista);
    }

    // ------------------- Métodos para llenar JComboBox -------------------
    public void cargarConductor(JComboBox<String> combo) {
        combo.removeAllItems();
        List<String> lista = dao.listarConductor();
        for (String c : lista) {
            combo.addItem(c);
        }
    }

    public void cargarPlantel(JComboBox<String> combo) {
        combo.removeAllItems();
        List<String> lista = dao.listarPlantel();
        for (String p : lista) {
            combo.addItem(p);
        }
    }

    public void cargarDireccion(JComboBox<Integer> combo) {
        combo.removeAllItems();
        List<Integer> lista = dao.listarDireccion();
        for (Integer d : lista) {
            combo.addItem(d);
        }
    }

    // ------------------- Filtrado -------------------
    public List<GuiaRequerimientos> listarFiltrando(
            String busqueda,
            String fechaInicio,
            String fechaFin,
            String conductor,
            String plantel,
            Integer direccion,
            String telefono
    ) {
        return dao.listarFiltrando(busqueda, fechaInicio, fechaFin, conductor, plantel, direccion, telefono);
    }

    // ------------------- Operaciones -------------------
    public void abrirInsertar() {
        view.abrirInsertarDialog();
    }

    public void abrirActualizar(GuiaRequerimientos g) {
        view.abrirActualizarDialog(g);
    }

    public void eliminar(int idGuia) {
        if (dao.eliminar(idGuia)) {
            cargarTabla();
        }
    }
}
