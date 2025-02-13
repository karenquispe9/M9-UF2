package com.iticbcn;

public class Forquilla {
    private int numeroPropietari;
    public static final int LLIURE = -1;

    public Forquilla(int numero) {
        this.numeroPropietari = numero;
    }

    public void setNumeroPropietari(int numero) {
        this.numeroPropietari = numero;
    }

    public int getNumeroPropietari() {
        return numeroPropietari;
    }
}

