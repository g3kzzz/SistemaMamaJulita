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
    private JTextField txtBusqueda;
    private GuiaRequerimientosGestionController controller;

    // Filtros solo de FK
    private JComboBox<String> cbFiltroConductor, cbFiltroPlantel;
    private JComboBox<Integer> cbFiltroDireccion;

    public GuiaRequerimientosGestionView() {
        setLayout(new BorderLayout(10, 10));

        // ------------------- Panel superior unificado: botones + búsqueda + filtros -------------------
        JPanel panelTop = new JPanel();
        panelTop.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

        // Botones CRUD
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnRefrescar = new JButton("Refrescar");

        panelTop.add(btnAgregar);
        panelTop.add(btnActualizar);
        panelTop.add(btnEliminar);
        panelTop.add(btnRefrescar);

        // Cuadro de búsqueda general
        txtBusqueda = new JTextField(15);
        txtBusqueda.setToolTipText("Buscar...");
        panelTop.add(new JLabel("Buscar:"));
        panelTop.add(txtBusqueda);

        // Filtros FK
        cbFiltroConductor = new JComboBox<>();
        cbFiltroPlantel = new JComboBox<>();
        cbFiltroDireccion = new JComboBox<>();

        panelTop.add(new JLabel("Conductor:"));
        panelTop.add(cbFiltroConductor);
        panelTop.add(new JLabel("Plantel:"));
        panelTop.add(cbFiltroPlantel);
        panelTop.add(new JLabel("Dirección:"));
        panelTop.add(cbFiltroDireccion);

        add(panelTop, BorderLayout.NORTH);

        // ------------------- Tabla -------------------
        modelo = new DefaultTableModel(
                new String[]{"ID", "Fecha", "Hora", "Conductor", "Plantel", "Dirección", "Teléfono"}, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // ------------------- Controller -------------------
        controller = new GuiaRequerimientosGestionController(this);
        controller.cargarTabla();

        // Llenar combos FK
        controller.cargarConductor(cbFiltroConductor);
        controller.cargarPlantel(cbFiltroPlantel);
        controller.cargarDireccion(cbFiltroDireccion);

        // ------------------- Eventos -------------------
        btnAgregar.addActionListener(e -> abrirInsertarDialog());
        btnActualizar.addActionListener(e -> abrirActualizarSeleccionado());
        btnEliminar.addActionListener(e -> eliminarSeleccionado());
        btnRefrescar.addActionListener(e -> controller.cargarTabla());

        // Filtros y búsqueda
        txtBusqueda.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override public void update() { aplicarFiltros(); }
        });
        cbFiltroConductor.addActionListener(e -> aplicarFiltros());
        cbFiltroPlantel.addActionListener(e -> aplicarFiltros());
        cbFiltroDireccion.addActionListener(e -> aplicarFiltros());
    }

    private void abrirActualizarSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una guía para actualizar", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        GuiaRequerimientos g = new GuiaRequerimientos();
        g.setIdGuia((int) modelo.getValueAt(fila, 0));
        g.setFechaEntrega(java.sql.Date.valueOf(modelo.getValueAt(fila, 1).toString()));
        g.setHoraEntrega(java.sql.Time.valueOf(modelo.getValueAt(fila, 2).toString()));
        g.setIdConductor(modelo.getValueAt(fila, 3).toString());
        g.setIdPlantel(modelo.getValueAt(fila, 4).toString());
        g.setIdDireccion(Integer.parseInt(modelo.getValueAt(fila, 5).toString()));
        g.setTelefono(modelo.getValueAt(fila, 6).toString());
        abrirActualizarDialog(g);
    }

    private void eliminarSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una guía para eliminar", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = (int) modelo.getValueAt(fila, 0);
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Eliminar guía seleccionada?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            controller.eliminar(id);
        }
    }

    public void mostrarDatos(List<GuiaRequerimientos> lista) {
        modelo.setRowCount(0);
        for (GuiaRequerimientos g : lista) {
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

    private void aplicarFiltros() {
        List<GuiaRequerimientos> lista = controller.listarFiltrando(
                txtBusqueda.getText(),
                null, null,
                (String) cbFiltroConductor.getSelectedItem(),
                (String) cbFiltroPlantel.getSelectedItem(),
                (Integer) cbFiltroDireccion.getSelectedItem(),
                null
        );
        mostrarDatos(lista);
    }

    public void abrirInsertarDialog() {
        new GuiaRequerimientosInsertarDialog().setVisible(true);
    }

    public void abrirActualizarDialog(GuiaRequerimientos g) {
        new GuiaRequerimientosActualizarDialog(g).setVisible(true);
    }

    // ------------------- Listener simplificado para Document -------------------
    private abstract class SimpleDocumentListener implements javax.swing.event.DocumentListener {
        public abstract void update();
        @Override public void insertUpdate(javax.swing.event.DocumentEvent e) { update(); }
        @Override public void removeUpdate(javax.swing.event.DocumentEvent e) { update(); }
        @Override public void changedUpdate(javax.swing.event.DocumentEvent e) { update(); }
    }
}
