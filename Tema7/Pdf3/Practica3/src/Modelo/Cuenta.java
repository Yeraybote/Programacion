package Modelo;

public class Cuenta {
    int clave;
    String dni;

    public Cuenta(int clave, String dni) {
        this.clave = clave;
        this.dni = dni;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
