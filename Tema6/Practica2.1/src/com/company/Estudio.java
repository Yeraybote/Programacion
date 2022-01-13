package com.company;

import java.util.ArrayList;

public class Estudio {
    String nombre;
    String ciudad;
    String direccion;
    String dirweb;
    String fecha;
    String pais;
    int tlf;

    public Estudio(String nombre, String ciudad, String direccion, String dirweb, String fecha, String pais, int tlf) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.dirweb = dirweb;
        this.fecha = fecha;
        this.pais = pais;
        this.tlf = tlf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDirweb() {
        return dirweb;
    }

    public void setDirweb(String dirweb) {
        this.dirweb = dirweb;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }
}
