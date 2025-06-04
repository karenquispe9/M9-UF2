public class Associacio {
    public static final int numSocis = 1000;
    private Soci[] socis;

    public Associacio() {
        socis = new Soci[numSocis];
    }

    public void iniciaCompteTempsSocis() {
        Compte compte = Compte.getInstance();

        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci(compte);
            socis[i].start();
        }
    }

    public void esperaPeriodeSocis() {
        try {
            for (Soci s : socis) {
                s.join(); // esperem a que tots acabin
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void mostraBalancComptes() {
        System.out.printf("Saldo: %.2f\n", Compte.getInstance().getSaldo());
    }

    public static void main(String[] args) {
        Associacio associacio = new Associacio();

        System.out.println("Saldo esperat: 0,00");
        System.out.println("Iniciant el compte de temps dels socis...");

        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();

        associacio.mostraBalancComptes();
    }
}