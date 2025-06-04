package com.iticbcn;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Classe que representa un bany compartit per homes i dones.
 * Només pot haver-hi persones d'un sol sexe alhora.
 */
public class BanyUnisex {
    public static final int BANY_BUIT = 0;
    public static final int BANY_AMB_HOMES = 1;
    public static final int BANY_AMB_DONES = 2;

    private int estatActual = BANY_BUIT;
    private int ocupants = 0;
    private final int CAPACITAT_MAX = 3;

    private final Semaphore capacitat = new Semaphore(CAPACITAT_MAX, true);
    private final ReentrantLock lockEstat = new ReentrantLock(true);

    /**
     * Mètode que permet a un home entrar al bany si és el seu torn
     */
    public void entraHome() {
        boolean entrat = false;
        while (!entrat) {
            lockEstat.lock();
            try {
                // Si el bany està buit, canviem l'estat
                if (estatActual == BANY_BUIT) {
                    estatActual = BANY_AMB_HOMES;
                }

                // només podem entrar si és el nostre torn
                if (estatActual == BANY_AMB_HOMES && capacitat.tryAcquire()) {
                    ocupants++;
                    System.out.println(Thread.currentThread().getName() + " entra al bany. Ocupants: " + ocupants);
                    entrat = true;
                }
            } finally {
                lockEstat.unlock();
            }

            if (!entrat) {
                try {
                    Thread.sleep(100); // Espera abans de tornar a provar
                } catch (InterruptedException ignored) {}
            }
        }
    }

    /**
     * Mètode que fa sortir un home del bany
     */
    public void surtHome() {
        lockEstat.lock();
        try {
            ocupants--;
            System.out.println(Thread.currentThread().getName() + " surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
                System.out.println("El bany està buit");
            }
        } finally {
            lockEstat.unlock();
            capacitat.release(); // Alliberam un espai al semàfor
        }
    }

    /**
     * Mètode que permet a una dona entrar al bany si és el seu torn
     */
    public void entraDona() {
        boolean entrat = false;
        while (!entrat) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT) {
                    estatActual = BANY_AMB_DONES;
                }

                if (estatActual == BANY_AMB_DONES && capacitat.tryAcquire()) {
                    ocupants++;
                    System.out.println(Thread.currentThread().getName() + " entra al bany. Ocupants: " + ocupants);
                    entrat = true;
                }
            } finally {
                lockEstat.unlock();
            }

            if (!entrat) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {}
            }
        }
    }

    /**
     * Mètode que fa sortir una dona del bany
     */
    public void surtDona() {
        lockEstat.lock();
        try {
            ocupants--;
            System.out.println(Thread.currentThread().getName() + " surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
                System.out.println("El bany està buit");
            }
        } finally {
            lockEstat.unlock();
            capacitat.release(); // Alliberam un espai al semàfor
        }
    }

    
    public static void main(String[] args) {
        BanyUnisex bany = new BanyUnisex();

        Home[] homes = new Home[5];
        Dona[] dones = new Dona[5];

        for (int i = 0; i < 5; i++) {
            homes[i] = new Home(bany, "Home-" + i);
            dones[i] = new Dona(bany, "Dona-" + i);
        }

        // Iniciem els fils
        for (Thread t : homes) t.start();
        for (Thread t : dones) t.start();
    }
}