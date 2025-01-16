import java.util.ArrayList;
import java.util.List;

public class Coet {
    private final List<Motor> motors; // Lista de motores

    public Coet() {
        motors = new ArrayList<>();
        // Crea y añade 4 motores al coet
        for (int i = 0; i < 4; i++) {
            motors.add(new Motor("Motor " + i));
        }
    }

    public void passaAPotencia(int potencia) {
        // Comprueba que la potencia está en el rango válido
        if (potencia < 0 || potencia > 10) {
            System.out.println("Error: Potència fora de rang (0-10)");
            return;
        }

        // Ajusta la potencia objetivo de cada motor
        System.out.println("Passant a potència " + potencia);
        for (Motor motor : motors) {
            motor.setPotencia(potencia);
        }
    }

    public void arranca() {
        // Arranca todos los motores (inicia sus hilos)
        System.out.println("Arrancant motors...");
        for (Motor motor : motors) {
            motor.start();
        }
    }
}
