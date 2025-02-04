package com.example;

public class Main {
    public static void main(String[] args) {
        Esdeveniment esdeveniment = new Esdeveniment(5);
        
        for (int i = 0; i < 10; i++) {
            new Assistent("Assistent-" + i, esdeveniment).start();
        }
    }
}
