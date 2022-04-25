package Modelo.UML;

import java.util.ArrayList;

public class Persona{

    private String dni;
    private String nombreApellidos;
    private String telefono;
    private String email;

    // Relaciones
    private ArrayList<Acontecimiento> lAcontecimientos;
    private Empresa e;

    public void setlAcontecimiento(Acontecimiento a)
    {
        this.lAcontecimientos.add(a);
    }

    public ArrayList<Acontecimiento> getlAcontecimientos() {
        return lAcontecimientos;
    }

    public Empresa getE() {
        return e;
    }

    public void setE(Empresa e) {
        this.e = e;
    }


    // Constructor
    public Persona(String dni, String nombreApellidos, String telefono, String email, Empresa e) {
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.telefono = telefono;
        this.email = email;
        this.e = e;
        this.lAcontecimientos = new ArrayList<>();
    }

    public Persona() {
        lAcontecimientos = new ArrayList<>();
    }

    // set y gets
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
