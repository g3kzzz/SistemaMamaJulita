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
    private JButton btnAgregarCabecera, btnAgregarDetalle;
    private final OrdenCompraGestionController controller = new OrdenCompraGestionController();

    public OrdenCompraGestionView() {
        setLayout(null);
        setSize(800, 600);

        tablaCabecera = new JTable();
        tablaDetalle = new JTable();
        JScrollPane scrollCab = new JScrollPane(tablaCabecera);
        scrollCab.setBounds(20, 20, 750, 200);
        JScrollPane scrollDet = new JScrollPane(tablaDetalle);
        scrollDet.setBounds(20, 250, 750, 200);

        btnAgregarCabecera = new JButton("Agregar Cabecera");
        btnAgregarCabecera.setBounds(20, 470, 180, 30);
        btnAgregarDetalle = new JButton("Agregar Detalle");
        btnAgregarDetalle.setBounds(220, 470, 180, 30);

        add(scrollCab);
        add(scrollDet);
        add(btnAgregarCabecera);
        add(btnAgregarDetalle);

        listarCabeceras();
        listarDetalles();

        btnAgregarCabecera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdenCompraCabeceraInsertarDialog dialog = new OrdenCompraCabeceraInsertarDialog();
                dialog.setVisible(true);
                listarCabeceras();
            }
        });

        btnAgregarDetalle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdenCompraDetalleInsertarDialog dialog = new OrdenCompraDetalleInsertarDialog();
                dialog.setVisible(true);
                listarDetalles();
            }
        });
    }

    private void listarCabeceras() {
        List<OrdenCompraCabecera> lista = controller.listarCabeceras();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "RUC", "Subtotal", "Total IGV"});
        if (lista != null) {
            for (OrdenCompraCabecera c : lista) {
                // Corregido nombres de getters según tu modelo
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
        if (lista != null) {
            for (OrdenCompraDetalle d : lista) {
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
