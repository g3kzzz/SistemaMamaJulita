package com.mamajulit.Controller.OrdenCompra;

import com.mamajulit.DAO.OrdenCompraDetalleDAO;

public class OrdenCompraDetalleEliminarController {
    private final OrdenCompraDetalleDAO dao = new OrdenCompraDetalleDAO();

    public boolean eliminar(String id) {
        return dao.eliminar(id);
    }
}
