package com.mamajulit.Controller.OrdenCompra;

import com.mamajulit.DAO.OrdenCompraDetalleDAO;
import com.mamajulit.Model.OrdenCompraDetalle;

public class OrdenCompraDetalleInsertarController {
    private final OrdenCompraDetalleDAO dao = new OrdenCompraDetalleDAO();

    public boolean insertar(OrdenCompraDetalle d) {
        return dao.insertar(d);
    }
}
