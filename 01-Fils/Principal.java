/*
 * Interleaving Equitativo
 * Este es el comportamiento por defecto al usar start() 
 * sin ninguna sincronización ni pausa. Los hilos compiten por 
 * el CPU y van apareciendo intercalados.
 */
public class Principal {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");

        //usamos start() para iniciar el hilo
        //Simplemente ejecuta el código inicial varias veces. 
        //A veces saldrá más intercalado, otras veces no tanto
        juan.start(); 
        pepe.start();

        System.out.println("Termina thread main");

        
    }
}