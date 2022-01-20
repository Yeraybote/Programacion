package Modelo;

import java.time.LocalDate;

public class Mascota
{
    private String raza;
    private String nombre;
    private LocalDate fechaNacimiento;
    private float peso;
    private String sexo;
    private float longitud;
    private String color;

    private Cliente dueño;
    private Veterinario v;

    public Mascota(String raza, String nombre, LocalDate fechaNacimiento, float peso, String sexo, float longitud, String color) {
        this.raza = raza;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.sexo = sexo;
        this.longitud = longitud;
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cliente getDueño() {
        return dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public Veterinario getV() {
        return v;
    }

    public void setV(Veterinario v) {
        this.v = v;
    }
}
