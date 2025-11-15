package com.mamajulit.Controller.TicketPesado;

import com.mamajulit.Model.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class TicketPesadoEliminarController {

    public boolean eliminarTicket(int id_ticket, String usuario) {
        String sql = "{CALL sp_eliminar_ticket_pesado(?,?)}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setInt(1, id_ticket);
            cs.setString(2, usuario);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
