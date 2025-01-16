package com.sleep;

import java.util.Random;

public class DormAleatori extends Thread {
    private final long startTime; // Tiempo de creación del hilo
    private final Random random; // Generador de números aleatorios

    // Constructor
    public DormAleatori(String name) {
        super(name); // Establece el nombre del hilo
        this.startTime = System.currentTimeMillis(); // Registra el momento de creación
        this.random = new Random(); // Inicializa el generador aleatorio
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int intervalAleatori = random.nextInt(1000); // Tiempo aleatorio entre 0 y 999 ms
            long totalTime = System.currentTimeMillis() - startTime; // Tiempo total desde la creación
            
            // Imprimir información del hilo
            System.out.printf("%s(%d) a dormir %dms total %dms%n", 
                getName(), i, intervalAleatori, totalTime);
            
            // Dormir el tiempo aleatorio
            try {
                Thread.sleep(intervalAleatori);
            } catch (InterruptedException e) {
                System.err.println(getName() + " fue interrumpido.");
            }
        }
    }

    public static void main(String[] args) {
        // Crear dos hilos
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        // Iniciar los hilos
        joan.start();
        pep.start();

        // Mensaje final del main
        System.out.println("-- Fi de main -----------");
    }
}

