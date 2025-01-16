public class Motor extends Thread {
    private int potenciaActual;
    private int potenciaObjectiu;
    private final String nom;
    private boolean actiu;

    public Motor(String nom) {
        this.nom = nom;
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        this.actiu = true;
    }

    public synchronized void setPotencia(int potenciaObjectiu) {
        this.potenciaObjectiu = potenciaObjectiu;
        notify(); // Despierta el hilo si está esperando
    }

    @Override
    public void run() {
        try {
            while (actiu) {
                synchronized (this) {
                    while (potenciaActual == potenciaObjectiu && actiu) {
                        wait(); // Espera hasta que se cambie la potencia objetivo
                    }
                }

                if (!actiu) break;

                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    System.out.println(nom + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                } else if (potenciaActual > potenciaObjectiu) {
                    potenciaActual--;
                    System.out.println(nom + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                }

                if (potenciaActual == potenciaObjectiu) {
                    System.out.println(nom + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                }

                Thread.sleep((int) (1000 + Math.random() * 1000)); // Espera entre 1 y 2 segundos
            }
        } catch (InterruptedException e) {
            System.out.println(nom + " interromput.");
        }
    }

    public synchronized void atura() {
        actiu = false;
        notify();
    }
}
