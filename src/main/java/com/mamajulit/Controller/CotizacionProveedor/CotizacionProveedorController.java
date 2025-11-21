package com.mamajulit.Controller.CotizacionProveedor;

import com.mamajulit.DAO.CotizacionProveedorDAO;
import com.mamajulit.Model.CotizacionProveedor;

import java.util.List;

public class CotizacionProveedorController {
    private final CotizacionProveedorDAO dao = new CotizacionProveedorDAO();

    public List<CotizacionProveedor> listar() {
        return dao.listar();
    }

    public List<CotizacionProveedor> buscar(String texto, String rucFilter, Boolean activaFilter) {
        return dao.buscar(texto, rucFilter, activaFilter);
    }

    public CotizacionProveedor obtener(int id) {
        return dao.obtenerPorId(id);
    }
}
