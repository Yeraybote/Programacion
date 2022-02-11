package Modelo;

import java.util.ArrayList;

public class Cliente {
    String nombre;
    double monedero;

    public Cliente(String nombre, double monedero) {
        this.nombre = nombre;
        this.monedero = monedero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonedero() {
        return monedero;
    }

    public void setMonedero(double monedero) {
        this.monedero = monedero;
    }
}
