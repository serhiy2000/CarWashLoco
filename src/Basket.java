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
        return
                "vehicle='" + vehicle + '\'' +
                ", service='" + service + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ';';
    }

    public static void addServiceBasket (ServiceList serviceToBasket, Set basket, Set bill) {

        String veh = serviceToBasket.getVehicle();
        String ser = serviceToBasket.getService();
        int pri = serviceToBasket.getPrice();


// here when adding new service we check if it is in the list. than it adds. looks like working good
        if (basket.add(serviceToBasket)) {

            int quantity = 1;
            Basket addBillItem = new Basket(veh, ser, pri, quantity);
            bill.add(addBillItem);
            System.out.println("We have in bill:" +"\n"+ bill);

        } else {
            System.out.println("We have this service in our basket already. Quantity incremented.");
            System.out.println("else basket" + basket);

            Iterator<Basket> iterator = bill.iterator();
            Basket currentItem = iterator.next();

                System.out.println("current item = " + currentItem.getVehicle() + currentItem.getService());

                if (currentItem.getVehicle().equalsIgnoreCase(serviceToBasket.getVehicle()) &
                        currentItem.getService().equalsIgnoreCase(serviceToBasket.getService())) {

                    int quantity = currentItem.getQuantity() + 1;

                    bill.remove(currentItem);
                    Basket addBillItem = new Basket(veh, ser, pri, quantity);
                    bill.add(addBillItem);
                    System.out.println(bill);
                }

        }
    }

    public static void billPrint (Set bill){
        int billSum = 0;
        Iterator <Basket> iterator = bill.iterator();
        while (iterator.hasNext()){
            Basket currentServiceList = iterator.next();
            billSum = billSum+currentServiceList.getQuantity()*currentServiceList.getPrice();

        }
        System.out.println(bill);
        System.out.println("Total sum of ordered services: "+ billSum +" UAH");

    }
}






