package com.mamajulit.Controller.ProveedorProducto;

import com.mamajulit.DAO.DetalleProveedorProductoDAO;
import com.mamajulit.Model.DetalleProveedorProducto;

import java.util.List;

public class ProveedorProductoGestionController {
    private final DetalleProveedorProductoDAO dao = new DetalleProveedorProductoDAO();

    public List<DetalleProveedorProducto> listar() { return dao.listar(); }
    public List<DetalleProveedorProducto> buscar(String filtro) { return dao.buscar(filtro); }
    public boolean eliminar(int id, String usuario) throws Exception { return dao.eliminar(id, usuario); }
}
