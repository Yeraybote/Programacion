package com.company;

import Modelo.Producto;
import Vista.Principal;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Producto> listaProductos = new ArrayList();
    public static void main(String[] args) {
        crearProductos();
        panelPrincipal();

    }

    public static void panelPrincipal () {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new Principal().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void crearProductos () {
        Producto m = new Producto("Manzana",2,10);
        listaProductos.add(m);
        Producto p = new Producto("Pera",1.5,20);
        listaProductos.add(p);
        Producto l = new Producto("Platano",3,15);
        listaProductos.add(l);
        Producto u = new Producto("Uva",1,25);
        listaProductos.add(u);
        Producto s = new Producto("Sandia",5,5);
        listaProductos.add(s);
    }

    public static void validarProductos (String p) {
        String error = "si";
        for (int x = 0; x < listaProductos.size(); x++) {
            if (listaProductos.get(x).getNombre().equals(p)) {
                error = "no";
                break;
            }
        }
        if (error.equals("si")) {
            JOptionPane.showMessageDialog(null,"Ese producto no existe");
        }
    }

    public static void venderProductos (String p,String u){
        int unidad = Integer.parseInt(u);
        int x = 0;
        int posicion = 0;
        for (x = 0; x < listaProductos.size(); x++) {
            if (listaProductos.get(x).getNombre().equals(p)) {
                posicion = x;
                int total = listaProductos.get(x).getUnidades() - unidad;
                listaProductos.get(x).setUnidades(total);
                System.out.println("Quedan " + listaProductos.get(posicion).getUnidades() + " " + p);
            }
        }

    }
}
