package com.iticbcn;

import java.util.Random;

class Filosof extends Thread {
    private int id;
    private Forquilla esquerra, dreta;
    private Random random = new Random();

    public Filosof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filosof " + id + " està pensant.");
        Thread.sleep(random.nextInt(1000) + 1000);
    }

    private void menjar() throws InterruptedException {
        System.out.println("Filosof " + id + " està menjant.");
        Thread.sleep(random.nextInt(1000) + 1000);
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                synchronized (esquerra) {
                    esquerra.agafar(id);
                    synchronized (dreta) {
                        dreta.agafar(id);
                        menjar();
                        dreta.deixar();
                    }
                    esquerra.deixar();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Filosof " + id + " interromput.");
        }
    }

    public Forquilla getEsquerra() {
        return esquerra;
    }

    public void setEsquerra(Forquilla esquerra) {
        this.esquerra = esquerra;
    }

    public Forquilla getDreta() {
        return dreta;
    }

    public void setDreta(Forquilla dreta) {
        this.dreta = dreta;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}