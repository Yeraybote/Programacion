package Modelo;

import java.util.ArrayList;

public class Curso {
    String numero;
    String letra;
    ArrayList <Persona> listaAlumnos;

    public Curso(String numero, String letra) {
        this.numero = numero;
        this.letra = letra;
    }

    public Curso(String numero, String letra, ArrayList<Persona> listaAlumnos) {
        this.numero = numero;
        this.letra = letra;
        this.listaAlumnos = listaAlumnos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public ArrayList<Persona> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Persona> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
}
