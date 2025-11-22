package com.mamajulit.View.OrdenCompra;

import com.mamajulit.DAO.EmpresaDAO;
import com.mamajulit.DAO.OrdenCompraCabeceraDAO;
import com.mamajulit.Model.OrdenCompraCabecera;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class OrdenCompraCabeceraActualizarDialog extends JDialog {

    private JTextField txtId, txtSubtotal, txtTotalIGV, txtTotalCargos, txtTotalDects, txtImporteTotal, txtMontoLetras;
    private JTextField txtAsignadoMinimo, txtAsignadoMaximo, txtPrecioMinimo, txtPrecioMaximo;
    private JTextField txtPuntoLlegada, txtPuntoPartida, txtCentroEntrega;
    private JComboBox<String> cmbRUC, cmbTipoPago, cmbViaPago, cmbClaseDocumento, cmbAreaCompra;
    private JButton btnActualizar, btnCancelar;

    private final OrdenCompraCabeceraDAO dao = new OrdenCompraCabeceraDAO();

    public OrdenCompraCabeceraActualizarDialog(String idOrden) {
        setTitle("Actualizar Orden de Compra - Cabecera");
        setSize(600, 500);
        setLayout(null);
        setModal(true);

        // --- ID ---
        addLabel("ID:", 20, 20, 130, 25);
        txtId = addTextField(150, 20, 150, 25);
        txtId.setEditable(false);

        // --- Asignado Min/Max ---
        addLabel("Asignado Min:", 20, 60, 130, 25);
        txtAsignadoMinimo = addTextField(150, 60, 150, 25);
        addLabel("Asignado Max:", 320, 60, 130, 25);
        txtAsignadoMaximo = addTextField(450, 60, 150, 25);

        // --- Precio Min/Max ---
        addLabel("Precio Min:", 20, 100, 130, 25);
        txtPrecioMinimo = addTextField(150, 100, 150, 25);
        addLabel("Precio Max:", 320, 100, 130, 25);
        txtPrecioMaximo = addTextField(450, 100, 150, 25);

        // --- Subtotal, IGV, Cargos, Deducciones ---
        addLabel("Subtotal:", 20, 140, 130, 25);
        txtSubtotal = addTextField(150, 140, 150, 25);
        addLabel("Total IGV:", 320, 140, 130, 25);
        txtTotalIGV = addTextField(450, 140, 150, 25);

        addLabel("Total Cargos:", 20, 180, 130, 25);
        txtTotalCargos = addTextField(150, 180, 150, 25);
        addLabel("Total Deducciones:", 320, 180, 130, 25);
        txtTotalDects = addTextField(450, 180, 150, 25);

        // --- Importe total y letras ---
        addLabel("Importe Total:", 20, 220, 130, 25);
        txtImporteTotal = addTextField(150, 220, 150, 25);
        txtImporteTotal.setEditable(false);
        addLabel("Monto Letras:", 320, 220, 130, 25);
        txtMontoLetras = addTextField(450, 220, 150, 25);
        txtMontoLetras.setEditable(false);

        // --- Puntos ---
        addLabel("Punto Llegada:", 20, 260, 130, 25);
        txtPuntoLlegada = addTextField(150, 260, 150, 25);
        addLabel("Punto Partida:", 320, 260, 130, 25);
        txtPuntoPartida = addTextField(450, 260, 150, 25);

        // --- Centro entrega ---
        addLabel("Centro Entrega:", 20, 300, 130, 25);
        txtCentroEntrega = addTextField(150, 300, 150, 25);

        // --- RUC ---
        addLabel("RUC Empresa:", 320, 300, 130, 25);
        cmbRUC = new JComboBox<>();
        cmbRUC.setBounds(450, 300, 150, 25);
        cargarRUC();
        add(cmbRUC);

        // --- Área Compra ---
        addLabel("Área Compra:", 20, 340, 130, 25);
        cmbAreaCompra = new JComboBox<>(new String[]{"--Seleccione--","Aves","Carnes","Otros"});
        cmbAreaCompra.setBounds(150, 340, 150, 25);
        add(cmbAreaCompra);

        // --- Tipo Pago ---
        addLabel("Tipo Pago:", 320, 340, 130, 25);
        cmbTipoPago = new JComboBox<>(new String[]{"--Seleccione--","Contado","Crédito"});
        cmbTipoPago.setBounds(450, 340, 150, 25);
        add(cmbTipoPago);

        // --- Vía Pago ---
        addLabel("Vía Pago:", 20, 380, 130, 25);
        cmbViaPago = new JComboBox<>(new String[]{"--Seleccione--","Transferencia","Cheque","Otros"});
        cmbViaPago.setBounds(150, 380, 150, 25);
        add(cmbViaPago);

        // --- Clase Documento ---
        addLabel("Clase Documento:", 320, 380, 130, 25);
        cmbClaseDocumento = new JComboBox<>(new String[]{"--Seleccione--","Factura","Boleta","Otros"});
        cmbClaseDocumento.setBounds(450, 380, 150, 25);
        add(cmbClaseDocumento);

        // --- Botones ---
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(150, 420, 120, 30);
        add(btnActualizar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(320, 420, 120, 30);
        add(btnCancelar);

        // --- Eventos ---
        btnCancelar.addActionListener(e -> dispose());
        btnActualizar.addActionListener(e -> actualizarCabecera());

        // --- Cargar datos actuales ---
        cargarDatos(idOrden);

        // --- Recalculo automático ---
        KeyAdapter recalcular = new KeyAdapter() {
            public void keyReleased(KeyEvent e){ calcularImporteTotal();}
        };
        txtSubtotal.addKeyListener(recalcular);
        txtTotalIGV.addKeyListener(recalcular);
        txtTotalCargos.addKeyListener(recalcular);
        txtTotalDects.addKeyListener(recalcular);
    }

    private void addLabel(String t,int x,int y,int w,int h){ JLabel lbl=new JLabel(t); lbl.setBounds(x,y,w,h); add(lbl);}
    private JTextField addTextField(int x,int y,int w,int h){ JTextField tf=new JTextField(); tf.setBounds(x,y,w,h); add(tf); return tf;}

    private void cargarRUC(){
        EmpresaDAO dao=new EmpresaDAO();
        List<String> rucs=dao.listarRUC();
        cmbRUC.addItem("--Seleccione--");
        for(String r:rucs) cmbRUC.addItem(r);
    }

    private void cargarDatos(String idOrden){
        OrdenCompraCabecera c = dao.obtenerPorId(idOrden);
        if(c==null){ JOptionPane.showMessageDialog(this,"Orden no encontrada"); dispose(); return; }

        txtId.setText(c.getIdOrdenCompra());
        txtAsignadoMinimo.setText(String.valueOf(c.getAsignadoMinimo()));
        txtAsignadoMaximo.setText(String.valueOf(c.getAsignadoMaximo()));
        txtPrecioMinimo.setText(String.valueOf(c.getPrecioMinimo()));
        txtPrecioMaximo.setText(String.valueOf(c.getPrecioMaximo()));
        txtSubtotal.setText(String.valueOf(c.getSubtotal()));
        txtTotalIGV.setText(String.valueOf(c.getTotalIgv()));
        txtTotalCargos.setText(String.valueOf(c.getTotalCargos()));
        txtTotalDects.setText(String.valueOf(c.getTotalDectsGlobal()));
        txtImporteTotal.setText(String.valueOf(c.getImporteTotal()));
        txtMontoLetras.setText(c.getMontoLetras());
        txtPuntoLlegada.setText(c.getPuntoLlegada());
        txtPuntoPartida.setText(c.getPuntoPartida());
        txtCentroEntrega.setText(c.getCentroEntrega());

        cmbRUC.setSelectedItem(c.getRuc());
        cmbAreaCompra.setSelectedItem(c.getAreaCompra());
        cmbTipoPago.setSelectedItem(c.getTipoPago());
        cmbViaPago.setSelectedItem(c.getViaPago());
        cmbClaseDocumento.setSelectedItem(c.getClaseDocumento());
    }

    private void calcularImporteTotal(){
        try{
            float subtotal=Float.parseFloat(txtSubtotal.getText());
            float igv=Float.parseFloat(txtTotalIGV.getText());
            float cargos=Float.parseFloat(txtTotalCargos.getText());
            float dects=Float.parseFloat(txtTotalDects.getText());
            float total=subtotal+igv+cargos-dects;
            txtImporteTotal.setText(String.format("%.2f", total));
            txtMontoLetras.setText("S/ "+String.format("%.2f", total));
        }catch(Exception ignored){}
    }

    private void actualizarCabecera(){
        try{
            OrdenCompraCabecera c = new OrdenCompraCabecera();
            c.setIdOrdenCompra(txtId.getText());
            c.setAsignadoMinimo(Integer.parseInt(txtAsignadoMinimo.getText()));
            c.setAsignadoMaximo(Integer.parseInt(txtAsignadoMaximo.getText()));
            c.setPrecioMinimo(Float.parseFloat(txtPrecioMinimo.getText()));
            c.setPrecioMaximo(Float.parseFloat(txtPrecioMaximo.getText()));
            c.setSubtotal(Float.parseFloat(txtSubtotal.getText()));
            c.setTotalIgv(Float.parseFloat(txtTotalIGV.getText()));
            c.setTotalCargos(Float.parseFloat(txtTotalCargos.getText()));
            c.setTotalDectsGlobal(Float.parseFloat(txtTotalDects.getText()));
            c.setImporteTotal(Float.parseFloat(txtImporteTotal.getText()));
            c.setMontoLetras(txtMontoLetras.getText());
            c.setPuntoLlegada(txtPuntoLlegada.getText());
            c.setPuntoPartida(txtPuntoPartida.getText());
            c.setCentroEntrega(txtCentroEntrega.getText());
            c.setRuc(cmbRUC.getSelectedItem().toString());
            c.setAreaCompra(cmbAreaCompra.getSelectedItem().toString());
            c.setTipoPago(cmbTipoPago.getSelectedItem().toString());
            c.setViaPago(cmbViaPago.getSelectedItem().toString());
            c.setClaseDocumento(cmbClaseDocumento.getSelectedItem().toString());
            c.setFechaEmision(new java.sql.Date(System.currentTimeMillis()));
            c.setCancelado(false);

            if(dao.actualizar(c)){
                JOptionPane.showMessageDialog(this,"Cabecera actualizada correctamente");
                dispose();
            } else JOptionPane.showMessageDialog(this,"Error al actualizar cabecera");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
        }
    }
}
