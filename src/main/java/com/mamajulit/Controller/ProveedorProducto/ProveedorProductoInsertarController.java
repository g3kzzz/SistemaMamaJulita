package com.mamajulit.Controller.ProveedorProducto;

import com.mamajulit.DAO.DetalleProveedorProductoDAO;

public class ProveedorProductoInsertarController {
    private final DetalleProveedorProductoDAO dao = new DetalleProveedorProductoDAO();

    public boolean insertar(String ruc, int idProducto, Integer cantidad, Float precioBase, String usuario) throws Exception {
        return dao.insertar(ruc, idProducto, cantidad, precioBase, usuario);
    }
}
