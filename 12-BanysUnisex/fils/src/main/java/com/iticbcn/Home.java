package com.iticbcn;

import java.util.Random;

public class Home extends Thread {
    private final BanyUnisex bany;
    private final Random rnd = new Random();

    public Home(BanyUnisex bany, String nom) {
        super(nom); // Per poder mostrar el nom al fer getName()
        this.bany = bany;
    }

    @Override
    public void run() {
        System.out.println(getName() + " vol entrar al bany");

        bany.entraHome();

        try {
            utilitzaLavabo(1000, 2001);
        } finally {
            bany.surtHome();
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