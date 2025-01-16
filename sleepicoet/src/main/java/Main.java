import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Coet coet = new Coet(); // Crear una instancia del coet
        coet.arranca(); // Arrancar los motores

        Scanner scanner = new Scanner(System.in);
        int potencia;

        try {
            while (true) {
                System.out.print("Introduïu la potència objectiu (0-10): ");
                potencia = scanner.nextInt();
                if (potencia == 0) {
                    coet.passaAPotencia(0); // Ajustar potencia a 0
                    break; // Finalizar el programa
                }
                coet.passaAPotencia(potencia);
            }
        } catch (Exception e) {
            System.out.println("Error en la entrada.");
        } finally {
            coet.atura(); // Detener los motores antes de salir
            System.out.println("Finalitzant simulació...");
            scanner.close();
        }
    }
}
