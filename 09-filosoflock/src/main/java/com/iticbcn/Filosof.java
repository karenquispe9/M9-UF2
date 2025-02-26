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
        resetGana();

    }
    
    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                menjar();
                gana = calcularGana();
                System.out.println("Fil" + id + " menja amb gana " + gana);
                resetGana();
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
        if (agafarForquilles()){
            System.out.println("Fil" + id + " té forquilles esq("+ esquerra.getNum() +") dreta ("+ dreta.getNum() +")");
            Thread.sleep(random.nextInt(1000)+1000);
            deixarForquilles();
        }

    }

    private boolean agafarForquilles() throws InterruptedException{
        if (!esquerra.agafar()){
            return false;
        }

        if (!dreta.agafar()){
            esquerra.deixar();
            return false;
        }
        return true;
    }

    private void deixarForquilles(){
        esquerra.deixar();
        dreta.deixar();
        System.out.println("Fil" + id + " deixa les forquilles " );
    }
    
    private long calcularGana(){
        return fiGana - iniciGana;

    }

    private void resetGana(){
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }

}
