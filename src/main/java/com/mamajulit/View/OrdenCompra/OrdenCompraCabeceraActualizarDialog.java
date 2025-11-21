package com.mamajulit.View.OrdenCompra;

import com.mamajulit.Controller.OrdenCompra.OrdenCompraCabeceraActualizarController;
import com.mamajulit.Model.OrdenCompraCabecera;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrdenCompraCabeceraActualizarDialog extends JDialog {

    private final OrdenCompraCabeceraActualizarController controller = new OrdenCompraCabeceraActualizarController();
    private JTextField txtId, txtRUC, txtSubtotal, txtTotalIGV;
    private JButton btnActualizar, btnCancelar;

    public OrdenCompraCabeceraActualizarDialog(OrdenCompraCabecera c) {
        setTitle("Actualizar Orden de Compra - Cabecera");
        setSize(400, 300);
        setModal(true);
        setLayout(null);

        // Corregido getRUC() -> getRuc()
        txtId = new JTextField(c.getIdOrdenCompra());
        txtId.setBounds(120, 20, 200, 25);
        txtId.setEditable(false);

        txtRUC = new JTextField(c.getRuc());
        txtRUC.setBounds(120, 60, 200, 25);

        txtSubtotal = new JTextField(String.valueOf(c.getSubtotal()));
        txtSubtotal.setBounds(120, 100, 200, 25);

        txtTotalIGV = new JTextField(String.valueOf(c.getTotalIgv()));
        txtTotalIGV.setBounds(120, 140, 200, 25);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(50, 200, 100, 30);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 200, 100, 30);

        add(new JLabel("ID:")).setBounds(20, 20, 100, 25);
        add(new JLabel("RUC:")).setBounds(20, 60, 100, 25);
        add(new JLabel("Subtotal:")).setBounds(20, 100, 100, 25);
        add(new JLabel("Total IGV:")).setBounds(20, 140, 100, 25);

        add(txtId); add(txtRUC); add(txtSubtotal); add(txtTotalIGV);
        add(btnActualizar); add(btnCancelar);

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.setRuc(txtRUC.getText()); // corregido
                    c.setSubtotal(Float.parseFloat(txtSubtotal.getText()));
                    c.setTotalIgv(Float.parseFloat(txtTotalIGV.getText())); // corregido
                    if(controller.actualizar(c)) {
                        JOptionPane.showMessageDialog(null, "Cabecera actualizada correctamente");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos");
                }
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }
}
