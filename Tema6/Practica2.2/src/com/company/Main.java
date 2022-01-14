package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static ArrayList <Pelicula> aPeliculas = new ArrayList<>();
    static ArrayList <Estudio> aEstudios = new ArrayList<>();
    public static void main(String[] args) {
        Estudio yeray = new Estudio("Yeray","Vitoria-Gasteiz", "C/Extremadura","www.yeray.com","04/05/2003","España",625200594);
        Estudio bote = new Estudio("Bote","Galicia", "C/Errr","www.bote.com","15/03/2007","España",312313132);
        aEstudios.add(yeray);
        aEstudios.add(bote);

        ArrayList <Estudio> listaEstudios = new ArrayList<>();
        listaEstudios.add(aEstudios.get(0));
        listaEstudios.add(aEstudios.get(1));
        Pelicula avatar = new Pelicula("Avatar",2003,120,"Fantasia",listaEstudios);
        Pelicula spiderman = new Pelicula("Spiderman",2021,140,"Accion",listaEstudios);
        Pelicula waydown = new Pelicula("Way Down",2020,150,"Terror",listaEstudios);
        aPeliculas.add(avatar);
        aPeliculas.add(spiderman);
        aPeliculas.add(waydown);

        funcionPeliculaLarga();
        funcionEstudioMasPelis();
    }

    public static void funcionPeliculaLarga () {
        int max = 0;
        Pelicula larga = null;
        for (int x=0; x < aPeliculas.size();x++) {
            if (aPeliculas.get(x).getDuracion() > max) {
                max = aPeliculas.get(x).getDuracion();
                larga = aPeliculas.get(x);
            }
        }
        javax.swing.JOptionPane.showMessageDialog(null,"La pelicula mas larga es " + larga.getTitulo() + " y es de " + larga.getTipo());
    }

    public static void funcionEstudioMasPelis () {
        /* Solucion de Nieves */
        int [] numeroPeliculas = new int[5];
        Arrays.fill(numeroPeliculas, 0);

        // Por cada Estudio recorro la lista de todas las películas para ver si está o no.
        for(int z = 0;z < aEstudios.size(); z++)
            for(int x=0; x < aEstudios.size();x++)
            {
                boolean salir = false;
                for(int y=0; y < aPeliculas.get(x).getlEstudios().size() && !salir; y++)
                {
                    if (aPeliculas.get(x).getlEstudios().get(y).equals(aEstudios.get(z)))
                    {
                        numeroPeliculas[z]+= 1;
                        salir = true;
                    }
                }
            }

        // Busco el máximo contador
        int maximo = 0;
        int posicion = 0;
        for (int x = 0; x < numeroPeliculas.length; x++)
            if(numeroPeliculas[x] > maximo)
            {
                maximo = numeroPeliculas[x];
                posicion = x;
            }

        JOptionPane.showMessageDialog(null,"El estudio que más películas ha producido es: " + aEstudios.get(0).getNombre() + " y ha producido "+ maximo);
    }
}
