package com.iticbcn;


class Taula {
    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];
        
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla();
        }
        
        for (int i = 0; i < numFilosofs; i++) {
            filosofs[i] = new Filosof(i, forquilles[i], forquilles[(i + 1) % numFilosofs]);
        }
    }

    public void cridarATaula() {
        for (Filosof f : filosofs) {
            f.start();
        }
    }

    public Filosof[] getFilosofs() {
        return filosofs;
    }

    public void setFilosofs(Filosof[] filosofs) {
        this.filosofs = filosofs;
    }

    public Forquilla[] getForquilles() {
        return forquilles;
    }

    public void setForquilles(Forquilla[] forquilles) {
        this.forquilles = forquilles;
    }
}