package com.mamajulit.View.OrdenCompra;

import com.mamajulit.Controller.OrdenCompra.OrdenCompraDetalleInsertarController;
import com.mamajulit.DAO.OrdenCompraCabeceraDAO;
import com.mamajulit.DAO.ProductoDAO;
import com.mamajulit.Model.OrdenCompraDetalle;

import javax.swing.*;
import java.util.List;

public class OrdenCompraDetalleInsertarDialog extends JDialog {

    private final OrdenCompraDetalleInsertarController controller = new OrdenCompraDetalleInsertarController();

    private JTextField txtIdDetalle, txtUnidadSolicitada, txtUnidadEntrega, txtValorUnitario, txtImporte;
    private JComboBox<String> cmbOrden, cmbProducto;
    private JButton btnGuardar, btnCancelar;

    public OrdenCompraDetalleInsertarDialog() {
        setTitle("Insertar Detalle - Orden de Compra");
        setSize(450, 400);
        setModal(true);
        setLayout(null);

        // --- CAMPOS ---
        txtIdDetalle = new JTextField();
        txtIdDetalle.setBounds(150, 20, 250, 25);
        txtIdDetalle.setEditable(false);
        txtIdDetalle.setText(generarIdDetalle());

        cmbOrden = new JComboBox<>();
        cmbOrden.setBounds(150, 60, 250, 25);

        txtUnidadSolicitada = new JTextField();
        txtUnidadSolicitada.setBounds(150, 100, 250, 25);

        txtUnidadEntrega = new JTextField();
        txtUnidadEntrega.setBounds(150, 140, 250, 25);

        txtValorUnitario = new JTextField();
        txtValorUnitario.setBounds(150, 180, 250, 25);

        txtImporte = new JTextField();
        txtImporte.setBounds(150, 220, 250, 25);
        txtImporte.setEditable(false);

        cmbProducto = new JComboBox<>();
        cmbProducto.setBounds(150, 260, 250, 25);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 310, 120, 30);

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
        add(txtUnidadEntrega); add(txtValorUnitario); add(txtImporte); add(cmbProducto);
        add(btnGuardar); add(btnCancelar);

        // --- CARGAR COMBOS ---
        cargarCombos();

        // --- BOTONES ---
        btnGuardar.addActionListener(e -> guardarDetalle());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void cargarCombos() {
        // Cargar órdenes
        OrdenCompraCabeceraDAO cabDAO = new OrdenCompraCabeceraDAO();
        List<String> ordenes = cabDAO.listarIds();
        for (String o : ordenes) cmbOrden.addItem(o);

        // Cargar productos
        ProductoDAO prodDAO = new ProductoDAO();
        List<String> productos = prodDAO.listarIds();
        for (String p : productos) cmbProducto.addItem(p);
    }

    private String generarIdDetalle() {
        return controller.generarNuevoId();
    }

    private void guardarDetalle() {
        try {
            // Validaciones
            String idDetalle = txtIdDetalle.getText().trim();
            if(idDetalle.isEmpty()) { JOptionPane.showMessageDialog(this, "ID Detalle vacío"); return; }

            if(cmbOrden.getSelectedItem() == null) { JOptionPane.showMessageDialog(this, "Seleccione una Orden"); return; }
            if(cmbProducto.getSelectedItem() == null) { JOptionPane.showMessageDialog(this, "Seleccione un Producto"); return; }

            String unidadSolicitada = txtUnidadSolicitada.getText().trim();
            if(unidadSolicitada.isEmpty()) { JOptionPane.showMessageDialog(this, "Ingrese Unidad Solicitada"); return; }

            int unidadEntrega;
            try { unidadEntrega = Integer.parseInt(txtUnidadEntrega.getText().trim()); if(unidadEntrega < 0) throw new NumberFormatException(); }
            catch(NumberFormatException ex) { JOptionPane.showMessageDialog(this, "Unidad de Entrega inválida"); return; }

            float valorUnitario;
            try { valorUnitario = Float.parseFloat(txtValorUnitario.getText().trim()); if(valorUnitario < 0) throw new NumberFormatException(); }
            catch(NumberFormatException ex) { JOptionPane.showMessageDialog(this, "Valor Unitario inválido"); return; }

            // Calcular importe
            float importe = unidadEntrega * valorUnitario;
            txtImporte.setText(String.valueOf(importe));

            // Crear objeto
            OrdenCompraDetalle d = new OrdenCompraDetalle();
            d.setIdDetalle(idDetalle);
            d.setIdOrdenCompra(cmbOrden.getSelectedItem().toString());
            d.setUnidadSolicitada(unidadSolicitada);
            d.setUnidadEntrega(unidadEntrega);
            d.setValorUnitario(valorUnitario);
            d.setImporte(importe);
            d.setIdProducto(Integer.parseInt(cmbProducto.getSelectedItem().toString()));

            // Insertar
            if(controller.insertar(d)) {
                JOptionPane.showMessageDialog(this, "Detalle insertado correctamente");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al insertar detalle");
            }

        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
