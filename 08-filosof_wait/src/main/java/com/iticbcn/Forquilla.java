package com.iticbcn;


class Forquilla {
    private int propietari;
    public static final int LLIURE = -1;

    public Forquilla() {
        this.propietari = LLIURE;
    }

    public synchronized void agafar(int filosof) throws InterruptedException {
        while (propietari != LLIURE) {
            wait();
        }
        propietari = filosof;
    }

    public synchronized void deixar() {
        propietari = LLIURE;
        notifyAll();
    }
}
