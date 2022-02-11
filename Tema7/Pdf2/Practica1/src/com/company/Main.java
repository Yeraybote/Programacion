package com.company;
import Modelo.Cliente;
import Modelo.Producto;
import Modelo.Proveedor;
import Vista.Principal;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Producto> listaProductos = new ArrayList<>();
    public static ArrayList<Proveedor> listaProveedores = new ArrayList<>();
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static void main(String[] args) {
	ventanaPrincipal();
    crearProveedores();
    crearProductos();
    crearClientes();
    }

    public static void ventanaPrincipal () {
        Principal dialog = new Principal();
        dialog.setSize(450,450);
        dialog.setLocationRelativeTo(null); //Se coloca donde quiere.
        dialog.pack();
        dialog.setVisible(true);
    }
    public static void crearProveedores (){
        Proveedor p1 = new Proveedor("Carrefour",listaProductos);
        listaProveedores.add(p1);
        Proveedor p2 = new Proveedor("Game",listaProductos);
        listaProveedores.add(p2);
        Proveedor p3 = new Proveedor("Eroski",listaProductos);
        listaProveedores.add(p3);
        Proveedor p4 = new Proveedor("Mercadona",listaProductos);
        listaProveedores.add(p4);
    }
    public static void crearProductos (){
        Producto n1 = new Producto("Peras",35,1.5);
        listaProductos.add(n1);
        Producto n2 = new Producto("Manzanas",40,3);
        listaProductos.add(n2);
        Producto n3 = new Producto("FIFA 22",15,50);
        listaProductos.add(n3);
        Producto n4 = new Producto("Pollo",10,5);
        listaProductos.add(n4);
    }
    public static void crearClientes() {
        Cliente c1 = new Cliente("Yeray",500);
        listaClientes.add(c1);
        Cliente c2 = new Cliente("Aritz",600);
        listaClientes.add(c2);
        Cliente c3 = new Cliente("Nano",700);
        listaClientes.add(c3);
        Cliente c4 = new Cliente("Nacho",800);
        listaClientes.add(c4);
    }

}
