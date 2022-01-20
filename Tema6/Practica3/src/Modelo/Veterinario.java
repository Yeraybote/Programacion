package Modelo;

import java.util.ArrayList;

public class Veterinario extends Persona
{
    private String dni;
    private String nss;

    public Veterinario(String nombre, String direccion, String telefono, String dni, String nss) {
        super(nombre, direccion, telefono);
        this.dni = dni;
        this.nss = nss;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

}
