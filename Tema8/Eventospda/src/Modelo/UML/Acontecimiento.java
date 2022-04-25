package Modelo.UML;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Acontecimiento {

    private String nombre;
    private String lugar;
    private LocalDate fecha;
    private LocalTime horaI;
    private LocalTime horaF;
    private Integer aforo;

    // Relación con personas
    private ArrayList<Persona> listaPersonas;

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersona(Persona p) {
        this.listaPersonas.add(p);
    }

    // Constructores
    public Acontecimiento() {
        this.listaPersonas = new ArrayList<>();
    }

    public Acontecimiento(String nombre)
    {
        this.nombre = nombre;
        this.listaPersonas = new ArrayList<>();
    }
    public Acontecimiento(String nombre, String lugar, LocalDate fecha, LocalTime horaI, LocalTime horaF, Integer aforo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaI = horaI;
        this.horaF = horaF;
        this.aforo = aforo;

        this.listaPersonas = new ArrayList<>();
    }

    // set y get
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public LocalTime getHoraI(){
        return horaI;
    }

    public void setHoraI(LocalTime horaI) {
        this.horaI = horaI;
    }

    public LocalTime getHoraF(){
        return horaF;
    }

    public void setHoraF(LocalTime horaF) {
        this.horaF = horaF;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer numeroAsistentes) {
        this.aforo = numeroAsistentes;
    }

    @Override
    public String toString(){
        return nombre + " " + lugar + " " + fecha + " " + getHoraI() + " " + getHoraF() + " "  + aforo;
    }
}
