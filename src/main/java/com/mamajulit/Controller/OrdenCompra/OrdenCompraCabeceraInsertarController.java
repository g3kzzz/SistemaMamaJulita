package com.mamajulit.Controller.OrdenCompra;

import com.mamajulit.DAO.OrdenCompraCabeceraDAO;
import com.mamajulit.Model.OrdenCompraCabecera;

public class OrdenCompraCabeceraInsertarController {
    private final OrdenCompraCabeceraDAO dao = new OrdenCompraCabeceraDAO();

    public boolean insertar(OrdenCompraCabecera c) {
        return dao.insertar(c);
    }
}
