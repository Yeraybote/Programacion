package com.company;
import Modelo.Cliente;
import Modelo.Directivo;
import Modelo.Empleado;
import Modelo.Empresa;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static ArrayList <Empleado> aEmpleados = new ArrayList<>();
    static ArrayList <Cliente> aCliente = new ArrayList<>();
    static ArrayList <Directivo> aDirectivo = new ArrayList<>();
    static ArrayList <Empresa> aEmpresa = new ArrayList<>();

    public static void main(String[] args) {
        crearEmpleados();
        crearClientes();
        crearDirectivos();
        crearEmpresas();
        masSubordinados();
    }

    public static void crearEmpleados(){
        Empleado peter = new Empleado("Peter",23,1200);
        aEmpleados.add(peter);
        Empleado ander = new Empleado("Ander",21,1300);
        aEmpleados.add(ander);
        Empleado manuel = new Empleado("Manuel",20,1400);
        aEmpleados.add(manuel);
        Empleado juan = new Empleado("Juan",54,1900);
        aEmpleados.add(juan);
    }
    public static void crearClientes(){
        Cliente cli1 = new Cliente("Ruben",21,111111111);
        aCliente.add(cli1);
        Cliente cli2 = new Cliente("Eneko",21,222222222);
        aCliente.add(cli2);
        Cliente cli3 = new Cliente("Imanol",21,333333333);
        aCliente.add(cli3);
    }
    public static void crearDirectivos(){
        ArrayList <Empleado> lista;


        /* Creacion del dir Yeray */
        lista = new ArrayList();
        lista.add(aEmpleados.get(0));
        lista.add(aEmpleados.get(1));
        lista.add(aEmpleados.get(2));
        Directivo dir1 = new Directivo("Yeray",18,2000,"Marketing",lista);
        aDirectivo.add(dir1);

        /* Creacion del dir Aritz */
        lista = new ArrayList();
        lista.add(aEmpleados.get(0));
        lista.add(aEmpleados.get(3));
        Directivo dir2 = new Directivo("Aritz",14,2200,"Notario",lista);
        aDirectivo.add(dir2);

        /* Creacion del dir Nacho */
        lista = new ArrayList();
        lista.add(aEmpleados.get(0));
        lista.add(aEmpleados.get(1));
        lista.add(aEmpleados.get(2));
        lista.add(aEmpleados.get(3));
        Directivo dir3 = new Directivo("Nacho",23,2500,"Relaciones Publicas",lista);
        aDirectivo.add(dir3);
    }
    public static void crearEmpresas(){
        Empresa emp1 = new Empresa("RUINASA",aEmpleados,aCliente);
        aEmpresa.add(emp1);
    }
    public static void masSubordinados(){
        int maximo = 0;
        int posicion = 0;
        for (int x = 0; x < aDirectivo.size(); x++) {
            if (aDirectivo.get(x).getListaEmpleDir().size() > maximo) {
                maximo = aDirectivo.get(x).getListaEmpleDir().size();
                posicion = x;
            }
        }
        JOptionPane.showMessageDialog(null,"El directivo con mas subordinador es " +
                aDirectivo.get(posicion).getNombre() + " con " + maximo + " subordinados");
    }
}


