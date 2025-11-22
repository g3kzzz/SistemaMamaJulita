package com.mamajulit.View.OrdenCompra;

import com.mamajulit.Controller.OrdenCompra.OrdenCompraCabeceraInsertarController;
import com.mamajulit.DAO.EmpresaDAO;
import com.mamajulit.DAO.OrdenCompraCabeceraDAO;
import com.mamajulit.Model.ConexionBD;
import com.mamajulit.Model.Empresa;
import com.mamajulit.Model.OrdenCompraCabecera;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.List;

public class OrdenCompraCabeceraInsertarDialog extends JDialog {

    private final OrdenCompraCabeceraInsertarController controller = new OrdenCompraCabeceraInsertarController();

    private JTextField txtId, txtSubtotal, txtTotalIGV, txtTotalCargos, txtTotalDects, txtImporteTotal, txtMontoLetras;
    private JTextField txtAsignadoMinimo, txtAsignadoMaximo, txtPrecioMaximo, txtPrecioMinimo;
    private JTextField txtPuntoLlegada, txtPuntoPartida, txtCentroEntrega;
    private JComboBox<String> cmbRUC, cmbEmpleado, cmbTipoPago, cmbViaPago, cmbClaseDocumento, cmbAreaCompra;
    private JButton btnGuardar, btnCancelar;

    public OrdenCompraCabeceraInsertarDialog() {
        setTitle("Insertar Orden de Compra - Cabecera");
        setSize(600, 550);
        setModal(true);
        setLayout(null);

        int y = 20;
        int labelWidth = 130;
        int fieldWidth = 150;
        int height = 25;
        int gap = 35;

        // --- ID ---
        addLabel("ID:", 20, y, labelWidth, height);
        txtId = addTextField(150, y, fieldWidth, height);
        txtId.setEditable(false);
        txtId.setText(generarNuevoID());

        y += gap;

        // --- Asignado Min/Max ---
        addLabel("Asignado Min:", 20, y, labelWidth, height);
        txtAsignadoMinimo = addTextField(150, y, fieldWidth, height);
        addLabel("Asignado Max:", 320, y, labelWidth, height);
        txtAsignadoMaximo = addTextField(450, y, fieldWidth, height);

        y += gap;

        // --- Precio Min/Max ---
        addLabel("Precio Min:", 20, y, labelWidth, height);
        txtPrecioMinimo = addTextField(150, y, fieldWidth, height);
        addLabel("Precio Max:", 320, y, labelWidth, height);
        txtPrecioMaximo = addTextField(450, y, fieldWidth, height);

        y += gap;

        // --- Subtotal, Total IGV, Total Cargos, Total Dcts ---
        addLabel("Subtotal:", 20, y, labelWidth, height);
        txtSubtotal = addTextField(150, y, fieldWidth, height);
        addLabel("Total IGV:", 320, y, labelWidth, height);
        txtTotalIGV = addTextField(450, y, fieldWidth, height);

        y += gap;

        addLabel("Total Cargos:", 20, y, labelWidth, height);
        txtTotalCargos = addTextField(150, y, fieldWidth, height);
        addLabel("Total Deducciones:", 320, y, labelWidth, height);
        txtTotalDects = addTextField(450, y, fieldWidth, height);

        y += gap;

        // --- Importe Total y Monto Letras (calculados) ---
        addLabel("Importe Total:", 20, y, labelWidth, height);
        txtImporteTotal = addTextField(150, y, fieldWidth, height);
        txtImporteTotal.setEditable(false);
        addLabel("Monto Letras:", 320, y, labelWidth, height);
        txtMontoLetras = addTextField(450, y, fieldWidth, height);
        txtMontoLetras.setEditable(false);

        y += gap;

        // --- Puntos ---
        addLabel("Punto Llegada:", 20, y, labelWidth, height);
        txtPuntoLlegada = addTextField(150, y, fieldWidth, height);
        addLabel("Punto Partida:", 320, y, labelWidth, height);
        txtPuntoPartida = addTextField(450, y, fieldWidth, height);

        y += gap;

        // --- Centro Entrega ---
        addLabel("Centro Entrega:", 20, y, labelWidth, height);
        txtCentroEntrega = addTextField(150, y, fieldWidth, height);

        y += gap;

        // --- RUC (Empresa) ---
        addLabel("RUC Empresa:", 20, y, labelWidth, height);
        cmbRUC = new JComboBox<>();
        cmbRUC.setBounds(150, y, fieldWidth, height);
        cargarRUC();
        add(cmbRUC);

        // --- Empleado ---
        addLabel("Empleado (Com_nombre):", 320, y, labelWidth, height);
        cmbEmpleado = new JComboBox<>();
        cmbEmpleado.setBounds(450, y, fieldWidth, height);
        cargarEmpleados();
        add(cmbEmpleado);

        y += gap;

        // --- Area Compra, Tipo Pago, Via Pago, Clase Documento ---
        addLabel("Area Compra:", 20, y, labelWidth, height);
        cmbAreaCompra = new JComboBox<>(new String[]{"-- Seleccione --", "Aves", "Carnes", "Otros"});
        cmbAreaCompra.setBounds(150, y, fieldWidth, height);
        add(cmbAreaCompra);

        addLabel("Tipo Pago:", 320, y, labelWidth, height);
        cmbTipoPago = new JComboBox<>(new String[]{"-- Seleccione --", "Contado", "Crédito"});
        cmbTipoPago.setBounds(450, y, fieldWidth, height);
        add(cmbTipoPago);

        y += gap;

        addLabel("Via Pago:", 20, y, labelWidth, height);
        cmbViaPago = new JComboBox<>(new String[]{"-- Seleccione --", "Transferencia", "Cheque", "Otros"});
        cmbViaPago.setBounds(150, y, fieldWidth, height);
        add(cmbViaPago);

        addLabel("Clase Documento:", 320, y, labelWidth, height);
        cmbClaseDocumento = new JComboBox<>(new String[]{"-- Seleccione --", "Factura", "Boleta", "Otros"});
        cmbClaseDocumento.setBounds(450, y, fieldWidth, height);
        add(cmbClaseDocumento);

        y += gap;

        // --- Botones ---
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, y, 120, 30);
        add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(320, y, 120, 30);
        add(btnCancelar);

