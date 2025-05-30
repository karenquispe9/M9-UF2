public class Fil extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            System.out.println(this.getName() + " " + i);
        }
        System.out.println("Termina el fil " + this.getName());
    }


}