package com.mamajulit.Controller.OrdenCompra;

import com.mamajulit.DAO.OrdenCompraCabeceraDAO;
import com.mamajulit.DAO.OrdenCompraDetalleDAO;
import com.mamajulit.Model.OrdenCompraCabecera;
import com.mamajulit.Model.OrdenCompraDetalle;

import java.util.List;

public class OrdenCompraGestionController {
    private final OrdenCompraCabeceraDAO cabeceraDAO = new OrdenCompraCabeceraDAO();
    private final OrdenCompraDetalleDAO detalleDAO = new OrdenCompraDetalleDAO();

    // --- Listados ---
    public List<OrdenCompraCabecera> listarCabeceras() {
        return cabeceraDAO.listar();
    }

    public List<OrdenCompraDetalle> listarDetalles() {
        return detalleDAO.listar();
    }

    // --- Insertar ---
    public boolean insertarCabecera(OrdenCompraCabecera c) {
        return cabeceraDAO.insertar(c);
    }

    public boolean insertarDetalle(OrdenCompraDetalle d) {
        return detalleDAO.insertar(d);
    }

    // --- Actualizar ---
    public boolean actualizarCabecera(OrdenCompraCabecera c) {
        return cabeceraDAO.actualizar(c);
    }

    public boolean actualizarDetalle(OrdenCompraDetalle d) {
        return detalleDAO.actualizar(d);
    }

    // --- Buscar por ID ---
    public OrdenCompraCabecera buscarCabeceraPorId(String id) {
        return cabeceraDAO.obtenerPorId(id); // <- ahora devuelve un objeto directamente
    }

    public OrdenCompraDetalle buscarDetallePorId(String id) {
        return detalleDAO.obtenerPorId(id); // <- idem, devuelve un objeto
    }

    // --- Eliminar ---
    public boolean eliminarCabecera(String id) {
        return cabeceraDAO.eliminar(id);
    }

    public boolean eliminarDetalle(String id) {
        return detalleDAO.eliminar(id);
    }
}
