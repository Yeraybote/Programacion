package Modelo;

import java.util.ArrayList;

public class Cuenta {
    int numero;
    double saldo;
    ArrayList <Movimientos> listaMovimientos;

    public Cuenta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Movimientos> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(ArrayList<Movimientos> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }
}
