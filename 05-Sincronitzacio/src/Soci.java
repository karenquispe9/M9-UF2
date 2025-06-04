import java.util.Random;

public class Soci extends Thread {
    private static int numSoci = 1; // Contador de socios
    private int id;
    private float aportacio = 10f;
    private int esperaMax = 100;
    private Random random = new Random();
    private Compte compte;

    public Soci(Compte compte) {
        this.compte = compte;
        this.id = numSoci++;
    }

    @Override
    public void run() {
        int maxAnys = 10;
        for (int any = 0; any < maxAnys; any++) {
            for (int mes = 1; mes <= 12; mes++) {
                try {
                    if (mes % 2 == 0) {
                        // Mes par: ingreso
                        compte.ingressar(aportacio);
                    } else {
                        // Mes impar: retirada
                        compte.retirar(aportacio);
                    }

                    // Simulamos tiempo variable
                    Thread.sleep(random.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}