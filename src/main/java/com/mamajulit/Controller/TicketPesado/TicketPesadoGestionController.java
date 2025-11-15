package com.mamajulit.Controller.TicketPesado;

import com.mamajulit.Model.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class TicketPesadoGestionController {

    public List<HashMap<String, Object>> listarTickets() {
        List<HashMap<String, Object>> lista = new ArrayList<>();
        String sql = "{CALL sp_listar_ticket_pesado()}";

        try (Connection cn = ConexionBD.getConnection();
             CallableStatement cs = cn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                HashMap<String, Object> ticket = new HashMap<>();
                ticket.put("Id_ticket", rs.getInt("Id_ticket"));
                ticket.put("Fecha_salida", rs.getDate("Fecha_salida"));
                ticket.put("Fecha_ingreso", rs.getDate("Fecha_ingreso"));
                ticket.put("Monto_total", rs.getFloat("Monto_total"));
                ticket.put("Peso_promedio", rs.getFloat("Peso_promedio"));
                ticket.put("Genero_pollo", rs.getString("Genero_pollo"));
                ticket.put("Cantidad_pollo", rs.getInt("Cantidad_pollo"));
                ticket.put("Mortalidad", rs.getInt("Mortalidad"));
                ticket.put("Destino", rs.getString("Destino"));
                ticket.put("Merma", rs.getFloat("Merma"));
                ticket.put("Placa_vehiculo", rs.getString("Placa_vehiculo"));
                ticket.put("Id_conductor", rs.getString("Id_conductor"));
                ticket.put("Id_plantel", rs.getString("Id_plantel"));
                lista.add(ticket);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
