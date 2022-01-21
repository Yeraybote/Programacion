package com.company;

import Modelo.*;

import javax.swing.*;
<<<<<<< HEAD
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
=======
<<<<<<< HEAD
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
=======
<<<<<<< HEAD
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
=======
import java.util.ArrayList;
>>>>>>> master
>>>>>>> master
>>>>>>> master
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Excepciones.*;
<<<<<<< HEAD
import jdk.nashorn.internal.scripts.JO;
=======
<<<<<<< HEAD
import jdk.nashorn.internal.scripts.JO;
=======
<<<<<<< HEAD
import jdk.nashorn.internal.scripts.JO;
=======
>>>>>>> master
>>>>>>> master
>>>>>>> master

public class Main {

    // "Base de datos"
    private static ArrayList<Veterinario> listaVeterinarios;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
>>>>>>> master
    private static ArrayList<Cliente> listaClientes;
    private static ArrayList<Mascota> listaMascotas;
    private static int contadorGatos = 0;
    private static int contadorPerros = 0;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======

>>>>>>> master
>>>>>>> master
>>>>>>> master

    public static void main(String[] args) {
	    try
        {
<<<<<<< HEAD
            guardarDatos();
=======
<<<<<<< HEAD
            guardarDatos();
=======
<<<<<<< HEAD
            guardarDatos();
=======
            /* guardarDatos(); */
>>>>>>> master
>>>>>>> master
>>>>>>> master
            abrirMenu();
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"El programa termina");
        }
        catch(Exception e)
        {
            System.out.println("Problemas: " + e.getClass());
        }

    }

    public static void guardarDatos() throws Exception
    {
        // Solicitar, validar y guardar los datos de los clientes, de las mascotas y de los veterinarios.
        guardarVeterinarios();
<<<<<<< HEAD
        guardarClientes();
        guardarMascotas();
=======
<<<<<<< HEAD
        guardarClientes();
        guardarMascotas();
=======
<<<<<<< HEAD
        guardarClientes();
        guardarMascotas();
=======

>>>>>>> master
>>>>>>> master
>>>>>>> master
    }

    public static void guardarVeterinarios() throws Exception
    {
        boolean seguir = true;
        listaVeterinarios = new ArrayList<>();
        while(seguir)
        {
            listaVeterinarios.add(new Veterinario(
                    solicitarDato("Nombre","Teclea el nombre del veterinario","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$" ),
                    solicitarDato("Dirección","Teclea la dirección","^C/ [A-Z][a-z]+([ ][A-Z][a-z]+)* [0-9]{1,3} [0-9][a-zA-Z]$" ),
                    solicitarDato("Teléfono","Teclea el teléfono","^[6789][0-9]{8}$") ,
                    solicitarDato("DNI","Teclea el DNI","^[0-9]{8}[A-Za-z]$") ,
                    solicitarDato("Número de la seguridad social" , "Teclea el número de la seguridad social", "^01 [0-9]{8} [0-9]{2}$")));

            int respuesta = JOptionPane.showConfirmDialog(null,"¿Hay más veterinarios?");
            if (respuesta != 0)
                seguir = false;
        }
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
>>>>>>> master
    public static void guardarClientes() throws Exception
    {
        boolean seguir = true;
        listaClientes = new ArrayList<>();
        while(seguir)
        {
            listaClientes.add(new Cliente(
                    solicitarDato("Nombre","Teclea el nombre del cliente","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$" ),
                    solicitarDato("Dirección","Teclea la dirección","^C/ [A-Z][a-z]+([ ][A-Z][a-z]+)* [0-9]{1,3} [0-9][a-zA-Z]$" ),
                    solicitarDato("Teléfono","Teclea el teléfono","^[6789][0-9]{8}$") ));

            int respuesta = JOptionPane.showConfirmDialog(null,"¿Hay más clientes?");
            if (respuesta != 0)
                seguir = false;
        }
    }

    public static void guardarMascotas() throws Exception
    {
        String tipoanimal;
        float peso;
        float longitud;
        boolean seguir = true;
        listaMascotas = new ArrayList<>();
        while(seguir)
        {
            tipoanimal = JOptionPane.showInputDialog(null,"Perro o gato?");
            if (tipoanimal.toUpperCase(Locale.ROOT).equals("PERRO")){
                contadorPerros ++;
            } else contadorGatos++;
            listaMascotas.add(new Mascota(
                    solicitarDato("Raza","Teclea la raza de su mascota","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$" ),
                    solicitarDato("Nombre","Teclea el nombre de su mascota","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$" ),
                    LocalDate.now(),
                    peso  = Float.parseFloat(JOptionPane.showInputDialog(null,"Teclea el peso")),
                    solicitarDato("Sexo","Teclea el sexo","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$"),
                    longitud  = Float.parseFloat(JOptionPane.showInputDialog(null,"Teclea la longitud")),
                    solicitarDato("Color","Teclea el color","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$")));

            String nombredueño = solicitarDato("Nombre","Teclea el nombre de su dueño","^[A-Z][a-z]+([ ][A-Z][a-z]+)*$" );
            for (int x = 0; x < listaClientes.size(); x++) {
                if (listaClientes.get(x).getNombre().equals(nombredueño)) {
                    listaMascotas.get(x).setDueño(listaClientes.get(x));
                } else {
                    new Cliente(
                            nombredueño,
                            solicitarDato("Dirección","Teclea la dirección del cliente","^C/ [A-Z][a-z]+([ ][A-Z][a-z]+)* [0-9]{1,3} [0-9][a-zA-Z]$" ),
                            solicitarDato("Teléfono","Teclea el teléfono del cliente","^[6789][0-9]{8}$"));
                }
            }
            int respuesta = JOptionPane.showConfirmDialog(null,"¿Hay más mascotas?");
            if (respuesta != 0)
                seguir = false;
        }
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> master
>>>>>>> master
>>>>>>> master
    public static String solicitarDato(String dato, String mensaje,String exp) throws Exception
    {
        String variable="";
        boolean error = true;
        while(error)
        {
            try
            {
                variable = JOptionPane.showInputDialog(mensaje );
                if (variable.isEmpty())
                    throw new DatoNoValido(dato + " es un campo obligatorio");
                Pattern pat = Pattern.compile(exp);
                Matcher mat = pat.matcher(variable);
                if (!mat.matches())
                    throw new DatoNoValido(dato + " no tiene un formato adecuado");
                error = false;
            }
            catch(DatoNoValido e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        return variable;
    }


    public static void abrirMenu() throws Exception {
        int menu = 6;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione una opción: \n" +
<<<<<<< HEAD
                    "1. Nº clientes que poseen un tipo de animal concreto.\n" +
=======
<<<<<<< HEAD
                    "1. Nº clientes que poseen un tipo de animal concreto.\n" +
=======
<<<<<<< HEAD
                    "1. Nº clientes que poseen un tipo de animal concreto.\n" +
=======
                    "1. Mostrar el número de clientes que poseen un tipo de animal concreto.\n" +
>>>>>>> master
>>>>>>> master
>>>>>>> master
                    "2. Datos personales del cliente a partir del nombre de mascota.\n" +
                    "3. Datos del veterinario a partir de los datos de una mascota.\n" +
                    "4. Datos de las mascotas de un cliente.\n" +
                    "5. Datos de las mascotas de un veterinario.\n" +
                    "6. Terminar"));
        switch (menu) {
            case 1:
                f1();
                break;
            case 2:
                f2();
                break;
            case 3:
                f3();
                break;
            case 4:
                f4();
                break;
            case 5:
                f5();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "El programa ha finalizado");
                break;
        }

        } while (menu!=6);
    }

    public static void f1(){
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
>>>>>>> master
        String tipo = JOptionPane.showInputDialog(null,"Perros o gatos: ");
        if (tipo.toUpperCase(Locale.ROOT).equals("PERROS")) {
            JOptionPane.showMessageDialog(null,"Tenemos " + contadorPerros + " perros en nuestra clínica.");
        } else {
            JOptionPane.showMessageDialog(null,"Tenemos " + contadorGatos + " gatos en nuestra clínica.");
        }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======

>>>>>>> master
>>>>>>> master
>>>>>>> master
    }
    public static void f2(){
        String nombremascota = JOptionPane.showInputDialog(null,"Nombre de la mascota: ");
        for (int x = 0; x < listaMascotas.size(); x++){
            if (listaMascotas.get(x).getNombre().toUpperCase(Locale.ROOT).equals(nombremascota.toUpperCase(Locale.ROOT))){
                JOptionPane.showMessageDialog(null,"Nombre: " + listaMascotas.get(x).getDueño().getNombre()
                + "\nDirección: " + listaMascotas.get(x).getDueño().getDireccion()
                + "\nTeléfono: " + listaMascotas.get(x).getDueño().getTelefono());
            }
        }
    }
    public static void f3(){
        String nombremascota = JOptionPane.showInputDialog(null,"Nombre de la mascota: ");
        for (int x = 0; x < listaMascotas.size(); x++){
            if (listaMascotas.get(x).getNombre().toUpperCase(Locale.ROOT).equals(nombremascota.toUpperCase(Locale.ROOT))){
                JOptionPane.showMessageDialog(null,"Nombre: " + listaMascotas.get(x).getV().getNombre()
                        + "\nDirección: " + listaMascotas.get(x).getV().getDireccion()
                        + "\nTeléfono: " + listaMascotas.get(x).getV().getTelefono()
                        + "\nDNI: " + listaMascotas.get(x).getV().getDni()
                        + "\nNSS: " + listaMascotas.get(x).getV().getNss());
            }
        }
    }
    public static void f4(){
        String nombrecliente = JOptionPane.showInputDialog(null,"Nombre de la cliente: ");
        for (int x = 0; x < listaClientes.size(); x++){
            if (listaClientes.get(x).getListaMascotas().get(x).getDueño().equals(nombrecliente)) {
                JOptionPane.showMessageDialog(null, "Raza: " + listaClientes.get(x).getListaMascotas().get(x).getRaza()
                + "\nNombre: " + listaClientes.get(x).getListaMascotas().get(x).getNombre()
                + "\nFecha Nac: " + listaClientes.get(x).getListaMascotas().get(x).getFechaNacimiento()
                + "\nPeso: " + listaClientes.get(x).getListaMascotas().get(x).getPeso()
                + "\nSexo: " + listaClientes.get(x).getListaMascotas().get(x).getSexo()
                + "\nLongitud: " + listaClientes.get(x).getListaMascotas().get(x).getLongitud()
                + "\nColor: " + listaClientes.get(x).getListaMascotas().get(x).getColor());
            }
        }
    }
    public static void f5(){

    }
}
