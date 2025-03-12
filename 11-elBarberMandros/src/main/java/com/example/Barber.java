package com.example;


class Barber implements Runnable {
    private final String name;
    private final Barberia barberia;

    public Barber(String name, Barberia barberia) {
        this.name = name;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (barberia.condBarber) {
                while (barberia.isEmpty()) {
                    try {
                        System.out.println("Ningú en espera\nBarber " + name + " dormint");
                        barberia.condBarber.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            Client client = barberia.seguentClient();
            if (client != null) {
                System.out.println("Li toca al client " + client.getNom());
                client.tallarseElCabell();
            }
        }
    }
}
