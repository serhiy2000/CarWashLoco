import java.util.*;

public class ServiceList {

    private String vehicle;
    private String service;
    private int price;
    private String description;

    private ServiceList(String vehicle, String service, int price, String description) {
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

    private static void fillArrayListCar(ArrayList<ServiceList> arrayList){

        String vehicle = "Car";
        ServiceList service1 = new ServiceList(vehicle,"Wash", 20, "Full body wash with active foam");
        ServiceList service2 = new ServiceList(vehicle,"Tires wash", 10, "Tires wash with water and active foam");
        ServiceList service3 = new ServiceList(vehicle,"Engine wash", 15, "Engine wash with water-soluble engine degreaser");
        ServiceList service4 = new ServiceList(vehicle,"Vacuum", 15, "Interior cleaning with the vacuum cleaner");
        ServiceList service5 = new ServiceList(vehicle,"Polish", 25, "Polishing with an electric polisher and covering a car with a wax");
            arrayList.add(service1);
            arrayList.add(service2);
            arrayList.add(service3);
            arrayList.add(service4);
            arrayList.add(service5);

        }

    private static void fillArrayListCross(ArrayList<ServiceList> arrayList){

        String vehicle = "Crossover";
        ServiceList service1 = new ServiceList(vehicle,"Wash", 25, "Full body wash with active foam");
        ServiceList service2 = new ServiceList(vehicle,"Tires wash", 10, "Tires wash with water and active foam");
        ServiceList service3 = new ServiceList(vehicle,"Engine wash", 20, "Engine wash with water-soluble engine degreaser");
        ServiceList service4 = new ServiceList(vehicle,"Vacuum", 15, "Interior cleaning with the vacuum cleaner");
        ServiceList service5 = new ServiceList(vehicle,"Polish", 30, "Polishing with an electric polisher and covering a crossover with a wax");

        arrayList.add(service1);
        arrayList.add(service2);
        arrayList.add(service3);
        arrayList.add(service4);
        arrayList.add(service5);

    }

    private static void fillArrayListMoto(ArrayList<ServiceList> arrayList){

        String vehicle = "Motorcycle";
        ServiceList service1 = new ServiceList(vehicle,"Wash", 10, "Full body wash with active foam");
        ServiceList service2 = new ServiceList(vehicle,"Tires wash", 5, "Tires wash with water and active foam");
        ServiceList service3 = new ServiceList(vehicle,"Engine wash", 15, "Engine wash with water-soluble engine degreaser");
        ServiceList service4 = new ServiceList(vehicle,"Polish", 20, "Polishing with an electric polisher and covering a fueltank with a wax");

        arrayList.add(service1);
        arrayList.add(service2);
        arrayList.add(service3);
        arrayList.add(service4);

    }

    private static void fillArrayListTruck(ArrayList<ServiceList> arrayList){

        String vehicle = "Truck";
        ServiceList service1 = new ServiceList(vehicle,"Wash", 50, "Full body wash with active foam");
        ServiceList service2 = new ServiceList(vehicle,"Tires wash", 20, "Tires wash with water and active foam");
        ServiceList service3 = new ServiceList(vehicle,"Engine wash", 25, "Engine wash with water-soluble engine degreaser");
        ServiceList service4 = new ServiceList(vehicle,"Vacuum", 15, "Interior cleaning with the vacuum cleaner");
        ServiceList service5 = new ServiceList(vehicle,"Polish", 30, "Polishing with an electric polisher and covering a truck with a wax");


            arrayList.add(service1);
            arrayList.add(service2);
            arrayList.add(service3);
            arrayList.add(service4);
            arrayList.add(service5);

        }

    public static void fillMap(Map menuMap){

        List <ServiceList> serviceCar = new ArrayList<>();
        ServiceList.fillArrayListCar(serviceCar);

        List <ServiceList> serviceTruck = new ArrayList<>();
        ServiceList.fillArrayListTruck((ArrayList) serviceTruck);

        List <ServiceList> serviceMoto = new ArrayList<>();
        ServiceList.fillArrayListMoto((ArrayList) serviceMoto);

        List <ServiceList> serviceCross = new ArrayList<>();
        ServiceList.fillArrayListCross((ArrayList) serviceCross);

        menuMap.put("Car",serviceCar);
        menuMap.put("Truck",serviceTruck);
        menuMap.put("Motorcycle",serviceMoto);
        menuMap.put("Crossover",serviceCross);

            }

}