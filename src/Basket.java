import java.util.Iterator;
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

    private String getVehicle() {
        return vehicle;
    }

    private String getService() {
        return service;
    }

    private int getPrice() {
        return price;
    }

    private int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return
                "vehicle='" + vehicle + '\'' +
                ", service='" + service + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ';';

    }

    public static void addServiceBasket (ServiceList serviceToBasket, Set basket, Set bill) {

        String toBasketVehicle = serviceToBasket.getVehicle();
        String toBasketService = serviceToBasket.getService();
        int toBasketPrice = serviceToBasket.getPrice();

// here when adding new service we check if it is in the list, then it is added

        if (basket.add(serviceToBasket)) {

            int quantity = 1;
            Basket addBillItem = new Basket(toBasketVehicle, toBasketService, toBasketPrice, quantity);
            bill.add(addBillItem);


        } else {
            Iterator<Basket> iterator = bill.iterator();
            while (iterator.hasNext()){
                Basket currentItem = iterator.next();

                if (currentItem.getVehicle().equalsIgnoreCase(serviceToBasket.getVehicle()) &
                        currentItem.getService().equalsIgnoreCase(serviceToBasket.getService())) {

                    int quantity = currentItem.getQuantity() + 1;

                    bill.remove(currentItem);
                    Basket addBillItem = new Basket(toBasketVehicle, toBasketService, toBasketPrice, quantity);
                    bill.add(addBillItem);

                }
            }

        }
    }

    public static void billPrint (Set bill){
        int billSum = 0;

        int tableLength = 49;

        String format = "|%1$-11s|%2$-20s|%3$-5s|%4$-8s|\n";
        for(int i=1; i<=tableLength; i++) System.out.print("=");
        System.out.println();
        System.out.format(format, "Vehicle","Service","Price", "Quantity");
        for(int i=1; i<=tableLength; i++) System.out.print("=");
        System.out.println();

        Iterator <Basket> iterator = bill.iterator();
        while (iterator.hasNext()){
            Basket currentItem = iterator.next();
            billSum = billSum + currentItem.getQuantity() * currentItem.getPrice();
            System.out.format(format, currentItem.getVehicle(), currentItem.getService(),
                    currentItem.getPrice(), currentItem.getQuantity());
        }
        for(int i=1; i<=tableLength; i++) System.out.print("=");
        System.out.println();
        System.out.println("Total sum of ordered services: "+ billSum +" USD");
        System.out.println();



    }
}






