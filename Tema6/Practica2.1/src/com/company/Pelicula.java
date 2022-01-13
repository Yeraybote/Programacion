package com.company;

import java.util.ArrayList;

public class Pelicula {
    String titulo;
    int año;
    int duracion;
    String tipo;
    ArrayList<Estudio> lEstudios;

    public Pelicula(String titulo, int año, int duracion, String tipo, ArrayList<Estudio> lEstudios) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.tipo = tipo;
        this.lEstudios = lEstudios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estudio> getlEstudios() {
        return lEstudios;
    }

    public void setlEstudios(ArrayList<Estudio> lEstudios) {
        this.lEstudios = lEstudios;
    }
}


