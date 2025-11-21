package com.mamajulit.Controller.OrdenCompra;

import com.mamajulit.DAO.OrdenCompraCabeceraDAO;

public class OrdenCompraCabeceraEliminarController {
    private final OrdenCompraCabeceraDAO dao = new OrdenCompraCabeceraDAO();

    public boolean eliminar(String id) {
        return dao.eliminar(id);
    }
}
