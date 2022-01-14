package Modelo;

import javax.swing.*;

public class Empleado extends Persona{
    int sueldoBruto;

    public Empleado(String nombre, int edad) {
        super(nombre, edad);
    }

    public Empleado(String nombre, int edad, int sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }

    public int getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(int sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public void mostrar(){
        JOptionPane.showMessageDialog(null,"Nombre: " + getNombre() + "\nEdad: " + getEdad() + "\nSueldo bruto: " + getSueldoBruto());
        /* String mensaje = "Nombre: " + getNombre() + "\nEdad: " + getEdad() + "\nSueldo bruto: " + getSueldoBruto();
        return mensaje; */
    }

    public void calcularSalario() {
    }
}
