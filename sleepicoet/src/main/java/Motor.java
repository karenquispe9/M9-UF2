import java.util.Random;

public class Motor extends Thread {
    private int potenciaActual; // potencia actual del motor
    private int potenciaObjectiu; // potencia objetivo
    private final Random random = new Random(); 

    public Motor(String name) {
        super(name); // asigna nombre al hilo
        this.potenciaActual = 0; // inicializa la potencia actual a 0
        this.potenciaObjectiu = 0; // inicializa la potencia objetivo a 0
    }

    public synchronized void setPotencia(int potenciaObjectiu) {
        this.potenciaObjectiu = potenciaObjectiu; // actualiza la potencia objetivo
    }

    @Override
    public void run() {
        try {
            while (true) { // mantiene el hilo en ejecución
                while (potenciaActual != potenciaObjectiu) { // ajusta la potencia
                    synchronized (this) {
                        if (potenciaActual < potenciaObjectiu) {
                            potenciaActual++;
                            System.out.printf("%s: Incre. Objectiu: %d Actual: %d%n",
                                    getName(), potenciaObjectiu, potenciaActual);
                        } else if (potenciaActual > potenciaObjectiu) {
                            potenciaActual--;
                            System.out.printf("%s: Decre. Objectiu: %d Actual: %d%n",
                                    getName(), potenciaObjectiu, potenciaActual);
                        }
                    }

                    // simula el tiempo de respuesta del motor, 1-2 segundos
                    Thread.sleep(1000 + random.nextInt(1001));
                }

                // si la potencia objetivo es 0 y se alcanzó, el hilo termina
                if (potenciaObjectiu == 0) {
                    System.out.printf("%s: FerRes Objectiu: %d Actual: %d%n",
                            getName(), potenciaObjectiu, potenciaActual);
                    break; // Sale del bucle externo, terminando el hilo
                }

                // pequeña pausa para evitar consumo excesivo cuando no hay cambios
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.err.println(getName() + " fue interrumpido.");
        }
    }
}
