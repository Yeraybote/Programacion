package com.company;
import Modelo.Curso;
import Modelo.Persona;
import Vista.PanelPrincipal;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Currency;

public class Main {
    private static ArrayList<Persona> listaPersonas;
    public static void main(String[] args) {
        listaPersonas = new ArrayList();
	    altapersonas();
        Curso.rellenarCursos();
    }

    public static void altapersonas(){
        JFrame frame = new JFrame("PanelPrincipal");
        frame.setContentPane(new PanelPrincipal().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }



}
