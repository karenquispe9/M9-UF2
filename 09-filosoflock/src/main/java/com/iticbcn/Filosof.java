package com.iticbcn;

public class Filosof extends Thread {
    private final int id;
    private final Forquilla esquerra, dreta;
    private final Random random = new Random();

    public Filosof(int id, Forquilla esquera, Forquilla dreta){
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;

    }

    public void run() {
        try {
            while (true) {
                pensar();
                menjar();
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void pensar() throws InterruptedException {
        
    }

    private void menjar() throws InterruptedException {
        
    }
       

}
