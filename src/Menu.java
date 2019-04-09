import java.util.*;

public class Menu {


    private static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return ""; 
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public static void start() {

        Map <String, ArrayList> menuMap = new LinkedHashMap<>(); // creates menu for main entrance;
        ServiceList.fillMap(menuMap); // fills menu with data from ServiceList;

        Set <ServiceList> basket = new LinkedHashSet<>();
        Set <Basket> bill = new LinkedHashSet<>();
        Set vehicles = menuMap.keySet();  // main menu list

        String input, key = "init";
        int roomMark = 1;
        List <ServiceList> currentServiceList = new ArrayList<>();
        boolean checker;

        do {
            checker = false; // checks if the command for ordered service is in servicelist

            Scanner scanner = new Scanner(System.in);

            if (roomMark ==1) System.out.print("Choose your vehicle type: \n" + vehicles + "\n");

            System.out.println("Please enter your choice (vehicle or service, \"q\"-for checkout, \"bill\" - shows your bill, \"back\" - back to vehicle selection):");

            input=firstUpperCase(scanner.nextLine());

            for (int i=0; i < 24; i++) System.out.println(); // emulation of clearscreen command

            if ((roomMark == 1) & menuMap.containsKey(input)) {    // shows service list for the selected vehicle
                key = input;
                roomMark = 2;

                System.out.println("You've entered: " + key.toUpperCase() + '\n' + "We would like to offer the following services for your: "+key.toUpperCase());

                String format = "|%1$-15s|%2$-5s|%3$-8s|%4$-70s|\n";
                int tableLength = 103;
                for(int i=1; i<=tableLength; i++) System.out.print("=");
                System.out.println();
                System.out.format(format, "Service", "Price", "Currency", "Description");
                for(int i=1; i<=tableLength; i++) System.out.print("=");
                System.out.println();

                Iterator <ServiceList> iterator = menuMap.get(key).iterator();
                while (iterator.hasNext()){
                    ServiceList current = iterator.next();
                    System.out.format(format, current.getService(), current.getPrice(), "USD", current.getDescription());
                }
                for(int i=1; i<=tableLength; i++) System.out.print("=");
                System.out.println();


                currentServiceList = menuMap.get(key);
            } // shows service list for the selected vehicle

            for (int i = 0; i < currentServiceList.size(); i++) {     // Check if input equals service
                    ServiceList serviceList = currentServiceList.get(i);
                    String serviceInput = (serviceList.getService());
                    String serviceDescription = (serviceList.getDescription());

                    if (input.equalsIgnoreCase(serviceInput)) {

                           // addition to the basket
                            System.out.println("You have ordered "+ serviceInput + " (" + serviceDescription + ") for "+key +".\n");
                            ArrayList <ServiceList> current = menuMap.get(key);
                            ServiceList addServiceList = current.get(i);
                            Basket.addServiceBasket(addServiceList, basket, bill);
                            //Basket.billPrint(bill);
                            checker =true;

                        System.out.println("You can order another services for your: "+key.toUpperCase());

                        String format = "|%1$-15s|%2$-5s|%3$-8s|%4$-70s|\n";
                        int tableLength = 103;
                        for(int j=1; j<=tableLength; j++) System.out.print("=");
                        System.out.println();
                        System.out.format(format, "Service", "Price", "Currency", "Description");
                        for(int j=1; j<=tableLength; j++) System.out.print("=");
                        System.out.println();

                        Iterator <ServiceList> iterator = menuMap.get(key).iterator();
                        while (iterator.hasNext()){
                            ServiceList currentList = iterator.next();
                            System.out.format(format, currentList.getService(), currentList.getPrice(), "USD", currentList.getDescription());
                        }
                        for(int j=1; j<=tableLength; j++) System.out.print("=");
                        System.out.println();


                    }
                } // Check if input equals service

            if (!(input.equalsIgnoreCase("back") |
                    input.equalsIgnoreCase("bill") |
                    input.equalsIgnoreCase("q") |
                    input == key |
                    checker)) {
                System.out.println("Incorrect input. Please try again.");

            }

            if (input.equalsIgnoreCase("bill")) {      // prints current bill;
            Basket.billPrint(bill);
            }

            if (input.equalsIgnoreCase("back")) {   // go one level up;
                roomMark = 1;
            }

        } while (!(input.equalsIgnoreCase("q")));

        System.out.println("Thank you.\nYou've ordered:");
        Basket.billPrint(bill);

    }

}



