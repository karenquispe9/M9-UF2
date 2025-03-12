package com.example;

import java.util.LinkedList;
import java.util.Queue;

class Barberia {
    private final Queue<Client> salaEspera;
    private final int maxCadires;
    public final Object condBarber;
    
    public Barberia(int maxCadires) {
        this.salaEspera = new LinkedList<>();
        this.maxCadires = maxCadires;
        this.condBarber = new Object();
    }

    public synchronized boolean isEmpty() {
        return salaEspera.isEmpty();
    }

    public synchronized Client seguentClient() {
        return salaEspera.poll();
    }

    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (salaEspera.size() < maxCadires) {
                salaEspera.offer(client);
                System.out.println("Client " + client.getNom() + " en espera");
                condBarber.notify();
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
            }
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void iniciarClients() {
        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    entrarClient(new Client(i));
                    Thread.sleep(500);
                }
                Thread.sleep(10000);
                for (int i = 11; i <= 20; i++) {
                    entrarClient(new Client(i));
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }




    public static void main(String[]args) {
        Barberia barberia = new Barberia(3);
        Barber barber = new Barber("Pepe", barberia);
    
        Thread barberThread = new Thread(barber);
        barberThread.start();
    
        barberia.iniciarClients();
    }
    
}

