package com.company;

import Modelo.BD.BaseDatos;
import Modelo.BD.EventosDAO;
import Modelo.UML.Eventos;
import Vista.CancelarEvento;
import Vista.CrearEvento;
import Vista.Principal;

import javax.swing.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    private static BaseDatos bd;
    private static EventosDAO edao;
    public static boolean error = true;
    public static void main(String[] args) {
        try {
            bd = new BaseDatos();
            edao = new EventosDAO(bd.getConnection());
            ventanaPrincipal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ventanaPrincipal(){
        JFrame frame = new JFrame("Principal");
        frame.setSize(200,200);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new Principal().jPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void ventanaCrearEvento(){
        JFrame frame = new JFrame("CrearEvento");
        frame.setSize(200,200);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new CrearEvento().jCrearEvento);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void ventanaCancelarEvento(){
        JFrame frame = new JFrame("CancelarEvento");
        frame.setSize(200,200);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new CancelarEvento().jCancelar);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static Time pasarStringTime(String hora) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        java.util.Date d1 =(java.util.Date)format.parse(hora);
        java.sql.Time hbuena = new java.sql.Time(d1.getTime());
        return hbuena;
    }

    public static void insertarDatos(Eventos ev) throws Exception {
        edao.registrarEvento(ev);
    }

    public static void eliminarEvento(String n){
        try {
            edao.eliminarEvento(n);
        } catch (Exception e) {
            e.printStackTrace();
            error = false;
        }
    }
}
