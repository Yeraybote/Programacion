package Modelo;

import java.util.ArrayList;

public class Curso {
    String codigo;
    static ArrayList <Curso> listaCurso;

    public Curso(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Curso> getListaCurso() {
        return listaCurso;
    }

    public void setListaCurso(ArrayList<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }

    public static void rellenarCursos (){
        Curso A1 = new Curso("A1");
        listaCurso.add(A1);
        Curso A2 = new Curso("A2");
        listaCurso.add(A2);
        Curso A3 = new Curso("A3");
        listaCurso.add(A3);
        Curso A4 = new Curso("A4");
        listaCurso.add(A4);
        Curso B1 = new Curso("B1");
        listaCurso.add(B1);
        Curso B2 = new Curso("B2");
        listaCurso.add(B2);
        Curso B3 = new Curso("B3");
        listaCurso.add(B3);
        Curso B4 = new Curso("B4");
        listaCurso.add(B4);
        Curso C1 = new Curso("C1");
        listaCurso.add(C1);
        Curso C2 = new Curso("C2");
        listaCurso.add(C2);
        Curso C3 = new Curso("C3");
        listaCurso.add(C3);
        Curso C4 = new Curso("C4");
        listaCurso.add(C4);
        Curso D1 = new Curso("D1");
        listaCurso.add(D1);
        Curso D2 = new Curso("D2");
        listaCurso.add(D2);
        Curso D3 = new Curso("D3");
        listaCurso.add(D3);
        Curso D4 = new Curso("D4");
        listaCurso.add(D4);
    }
}
