package com.itic;


import java.util.Random;

/*
 * Aquesta classe representa un fumador que necessita tabac, paper i llumiper fumar
 * objecitu: fumar 3 vegades al dia 
 */
public class Fumador extends Thread {
    private Estanc estanc;
    private int id; //identificador unic del fumador

    // recursos que pot comprar
    // si un fumador compra un recurs, aquest es posa a null per evitar que el compri
    private Tabac tabac;
    private Llumi llumi;
    private Paper paper;

    private int fumades;
    private Random random;


    /*
     * Constructor del fumador
     */
    public Fumador(Estanc est, int id) {
        this.estanc = est;
        this.id = id;
        this.tabac = null;
        this.llumi = null;
        this.paper = null;
        this.fumades = 0;
        this.random = new Random();
    }

    /**
     * Mètode fuma: consumeix els ingredients i simula que el fumador fuma.
     * Si te tots tres, fa servir-los, fuma i espera entre 0.5 i 1 segon.
     */
    public void fuma() {
        if (tabac != null && llumi != null && paper != null) {
            fumades++;
            System.out.printf("Fumador %d fumant\n", id);
            System.out.printf("Fumador %d ha fumat %d vegades\n", id, fumades);
            tabac = null;
            llumi = null;
            paper = null;
            espera(500, 1001);
        }   
    }

    //fa la pausa aleatrotia en mil.lisegons
    public void espera(int org, int limit) {
        try {
            sleep(random.nextInt(org, limit));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    public void compraTabac() {
        if (tabac == null) {
            // variable reassignat en la global
            if((tabac = estanc.venTabac()) != null) {
                System.out.printf("Fumador %d comprant Tabac\n", id);
            }
        }
    }
    public void compraPaper() {
        if (paper == null) {
            if ((paper = estanc.venPaper()) != null) {
                System.out.printf("Fumador %d comprant Paper\n", id);
            }
        }
    }
    public void compraLlumi() {
        if (llumi == null) {
            if ((llumi = estanc.venLlumi()) != null) {
                System.out.printf("Fumador %d comprant Llumí\n", id);
            }
        }
    }

    @Override
    public void run() {
        while (fumades < 3) {  // limit 3 vegades
            compraTabac();
            compraPaper();
            compraLlumi();
            fuma();
        }
    }

     /**
     * Getter per saber quantes vegades ha fumat
     * @return nombre de vegades que ha fumat
     */
    public int getFumades() {
        return fumades;
    }
}