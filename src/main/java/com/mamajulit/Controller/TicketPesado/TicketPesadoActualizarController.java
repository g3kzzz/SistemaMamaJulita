package com.mamajulit.Controller.TicketPesado;

import com.mamajulit.Model.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class TicketPesadoActualizarController {

    public boolean actualizarTicket(
            int id_ticket, String fecha_salida, String fecha_ingreso, float monto_total,
            float peso_promedio, String genero_pollo, int cantidad_pollo,
            int mortalidad, String destino, float merma,
            String placa_vehiculo, String id_conductor, String id_plantel,
            String usuario
    ) {
        String sql = "{CALL sp_actualizar_ticket_pesado(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setInt(1, id_ticket);
            cs.setString(2, fecha_salida);
            cs.setString(3, fecha_ingreso);
            cs.setFloat(4, monto_total);
            cs.setFloat(5, peso_promedio);
            cs.setString(6, genero_pollo);
            cs.setInt(7, cantidad_pollo);
            cs.setInt(8, mortalidad);
            cs.setString(9, destino);
            cs.setFloat(10, merma);
            cs.setString(11, placa_vehiculo);
            cs.setString(12, id_conductor);
            cs.setString(13, id_plantel);
            cs.setString(14, usuario);

            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
