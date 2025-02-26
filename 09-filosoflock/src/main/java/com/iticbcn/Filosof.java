package com.iticbcn;

import java.util.Random;

public class Filosof extends Thread {
    private final int id;
    private final Forquilla esquerra, dreta;
    private final Random random = new Random();
    private long iniciGana;
    private long fiGana;
    private long gana;

    public Filosof(int id, Forquilla esquerra, Forquilla dreta){
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
        this.gana = 0;
        iniciGana = System.currentTimeMillis();
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                menjar();
                calcularGana();
               
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Fil" + id + " pensant");
        Thread.sleep(random.nextInt(1000)+1000);
        
    }

    private void menjar() throws InterruptedException {
        while (!agafarForquilles()) {
            Thread.sleep(random.nextInt(500) + 500); 
        }
        fiGana = System.currentTimeMillis();
        gana = calcularGana();
        int ganaEnSegons = (int) (gana / 1000); 
        System.out.println("Fil" + id + " té forquilles esq("+ esquerra.getNum() +") dreta ("+ dreta.getNum() +")");
        System.out.println("Fil" + id + " menja amb gana " + ganaEnSegons);
        Thread.sleep(random.nextInt(1000) + 1000); // Menja entre 1s i 2s
        System.out.println("Fil" + id + " ha acabat de menjar");
        deixarForquilles();
        resetGana();

    }

    private boolean agafarForquilles() throws InterruptedException {
        if (agafarForquillaEsquerra()) {
            if (agafarForquillaDreta()) {
                return true;
            } else {
                esquerra.deixar();
            }
        }
        return false;
    }

    private boolean agafarForquillaEsquerra() {
        return esquerra.agafar();
    }

    private boolean agafarForquillaDreta() {
        return dreta.agafar();
    }

    private void deixarForquilles() {
        dreta.deixar();
        esquerra.deixar();
        System.out.println("Fil" + id + " deixa les forquilles");
    }

    private long calcularGana() {
        return fiGana - iniciGana;
        
    }

    private void resetGana() {
        iniciGana = System.currentTimeMillis();
        //gana = 0;
    }

}
