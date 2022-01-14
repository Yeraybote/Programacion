package Modelo;

import javax.swing.*;

public class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrar(){
        JOptionPane.showMessageDialog(null,"Nombre: " + getNombre() + "\nEdad: " + getEdad());
        /* String mensaje = "Nombre: " + getNombre() + "\nEdad: " + getEdad();
        return mensaje; */
    }
}
