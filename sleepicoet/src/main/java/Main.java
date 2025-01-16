public class Main {
    public static void main(String[] args) {
        Coet coet = new Coet(); // Crea una instancia del coet
        coet.arranca(); // Arranca los motores

        // Cambios automáticos de potencia predefinidos
        int[] potencies = {3, 7, 5, 0}; // Secuencia de potencias
        for (int potencia : potencies) {
            coet.passaAPotencia(potencia);

            // Espera 3 segundos entre cada cambio
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println("Interrupció en el programa principal.");
            }
        }

        System.out.println("Finalitzant simulació...");
    }
}
