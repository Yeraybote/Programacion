import static javax.swing.JOptionPane.*;
public class Alumnos {
    String codigo;
    String nombre;
    String domicilio;
    String telefono;

    public Alumnos(String codigo, String nombre, String domicilio, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }
    public Alumnos() {
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {this.domicilio = domicilio;}
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "INFORMACIÓN DEL ALUMNO " + codigo
                + "\n Nombre: " + nombre
                + "\n Domicilio: " + domicilio
                + "\n Teléfono: " + telefono;
    }
}
