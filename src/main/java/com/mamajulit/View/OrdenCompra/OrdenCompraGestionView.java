package com.mamajulit.View.OrdenCompra;

import com.mamajulit.Controller.OrdenCompra.OrdenCompraGestionController;
import com.mamajulit.Model.OrdenCompraCabecera;
import com.mamajulit.Model.OrdenCompraDetalle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class OrdenCompraGestionView extends JPanel {

    private JTable tablaCabecera, tablaDetalle;
    private JButton btnAgregarCabecera, btnActualizarCabecera, btnEliminarCabecera;
    private JButton btnAgregarDetalle, btnActualizarDetalle, btnEliminarDetalle;
    private final OrdenCompraGestionController controller = new OrdenCompraGestionController();

    public OrdenCompraGestionView() {
        setLayout(new BorderLayout());

        // --- PANEL SUPERIOR: BOTONES ---
        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 10, 10));
        btnAgregarCabecera = new JButton("Agregar Cabecera");
        btnActualizarCabecera = new JButton("Actualizar Cabecera");
        btnEliminarCabecera = new JButton("Eliminar Cabecera");
        btnAgregarDetalle = new JButton("Agregar Detalle");
        btnActualizarDetalle = new JButton("Actualizar Detalle");
        btnEliminarDetalle = new JButton("Eliminar Detalle");

        panelBotones.add(btnAgregarCabecera);
        panelBotones.add(btnActualizarCabecera);
        panelBotones.add(btnEliminarCabecera);
        panelBotones.add(btnAgregarDetalle);
        panelBotones.add(btnActualizarDetalle);
        panelBotones.add(btnEliminarDetalle);

        add(panelBotones, BorderLayout.NORTH);

        // --- TABLAS ---
        tablaCabecera = new JTable();
        tablaDetalle = new JTable();
        JScrollPane scrollCabecera = new JScrollPane(tablaCabecera);
        JScrollPane scrollDetalle = new JScrollPane(tablaDetalle);

        JPanel panelTablas = new JPanel(new GridLayout(2, 1, 0, 10));
        panelTablas.add(scrollCabecera);
        panelTablas.add(scrollDetalle);
        add(panelTablas, BorderLayout.CENTER);

        // --- CARGAR DATOS ---
        listarCabeceras();
        listarDetalles();

        // --- ACCIONES CABECERA ---
        btnAgregarCabecera.addActionListener(e -> {
            OrdenCompraCabeceraInsertarDialog dialog = new OrdenCompraCabeceraInsertarDialog();
            dialog.setVisible(true);
            listarCabeceras();
        });

        btnActualizarCabecera.addActionListener(e -> {
            int fila = tablaCabecera.getSelectedRow();
            if(fila >= 0) {
                String id = tablaCabecera.getValueAt(fila, 0).toString();
                OrdenCompraCabecera c = controller.buscarCabeceraPorId(id);
                if(c != null) {
                    OrdenCompraCabeceraActualizarDialog dialog = new OrdenCompraCabeceraActualizarDialog(c.getIdOrdenCompra());
                    dialog.setVisible(true);
                    listarCabeceras();
                } else {
                    JOptionPane.showMessageDialog(null, "Cabecera no encontrada");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una cabecera para actualizar");
            }
        });

        btnEliminarCabecera.addActionListener(e -> {
            int fila = tablaCabecera.getSelectedRow();
            if(fila >= 0) {
                String id = tablaCabecera.getValueAt(fila, 0).toString();
                if(controller.eliminarCabecera(id)) {
                    JOptionPane.showMessageDialog(null, "Cabecera eliminada");
                    listarCabeceras();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar cabecera");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una cabecera para eliminar");
            }
        });

        // --- ACCIONES DETALLE ---
        btnAgregarDetalle.addActionListener(e -> {
            OrdenCompraDetalleInsertarDialog dialog = new OrdenCompraDetalleInsertarDialog();
            dialog.setVisible(true);
            listarDetalles();
        });

        btnActualizarDetalle.addActionListener(e -> {
            int fila = tablaDetalle.getSelectedRow();
            if(fila >= 0) {
                String id = tablaDetalle.getValueAt(fila, 0).toString();
                OrdenCompraDetalle d = controller.buscarDetallePorId(id); // debe traer todos los campos
                if(d != null) {
                    OrdenCompraDetalleActualizarDialog dialog = new OrdenCompraDetalleActualizarDialog(d);
                    dialog.setVisible(true);
                    listarDetalles();
                } else {
                    JOptionPane.showMessageDialog(null, "Detalle no encontrado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un detalle para actualizar");
            }
        });

        btnEliminarDetalle.addActionListener(e -> {
            int fila = tablaDetalle.getSelectedRow();
            if(fila >= 0) {
                String id = tablaDetalle.getValueAt(fila, 0).toString();
                if(controller.eliminarDetalle(id)) {
                    JOptionPane.showMessageDialog(null, "Detalle eliminado");
                    listarDetalles();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar detalle");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un detalle para eliminar");
            }
        });
    }

    private void listarCabeceras() {
        List<OrdenCompraCabecera> lista = controller.listarCabeceras();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "RUC", "Subtotal", "Total IGV"});
        if(lista != null) {
            for(OrdenCompraCabecera c : lista) {
                model.addRow(new Object[]{
                        c.getIdOrdenCompra(),
                        c.getRuc(),
                        c.getSubtotal(),
                        c.getTotalIgv()
                });
            }
        }
        tablaCabecera.setModel(model);
    }

    private void listarDetalles() {
        List<OrdenCompraDetalle> lista = controller.listarDetalles();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
                "ID Detalle", "ID Orden", "Producto", "Unidad Solicitada",
                "Unidad Entrega", "Valor Unitario", "Importe"
        });
        if(lista != null) {
            for(OrdenCompraDetalle d : lista) {
                model.addRow(new Object[]{
                        d.getIdDetalle(),
                        d.getIdOrdenCompra(),
                        d.getIdProducto(),
                        d.getUnidadSolicitada(),
                        d.getUnidadEntrega(),
                        d.getValorUnitario(),
                        d.getImporte()
                });
            }
        }
        tablaDetalle.setModel(model);
    }
}
