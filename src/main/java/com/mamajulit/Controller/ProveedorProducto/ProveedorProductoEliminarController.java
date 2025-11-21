package com.mamajulit.Controller.ProveedorProducto;

import com.mamajulit.DAO.DetalleProveedorProductoDAO;

public class ProveedorProductoEliminarController {
    private final DetalleProveedorProductoDAO dao = new DetalleProveedorProductoDAO();

    public boolean eliminar(int idDetalle, String usuario) throws Exception {
        return dao.eliminar(idDetalle, usuario);
    }
}
