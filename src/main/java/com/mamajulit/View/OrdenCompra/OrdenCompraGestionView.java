package com.mamajulit.View.OrdenCompra;

import com.mamajulit.Controller.OrdenCompra.OrdenCompraGestionController;
import com.mamajulit.DAO.OrdenCompraCabeceraDAO;
import com.mamajulit.DAO.ProductoDAO;
import com.mamajulit.Model.OrdenCompraCabecera;
import com.mamajulit.Model.OrdenCompraDetalle;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class OrdenCompraGestionView extends JPanel {

    private JTable tablaCabecera, tablaDetalle;
    private JButton btnAgregarCabecera, btnActualizarCabecera, btnEliminarCabecera;
    private JButton btnAgregarDetalle, btnActualizarDetalle, btnEliminarDetalle;
    private JTextField txtBuscar;
    private JComboBox<String> cmbFiltroOrden, cmbFiltroProducto;
    private final OrdenCompraGestionController controller = new OrdenCompraGestionController();

    public OrdenCompraGestionView() {
        setLayout(new BorderLayout());

        // --- PANEL SUPERIOR COMPLETO ---
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout(5,5));

        // --- BOTONES CRUD ---
        JPanel panelBotones = new JPanel(new GridLayout(2, 4, 5, 5));
        btnAgregarCabecera = new JButton("Agregar Cabecera");
        btnActualizarCabecera = new JButton("Actualizar Cabecera");
        btnEliminarCabecera = new JButton("Eliminar Cabecera");
        btnAgregarDetalle = new JButton("Agregar Detalle");
        btnActualizarDetalle = new JButton("Actualizar Detalle");
        btnEliminarDetalle = new JButton("Eliminar Detalle");
        JButton btnRefrescarCabecera = new JButton("Refrescar Cabecera");
        JButton btnRefrescarDetalle = new JButton("Refrescar Detalle");

        panelBotones.add(btnAgregarCabecera);
        panelBotones.add(btnActualizarCabecera);
        panelBotones.add(btnEliminarCabecera);
        panelBotones.add(btnRefrescarCabecera);
        panelBotones.add(btnAgregarDetalle);
        panelBotones.add(btnActualizarDetalle);
        panelBotones.add(btnEliminarDetalle);
        panelBotones.add(btnRefrescarDetalle);

        panelSuperior.add(panelBotones, BorderLayout.NORTH);

        // --- BUSCADOR Y FILTROS ---
        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,5));
        txtBuscar = new JTextField(20);
        txtBuscar.setToolTipText("Buscar en todas las columnas...");
        cmbFiltroOrden = new JComboBox<>();
        cmbFiltroProducto = new JComboBox<>();
        panelFiltros.add(new JLabel("Buscar:"));
        panelFiltros.add(txtBuscar);
        panelFiltros.add(new JLabel("Filtrar por Orden:"));
        panelFiltros.add(cmbFiltroOrden);
        panelFiltros.add(new JLabel("Filtrar por Producto:"));
        panelFiltros.add(cmbFiltroProducto);

        panelSuperior.add(panelFiltros, BorderLayout.SOUTH);

        add(panelSuperior, BorderLayout.NORTH);

        // --- TABLAS ---
        tablaCabecera = new JTable();
        tablaDetalle = new JTable();
        JScrollPane scrollCabecera = new JScrollPane(tablaCabecera);
        JScrollPane scrollDetalle = new JScrollPane(tablaDetalle);

        JPanel panelTablas = new JPanel(new GridLayout(2, 1, 0, 10));
        panelTablas.add(scrollCabecera);
        panelTablas.add(scrollDetalle);
        add(panelTablas, BorderLayout.CENTER);

        // --- CARGAR DATOS Y COMBOS ---
        listarCabeceras();
        listarDetalles();
        cargarCombosFiltro();

        // --- LISTENERS ---
        // Busqueda automática
        txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { filtrar(); }
            @Override public void removeUpdate(DocumentEvent e) { filtrar(); }
            @Override public void changedUpdate(DocumentEvent e) { filtrar(); }
        });

        // Filtros por combo
        cmbFiltroOrden.addActionListener(e -> filtrar());
        cmbFiltroProducto.addActionListener(e -> filtrar());

        // CRUD botones
        btnAgregarCabecera.addActionListener(e -> {
            OrdenCompraCabeceraInsertarDialog dialog = new OrdenCompraCabeceraInsertarDialog();
            dialog.setVisible(true);
            listarCabeceras();
            cargarCombosFiltro();
        });
        btnActualizarCabecera.addActionListener(e -> {
            int fila = tablaCabecera.getSelectedRow();
            if(fila >= 0) {
                String id = tablaCabecera.getValueAt(fila,0).toString();
                OrdenCompraCabecera c = controller.buscarCabeceraPorId(id);
                if(c!=null) {
                    OrdenCompraCabeceraActualizarDialog dialog = new OrdenCompraCabeceraActualizarDialog(c.getIdOrdenCompra());
                    dialog.setVisible(true);
                    listarCabeceras();
                    cargarCombosFiltro();
                }
            } else JOptionPane.showMessageDialog(null,"Seleccione cabecera para actualizar");
        });
        btnEliminarCabecera.addActionListener(e -> {
            int fila = tablaCabecera.getSelectedRow();
            if(fila >= 0) {
                String id = tablaCabecera.getValueAt(fila,0).toString();
                if(controller.eliminarCabecera(id)) {
                    JOptionPane.showMessageDialog(null,"Cabecera eliminada");
                    listarCabeceras();
                    cargarCombosFiltro();
                }
            } else JOptionPane.showMessageDialog(null,"Seleccione cabecera para eliminar");
        });
        btnRefrescarCabecera.addActionListener(e -> listarCabeceras());

        btnAgregarDetalle.addActionListener(e -> {
            OrdenCompraDetalleInsertarDialog dialog = new OrdenCompraDetalleInsertarDialog();
            dialog.setVisible(true);
            listarDetalles();
            cargarCombosFiltro();
        });
        btnActualizarDetalle.addActionListener(e -> {
            int fila = tablaDetalle.getSelectedRow();
            if(fila >= 0) {
                String id = tablaDetalle.getValueAt(fila,0).toString();
                OrdenCompraDetalle d = controller.buscarDetallePorId(id);
                if(d!=null) {
                    OrdenCompraDetalleActualizarDialog dialog = new OrdenCompraDetalleActualizarDialog(d);
                    dialog.setVisible(true);
                    listarDetalles();
                    cargarCombosFiltro();
                }
            } else JOptionPane.showMessageDialog(null,"Seleccione detalle para actualizar");
        });
        btnEliminarDetalle.addActionListener(e -> {
            int fila = tablaDetalle.getSelectedRow();
            if(fila >= 0) {
                String id = tablaDetalle.getValueAt(fila,0).toString();
                if(controller.eliminarDetalle(id)) {
                    JOptionPane.showMessageDialog(null,"Detalle eliminado");
                    listarDetalles();
                    cargarCombosFiltro();
                }
            } else JOptionPane.showMessageDialog(null,"Seleccione detalle para eliminar");
        });
        btnRefrescarDetalle.addActionListener(e -> listarDetalles());
    }

    // --- LISTAR DATOS ---
    private void listarCabeceras() {
        List<OrdenCompraCabecera> lista = controller.listarCabeceras();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "RUC", "Subtotal", "Total IGV"});
        if(lista!=null) {
            for(OrdenCompraCabecera c : lista)
                model.addRow(new Object[]{c.getIdOrdenCompra(), c.getRuc(), c.getSubtotal(), c.getTotalIgv()});
        }
        tablaCabecera.setModel(model);
    }

    private void listarDetalles() {
        List<OrdenCompraDetalle> lista = controller.listarDetalles();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
                "ID Detalle", "ID Orden", "Producto", "Unidad Solicitada",
                "Unidad Entrega", "Valor Unitario", "Importe"
        });
        if(lista!=null) {
            for(OrdenCompraDetalle d : lista)
                model.addRow(new Object[]{
                        d.getIdDetalle(), d.getIdOrdenCompra(), d.getIdProducto(),
                        d.getUnidadSolicitada(), d.getUnidadEntrega(), d.getValorUnitario(), d.getImporte()
                });
        }
        tablaDetalle.setModel(model);
    }

    // --- COMBOS FILTROS ---
    private void cargarCombosFiltro() {
        // Ordenes
        cmbFiltroOrden.removeAllItems();
        cmbFiltroOrden.addItem("Todos");
        OrdenCompraCabeceraDAO cabDAO = new OrdenCompraCabeceraDAO();
        for(String id : cabDAO.listarIds()) cmbFiltroOrden.addItem(id);

        // Productos
        cmbFiltroProducto.removeAllItems();
        cmbFiltroProducto.addItem("Todos");
        ProductoDAO prodDAO = new ProductoDAO();
        for(String id : prodDAO.listarIds()) cmbFiltroProducto.addItem(id);
    }

    // --- FILTRO AUTOMÁTICO ---
    private void filtrar() {
        String texto = txtBuscar.getText().toLowerCase();
        String ordenSel = cmbFiltroOrden.getSelectedItem() != null ? cmbFiltroOrden.getSelectedItem().toString() : "Todos";
        String prodSel = cmbFiltroProducto.getSelectedItem() != null ? cmbFiltroProducto.getSelectedItem().toString() : "Todos";

        // Filtrar cabecera
        List<OrdenCompraCabecera> listaC = controller.listarCabeceras();
        DefaultTableModel modelC = new DefaultTableModel();
        modelC.setColumnIdentifiers(new Object[]{"ID", "RUC", "Subtotal", "Total IGV"});
        if(listaC != null) {
            for(OrdenCompraCabecera c : listaC) {
                boolean coincide = (c.getIdOrdenCompra().toLowerCase().contains(texto) ||
                        c.getRuc().toLowerCase().contains(texto) ||
                        String.valueOf(c.getSubtotal()).contains(texto) ||
                        String.valueOf(c.getTotalIgv()).contains(texto));
                if(coincide) modelC.addRow(new Object[]{c.getIdOrdenCompra(), c.getRuc(), c.getSubtotal(), c.getTotalIgv()});
            }
        }
        tablaCabecera.setModel(modelC);

        // Filtrar detalle
        List<OrdenCompraDetalle> listaD = controller.listarDetalles();
        DefaultTableModel modelD = new DefaultTableModel();
        modelD.setColumnIdentifiers(new Object[]{
                "ID Detalle","ID Orden","Producto","Unidad Solicitada",
                "Unidad Entrega","Valor Unitario","Importe"
        });
        if(listaD != null) {
            for(OrdenCompraDetalle d : listaD) {
                boolean coincideTexto = (d.getIdDetalle().toLowerCase().contains(texto) ||
                        d.getIdOrdenCompra().toLowerCase().contains(texto) ||
                        String.valueOf(d.getIdProducto()).contains(texto) ||
                        d.getUnidadSolicitada().toLowerCase().contains(texto) ||
                        String.valueOf(d.getUnidadEntrega()).contains(texto) ||
                        String.valueOf(d.getValorUnitario()).contains(texto) ||
                        String.valueOf(d.getImporte()).contains(texto));
                boolean coincideOrden = ordenSel.equals("Todos") || d.getIdOrdenCompra().equals(ordenSel);
                boolean coincideProd = prodSel.equals("Todos") || String.valueOf(d.getIdProducto()).equals(prodSel);
                if(coincideTexto && coincideOrden && coincideProd)
                    modelD.addRow(new Object[]{
                            d.getIdDetalle(), d.getIdOrdenCompra(), d.getIdProducto(),
                            d.getUnidadSolicitada(), d.getUnidadEntrega(), d.getValorUnitario(), d.getImporte()
                    });
            }
        }
        tablaDetalle.setModel(modelD);
    }
}
