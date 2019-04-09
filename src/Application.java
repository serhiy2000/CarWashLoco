public class Application {
    public static void main(String[] args) {

        System.out.println("Welcome to \"DOS\" CarWash Service! \n===========================================");
        System.out.println("Please note following commands: \nType word or figure to choose your vehicle or service, \n" +
                "'q'-for checkout, 'bill' - shows your current bill, 'back' - back to vehicle selection):");
        System.out.println();

        Menu.start();
    }
}
