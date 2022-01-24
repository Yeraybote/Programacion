package com.company;

import Vista.VentanaPrincipal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// ArrayList <>
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void tenDatos(String nombre){
        // Persona p = new Persona(nombre);
        frame.tenDatos("pepe");
    }
}
