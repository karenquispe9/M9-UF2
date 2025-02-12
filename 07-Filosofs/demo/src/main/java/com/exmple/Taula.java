package com.exmple;

class Taula {
    private final Filosof[] filosofos;
    private final Forquilla[] forquillas;

    public Taula(int numFilosofos) {
        filosofos = new Filosof[numFilosofos];
        forquillas = new Forquilla[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            forquillas[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilosofos; i++) {
            boolean invierteOrden = (i == numFilosofos - 1); // El último filósofo invierte el orden
            filosofos[i] = new Filosof(i, forquillas[i], forquillas[(i + 1) % numFilosofos], invierteOrden);
        }
    }

    public void showTaula() {
        for (Filosof f : filosofos) {
            System.out.println("Filósofo: " + f.getName() + " izquierda: " + f.getEsquerra() + " derecha: " + f.getDreta());
        }
    }

    public void llamarATaula() {
        for (Filosof f : filosofos) {
            f.start();
        }
    }
}