        // --- Eventos ---
        btnGuardar.addActionListener(e -> guardarCabecera());
        btnCancelar.addActionListener(e -> dispose());

        // --- Eventos de cálculo automático ---
        KeyAdapter recalcular = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calcularImporteTotal();
            }
        };

        txtSubtotal.addKeyListener(recalcular);
        txtTotalIGV.addKeyListener(recalcular);
        txtTotalCargos.addKeyListener(recalcular);
        txtTotalDects.addKeyListener(recalcular);
    }

    private void addLabel(String text, int x, int y, int w, int h) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, w, h);
        add(lbl);
    }

    private JTextField addTextField(int x, int y, int w, int h) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, w, h);
        add(tf);
        return tf;
    }

    private void cargarRUC() {
        EmpresaDAO dao = new EmpresaDAO();
        List<String> rucs = dao.listarRUC();
        cmbRUC.addItem("-- Seleccione --");
        for (String r : rucs) cmbRUC.addItem(r);
    }

    private void cargarEmpleados() {
        try (Connection conn = ConexionBD.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Id_empleado FROM empleado");
            cmbEmpleado.addItem("-- Seleccione --");
            while (rs.next()) {
                cmbEmpleado.addItem(rs.getString("Id_empleado"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar empleados: " + e.getMessage());
        }
    }

    private String generarNuevoID() {
        OrdenCompraCabeceraDAO dao = new OrdenCompraCabeceraDAO();
        String ultimoId = dao.obtenerUltimoId();
        int numero = 0;
        if (ultimoId != null && ultimoId.startsWith("OC")) {
            try { numero = Integer.parseInt(ultimoId.substring(2)); } catch (NumberFormatException ignored) {}
        }
        numero++;
        return String.format("OC%03d", numero);
    }

    private void calcularImporteTotal() {
        try {
            float subtotal = parseFloat(txtSubtotal.getText());
            float igv = parseFloat(txtTotalIGV.getText());
            float cargos = parseFloat(txtTotalCargos.getText());
            float dects = parseFloat(txtTotalDects.getText());
            float total = subtotal + igv + cargos - dects;
            txtImporteTotal.setText(String.format("%.2f", total));
            txtMontoLetras.setText(convertirNumeroALetras(total));
        } catch (NumberFormatException ignored) {}
    }

    private float parseFloat(String s) {
        if (s == null || s.isEmpty()) return 0f;
        return Float.parseFloat(s);
    }

    private String convertirNumeroALetras(float numero) {
        return "S/ " + String.format("%.2f", numero);
    }

    private void guardarCabecera() {
        if (cmbRUC.getSelectedIndex() <= 0) { showError("Seleccione un RUC"); return; }
        if (cmbEmpleado.getSelectedIndex() <= 0) { showError("Seleccione un Empleado"); return; }
        if (cmbTipoPago.getSelectedIndex() <= 0) { showError("Seleccione Tipo de Pago"); return; }
        if (cmbViaPago.getSelectedIndex() <= 0) { showError("Seleccione Vía de Pago"); return; }
        if (cmbClaseDocumento.getSelectedIndex() <= 0) { showError("Seleccione Clase Documento"); return; }
        if (cmbAreaCompra.getSelectedIndex() <= 0) { showError("Seleccione Área Compra"); return; }

        try {
            float asignMin = parseFloat(txtAsignadoMinimo.getText());
            float asignMax = parseFloat(txtAsignadoMaximo.getText());
            float precioMin = parseFloat(txtPrecioMinimo.getText());
            float precioMax = parseFloat(txtPrecioMaximo.getText());
            if (asignMin > asignMax) { showError("Asignado mínimo no puede ser mayor que máximo"); return; }
            if (precioMin > precioMax) { showError("Precio mínimo no puede ser mayor que máximo"); return; }
        } catch (NumberFormatException ex) {
            showError("Ingrese valores numéricos válidos para Asignado/Precio"); return;
        }

        // --- Verificar empresa ---
        String rucSeleccionado = cmbRUC.getSelectedItem().toString();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        if (empresaDAO.buscarPorRUC(rucSeleccionado) == null) {
            Empresa nueva = new Empresa(rucSeleccionado, "Nombre Empresa", "Razón Social", 1, "000000000");
            empresaDAO.insertar(nueva);
        }

        OrdenCompraCabecera c = new OrdenCompraCabecera();
        c.setIdOrdenCompra(txtId.getText());
        c.setAsignadoMinimo(Integer.parseInt(txtAsignadoMinimo.getText()));
        c.setAsignadoMaximo(Integer.parseInt(txtAsignadoMaximo.getText()));
        c.setPrecioMinimo(Float.parseFloat(txtPrecioMinimo.getText()));
        c.setPrecioMaximo(Float.parseFloat(txtPrecioMaximo.getText()));
        c.setSubtotal(parseFloat(txtSubtotal.getText()));
        c.setTotalIgv(parseFloat(txtTotalIGV.getText()));
        c.setTotalCargos(parseFloat(txtTotalCargos.getText()));
        c.setTotalDectsGlobal(parseFloat(txtTotalDects.getText()));
        c.setImporteTotal(parseFloat(txtImporteTotal.getText()));
        c.setMontoLetras(txtMontoLetras.getText());
        c.setPuntoLlegada(txtPuntoLlegada.getText());
        c.setPuntoPartida(txtPuntoPartida.getText());
        c.setCentroEntrega(txtCentroEntrega.getText());
        c.setRuc(rucSeleccionado);
        c.setComNombre(Integer.parseInt(cmbEmpleado.getSelectedItem().toString()));
        c.setAreaCompra(cmbAreaCompra.getSelectedItem().toString());
        c.setTipoPago(cmbTipoPago.getSelectedItem().toString());
        c.setViaPago(cmbViaPago.getSelectedItem().toString());
        c.setClaseDocumento(cmbClaseDocumento.getSelectedItem().toString());
        c.setFechaEmision(new java.sql.Date(System.currentTimeMillis()));
        c.setCancelado(false);

        if (controller.insertar(c)) {
            JOptionPane.showMessageDialog(this, "Cabecera insertada correctamente");
            dispose();
        } else {
            showError("Error al insertar cabecera");
        }
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
