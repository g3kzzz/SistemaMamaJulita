package com.mamajulit.View.OrdenCompra;

import com.mamajulit.Controller.OrdenCompra.OrdenCompraGestionController;
import com.mamajulit.Model.OrdenCompraCabecera;
import com.mamajulit.Model.OrdenCompraDetalle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrdenCompraGestionView extends JPanel {

    private JTable tablaCabecera, tablaDetalle;
    private JButton btnAgregarCabecera, btnActualizarCabecera, btnEliminarCabecera;
    private JButton btnAgregarDetalle, btnActualizarDetalle, btnEliminarDetalle;
    private final OrdenCompraGestionController controller = new OrdenCompraGestionController();

    public OrdenCompraGestionView() {
        setLayout(null);
        setSize(900, 650);

        // Tablas
        tablaCabecera = new JTable();
        tablaDetalle = new JTable();
        JScrollPane scrollCab = new JScrollPane(tablaCabecera);
        scrollCab.setBounds(20, 20, 850, 200);
        JScrollPane scrollDet = new JScrollPane(tablaDetalle);
        scrollDet.setBounds(20, 250, 850, 200);

        // Botones Cabecera
        btnAgregarCabecera = new JButton("Agregar Cabecera"); btnAgregarCabecera.setBounds(20, 470, 150, 30);
        btnActualizarCabecera = new JButton("Actualizar Cabecera"); btnActualizarCabecera.setBounds(190, 470, 150, 30);
        btnEliminarCabecera = new JButton("Eliminar Cabecera"); btnEliminarCabecera.setBounds(360, 470, 150, 30);

        // Botones Detalle
        btnAgregarDetalle = new JButton("Agregar Detalle"); btnAgregarDetalle.setBounds(20, 510, 150, 30);
        btnActualizarDetalle = new JButton("Actualizar Detalle"); btnActualizarDetalle.setBounds(190, 510, 150, 30);
        btnEliminarDetalle = new JButton("Eliminar Detalle"); btnEliminarDetalle.setBounds(360, 510, 150, 30);

        add(scrollCab); add(scrollDet);
        add(btnAgregarCabecera); add(btnActualizarCabecera); add(btnEliminarCabecera);
        add(btnAgregarDetalle); add(btnActualizarDetalle); add(btnEliminarDetalle);

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
                    OrdenCompraCabeceraActualizarDialog dialog = new OrdenCompraCabeceraActualizarDialog(c);
                    dialog.setVisible(true);
                    listarCabeceras();
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
                OrdenCompraDetalle d = controller.buscarDetallePorId(id);
                if(d != null) {
                    OrdenCompraDetalleActualizarDialog dialog = new OrdenCompraDetalleActualizarDialog(d);
                    dialog.setVisible(true);
                    listarDetalles();
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
        model.setColumnIdentifiers(new Object[]{"ID Detalle", "ID Orden", "Producto", "Unidad", "Valor", "Importe"});
        if(lista != null) {
            for(OrdenCompraDetalle d : lista) {
                model.addRow(new Object[]{
                        d.getIdDetalle(),
                        d.getIdOrdenCompra(),
                        d.getIdProducto(),
                        d.getUnidadSolicitada(),
                        d.getValorUnitario(),
                        d.getImporte()
                });
            }
        }
        tablaDetalle.setModel(model);
    }
}
