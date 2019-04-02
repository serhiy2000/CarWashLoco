import java.util.*;

public class Menu {


    public static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return ""; 
        return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
    }

    private static final String SERVICE_PATTERN = "(%s)-%s-\t %s \t %s";

    public static void main() {

        HashMap <String, ArrayList> menuMap = new HashMap(); // creates menu for main entrance;
        ServiceList.fillHashMap(menuMap); // fills menu with data from ServiceList;

        Set <ServiceList> basket = new LinkedHashSet<>();
        Set <Basket> bill = new LinkedHashSet<>();

        Set vehicles = menuMap.keySet();  // main menu list

        String input, key = "f", service = ";";
        int roomMark = 1, serviceMark = 0;
        String input, key = "f";
        int roomMark = 1;
        List <ServiceList> currentServiceList = new ArrayList<>();
        Boolean checker;
        Integer positionMark = 99;

        do {
            checker = false;
            Scanner sc = new Scanner(System.in);

            if (roomMark ==1) System.out.print("We can make service to: \n"+vehicles + "\n");

            System.out.println("Please enter your choice:");

            input = sc.nextLine();
            input=firstUpperCase(input);

            if ((roomMark == 1) & menuMap.containsKey(input)) {    // shows service list for the selected vehicle
                key = input;
                roomMark = 2;
                System.out.println("You entered: " + key.toUpperCase() + "." + '\n' + "We can offer following services for: "+key.toUpperCase());

                Iterator <ServiceList> iter = menuMap.get(key).iterator();
                while (iter.hasNext()){
                    ServiceList current = iter.next();
                    System.out.println(current.getService()+"(price = "+current.getPrice()+") UAH");
                }
                currentServiceList = menuMap.get(key);
            }

                for (int i = 0; i < currentServiceList.size(); i++) {      // Check if input equals service
                    ServiceList serviceList = currentServiceList.get(i);
                    String serviceInput = (serviceList.getService());

                    if (input.equalsIgnoreCase(serviceInput)) {
                        positionMark = i;
                        System.out.println("You ordered "+ serviceInput + " for "+key);
                        checker = true;
                    }
                }

            if ((menuMap.containsKey(key)) & (checker == true)) {   // addition to the basket
                ArrayList <ServiceList> current = menuMap.get(key);
                ServiceList addServiceList = current.get(positionMark);
                Basket.addServiceBasket(addServiceList, basket, bill);
                Basket.billPrint(bill);
            }

            if (!(input.equalsIgnoreCase("back") |
                    input.equalsIgnoreCase("bill") |
                    input.equalsIgnoreCase("q") |
                    menuMap.containsKey(input) |
                    checker == true) ) {
                System.out.println("Incorrect input. Please try again.");

            }

            if (input.equalsIgnoreCase("bill")) {      // prints current bill;
            Basket.billPrint(bill);
            }

            if (input.equalsIgnoreCase("back")) {   // go one level up;
                roomMark = 1;
            }

        } while (!(input.equalsIgnoreCase("q")));

        System.out.println("Thank you.\nYou ordered:");
        Basket.billPrint(bill);

    }

}



