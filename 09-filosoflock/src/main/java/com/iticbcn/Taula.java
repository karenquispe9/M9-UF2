package com.iticbcn;

public class Taula {
    private final Forquilla[] forquilles;
    private final Filosof[] filosofs;

    public Taula(int numFilosofs) {
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }
        for (int i = 0; i < numFilosofs; i++) {
            filosofs[i] = new Filosof(i, forquilles[i], forquilles[(i + 1) % numFilosofs]);
            System.out.println(
                "Comensal:Fil" + i + " esq:" + forquilles[i].getNum() + " dret:" + forquilles[(i + 1) % numFilosofs].getNum());
        }

    }

    public void cridarTaula(){
        for (Filosof f : filosofs){
            f.start();
        }
    
    }

}
