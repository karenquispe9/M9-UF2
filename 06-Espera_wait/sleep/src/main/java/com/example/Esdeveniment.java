package com.example;

import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private final int capacitatMaxima;
    private final List<Assistent> assistents;
    
    public Esdeveniment(int capacitatMaxima) {
        this.capacitatMaxima = capacitatMaxima;
        this.assistents = new ArrayList<>();
    }
    
    public synchronized void ferReserva(Assistent assistent) throws InterruptedException {
        while (assistents.size() >= capacitatMaxima) {
            wait();
        }
        assistents.add(assistent);
        System.out.println(assistent.getNom() + " ha fet una reserva. Places disponibles: " + (capacitatMaxima - assistents.size()));
        notifyAll();
    }
    
    public synchronized void cancelaReserva(Assistent assistent) {
        if (assistents.remove(assistent)) {
            System.out.println(assistent.getNom() + " ha cancel-lat una reserva. Places disponibles: " + (capacitatMaxima - assistents.size()));
            notifyAll();
        } else {
            System.out.println(assistent.getNom() + " no ha pogut cancel-lar una reserva inexistent. Places disponibles: " + (capacitatMaxima - assistents.size()));
        }
    }
}
