package Modelo;

import java.util.ArrayList;

public class Proveedor {
    String nombre;
    ArrayList <Producto> listaProductos;

    public Proveedor(String nombre, ArrayList<Producto> listaProductos) {
        this.nombre = nombre;
        this.listaProductos = listaProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
