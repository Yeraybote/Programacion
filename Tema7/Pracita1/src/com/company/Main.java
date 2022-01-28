package com.company;
import Modelo.Persona;
import Vista.PanelListaPersonas;
import Vista.PanelPrincipal;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
	altapersonas();
        // ArrayList <Persona> listaAlumnos = pillarDatos();
    listadoAlumnos();
    }

    public static void altapersonas(){
        JFrame frame = new JFrame("PanelPrincipal");
        frame.setContentPane(new PanelPrincipal().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void listadoAlumnos(){
        JFrame frame = new JFrame("PanelListaPersonas");
        frame.setContentPane(new PanelListaPersonas().Panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


    public static ArrayList pillarDatos(){
        return PanelPrincipal.getListapersonas();
    }
}
