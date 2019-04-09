import java.util.*;

public class Menu {

    public static String CURRENCY = "uah";

    private static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return ""; 
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    static void start() {
        // creates menu for main entrance;
        Map<String, List<Services>> mainMenu = new LinkedHashMap<>();

        // fills menu with data from Services;
        Services.fillMainMenu(mainMenu);

        Set<Services> basket = new LinkedHashSet<>();
        Set<Basket> bill = new LinkedHashSet<>();
        Set<String> vehicles = mainMenu.keySet();

        String input, key = "init";
        int roomMark = 1;
        List<Services> servicesForSelectedVehicle = new ArrayList<>();
        boolean checker;

        do {
            Scanner scanner = new Scanner(System.in);

            checker = false;
            if (roomMark ==1) System.out.print("Choose your vehicle type: \n" + vehicles + "\n");
            input=firstUpperCase(scanner.nextLine());
            Menu.clearScreen();

            // shows servicesForSelectedVehicle list for the selected vehicle
            if ((roomMark == 1) & mainMenu.containsKey(input)) {
                key = input;
                roomMark = 2;
                Menu.clearScreen();
                System.out.println("You've entered: " + key.toUpperCase());
                Menu.printTableWithServices(mainMenu,key);
                servicesForSelectedVehicle = mainMenu.get(key);
            }

            // Check if input equals servicesForSelectedVehicle
            if (roomMark == 2){
                for (int i = 0; i < servicesForSelectedVehicle.size(); i++) {     // Check if input equals servicesForSelectedVehicle
                    Services services = servicesForSelectedVehicle.get(i);
                    if (input.equalsIgnoreCase(services.getService())) {

                        // addition to the basket
                        System.out.println("You have ordered "+ servicesForSelectedVehicle.get(i).getService() + " (" + servicesForSelectedVehicle.get(i).getDescription() + ") for "+key +".\n");
                        List<Services> current = mainMenu.get(key);
                        Services addServices = current.get(i);
                        Basket.addServiceBasket(addServices, basket, bill);
                        checker =true;
                        Menu.printTableWithServices(mainMenu, key);
                    }
                }
            }

            if (!(input.equalsIgnoreCase("back") |
                    input.equalsIgnoreCase("bill") |
                    input.equalsIgnoreCase("q") |
                    input.equals(key) |
                    checker)) {
                System.out.println("Incorrect input. Please try again.");
                if (roomMark ==2) Menu.printTableWithServices(mainMenu,key);
            }

            // prints current bill;
            if (input.equalsIgnoreCase("bill")) Basket.billPrint(bill);

            // go one level up;
            if (input.equalsIgnoreCase("back")) roomMark = 1;

        } while (!(input.equalsIgnoreCase("q")));

        System.out.println("Thank you.");
        Basket.billPrint(bill);
    }
    private static void clearScreen () {
        // emulation of clearscreen command
        for (int i=0; i < 24; i++) System.out.println();
    }

    private static void printTableWithServices(Map<String,List<Services>> mainMenu, String key) {
        System.out.println("We can offer following services for your: "+key.toUpperCase());
        String format = "|%1$-15s|%2$-5s|%3$-8s|%4$-70s|\n";
        int tableLength = 103;
        for(int i=1; i<=tableLength; i++) System.out.print("=");
        System.out.println();
        System.out.format(format, "Service", "Price", "Currency", "Description");
        for(int i=1; i<=tableLength; i++) System.out.print("=");
        System.out.println();

        for (Services current : mainMenu.get(key)) {
            System.out.format(format, current.getService(), current.getPrice(), CURRENCY, current.getDescription());
        }

        for(int i=1; i<=tableLength; i++) System.out.print("=");
        System.out.println();
    }

}



