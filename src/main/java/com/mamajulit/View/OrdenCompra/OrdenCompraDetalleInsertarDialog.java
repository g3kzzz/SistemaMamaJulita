package com.mamajulit.View.OrdenCompra;

import com.mamajulit.Controller.OrdenCompra.OrdenCompraDetalleInsertarController;
import com.mamajulit.DAO.ProductoDAO;
import com.mamajulit.DAO.OrdenCompraCabeceraDAO;
import com.mamajulit.Model.OrdenCompraDetalle;

import javax.swing.*;
import java.util.List;

public class OrdenCompraDetalleInsertarDialog extends JDialog {

    private final OrdenCompraDetalleInsertarController controller = new OrdenCompraDetalleInsertarController();
    private JTextField txtIdDetalle, txtUnidad, txtValor, txtImporte;
    private JComboBox<String> cmbProducto, cmbOrden;
    private JButton btnGuardar, btnCancelar;

    public OrdenCompraDetalleInsertarDialog() {
        setTitle("Insertar Detalle - Orden de Compra");
        setSize(400, 350);
        setModal(true);
        setLayout(null);

        txtIdDetalle = new JTextField(); txtIdDetalle.setBounds(150, 20, 200, 25);
        txtUnidad = new JTextField(); txtUnidad.setBounds(150, 100, 200, 25);
        txtValor = new JTextField(); txtValor.setBounds(150, 140, 200, 25);
        txtImporte = new JTextField(); txtImporte.setBounds(150, 180, 200, 25);

        cmbOrden = new JComboBox<>(); cmbOrden.setBounds(150, 60, 200, 25);
        cmbProducto = new JComboBox<>(); cmbProducto.setBounds(150, 220, 200, 25);
        cargarCombos();

        btnGuardar = new JButton("Guardar"); btnGuardar.setBounds(50, 260, 100, 30);
        btnCancelar = new JButton("Cancelar"); btnCancelar.setBounds(200, 260, 100, 30);

        add(new JLabel("ID Detalle:")).setBounds(20, 20, 120, 25);
        add(new JLabel("ID Orden:")).setBounds(20, 60, 120, 25);
        add(new JLabel("Unidad:")).setBounds(20, 100, 120, 25);
        add(new JLabel("Valor Unitario:")).setBounds(20, 140, 120, 25);
        add(new JLabel("Importe:")).setBounds(20, 180, 120, 25);
        add(new JLabel("Producto:")).setBounds(20, 220, 120, 25);

        add(txtIdDetalle); add(cmbOrden); add(txtUnidad);
        add(txtValor); add(txtImporte); add(cmbProducto);
        add(btnGuardar); add(btnCancelar);

        btnGuardar.addActionListener(e -> {
            try {
                OrdenCompraDetalle d = new OrdenCompraDetalle();
                d.setIdDetalle(txtIdDetalle.getText());
                d.setIdOrdenCompra(cmbOrden.getSelectedItem().toString());
                d.setUnidadSolicitada(txtUnidad.getText());
                d.setValorUnitario(Float.parseFloat(txtValor.getText()));
                d.setImporte(Float.parseFloat(txtImporte.getText()));
                d.setIdProducto(Integer.parseInt(cmbProducto.getSelectedItem().toString()));

                if(controller.insertar(d)) {
                    JOptionPane.showMessageDialog(null, "Detalle insertado correctamente");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al insertar");
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Ingrese valores válidos");
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }

    private void cargarCombos() {
        // Cargar ordenes existentes
        OrdenCompraCabeceraDAO cabDAO = new OrdenCompraCabeceraDAO();
        List<String> ordenes = cabDAO.listarIds();
        for(String o : ordenes) cmbOrden.addItem(o);

        // Cargar productos existentes
        ProductoDAO prodDAO = new ProductoDAO();
        List<String> productos = prodDAO.listarIds();
        for(String p : productos) cmbProducto.addItem(p);
    }
}
