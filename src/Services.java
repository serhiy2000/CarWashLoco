import java.util.*;

public class Services {

    private static String CAR = "Car";
    private static String MOTO = "Moto";
    private static String TRUCK = "Truck";
    private static String CROSS = "Cross";

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

    private static void fillArrayListCar(List<Services> services){

            services.add(new Services(CAR,"Wash", 20, "Full body wash with active foam"));
            services.add(new Services(CAR,"Tires wash", 10, "Tires wash with water and active foam"));
            services.add(new Services(CAR,"Engine wash", 15, "Engine wash with water-soluble engine degreaser"));
            services.add(new Services(CAR,"Vacuum", 15, "Interior cleaning with the vacuum cleaner"));
            services.add(new Services(CAR,"Polish", 25, "Polishing with an electric polisher and covering a car with a wax"));
        }

    private static void fillArrayListCross(List<Services> services){

        services.add(new Services(CROSS,"Wash", 25, "Full body wash with active foam"));
        services.add(new Services(CROSS,"Tires wash", 10, "Tires wash with water and active foam"));
        services.add(new Services(CROSS,"Engine wash", 20, "Engine wash with water-soluble engine degreaser"));
        services.add(new Services(CROSS,"Vacuum", 15, "Interior cleaning with the vacuum cleaner"));
        services.add(new Services(CROSS,"Polish", 30, "Polishing with an electric polisher and covering a crossover with a wax"));
    }

    private static void fillArrayListMoto(List<Services> services){

        services.add(new Services(MOTO,"Wash", 10, "Full body wash with active foam"));
        services.add(new Services(MOTO,"Tires wash", 5, "Tires wash with water and active foam"));
        services.add(new Services(MOTO,"Engine wash", 15, "Engine wash with water-soluble engine degreaser"));
        services.add(new Services(MOTO,"Polish", 20, "Polishing with an electric polisher and covering a fueltank with a wax"));
    }

    private static void fillArrayListTruck(List<Services> services){
            services.add(new Services(TRUCK,"Wash", 50, "Full body wash with active foam"));
            services.add(new Services(TRUCK,"Tires wash", 20, "Tires wash with water and active foam"));
            services.add(new Services(TRUCK,"Engine wash", 25, "Engine wash with water-soluble engine degreaser"));
            services.add(new Services(TRUCK,"Vacuum", 15, "Interior cleaning with the vacuum cleaner"));
            services.add(new Services(TRUCK,"Polish", 30, "Polishing with an electric polisher and covering a truck with a wax"));
        }

    static void fillMainMenu(Map<String, List<Services>> menuMap){

        List<Services> serviceForCar = new ArrayList<>();
        Services.fillArrayListCar(serviceForCar);

        List<Services> serviceForTruck = new ArrayList<>();
        Services.fillArrayListTruck(serviceForTruck);

        List<Services> serviceForMoto = new ArrayList<>();
        Services.fillArrayListMoto(serviceForMoto);

        List<Services> serviceForCross = new ArrayList<>();
        Services.fillArrayListCross(serviceForCross);


        menuMap.put(CAR, serviceForCar);
        menuMap.put(TRUCK, serviceForTruck);
        menuMap.put(MOTO, serviceForMoto);
        menuMap.put(CROSS, serviceForCross);
            }
}