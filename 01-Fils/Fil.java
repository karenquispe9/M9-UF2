public class Fil extends Thread {


    private static final Object lock = new Object();
    private static String turno = "Juan"; // Variable para controlar el turno


    @Override
    public void run() {

         for (int i = 1; i < 10; i++) {
            synchronized (lock) {
                String nombre = this.getName(); // obtenemos el nombre del hilo

                // Mientras no sea mi turno, espero
                while (!turno.equals(nombre)) {
                    try {
                        lock.wait(); // me duermo hasta que me notifiquen
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

               
                System.out.println(nombre + " " + i);

                // Cambio el turno
                turno = nombre.equals("Juan") ? "Pepe" : "Juan";

                // Notifico a todos los hilos
                lock.notifyAll();
            }
        }

    
        synchronized (lock) {
            System.out.println("Termina el fil " + this.getName());
        }
    }


}