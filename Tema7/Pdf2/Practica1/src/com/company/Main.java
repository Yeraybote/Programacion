package com.company;

import Modelo.Producto;
import Vista.Principal;

import java.util.ArrayList;

public class Main {
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    public static void main(String[] args) {
	ventanaPrincipal();
    }

    public static void ventanaPrincipal () {
        Principal dialog = new Principal();
        // dialog.setLocationRelativeTo(null); Se coloca donde quiere.
        dialog.pack();
        dialog.setVisible(true);
    }
}
