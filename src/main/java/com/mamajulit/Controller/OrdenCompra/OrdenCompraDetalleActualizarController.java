package com.mamajulit.Controller.OrdenCompra;

import com.mamajulit.DAO.OrdenCompraDetalleDAO;
import com.mamajulit.Model.OrdenCompraDetalle;

public class OrdenCompraDetalleActualizarController {
    private final OrdenCompraDetalleDAO dao = new OrdenCompraDetalleDAO();

    public boolean actualizar(OrdenCompraDetalle d) {
        return dao.actualizar(d);
    }
}
