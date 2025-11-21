package com.mamajulit.Controller.OrdenCompra;

import com.mamajulit.DAO.OrdenCompraCabeceraDAO;
import com.mamajulit.Model.OrdenCompraCabecera;

public class OrdenCompraCabeceraActualizarController {
    private final OrdenCompraCabeceraDAO dao = new OrdenCompraCabeceraDAO();

    public boolean actualizar(OrdenCompraCabecera c) {
        return dao.actualizar(c);
    }
}
