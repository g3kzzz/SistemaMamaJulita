package com.mamajulit.Controller.CotizacionProveedor;

import com.mamajulit.DAO.CotizacionProveedorDAO;

public class CotizacionProveedorEliminarController {
    private final CotizacionProveedorDAO dao = new CotizacionProveedorDAO();

    public boolean eliminar(int id) {
        return dao.eliminar(id);
    }
}
