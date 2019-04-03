import java.util.*;

public class ServiceList {

    String vehicle;
    String service;
    int price;

    public ServiceList(String vehicle, String service, int price) {
        this.vehicle = vehicle;
        this.service = service;
        this.price = price;
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

    @Override
    public String toString() {
        return service  +
                "(price=" + price +")";
    }

    public static void fillArrayListCar(ArrayList arrayList){

        String vehicle = "Car";
        ServiceList service1 = new ServiceList(vehicle,"Wash", 20);
        ServiceList service2 = new ServiceList(vehicle,"Tires wash", 10);
        ServiceList service3 = new ServiceList(vehicle,"Engine wash", 15);
        ServiceList service4 = new ServiceList(vehicle,"Vacuum", 15);
        ServiceList service5 = new ServiceList(vehicle,"Polish", 25);
            arrayList.add(service1);
            arrayList.add(service2);
            arrayList.add(service3);
            arrayList.add(service4);
            arrayList.add(service5);

        }

    public static void fillArrayListTruck(ArrayList arrayList){

        String vehicle = "Truck";
        ServiceList service1 = new ServiceList(vehicle,"Wash", 50);
        ServiceList service2 = new ServiceList(vehicle,"Tires wash", 20);
        ServiceList service3 = new ServiceList(vehicle,"Engine wash", 25);
        ServiceList service4 = new ServiceList(vehicle,"Vacuum", 15);
        ServiceList service5 = new ServiceList(vehicle,"Polish", 30);


            arrayList.add(service1);
            arrayList.add(service2);
            arrayList.add(service3);
            arrayList.add(service4);
            arrayList.add(service5);

        }


    public static void fillArrayListMoto(ArrayList arrayList){

        String vehicle = "Motorcycle";
        ServiceList service1 = new ServiceList(vehicle,"Wash", 10);
        ServiceList service2 = new ServiceList(vehicle,"Tires wash", 5);
        ServiceList service3 = new ServiceList(vehicle,"Motor wash", 15);
        ServiceList service4 = new ServiceList(vehicle,"Polish", 20);

            arrayList.add(service1);
            arrayList.add(service2);
            arrayList.add(service3);
            arrayList.add(service4);

        }

    public static void fillArrayListCross(ArrayList arrayList){

        String vehicle = "Crossover";
        ServiceList service1 = new ServiceList(vehicle,"Wash", 25);
        ServiceList service2 = new ServiceList(vehicle,"Tires wash", 10);
        ServiceList service3 = new ServiceList(vehicle,"Engine wash", 20);
        ServiceList service4 = new ServiceList(vehicle,"Vacuum", 15);
        ServiceList service5 = new ServiceList(vehicle,"Polish", 30);

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
        hashMap.put("Moto",serviceMoto);
        hashMap.put("Cross",serviceCross);

            }

}