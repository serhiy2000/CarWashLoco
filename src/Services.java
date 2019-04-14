import java.util.*;

public class Services {

    private static String CAR = "1.Car";
    private static String MOTO = "2.Moto";
    private static String TRUCK = "3.Truck";
    private static String CROSS = "4.Cross";

    private String vehicle;
    private String service;
    private int price;
    private String description;

    private Services(String vehicle, String service, int price, String description) {
        this.vehicle = vehicle;
        this.service = service;
        this.price = price;
        this.description = description;
    }

    String getService() {
        return service;
    }

    int getPrice() {
        return price;
    }

    String getVehicle() {
        return vehicle;
    }

    String getDescription() { return description; }

    @Override
    public String toString() {
        return service  +
                "(price=" + price +")";
    }

    private static void fillServicesForCar(List<Services> services){
        services.add(new Services(CAR,"1.Wash", 20, "Full body wash with active foam"));
        services.add(new Services(CAR,"2.Tires wash", 10, "Tires wash with water and active foam"));
        services.add(new Services(CAR,"3.Engine wash", 15, "Engine wash with water-soluble engine degreaser"));
        services.add(new Services(CAR,"4.Vacuum", 15, "Interior cleaning with the vacuum cleaner"));
        services.add(new Services(CAR,"5.Polish", 25, "Polishing with an electric polisher and covering a car with a wax"));
        }

    private static void fillServicesForCross(List<Services> services){
        services.add(new Services(CROSS,"1.Wash", 25, "Full body wash with active foam"));
        services.add(new Services(CROSS,"2.Tires wash", 10, "Tires wash with water and active foam"));
        services.add(new Services(CROSS,"3.Engine wash", 20, "Engine wash with water-soluble engine degreaser"));
        services.add(new Services(CROSS,"4.Vacuum", 15, "Interior cleaning with the vacuum cleaner"));
        services.add(new Services(CROSS,"5.Polish", 30, "Polishing with an electric polisher and covering a crossover with a wax"));
    }

    private static void fillServicesForMoto(List<Services> services){
        services.add(new Services(MOTO,"1.Wash", 10, "Full body wash with active foam"));
        services.add(new Services(MOTO,"2.Tires wash", 5, "Tires wash with water and active foam"));
        services.add(new Services(MOTO,"3.Engine wash", 15, "Engine wash with water-soluble engine degreaser"));
        services.add(new Services(MOTO,"4.Polish", 20, "Polishing with an electric polisher and covering a fueltank with a wax"));
    }

    private static void fillServicesForTruck(List<Services> services){
        services.add(new Services(TRUCK,"1.Wash", 50, "Full body wash with active foam"));
        services.add(new Services(TRUCK,"2.Tires wash", 20, "Tires wash with water and active foam"));
        services.add(new Services(TRUCK,"3.Engine wash", 25, "Engine wash with water-soluble engine degreaser"));
        services.add(new Services(TRUCK,"4.Vacuum", 15, "Interior cleaning with the vacuum cleaner"));
        services.add(new Services(TRUCK,"5.Polish", 30, "Polishing with an electric polisher and covering a truck with a wax"));
        }

    static void fillMainMenu(Map<String, List<Services>> menuMap){
        List<Services> serviceForCar = new ArrayList<>();
        Services.fillServicesForCar(serviceForCar);
        List<Services> serviceForTruck = new ArrayList<>();
        Services.fillServicesForTruck(serviceForTruck);
        List<Services> serviceForMoto = new ArrayList<>();
        Services.fillServicesForMoto(serviceForMoto);
        List<Services> serviceForCross = new ArrayList<>();
        Services.fillServicesForCross(serviceForCross);
        menuMap.put(CAR, serviceForCar);
        menuMap.put(MOTO, serviceForMoto);
        menuMap.put(TRUCK, serviceForTruck);
        menuMap.put(CROSS, serviceForCross);
    }
}