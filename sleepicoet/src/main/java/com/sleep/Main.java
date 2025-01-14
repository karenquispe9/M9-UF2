package com.sleep;


public class Main {
    public static void main(String[] args) {
        
        DormAleatori Joan = new DormAleatori("Joan");
        DormAleatori Pep = new DormAleatori("Pep");

        Joan.start();
        Pep.start();

        System.out.println("......Finalitzat........");
    }
}