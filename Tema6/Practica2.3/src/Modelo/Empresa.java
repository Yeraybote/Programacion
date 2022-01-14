package Modelo;

import java.util.ArrayList;

public class Empresa {
    String nombre;
    ArrayList <Empleado> listaEmpleados;
    ArrayList <Cliente> listaClientes;

    public Empresa(String nombre, ArrayList<Empleado> listaEmpleados, ArrayList<Cliente> listaClientes) {
        this.nombre = nombre;
        this.listaEmpleados = listaEmpleados;
        this.listaClientes = listaClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
