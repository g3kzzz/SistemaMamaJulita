package com.mamajulit.Controller.OrdenRecepcion;

import com.mamajulit.DAO.OrdenRecepcionDAO;
import com.mamajulit.Model.OrdenRecepcion;

import java.util.List;

public class OrdenRecepcionGestionController {
    private final OrdenRecepcionDAO dao = new OrdenRecepcionDAO();

    public List<OrdenRecepcion> listar() {
        return dao.listar();
    }

    public List<OrdenRecepcion> buscar(String filtro) {
        return dao.buscar(filtro);
    }
}
