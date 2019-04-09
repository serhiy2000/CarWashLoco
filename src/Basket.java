import java.util.Set;

public class Basket {

    static String CURRENCY = "uah";

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

    static void addServiceBasket (Services serviceToAddToBasket, Set<Services> basket, Set<Basket> bill) {

        String toBasketVehicle = serviceToAddToBasket.getVehicle();
        String toBasketService = serviceToAddToBasket.getService();
        int toBasketPrice = serviceToAddToBasket.getPrice();

        // we check if serviceToBeAdded is in the list, then it is added or incremented
        if (basket.add(serviceToAddToBasket)) {
            int quantity = 1;
            bill.add(new Basket(toBasketVehicle, toBasketService, toBasketPrice, quantity));
        } else {
            for (Basket currentItem : bill) {
                if (currentItem.getVehicle().equalsIgnoreCase(serviceToAddToBasket.getVehicle()) &
                        currentItem.getService().equalsIgnoreCase(serviceToAddToBasket.getService())) {
                    int quantity = currentItem.getQuantity() + 1;
                    bill.remove(currentItem);
                    bill.add(new Basket(toBasketVehicle, toBasketService, toBasketPrice, quantity));
                }
            }
        }
    }

    static void billPrint (Set<Basket> bill){
        int billSum = 0;
        int tableLength = 49;
        System.out.println("You have ordered:");
        String format = "|%1$-11s|%2$-20s|%3$-5s|%4$-8s|\n";
        for(int i=1; i<=tableLength; i++) System.out.print("=");
        System.out.println();
        System.out.format(format, "Vehicle","Service","Price", "Quantity");
        for(int i=1; i<=tableLength; i++) System.out.print("=");
        System.out.println();

        for (Basket currentItem : bill) {
            billSum = billSum + currentItem.getQuantity() * currentItem.getPrice();
            System.out.format(format, currentItem.getVehicle(), currentItem.getService(),
                    currentItem.getPrice(), currentItem.getQuantity());
        }
        for(int i=1; i<=tableLength; i++) System.out.print("=");
        System.out.println();
        System.out.println("Total sum of ordered services: " + billSum + " " + CURRENCY);
        System.out.println();
    }
}






