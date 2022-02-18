package Modelo;

import java.util.ArrayList;

public class Cliente {
    String clave;
    String dni;
    String nombreApellidos;
    ArrayList <Cuenta> listaCuentas;

    public Cliente(String clave, String dni, String nombreApellidos) {
        this.clave = clave;
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
}
