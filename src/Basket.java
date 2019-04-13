import java.util.Iterator;
import java.util.Set;

public class Basket {

    static final String CURRENCY = "uah";
    static final String REGEXTOGETCHARS = "[^A-Za-z]";
    private String vehicle;
    private String service;
    private int price;
    private int quantity;
    private static boolean itemInTheBasketAlready;

    public Basket(String vehicle, String service, int price, int quantity) {
        this.vehicle = vehicle;
        this.service = service;
        this.price = price;
        this.quantity = quantity;
    }

    public Basket() {

    }

    private String getVehicle() {
        return vehicle;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    static void addServiceBasket (Services serviceToAddToBasket, Set<Basket> bill) {

        itemInTheBasketAlready = false;

        System.out.println(serviceToAddToBasket.getVehicle());
        System.out.println(serviceToAddToBasket.getService());
        Iterator<Basket> iterator = bill.iterator();
           while (iterator.hasNext()){
               Basket current ;
               current = iterator.next();
                 if (current.getVehicle().equalsIgnoreCase(serviceToAddToBasket.getVehicle()) &
                       current.getService().equalsIgnoreCase(serviceToAddToBasket.getService())) {
                   itemInTheBasketAlready = true;
                   int incrementedQuantity = current.getQuantity() + 1;
                   current.setQuantity(incrementedQuantity);
               }
           }

        if (!itemInTheBasketAlready) {
            bill.add(new Basket(serviceToAddToBasket.getVehicle(), serviceToAddToBasket.getService(),
                    serviceToAddToBasket.getPrice(), 1));
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
            System.out.format(format,
                    currentItem.getVehicle().replaceAll(REGEXTOGETCHARS,""),
                    currentItem.getService().replaceAll(REGEXTOGETCHARS,""),
                    currentItem.getPrice(),
                    currentItem.getQuantity());
        }
        for(int i=1; i<=tableLength; i++) System.out.print("=");
        System.out.println();
        System.out.println("Total sum of ordered services: " + billSum + " " + CURRENCY);
        System.out.println();
    }
}






