package com.exmple;

import java.util.Random;

class Filosof extends Thread {
    private final int id;
    private final Forquilla izquierda;
    private final Forquilla derecha;
    private final boolean invierteOrden;
    private final Random random = new Random();
    private int hambre = 0;
    private Forquilla esquerra;
    private Forquilla dreta;

    public Filosof(int id, Forquilla izquierda, Forquilla derecha, boolean invierteOrden) {
        this.id = id;
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.invierteOrden = invierteOrden;
    }

    public Forquilla getEsquerra() {
        return esquerra;
    }

    public Forquilla getDreta() {
        return dreta;
    }
    
    private void pensar() {
        try {
            System.out.println("Filósofo " + id + " está pensando.");
            Thread.sleep(random.nextInt(1000, 2001));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void comer() {
        try {
            System.out.println("Filósofo " + id + " está comiendo.");
            Thread.sleep(random.nextInt(1000, 2001));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        while (true) {
            pensar();

            boolean forquillasCogidas = false;
            while (!forquillasCogidas) {
                if (invierteOrden) {
                    if (derecha.coger()) {
                        System.out.println("Filósofo " + id + " ha cogido la forquilla derecha " + derecha.getId());

                        if (izquierda.coger()) {
                            System.out.println("Filósofo " + id + " ha cogido la forquilla izquierda " + izquierda.getId());
                            forquillasCogidas = true;
                        } else {
                            derecha.dejar();
                        }
                    }
                } else {
                    if (izquierda.coger()) {
                        System.out.println("Filósofo " + id + " ha cogido la forquilla izquierda " + izquierda.getId());

                        if (derecha.coger()) {
                            System.out.println("Filósofo " + id + " ha cogido la forquilla derecha " + derecha.getId());
                            forquillasCogidas = true;
                        } else {
                            izquierda.dejar();
                        }
                    }
                }

                if (!forquillasCogidas) {
                    try {
                        Thread.sleep(random.nextInt(500, 1001)); // Espera entre 0.5s y 1s
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            comer();
            hambre = 0;

            izquierda.dejar();
            derecha.dejar();
        }
    }

    
}
