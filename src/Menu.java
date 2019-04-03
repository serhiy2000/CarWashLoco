import java.util.*;

public class Menu {


    private static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return ""; 
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public static void start() {

        HashMap <String, ArrayList> menuMap = new HashMap(); // creates menu for main entrance;
        ServiceList.fillHashMap(menuMap); // fills menu with data from ServiceList;

        Set <ServiceList> basket = new LinkedHashSet<>();
        Set <Basket> bill = new LinkedHashSet<>();

        Set vehicles = menuMap.keySet();  // main menu list

        String input, key = "init";
        int roomMark = 1;
        List <ServiceList> currentServiceList = new ArrayList<>();
        boolean checker;
        int positionMark = 0;

        do {
            checker = false;
            Scanner scanner = new Scanner(System.in);

            if (roomMark ==1) System.out.print("Choose your vehicle type: \n" + vehicles + "\n");

            System.out.println("Please enter your choice:");

            input=firstUpperCase(scanner.nextLine());

            if ((roomMark == 1) & menuMap.containsKey(input)) {    // shows service list for the selected vehicle
                key = input;
                roomMark = 2;
                System.out.println("You've entered: " + key.toUpperCase() + '\n' + "We would like to offer the following services for your: "+key.toUpperCase());

                Iterator <ServiceList> iterator = menuMap.get(key).iterator();
                while (iterator.hasNext()){
                    ServiceList current = iterator.next();
                    System.out.println(current.getService()+"(price = "+current.getPrice()+") USD");
                }
                currentServiceList = menuMap.get(key);
            }

                for (int i = 0; i < currentServiceList.size(); i++) {      // Check if input equals service
                    ServiceList serviceList = currentServiceList.get(i);
                    String serviceInput = (serviceList.getService());

                    if (input.equalsIgnoreCase(serviceInput)) {
                        positionMark = i;
                        System.out.println("You've ordered "+ serviceInput + " for "+key);
                        checker = true;
                    }
                }

            if ((menuMap.containsKey(key)) & (checker)) {   // addition to the basket
                ArrayList <ServiceList> current = menuMap.get(key);
                ServiceList addServiceList = current.get(positionMark);
                Basket.addServiceBasket(addServiceList, basket, bill);
                Basket.billPrint(bill);
            }

            if (!(input.equalsIgnoreCase("back") |
                    input.equalsIgnoreCase("bill") |
                    input.equalsIgnoreCase("q") |
                    menuMap.containsKey(input) |
                    checker) ) {
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



