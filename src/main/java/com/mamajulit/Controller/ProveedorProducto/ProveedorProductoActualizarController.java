package com.mamajulit.Controller.ProveedorProducto;

import com.mamajulit.DAO.DetalleProveedorProductoDAO;

public class ProveedorProductoActualizarController {
    private final DetalleProveedorProductoDAO dao = new DetalleProveedorProductoDAO();

    public boolean actualizar(int idDetalle, Integer cantidad, Float precioBase, String usuario) throws Exception {
        return dao.actualizar(idDetalle, cantidad, precioBase, usuario);
    }
}
