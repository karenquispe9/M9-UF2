package com.iticbcn;

import java.util.Random;

public class Dona extends Thread {
    private final BanyUnisex bany;
    private final Random rnd = new Random();

    public Dona(BanyUnisex bany, String nom) {
        super(nom);
        this.bany = bany;
    }

    @Override
    public void run() {
        System.out.println(getName() + " vol entrar al bany");

        bany.entraDona();

        try {
            utilitzaLavabo(2000, 3001);
        } finally {
            bany.surtDona();
        }
    }

    public void utilitzaLavabo(int min, int max) {
        try {
            Thread.sleep(rnd.nextInt(min, max));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}