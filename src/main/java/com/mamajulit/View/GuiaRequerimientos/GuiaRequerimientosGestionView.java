package com.mamajulit.View.GuiaRequerimientos;

import com.mamajulit.Controller.GuiaRequerimientos.GuiaRequerimientosGestionController;
import com.mamajulit.Model.GuiaRequerimientos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class GuiaRequerimientosGestionView extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton btnAgregar, btnActualizar, btnEliminar, btnRefrescar;
    private GuiaRequerimientosGestionController controller;

    public GuiaRequerimientosGestionView() {
        setLayout(new BorderLayout());

        // 1. Inicializamos modelo y tabla antes de crear el controller
        modelo = new DefaultTableModel(
                new String[]{"ID", "Fecha", "Hora", "Conductor", "Plantel", "Direccion", "Telefono"}, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // 2. Panel de botones
        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnRefrescar = new JButton("Refrescar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRefrescar);
        add(panelBotones, BorderLayout.SOUTH);

        // 3. Creamos el controller después de inicializar tabla y botones
        controller = new GuiaRequerimientosGestionController(this);

        // 4. Eventos
        btnAgregar.addActionListener(e -> abrirInsertarDialog());

        btnActualizar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(this, "Por favor, selecciona una guía para actualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            GuiaRequerimientos g = new GuiaRequerimientos();
            g.setIdGuia((int) modelo.getValueAt(fila,0));
            g.setFechaEntrega(java.sql.Date.valueOf(modelo.getValueAt(fila,1).toString()));
            g.setHoraEntrega(java.sql.Time.valueOf(modelo.getValueAt(fila,2).toString()));
            g.setIdConductor(modelo.getValueAt(fila,3).toString());
            g.setIdPlantel(modelo.getValueAt(fila,4).toString());
            g.setIdDireccion(Integer.parseInt(modelo.getValueAt(fila,5).toString()));
            g.setTelefono(modelo.getValueAt(fila,6).toString());
            abrirActualizarDialog(g);
        });

        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(this, "Por favor, selecciona una guía para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int id = (int) modelo.getValueAt(fila,0);
            int confirmar = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de eliminar la guía seleccionada?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(confirmar == JOptionPane.YES_OPTION){
                controller.eliminar(id);
            }
        });

        btnRefrescar.addActionListener(e -> controller.cargarTabla());

        // 5. Cargamos los datos iniciales
        controller.cargarTabla();
    }

    public void mostrarDatos(List<GuiaRequerimientos> lista){
        modelo.setRowCount(0);
        for(GuiaRequerimientos g : lista){
            modelo.addRow(new Object[]{
                    g.getIdGuia(),
                    g.getFechaEntrega(),
                    g.getHoraEntrega(),
                    g.getIdConductor(),
                    g.getIdPlantel(),
                    g.getIdDireccion(),
                    g.getTelefono()
            });
        }
    }

    public void abrirInsertarDialog(){
        new GuiaRequerimientosInsertarDialog().setVisible(true);
    }

    public void abrirActualizarDialog(GuiaRequerimientos g){
        new GuiaRequerimientosActualizarDialog(g).setVisible(true);
    }
}
