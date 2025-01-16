package com.sleep;

import java.util.Random;

public class DormAleatori extends Thread {
    private final long tiempoActual; //tiempo de creación del hilo
    private final Random random; 

    // Constructor
    public DormAleatori(String name) {
        super(name); // nombre del hilo
        this.tiempoActual = System.currentTimeMillis(); // registro momento de creación
        this.random = new Random(); 
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int intervalAleatori = random.nextInt(1000); // tiempo aleatorio entre 0 y 999 ms
            long totalTime = System.currentTimeMillis() - tiempoActual; //tiempo total desde la creación
            
            System.out.printf("%s(%d) a dormir %dms total %dms%n", 
                getName(), i, intervalAleatori, totalTime);
            
            // Dormir
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
        System.out.println("------ Finalizado ---------");
    }
}

