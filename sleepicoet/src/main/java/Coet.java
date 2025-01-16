import java.util.ArrayList;
import java.util.List;

public class Coet {
    private final List<Motor> motors;

    public Coet() {
        motors = new ArrayList<>();
        // Crear los 4 motores del coet
        for (int i = 0; i < 4; i++) {
            motors.add(new Motor("Motor " + i));
        }
    }

    public void passaAPotencia(int potencia) {
        // Comprobar si la potencia está en rango
        if (potencia < 0 || potencia > 10) {
            System.out.println("Error: Potència fora de rang (0-10)");
            return;
        }

        System.out.println("Passant a potència " + potencia);
        for (Motor motor : motors) {
            motor.setPotencia(potencia);
        }
    }

    public void arranca() {
        // Inicia los hilos de los motores
        for (Motor motor : motors) {
            motor.start();
        }
    }

    public void atura() {
        // Detiene los motores
        for (Motor motor : motors) {
            motor.atura();
        }
    }
}
