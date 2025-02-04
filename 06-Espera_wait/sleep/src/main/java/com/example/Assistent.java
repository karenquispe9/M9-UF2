package com.example;

import java.util.Random;

public class Assistent extends Thread {
    private final Esdeveniment esdeveniment;
    private final String nom;
    private final Random random;
    
    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
        this.random = new Random();
    }
    
    public String getNom() {
        return nom;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                if (random.nextBoolean()) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
