package com.mamajulit.Controller.OrdenRecepcion;

import com.mamajulit.DAO.OrdenRecepcionDAO;
import com.mamajulit.Model.OrdenRecepcion;

public class OrdenRecepcionInsertarController {
    private final OrdenRecepcionDAO dao = new OrdenRecepcionDAO();

    public boolean insertar(OrdenRecepcion o, String usuario) {
        return dao.insertar(o, usuario);
    }
}
