package com.company;

import Vista.Principal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	PestañaPrincipal();
    }

    public static void PestañaPrincipal(){
            JFrame frame = new JFrame("Principal");
            frame.setContentPane(new Principal().jPrincipal);
            frame.setSize(400,400);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

    }
}
