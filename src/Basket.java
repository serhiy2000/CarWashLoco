import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Basket {

    private String vehicle;
    private String service;
    private int price;
    private int quantity;

    public Basket(String vehicle, String service, int price, int quantity) {
        this.vehicle = vehicle;
        this.service = service;
        this.price = price;
        this.quantity = quantity;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getService() {
        return service;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "vehicle='" + vehicle + '\'' +
                ", service='" + service + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public static void addServiceBasket (ServiceList serviceToCheque, LinkedHashSet basket, LinkedHashSet check) {

        basket.add(serviceToCheque);
        String veh = serviceToCheque.getVehicle();
        String ser = serviceToCheque.getService();
        int pri = serviceToCheque.getPrice();


// here when adding new service we check if it is in the list. than it adds. looks like working good
        if (basket.add(serviceToCheque)) {

            int quantity = 1;
            Basket addCheckoutItem = new Basket(veh, ser, pri, quantity);
            check.add(addCheckoutItem);
            System.out.println(check);

// я дописав до цього місця.
//

        } else {
            System.out.println("We have this service in our basket already/");
            Iterator<Basket> iterator = check.iterator();
            Basket currentItem = iterator.next();
            if (currentItem.getVehicle().equals(basketItem.getVehicle()) & currentItem.getService().equals(basketItem.getService())) {
                int quantity = currentItem.getQuantity() + 1;

                check.remove(currentItem);
                Basket checkItem = new Basket(basketItem.getVehicle(), basketItem.getService(), basketItem.getPrice(), quantity);
                check.add(checkItem);
                System.out.println("Now in checkout we have " + check);
            }


        }
    }

    // Ill try to make Q button.

//        System.out.println("Thank you. Your order is:");
//        Iterator <Basket> iterator = check.iterator();
//        int sum = 0;
//        while (iterator.hasNext())
//        {
//            Basket currentItem = iterator.next();
//            sum = sum + currentItem.getPrice()*currentItem.getQuantity();
//        }
//        System.out.println(sum);
//    }
}






