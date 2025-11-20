package com.mamajulit.Controller.OrdenRecepcion;

import com.mamajulit.DAO.OrdenRecepcionDAO;

public class OrdenRecepcionEliminarController {
    private final OrdenRecepcionDAO dao = new OrdenRecepcionDAO();

    public boolean eliminar(int codigoRecepcion, String usuario) {
        return dao.eliminar(codigoRecepcion, usuario);
    }
}
