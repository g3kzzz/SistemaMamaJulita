package com.mamajulit.View.OrdenCompra;

import com.mamajulit.Controller.OrdenCompra.OrdenCompraDetalleInsertarController;
import com.mamajulit.Model.OrdenCompraDetalle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrdenCompraDetalleInsertarDialog extends JDialog {

    private final OrdenCompraDetalleInsertarController controller = new OrdenCompraDetalleInsertarController();
    private JTextField txtIdDetalle, txtIdOrden, txtProducto, txtUnidad, txtValor, txtImporte;
    private JButton btnGuardar, btnCancelar;

    public OrdenCompraDetalleInsertarDialog() {
        setTitle("Insertar Orden de Compra - Detalle");
        setSize(400, 350);
        setModal(true);
        setLayout(null);

        txtIdDetalle = new JTextField(); txtIdDetalle.setBounds(150, 20, 200, 25);
        txtIdOrden = new JTextField(); txtIdOrden.setBounds(150, 60, 200, 25);
        txtProducto = new JTextField(); txtProducto.setBounds(150, 100, 200, 25);
        txtUnidad = new JTextField(); txtUnidad.setBounds(150, 140, 200, 25);
        txtValor = new JTextField(); txtValor.setBounds(150, 180, 200, 25);
        txtImporte = new JTextField(); txtImporte.setBounds(150, 220, 200, 25);

        btnGuardar = new JButton("Guardar"); btnGuardar.setBounds(50, 270, 100, 30);
        btnCancelar = new JButton("Cancelar"); btnCancelar.setBounds(200, 270, 100, 30);

        add(new JLabel("ID Detalle:")).setBounds(20, 20, 120, 25);
        add(new JLabel("ID Orden:")).setBounds(20, 60, 120, 25);
        add(new JLabel("Producto:")).setBounds(20, 100, 120, 25);
        add(new JLabel("Unidad:")).setBounds(20, 140, 120, 25);
        add(new JLabel("Valor Unitario:")).setBounds(20, 180, 120, 25);
        add(new JLabel("Importe:")).setBounds(20, 220, 120, 25);

        add(txtIdDetalle); add(txtIdOrden); add(txtProducto);
        add(txtUnidad); add(txtValor); add(txtImporte);
        add(btnGuardar); add(btnCancelar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdenCompraDetalle d = new OrdenCompraDetalle();
                d.setIdDetalle(txtIdDetalle.getText());
                d.setIdOrdenCompra(txtIdOrden.getText());
                d.setIdProducto(Integer.parseInt(txtProducto.getText()));
                d.setUnidadSolicitada(txtUnidad.getText());
                d.setValorUnitario(Float.parseFloat(txtValor.getText()));
                d.setImporte(Float.parseFloat(txtImporte.getText()));
                if(controller.insertar(d)) {
                    JOptionPane.showMessageDialog(null, "Detalle insertado correctamente");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al insertar");
                }
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }
}
