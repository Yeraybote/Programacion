package com.company;

import Modelo.Persona;
import Vista.Principal;
import Vista.RegistrarPersona;
import Vista.VisualizarPersonas;
import Vista.VisualizarUnaPersona;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static boolean error;
    public static int posPersona = -1;
    public static int nveces = 0;
    public static void main(String[] args) {
        ventanaPrincipal();
    }
    public static void crearPersona(String nombre,String edad,String profesion,String telefono){
        try {
            int edad2 = Integer.parseInt(edad);
            Persona p1 = new Persona(nombre,edad2,profesion,telefono);
            posPersona ++;
            // 1. Cargar el controlador de acceso a datos
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Conectarse a la base de datos
            String url = "jdbc:mysql://localhost:3307/yeray";
            String user = "root";
            String passwd = "usbw";
            Connection con = DriverManager. getConnection (url , user ,
                    passwd);

            // 3. Construir comandos SQL
            Statement sentencia = con. createStatement ();
            String s = "insert into personas values ( '" +
                    p1.getNombre() + "','"+ p1.getEdad() + "','" + p1.getProfesion() + "','" +
                    p1.getTelefono() + "')";;
            sentencia . executeUpdate (s);

            // 4. Cerrar
            con.close ();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null,"Error, ha superado el limite de caracteres");
            error = false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error, has introducido un caracter alfanumerico en lugar de uno numerico");
            error = false;
        }
    }
    public static Persona recogerTodasPersonas(int n){
        Persona p = new Persona();
        try {
            // 1. Cargar el controlador de acceso a datos
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Conectarse a la base de datos
            String url = "jdbc:mysql://localhost:3307/yeray";
            String user = "root";
            String passwd = "usbw";
            Connection con = DriverManager. getConnection (url , user ,
                    passwd);

            // 3. Construir comandos SQL
            Statement sentencia = con.createStatement ();
            String s = "select nombre,edad,profesión,teléfono from personas;";
            ResultSet resultado = sentencia.executeQuery(s);
            if (n == 1) {
                p = pillarDatosSiguiente(resultado);
            } else {
                p = pillarDatosAnterior(resultado);
            }


            // 4. Cerrar
            con.close ();
            error = false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error, vuelva a intentarlo");
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null,"Esa persona no existe");
            error = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error, has introducido un caracter alfanumerico en lugar de uno numerico");
            error = true;
        }
        return p;
    }
    public static Persona pillarDatosSiguiente(ResultSet resultado){
        Persona p = new Persona();
        try {
            nveces++;
            for (int x=0; x < nveces;x++) {
                resultado.next();
            }

                String nombre = resultado.getString("nombre");
                int edad = resultado.getInt("edad");
                String pro = resultado.getString("profesión");
                String tel = resultado.getString("teléfono");
                p.setNombre(nombre);
                p.setEdad(edad);
                p.setProfesion(pro);
                p.setTelefono(tel);

        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null,"No hay mas personas");
        }
        return p;
    }
    public static Persona pillarDatosAnterior(ResultSet resultado){
        Persona p = new Persona();
        try {
            nveces--;
            for (int x=0; x < nveces;x++) {
                resultado.next();
            }
            String nombre = resultado.getString("nombre");
            int edad = resultado.getInt("edad");
            String pro = resultado.getString("profesión");
            String tel = resultado.getString("teléfono");
            p.setNombre(nombre);
            p.setEdad(edad);
            p.setProfesion(pro);
            p.setTelefono(tel);

        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null,"No hay mas personas");
        }
        return p;
    }
    public static Persona recogerDatosPersona(String n){
        Persona p = new Persona();
        try {
            // 1. Cargar el controlador de acceso a datos
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Conectarse a la base de datos
            String url = "jdbc:mysql://localhost:3307/yeray";
            String user = "root";
            String passwd = "usbw";
            Connection con = DriverManager. getConnection (url , user ,
                    passwd);

            // 3. Construir comandos SQL
            Statement sentencia = con.createStatement ();
            String s = "select nombre,edad,profesión,teléfono from personas where nombre ='"+ n +"';";
            ResultSet resultado = sentencia.executeQuery(s);
            resultado.next();
            n = resultado.getString("nombre");
            int edad = resultado.getInt("edad");
            String pro = resultado.getString("profesión");
            String tel = resultado.getString("teléfono");
            p.setNombre(n);
            p.setEdad(edad);
            p.setProfesion(pro);
            p.setTelefono(tel);

            // 4. Cerrar
            con.close ();
            error = false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error, vuelva a intentarlo");
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null,"Esa persona no existe");
            error = true;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error, has introducido un caracter alfanumerico en lugar de uno numerico");
            error = true;
        }
        return p;
    }
    public static void ventanaPrincipal(){
        JFrame frame = new JFrame("Principal");
        frame.setSize(200,200);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new Principal().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void ventanaCrearPersonas() throws Exception {
        JFrame frame = new JFrame("RegistrarPersona");
        frame.setSize(200,200);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new RegistrarPersona().jPersonas);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void ventanaUnaPersona() {
        JFrame frame = new JFrame("VisualizarUnaPersona");
        frame.setSize(200,200);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new VisualizarUnaPersona().jVisualizarUnaPersona);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void ventanaConsultarTodasPersonas(){
        JFrame frame = new JFrame("VisualizarPersonas");
        frame.setSize(200,200);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new VisualizarPersonas().jListaPersonas);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        nveces = 0;
    }
}
