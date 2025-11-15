package com.mamajulit.Controller.Proveedores;

import com.mamajulit.View.Proveedores.ProveedorGestionView;

import javax.swing.*;

public class ProveedorGestionController {

    private final ProveedorGestionView view;

    public ProveedorGestionController(JPanel panelContenido) {

        view = new ProveedorGestionView();

        panelContenido.removeAll();
        panelContenido.add(view);
        panelContenido.revalidate();
        panelContenido.repaint();
    }
}
