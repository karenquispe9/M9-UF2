
public class Principal {
    public static void main(String[] args) {
        Fil juan = new Fil();
        Fil pepe = new Fil();

        juan.setName("Juan");
        pepe.setName("Pepe");

        //prioritzem un fil respecte a l'altre
        juan.setPriority(Thread.MIN_PRIORITY);
        pepe.setPriority(Thread.MAX_PRIORITY);

        juan.start(); 
        pepe.start();

        System.out.println("Termina thread main");

        
    }
}