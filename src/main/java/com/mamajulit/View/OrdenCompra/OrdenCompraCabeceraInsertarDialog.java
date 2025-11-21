package com.mamajulit.View.OrdenCompra;

import com.mamajulit.Controller.OrdenCompra.OrdenCompraCabeceraInsertarController;
import com.mamajulit.DAO.ProveedorDAO;
import com.mamajulit.Model.OrdenCompraCabecera;

import javax.swing.*;
import java.util.List;

public class OrdenCompraCabeceraInsertarDialog extends JDialog {

    private final OrdenCompraCabeceraInsertarController controller = new OrdenCompraCabeceraInsertarController();
    private JTextField txtId, txtSubtotal, txtTotalIGV;
    private JComboBox<String> cmbRUC;
    private JButton btnGuardar, btnCancelar;

    public OrdenCompraCabeceraInsertarDialog() {
        setTitle("Insertar Orden de Compra - Cabecera");
        setSize(400, 300);
        setModal(true);
        setLayout(null);

        txtId = new JTextField(); txtId.setBounds(120, 20, 200, 25);
        txtSubtotal = new JTextField(); txtSubtotal.setBounds(120, 60, 200, 25);
        txtTotalIGV = new JTextField(); txtTotalIGV.setBounds(120, 100, 200, 25);

        cmbRUC = new JComboBox<>(); cmbRUC.setBounds(120, 140, 200, 25);
        cargarRUC();

        btnGuardar = new JButton("Guardar"); btnGuardar.setBounds(50, 200, 100, 30);
        btnCancelar = new JButton("Cancelar"); btnCancelar.setBounds(200, 200, 100, 30);

        add(new JLabel("ID:")).setBounds(20, 20, 100, 25);
        add(new JLabel("Subtotal:")).setBounds(20, 60, 100, 25);
        add(new JLabel("Total IGV:")).setBounds(20, 100, 100, 25);
        add(new JLabel("RUC:")).setBounds(20, 140, 100, 25);

        add(txtId); add(txtSubtotal); add(txtTotalIGV); add(cmbRUC);
        add(btnGuardar); add(btnCancelar);

        btnGuardar.addActionListener(e -> {
            try {
                OrdenCompraCabecera c = new OrdenCompraCabecera();
                c.setIdOrdenCompra(txtId.getText());
                c.setSubtotal(Float.parseFloat(txtSubtotal.getText()));
                c.setTotalIgv(Float.parseFloat(txtTotalIGV.getText()));
                c.setRuc(cmbRUC.getSelectedItem().toString());

                if(controller.insertar(c)) {
                    JOptionPane.showMessageDialog(null, "Cabecera insertada correctamente");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al insertar");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos");
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }

    private void cargarRUC() {
        ProveedorDAO dao = new ProveedorDAO();
        List<String> rucs = dao.listarRUC();
        for(String ruc : rucs) {
            cmbRUC.addItem(ruc);
        }
    }
}
