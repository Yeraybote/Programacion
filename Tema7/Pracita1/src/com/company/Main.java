package com.company;
import Modelo.Persona;
import Vista.PanelPrincipal;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
	altapersonas();
    }

    public static void altapersonas(){
        JFrame frame = new JFrame("PanelPrincipal");
        frame.setContentPane(new PanelPrincipal().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }


    public static void crearpersona(String nombre, String apellido, String dni){

    }
}
