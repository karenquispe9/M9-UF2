
public class Principal {
    public static void main(String[] args) {
        Fil juan = new Fil();
        Fil pepe = new Fil();

        juan.setName("Juan");
        pepe.setName("Pepe");

        juan.start(); 
        pepe.start();

        System.out.println("Termina thread main");

        
    }
}