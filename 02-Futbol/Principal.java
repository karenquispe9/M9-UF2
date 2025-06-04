

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Futbolista[] jugadors = {
            new Futbolista("Piqué"),
            new Futbolista("Vinicius"),
            new Futbolista("Torres"),
            new Futbolista("Ramos"),
            new Futbolista("Ronaldo"),
            new Futbolista("Lewan"),
            new Futbolista("Belli"),
            new Futbolista("Arnau"),
            new Futbolista("Aspas"),
            new Futbolista("Messi"),
            new Futbolista("MBapé")
        };

        System.out.println("Inici dels xuts --------------------");

        // Iniciar tots els fils
        for (Futbolista f : jugadors) {
            f.start();
        }

        // Esperar a que acabin tots els fils
        for (Futbolista f : jugadors) {
            f.join();
        }

        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");

        for (Futbolista f : jugadors) {
            System.out.println(f.getNom() + " -> " + f.getGols() + " gols");
        }
    }
}