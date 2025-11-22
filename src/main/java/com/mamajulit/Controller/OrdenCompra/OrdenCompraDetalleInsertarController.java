package com.mamajulit.Controller.OrdenCompra;

import com.mamajulit.DAO.OrdenCompraDetalleDAO;

import java.util.List;

public class OrdenCompraDetalleInsertarController {

    private final OrdenCompraDetalleDAO dao = new OrdenCompraDetalleDAO();

    // Inserta el detalle
    public boolean insertar(com.mamajulit.Model.OrdenCompraDetalle d) {
        return dao.insertar(d);
    }

    // Método para generar el siguiente ID automáticamente
    public String generarNuevoId() {
        List<String> ids = dao.listarIds(); // Obtiene todos los IDs existentes
        int max = 0;

        for(String id : ids) {
            if(id.startsWith("OD")) {
                try {
                    int num = Integer.parseInt(id.substring(2)); // Extrae el número
                    if(num > max) max = num;
                } catch(NumberFormatException e) {
                    // Ignorar IDs corruptos
                }
            }
        }

        // Formatear con ceros a la izquierda
        int siguiente = max + 1;
        return String.format("OD%03d", siguiente);
    }
}
