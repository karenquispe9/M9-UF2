
import java.util.Random;

public class Futbolista extends Thread {

    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

   
    private final String nom;
    private int ngols = 0;
    private int ntirades = 0;
    private static final Object lock = new Object(); // para sincronizar acceso a salida

    public Futbolista(String nom) {
        this.nom = nom;
    }

    @Override
    public void run() {
        Random rand = new Random();

        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;

            if (rand.nextFloat() < PROBABILITAT) {
                ngols++;
            }

            
            //System.out.println(nom + " -> Tirada " + (i+1) + ", Goles: " + ngols);
        }
    }

    public String getNom() {
        return nom;
    }

    public int getGols() {
        return ngols;
    }

    public int getTirades() {
        return ntirades;
    }
}
