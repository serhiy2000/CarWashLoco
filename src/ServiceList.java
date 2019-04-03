import java.util.*;

public class ServiceList {

    String vehicle;
    String service;
    int price;
    String description;

    public ServiceList(String vehicle, String service, int price, String description) {
        this.vehicle = vehicle;
        this.service = service;
        this.price = price;
        this.description = description;
    }

    public String getService() {
        return service;
    }

    public int getPrice() {
        return price;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getDescription() { return description; }

    @Override
    public String toString() {
        return service  +
                "(price=" + price +")";
    }

    public static void fillArrayListCar(ArrayList arrayList){

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

    public static void fillArrayListTruck(ArrayList arrayList){

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


    public static void fillArrayListMoto(ArrayList arrayList){

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

    public static void fillArrayListCross(ArrayList arrayList){

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

    public static void fillHashMap (HashMap hashMap){

        ArrayList <ServiceList> serviceCar = new ArrayList<>();
        ServiceList.fillArrayListCar(serviceCar);

        ArrayList <ServiceList> serviceTruck = new ArrayList<>();
        ServiceList.fillArrayListTruck(serviceTruck);

        ArrayList <ServiceList> serviceMoto = new ArrayList<>();
        ServiceList.fillArrayListMoto(serviceMoto);

        ArrayList <ServiceList> serviceCross = new ArrayList<>();
        ServiceList.fillArrayListCross(serviceCross);

        hashMap.put("Car",serviceCar);
        hashMap.put("Truck",serviceTruck);
        hashMap.put("Motorcycle",serviceMoto);
        hashMap.put("Crossover",serviceCross);

            }

}