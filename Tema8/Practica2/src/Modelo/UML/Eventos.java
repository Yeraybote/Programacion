package Modelo.UML;

import java.sql.Time;
import java.time.LocalDate;

public class Eventos {
    private String nombre;
    private String lugar;
    private LocalDate fecha;
    private Time hinicio;
    private Time hfin;
    private int npersonas;

    public Eventos(String nombre, String lugar, LocalDate fecha, Time hinicio, Time hfin, int npersonas) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hinicio = hinicio;
        this.hfin = hfin;
        this.npersonas = npersonas;
    }

    public Eventos() {
    }

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

    public Time getHinicio() {
        return hinicio;
    }

    public void setHinicio(Time hinicio) {
        this.hinicio = hinicio;
    }

    public Time getHfin() {
        return hfin;
    }

    public void setHfin(Time hfin) {
        this.hfin = hfin;
    }

    public int getNpersonas() {
        return npersonas;
    }

    public void setNpersonas(int npersonas) {
        this.npersonas = npersonas;
    }
}
