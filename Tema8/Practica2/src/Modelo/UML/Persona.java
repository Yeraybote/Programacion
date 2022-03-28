package Modelo.UML;
public class Persona {
    String nombre;
    String dni;
    Empresa emp;

    public Persona(String nombre, String dni, Empresa emp) {
        this.nombre = nombre;
        this.dni = dni;
        this.emp = emp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Empresa getEmp() {
        return emp;
    }

    public void setEmp(Empresa emp) {
        this.emp = emp;
    }
}
