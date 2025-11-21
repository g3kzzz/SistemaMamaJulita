package com.mamajulit.Controller.GuiaRequerimientos;

import com.mamajulit.DAO.GuiaRequerimientosDAO;

public class GuiaRequerimientosEliminar {
    private GuiaRequerimientosDAO dao = new GuiaRequerimientosDAO();

    public boolean eliminar(int idGuia){
        return dao.eliminar(idGuia);
    }
}
