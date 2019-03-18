import java.util.Iterator;
import java.util.LinkedHashSet;

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

    public int getQuantity() {
        return quantity;
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

    public static void addServiceBasket (ServiceList serviceToBasket, LinkedHashSet basket, LinkedHashSet bill) {

//        basket.add(serviceToBasket);
        String veh = serviceToBasket.getVehicle();
        String ser = serviceToBasket.getService();
        int pri = serviceToBasket.getPrice();


// here when adding new service we check if it is in the list. than it adds. looks like working good
        if (basket.add(serviceToBasket)) {

            int quantity = 1;
            Basket addBillItem = new Basket(veh, ser, pri, quantity);
            bill.add(addBillItem);
            System.out.println(bill);

// я дописав до цього місця.
//

        } else {
            System.out.println("We have this service in our basket already/");

            Iterator<Basket> iterator = bill.iterator();
            Basket currentItem = iterator.next();
            if (currentItem.getVehicle().equals(serviceToBasket.getVehicle()) & currentItem.getService().equals(serviceToBasket.getService())) {

                int quantity = currentItem.getQuantity() + 1;

                bill.remove(currentItem);
                Basket addBillItem = new Basket(serviceToBasket.getVehicle(), serviceToBasket.getService(), serviceToBasket.getPrice(), quantity);
                bill.add(addBillItem);
                System.out.println("Now in checkout we have " + bill);
            }


        }
    }

}






