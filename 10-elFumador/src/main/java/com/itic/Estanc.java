package com.itic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe Estanc
 * Representa l'estanc del barri on es subministren els ingredients que necessiten els fumadors.
 * recursos: tabac, paper i llumins.
 * Els subministra aleatòriament i controla quan s'ha d'acabar el dia.
 */
public class Estanc extends Thread {
    private List<Tabac> tabacs;
    private List<Llumi> llumins;
    private List<Paper> papers;

    private Random random;
    private boolean obert;

    /**
     * Constructor de l'estanc
     * Inicialitza les llistes de recursos i el generador aleatori.
     */
    public Estanc() {
        this.tabacs = new ArrayList<>();
        this.llumins = new ArrayList<>();
        this.papers = new ArrayList<>();
        this.random = new Random();
        this.obert = false;
    }

    /**
     * afegeix un recurs aleatori (1 sol)
     * Pot rebre tabac, paper o llumí.
     */
    public void nouSubministrament() {
        int recurs = random.nextInt(3);
        switch (recurs) {
            case 0 -> addTabac(new Tabac());
            case 1 -> addLlumi(new Llumi()); 
            case 2 -> addPaper(new Paper());
            default -> throw new AssertionError();
        }
    }

    /**
     * Afegeix una unitat de tabac,llumi, papaer a l'estoc
     * Notifica als fumadors que potser n'hi ha disponible
     */
    public synchronized void addTabac(Tabac tab) { 
        tabacs.add(tab); 
        System.out.println("Afegint tabac");
        notifyAll();  // Despertem tots els fumadors que esperen
    }
    public synchronized void addLlumi(Llumi llum) { 
        llumins.add(llum); 
        System.out.println("Afegint Llumí");
        notifyAll();
    }
    public synchronized void addPaper(Paper pap) { 
        papers.add(pap); 
        System.out.println("Afegint Paper");
        notifyAll();
    }

    /**
     * Ven una unitat de tabac,llumi, papaer al fumador
     * Si no n'hi ha, espera fins que hi hagi
     */
    public synchronized Tabac venTabac() {
        while (tabacs.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return tabacs.remove(0);
    }


    public synchronized Llumi venLlumi() {
        while (llumins.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return llumins.remove(0);
    }
    public synchronized Paper venPaper() {
        while (papers.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return papers.remove(0);
    }

    public void tancarEstanc() {
        obert = false;
    }

    @Override
    public void run() {
        obert = true;
        while (obert) { 
            nouSubministrament();
            espera(500, 1001);  // Espera entre 0.5 i 1 segon
        }
    }
    public void espera(int org, int limit) {
        try {
            sleep(random.nextInt(org, limit));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}