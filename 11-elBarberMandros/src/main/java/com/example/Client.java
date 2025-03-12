package com.example;

class Client {
    private final String nom;

    public Client(int id) {
        this.nom = "Client-" + id;
    }

    public String getNom() {
        return nom;
    }

    public void tallarseElCabell() {
        try {
            Thread.sleep(900 + (int) (Math.random() * 100));
            System.out.println("Tallant cabell a " + nom);
        } catch (InterruptedException e) {
        }
    }
}