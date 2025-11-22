package com.mamajulit.View.OrdenCompra;

import com.mamajulit.Controller.OrdenCompra.OrdenCompraDetalleActualizarController;
import com.mamajulit.DAO.OrdenCompraCabeceraDAO;
import com.mamajulit.DAO.ProductoDAO;
import com.mamajulit.Model.OrdenCompraDetalle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrdenCompraDetalleActualizarDialog extends JDialog {

    private final OrdenCompraDetalleActualizarController controller = new OrdenCompraDetalleActualizarController();

    private JTextField txtIdDetalle, txtUnidadSolicitada, txtUnidadEntrega, txtValor, txtImporte;
    private JComboBox<String> cmbOrden, cmbProducto;
    private JButton btnActualizar, btnCancelar;

    public OrdenCompraDetalleActualizarDialog(OrdenCompraDetalle d) {
        setTitle("Actualizar Orden de Compra - Detalle");
        setSize(450, 400);
        setModal(true);
        setLayout(null);
        setLocationRelativeTo(null);

        // --- CAMPOS ---
        txtIdDetalle = new JTextField(d.getIdDetalle());
        txtIdDetalle.setBounds(150, 20, 250, 25);
        txtIdDetalle.setEditable(false);

        cmbOrden = new JComboBox<>();
        cmbOrden.setBounds(150, 60, 250, 25);

        txtUnidadSolicitada = new JTextField(d.getUnidadSolicitada() != null ? d.getUnidadSolicitada() : "");
        txtUnidadSolicitada.setBounds(150, 100, 250, 25);

        txtUnidadEntrega = new JTextField(d.getUnidadEntrega() != null ? d.getUnidadEntrega().toString() : "");
        txtUnidadEntrega.setBounds(150, 140, 250, 25);

        txtValor = new JTextField(d.getValorUnitario() != null ? d.getValorUnitario().toString() : "");
        txtValor.setBounds(150, 180, 250, 25);

        txtImporte = new JTextField(d.getImporte() != null ? d.getImporte().toString() : "");
        txtImporte.setBounds(150, 220, 250, 25);
        txtImporte.setEditable(false);

        cmbProducto = new JComboBox<>();
        cmbProducto.setBounds(150, 260, 250, 25);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(50, 310, 120, 30);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(220, 310, 120, 30);

        // --- LABELS ---
        add(new JLabel("ID Detalle:")).setBounds(20, 20, 120, 25);
        add(new JLabel("ID Orden:")).setBounds(20, 60, 120, 25);
        add(new JLabel("Unidad Solicitada:")).setBounds(20, 100, 120, 25);
        add(new JLabel("Unidad Entrega:")).setBounds(20, 140, 120, 25);
        add(new JLabel("Valor Unitario:")).setBounds(20, 180, 120, 25);
        add(new JLabel("Importe:")).setBounds(20, 220, 120, 25);
        add(new JLabel("Producto:")).setBounds(20, 260, 120, 25);

        // --- AGREGAR CAMPOS ---
        add(txtIdDetalle); add(cmbOrden); add(txtUnidadSolicitada);
        add(txtUnidadEntrega); add(txtValor); add(txtImporte); add(cmbProducto);
        add(btnActualizar); add(btnCancelar);

        // --- CARGAR COMBOS ---
        cargarCombos(d);

        // --- BOTONES ---
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // VALIDACIONES
                String unidadSolicitada = txtUnidadSolicitada.getText().trim();
                if(unidadSolicitada.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese Unidad Solicitada");
                    return;
                }

                Integer unidadEntrega;
                try {
                    unidadEntrega = Integer.parseInt(txtUnidadEntrega.getText().trim());
                    if(unidadEntrega < 0) throw new NumberFormatException();
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese Unidad de Entrega válida");
                    return;
                }

                Float valorUnitario;
                try {
                    valorUnitario = Float.parseFloat(txtValor.getText().trim());
                    if(valorUnitario < 0) throw new NumberFormatException();
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese Valor Unitario válido");
                    return;
                }

                float importe = unidadEntrega * valorUnitario;
                txtImporte.setText(String.valueOf(importe));

                if(cmbOrden.getSelectedItem() == null || cmbProducto.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione Orden y Producto");
                    return;
                }

                // Actualizar objeto
                d.setIdOrdenCompra(cmbOrden.getSelectedItem().toString());
                d.setIdProducto(Integer.parseInt(cmbProducto.getSelectedItem().toString()));
                d.setUnidadSolicitada(unidadSolicitada);
                d.setUnidadEntrega(unidadEntrega);
                d.setValorUnitario(valorUnitario);
                d.setImporte(importe);

                // Ejecutar actualización
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

    private void cargarCombos(OrdenCompraDetalle d) {
        // Ordenes
        OrdenCompraCabeceraDAO cabDAO = new OrdenCompraCabeceraDAO();
        List<String> ordenes = cabDAO.listarIds();
        cmbOrden.removeAllItems();
        for(String o : ordenes) cmbOrden.addItem(o);
        cmbOrden.setSelectedItem(d.getIdOrdenCompra());

        // Productos
        ProductoDAO prodDAO = new ProductoDAO();
        List<String> productos = prodDAO.listarIds();
        cmbProducto.removeAllItems();
        for(String p : productos) cmbProducto.addItem(p);
        cmbProducto.setSelectedItem(String.valueOf(d.getIdProducto()));
    }
}
