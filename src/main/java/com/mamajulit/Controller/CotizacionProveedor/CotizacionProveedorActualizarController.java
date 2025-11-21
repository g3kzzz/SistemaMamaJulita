package com.mamajulit.Controller.CotizacionProveedor;

import com.mamajulit.DAO.CotizacionProveedorDAO;
import com.mamajulit.Model.CotizacionProveedor;

public class CotizacionProveedorActualizarController {
    private final CotizacionProveedorDAO dao = new CotizacionProveedorDAO();

    public boolean actualizar(CotizacionProveedor c) {
        return dao.actualizar(c);
    }
}
