public class Fil extends Thread {
    private String nombre;

    public Fil(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            System.out.println(nombre + " " + i);
        }
        System.out.println("Termina el fil " + nombre);
    }


}