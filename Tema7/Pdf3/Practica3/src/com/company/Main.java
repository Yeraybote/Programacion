package com.company;

import Modelo.Cliente;
import Modelo.Cuenta;
import Modelo.Movimientos;
import Vista.Principal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static ArrayList <Cliente> aClientes = new ArrayList();
    public static ArrayList<Cuenta> aCuentas = new ArrayList();
    public static ArrayList<Movimientos> aMovimientos = new ArrayList();

    public static void main(String[] args) {
	pestañaPrincipal();
    crearDatos();
    }

    public static void pestañaPrincipal(){
            JFrame frame = new JFrame("Principal");
            frame.setContentPane(new Principal().jPrincipal);
            frame.setSize(400,400);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
    }
    public static void crearDatos(){
        /* Creación de clientes */
        Cliente c1 = new Cliente("1234","58053266R","Yeray Bote");
        Cliente c2 = new Cliente("4321","111","Ankara Messi");
        aClientes.add(c1);
        aClientes.add(c2);

        /* Creación de cuentas */
        Cuenta u1 = new Cuenta(999,100);
        Cuenta u2 = new Cuenta(888,350);
        Cuenta u3 = new Cuenta(777,650);
        aCuentas.add(u1);
        aCuentas.add(u2);
        aCuentas.add(u3);

        /* Creación de movimientos */
        Movimientos m1 = new Movimientos("04/05/2003","Matricula gimnasio",-32);
        Movimientos m2 = new Movimientos("10/02/2021","Pintura",120);
        Movimientos m3 = new Movimientos("25/08/2022","Venta PS5",270);
        aMovimientos.add(m1);
        aMovimientos.add(m2);
        aMovimientos.add(m3);

        /* Crear relaciones */
        /* Null pointer exception
        aClientes.get(0).getListaCuentas().add(aCuentas.get(0));
        aClientes.get(0).getListaCuentas().add(aCuentas.get(1));
        aClientes.get(1).getListaCuentas().add(aCuentas.get(2)); */

        ArrayList mov1 = new ArrayList();
        mov1.add(aMovimientos.get(0));
        mov1.add(aMovimientos.get(1));
        mov1.add(aMovimientos.get(2));
        aCuentas.get(0).setListaMovimientos(mov1);

        ArrayList mov2 = new ArrayList();
        mov2.add(aMovimientos.get(1));
        aCuentas.get(1).setListaMovimientos(mov2);

        ArrayList mov3 = new ArrayList();
        mov3.add(aMovimientos.get(0));
        mov3.add(aMovimientos.get(2));
        aCuentas.get(0).setListaMovimientos(mov3);

        /* Null pointer exception
        aCuentas.get(0).getListaMovimientos().add(aMovimientos.get(0));
        aCuentas.get(0).getListaMovimientos().add(aMovimientos.get(1));
        aCuentas.get(1).getListaMovimientos().add(aMovimientos.get(2));
        aCuentas.get(2).getListaMovimientos().add(aMovimientos.get(1)); */
    }
    public static int comprobarCliente(String dni, String clave){
        int posicion = 0;
        for (int x = 0; x < aClientes.size(); x++) {
            if (aClientes.get(x).getDni().equals(dni) && aClientes.get(x).getClave().equals(clave)) {
                posicion = x;
            }
        }
        return posicion;
    }
}
