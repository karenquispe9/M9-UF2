package com.iticbcn;

public class Taula {
    private final Forquilla[] forquilles;
    private final Filosof[] filosofs;

    public Taula(int nForquilles) {
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

    }

    public void cridarTaula(){
        for (Filosof f : filosofs){
            f.start();
        }
    
    }

}
