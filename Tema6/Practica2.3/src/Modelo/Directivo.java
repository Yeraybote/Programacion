package Modelo;

import javax.swing.*;
import java.util.ArrayList;

public class Directivo extends Empleado{
    String categoria;
    ArrayList <Empleado> listaEmpleDir;

    public Directivo(String nombre, int edad, int sueldoBruto) {
        super(nombre, edad, sueldoBruto);
    }

    public Directivo(String nombre, int edad, int sueldoBruto, String categoria, ArrayList<Empleado> listaEmpleDir) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
        this.listaEmpleDir = listaEmpleDir;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Empleado> getListaEmpleDir() {
        return listaEmpleDir;
    }

    public void setListaEmpleDir(ArrayList<Empleado> listaEmpleDir) {
        this.listaEmpleDir = listaEmpleDir;
    }

    public void mostrar(){
        JOptionPane.showMessageDialog(null,"Nombre: " + getNombre() + "\nEdad: " + getEdad() + "\nSueldo bruto: " + getSueldoBruto() + "\nCategoria: " + getCategoria());
        /* String mensaje = "Nombre: " + getNombre() + "\nEdad: " + getEdad() + "\nSueldo bruto: " + getSueldoBruto() + "\nCategoria: " + getCategoria();
        return mensaje; */
    }
}
