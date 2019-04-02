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


//        Iterator <Basket> iterator = bill.iterator();
//        while (iterator.hasNext()){
//            Basket currentItem = iterator.next();
//            if (currentItem.getVehicle().equalsIgnoreCase(serviceToBasket.getVehicle()) &
//                    currentItem.getService().equalsIgnoreCase(serviceToBasket.getService())) {
//                int quantity = currentItem.getQuantity() + 1;
//
//                bill.remove(currentItem);
//                Basket addBillItem = new Basket(veh, ser, pri, quantity);
//                bill.add(addBillItem);
//                System.out.println(bill);
//                basketAdd=true;
//            }
//
//        }
//        System.out.println("цикл длобавки в корзинус");
//
//
//        if (basketAdd=false){
//            int quantity = 1;
//            Basket addBillItem = new Basket(veh, ser, pri, quantity);
//            bill.add(addBillItem);
//            System.out.println(bill);
//
//        }

        if (basket.add(serviceToBasket)) {

            int quantity = 1;
            Basket addBillItem = new Basket(veh, ser, pri, quantity);
            bill.add(addBillItem);


        } else {
            System.out.println("We have this service in our basket already. Quantity incremented.");

            Iterator<Basket> iterator = bill.iterator();
            while (iterator.hasNext()){
                Basket currentItem = iterator.next();

                if (currentItem.getVehicle().equalsIgnoreCase(serviceToBasket.getVehicle()) &
                        currentItem.getService().equalsIgnoreCase(serviceToBasket.getService())) {

                    int quantity = currentItem.getQuantity() + 1;

                    bill.remove(currentItem);
                    Basket addBillItem = new Basket(veh, ser, pri, quantity);
                    bill.add(addBillItem);

                }
            }

        }
    }

    public static void billPrint (Set bill){
        int billSum = 0;

        String format = "|%1$-8s|%2$-20s|%3$-5s|%4$-8s|\n";
        for(int i=1; i<=46; i++) System.out.print("=");
        System.out.println();
        System.out.format(format, "Vehicle","Service","Price", "Quantity");
        for(int i=1; i<=46; i++) System.out.print("=");
        System.out.println();

        Iterator <Basket> iterator = bill.iterator();
        while (iterator.hasNext()){
            Basket currentItem = iterator.next();
            billSum = billSum+currentItem.getQuantity()*currentItem.getPrice();
            System.out.format(format, currentItem.getVehicle(),currentItem.getService(),currentItem.getPrice(),currentItem.getQuantity());
        }
        for(int i=1; i<=46; i++) System.out.print("=");
        System.out.println();
        System.out.println("Total sum of ordered services: "+ billSum +" UAH");
        System.out.println();



    }
}






