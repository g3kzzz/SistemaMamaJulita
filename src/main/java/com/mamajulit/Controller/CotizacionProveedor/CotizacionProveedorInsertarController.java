package com.mamajulit.Controller.CotizacionProveedor;

import com.mamajulit.DAO.CotizacionProveedorDAO;
import com.mamajulit.Model.CotizacionProveedor;

public class CotizacionProveedorInsertarController {
    private final CotizacionProveedorDAO dao = new CotizacionProveedorDAO();

    public boolean insertar(CotizacionProveedor c) {
        return dao.insertar(c);
    }
}
