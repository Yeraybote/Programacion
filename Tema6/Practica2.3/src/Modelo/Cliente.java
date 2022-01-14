package Modelo;

import javax.swing.*;

public class Cliente extends Persona{
    int tlf;

    public Cliente(String nombre, int edad) {
        super(nombre, edad);
    }

    public Cliente(String nombre, int edad, int tlf) {
        super(nombre, edad);
        this.tlf = tlf;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public void mostrar(){
        JOptionPane.showMessageDialog(null,"Nombre: " + getNombre() + "\nEdad: " + getEdad() + "\nTeléfono: " + getTlf());
        /* String mensaje = "Nombre: " + getNombre() + "\nEdad: " + getEdad() + "\nTeléfono: " + getTlf();
        return mensaje; */
    }
}
