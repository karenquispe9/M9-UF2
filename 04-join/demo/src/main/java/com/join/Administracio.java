package com.join;

public class Administracio {
    private final int numPoblacioActiva = 50;
    private final Treballador[] poblacioActiva;

    //inicialitza els treballadors
    public Administracio() {
        poblacioActiva = new Treballador[numPoblacioActiva];
        for (int i = 0; i < numPoblacioActiva; i++) {
            poblacioActiva[i] = new Treballador("Ciutadà-" + i, 25000, 20, 65);
        }
    }

    public void iniciaSimulacio() {
        // iniciamos los hilos
        for (Treballador treballador : poblacioActiva) {
            treballador.start();
        }

        // esperamos q acaben
        for (Treballador treballador : poblacioActiva) {
            try {
                treballador.join();
            } catch (InterruptedException e) {
                System.err.println("Error esperando a " + treballador.getName());
            }
        }

        // mostramos estadisticas
        for (Treballador treballador : poblacioActiva) {
            System.out.printf("%s -> edat: %d / total: %.2f%n",
                    treballador.getName(),
                    treballador.getEdat(),
                    treballador.getCobrat());
        }
        
    }

    
}

