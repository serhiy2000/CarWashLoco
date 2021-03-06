import java.util.*;

public class Menu {

    private final static String CURRENCY = "uah";
    static final String REGEXTOGETCHARS = "[^A-Za-z]";
    static final String REGEXTOGETNUMBERS = "[^0-9]";

    private static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return ""; 
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    static void start() {
        // creates menu for main entrance;
        Map<String, List<Services>> mainMenu = new LinkedHashMap<>();
        // fills menu with data from Services;
        Services.fillMainMenu(mainMenu);
        Set<Basket> bill = new LinkedHashSet<>();
        String input, key = "init";
        int roomMark = 1;
        boolean checker;
        boolean checkerForWrongInput;
        String convertToWordCommand;
        String convertToIntegerCommand;

        do {
            Scanner scanner = new Scanner(System.in);
            checker = false;
            checkerForWrongInput = false;
            if (roomMark == 1) System.out.print("Choose your vehicle type: \n" + mainMenu.keySet() + "\n");
            input=firstUpperCase(scanner.nextLine());
            Menu.clearScreen();

            // shows servicesForSelectedVehicle list for the selected vehicle
            if (roomMark == 1){
                for (String iteratorWithinKeySet : mainMenu.keySet()){
                    convertToWordCommand = iteratorWithinKeySet.replaceAll(REGEXTOGETCHARS,"");
                    convertToIntegerCommand = iteratorWithinKeySet.replaceAll(REGEXTOGETNUMBERS,"");
                    if ((input.equalsIgnoreCase(convertToWordCommand) | input.equals(convertToIntegerCommand))) key = iteratorWithinKeySet;
                    if (roomMark == 1 & key.equals(iteratorWithinKeySet)){
                        roomMark = 2;
                        Menu.clearScreen();
                        checkerForWrongInput = true;
                    }
                }
                System.out.println("You've entered: " + key.toUpperCase().replaceAll(REGEXTOGETCHARS,""));
                Menu.printTableWithServices(mainMenu,key);
            }

            // Check if input equals servicesForSelectedVehicle, than adds to the basket
            if (roomMark == 2 & !checkerForWrongInput){
                for (int i = 0; mainMenu.get(key).size() > i; i++) {     // Check if input equals servicesForSelectedVehicle
                    Services servicesForSelectedVehicle = mainMenu.get(key).get(i);
                    convertToWordCommand = servicesForSelectedVehicle.getService().replaceAll(REGEXTOGETCHARS,"");
                    convertToIntegerCommand = servicesForSelectedVehicle.getService().replaceAll(REGEXTOGETNUMBERS,"");

                    if (input.equalsIgnoreCase(convertToWordCommand) || input.equals(convertToIntegerCommand)) {
                        // addition to the basket
                        System.out.println("You have ordered "+ mainMenu.get(key).get(i).getService().replaceAll(REGEXTOGETCHARS,"") +
                                " (" + mainMenu.get(key).get(i).getDescription().replaceAll(REGEXTOGETCHARS,"") + ") for "+key.replaceAll(REGEXTOGETCHARS,"") +".\n");
                        Services addServices = mainMenu.get(key).get(i);
                        Basket.addServiceBasket(addServices, bill);
                        checker = true;
                        Menu.printTableWithServices(mainMenu, key);
                        checkerForWrongInput=true;
                    }
                }
            }

            // prints current bill;
            if (input.equalsIgnoreCase("bill")) Basket.billPrint(bill);

            // go one level up;
            if (input.equalsIgnoreCase("back")) roomMark = 1;

            // incorrect input processing;
            if (!(input.equalsIgnoreCase("back") |
                    input.equalsIgnoreCase("bill") |
                    input.equalsIgnoreCase("q") |
                    input.equals(key) |
                    checker |
                    checkerForWrongInput)){
                System.out.println("Incorrect input. Please try again.");
                if (roomMark == 2) Menu.printTableWithServices(mainMenu,key);
            }
        } while (!(input.equalsIgnoreCase("q")));
        System.out.println("Thank you.");
        Basket.billPrint(bill);
    }

    private static void clearScreen () {
        // emulation of clearscreen command
        for (int i=0; i < 44; i++) System.out.println();
    }
    private static void printTableWithServices(Map<String,List<Services>> mainMenu, String key) {
        if (key.equalsIgnoreCase("INIT")){
            System.out.println("You didn't enter correct command.");
        } else {
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
}



