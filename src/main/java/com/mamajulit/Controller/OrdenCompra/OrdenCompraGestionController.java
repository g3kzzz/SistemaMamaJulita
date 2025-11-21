package com.mamajulit.Controller.OrdenCompra;

import com.mamajulit.DAO.OrdenCompraCabeceraDAO;
import com.mamajulit.DAO.OrdenCompraDetalleDAO;
import com.mamajulit.Model.OrdenCompraCabecera;
import com.mamajulit.Model.OrdenCompraDetalle;

import java.util.List;

public class OrdenCompraGestionController {
    private final OrdenCompraCabeceraDAO cabeceraDAO = new OrdenCompraCabeceraDAO();
    private final OrdenCompraDetalleDAO detalleDAO = new OrdenCompraDetalleDAO();

    public List<OrdenCompraCabecera> listarCabeceras() {
        return cabeceraDAO.listar();
    }

    public List<OrdenCompraDetalle> listarDetalles() {
        return detalleDAO.listar();
    }

    public boolean insertarCabecera(OrdenCompraCabecera c) {
        return cabeceraDAO.insertar(c);
    }

    public boolean insertarDetalle(OrdenCompraDetalle d) {
        return detalleDAO.insertar(d);
    }

    public boolean actualizarCabecera(OrdenCompraCabecera c) {
        return cabeceraDAO.actualizar(c);
    }

    public boolean actualizarDetalle(OrdenCompraDetalle d) {
        return detalleDAO.actualizar(d);
    }

    public boolean eliminarCabecera(String id) {
        return cabeceraDAO.eliminar(id);
    }

    public boolean eliminarDetalle(String id) {
        return detalleDAO.eliminar(id);
    }
}
