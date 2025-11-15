package com.mamajulit.Controller.TicketPesado;

import com.mamajulit.Model.ConexionBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class TicketPesadoAgregarController {

    public boolean agregarTicket(
            String fecha_salida, String fecha_ingreso, float monto_total,
            float peso_promedio, String genero_pollo, int cantidad_pollo,
            int mortalidad, String destino, float merma,
            String placa_vehiculo, String id_conductor, String id_plantel,
            String usuario
    ) {
        String sql = "{CALL sp_insertar_ticket_pesado(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql)) {

            cs.setString(1, fecha_salida);
            cs.setString(2, fecha_ingreso);
            cs.setFloat(3, monto_total);
            cs.setFloat(4, peso_promedio);
            cs.setString(5, genero_pollo);
            cs.setInt(6, cantidad_pollo);
            cs.setInt(7, mortalidad);
            cs.setString(8, destino);
            cs.setFloat(9, merma);
            cs.setString(10, placa_vehiculo);
            cs.setString(11, id_conductor);
            cs.setString(12, id_plantel);
            cs.setString(13, usuario);

            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
