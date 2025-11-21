package com.mamajulit.View.OrdenCompra;

import com.mamajulit.Controller.OrdenCompra.OrdenCompraDetalleActualizarController;
import com.mamajulit.Model.OrdenCompraDetalle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrdenCompraDetalleActualizarDialog extends JDialog {

    private final OrdenCompraDetalleActualizarController controller = new OrdenCompraDetalleActualizarController();
    private JTextField txtIdDetalle, txtIdOrden, txtProducto, txtUnidad, txtValor, txtImporte;
    private JButton btnActualizar, btnCancelar;

    public OrdenCompraDetalleActualizarDialog(OrdenCompraDetalle d) {
        setTitle("Actualizar Orden de Compra - Detalle");
        setSize(400, 350);
        setModal(true);
        setLayout(null);

        txtIdDetalle = new JTextField(d.getIdDetalle()); txtIdDetalle.setBounds(150, 20, 200, 25); txtIdDetalle.setEditable(false);
        txtIdOrden = new JTextField(d.getIdOrdenCompra()); txtIdOrden.setBounds(150, 60, 200, 25);
        txtProducto = new JTextField(String.valueOf(d.getIdProducto())); txtProducto.setBounds(150, 100, 200, 25);
        txtUnidad = new JTextField(d.getUnidadSolicitada()); txtUnidad.setBounds(150, 140, 200, 25);
        txtValor = new JTextField(String.valueOf(d.getValorUnitario())); txtValor.setBounds(150, 180, 200, 25);
        txtImporte = new JTextField(String.valueOf(d.getImporte())); txtImporte.setBounds(150, 220, 200, 25);

        btnActualizar = new JButton("Actualizar"); btnActualizar.setBounds(50, 270, 100, 30);
        btnCancelar = new JButton("Cancelar"); btnCancelar.setBounds(200, 270, 100, 30);

        add(new JLabel("ID Detalle:")).setBounds(20, 20, 120, 25);
        add(new JLabel("ID Orden:")).setBounds(20, 60, 120, 25);
        add(new JLabel("Producto:")).setBounds(20, 100, 120, 25);
        add(new JLabel("Unidad:")).setBounds(20, 140, 120, 25);
        add(new JLabel("Valor Unitario:")).setBounds(20, 180, 120, 25);
        add(new JLabel("Importe:")).setBounds(20, 220, 120, 25);

        add(txtIdDetalle); add(txtIdOrden); add(txtProducto);
        add(txtUnidad); add(txtValor); add(txtImporte);
        add(btnActualizar); add(btnCancelar);

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setIdOrdenCompra(txtIdOrden.getText());
                d.setIdProducto(Integer.parseInt(txtProducto.getText()));
                d.setUnidadSolicitada(txtUnidad.getText());
                d.setValorUnitario(Float.parseFloat(txtValor.getText()));
                d.setImporte(Float.parseFloat(txtImporte.getText()));
                if(controller.actualizar(d)) {
                    JOptionPane.showMessageDialog(null, "Detalle actualizado correctamente");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar");
                }
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }
}
