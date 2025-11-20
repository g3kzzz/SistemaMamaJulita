package com.mamajulit.Controller.OrdenRecepcion;

import com.mamajulit.DAO.OrdenRecepcionDAO;
import com.mamajulit.Model.OrdenRecepcion;

public class OrdenRecepcionActualizarController {
    private final OrdenRecepcionDAO dao = new OrdenRecepcionDAO();

    public boolean actualizar(OrdenRecepcion o, String usuario) {
        return dao.actualizar(o, usuario);
    }
}
