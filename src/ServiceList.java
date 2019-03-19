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

    public static void fillArrayListCar(ArrayList o){

        String vehicle = "Car";
        ServiceList service1 = new ServiceList(vehicle,"Wash", 100);
        ServiceList service2 = new ServiceList(vehicle,"Salon", 100);
        ServiceList service3 = new ServiceList(vehicle,"Tires", 20);
        ServiceList service4 = new ServiceList(vehicle,"Polish", 500);
            o.add(service1);
            o.add(service2);
            o.add(service3);
            o.add(service4);

        }

    public static void fillArrayListTruck(ArrayList o){

        String vehicle = "Truck";
        ServiceList service1 = new ServiceList(vehicle,"Wash", 300);
        ServiceList service2 = new ServiceList(vehicle,"Salon", 200);
        ServiceList service3 = new ServiceList(vehicle,"Pressure tires", 50);
        ServiceList service4 = new ServiceList(vehicle,"Polish", 500);


            o.add(service1);
            o.add(service2);
            o.add(service3);
            o.add(service4);

        }

    public static void fillArrayListMoto(ArrayList o){

        String vehicle = "Moto";
        ServiceList service1 = new ServiceList(vehicle,"Wash body", 50);
        ServiceList service2 = new ServiceList(vehicle,"Wash engine", 50);
        ServiceList service3 = new ServiceList(vehicle,"Clean salon", 20);
        ServiceList service4 = new ServiceList(vehicle,"Polish", 500);

            o.add(service1);
            o.add(service2);
            o.add(service3);
            o.add(service4);

        }

    public static void fillArrayListCross(ArrayList o){

        String vehicle = "Cross";
        ServiceList service1 = new ServiceList(vehicle,"Wash", 120);
        ServiceList service2 = new ServiceList(vehicle,"Clean salon", 100);
        ServiceList service3 = new ServiceList(vehicle,"Clean engine", 20);
        ServiceList service4 = new ServiceList(vehicle,"Polish", 330);
        ServiceList service5 = new ServiceList(vehicle,"Write", 3);

            o.add(service1);
            o.add(service2);
            o.add(service3);
            o.add(service4);
            o.add(service5); // service 5

        }

    public static void fillHashMap (HashMap o){

        ArrayList <ServiceList> serviceCar = new ArrayList<>();
        ServiceList.fillArrayListCar(serviceCar);

        ArrayList <ServiceList> serviceTruck = new ArrayList<>();
        ServiceList.fillArrayListTruck(serviceTruck);

        ArrayList <ServiceList> serviceMoto = new ArrayList<>();
        ServiceList.fillArrayListMoto(serviceMoto);

        ArrayList <ServiceList> serviceCross = new ArrayList<>();
        ServiceList.fillArrayListCross(serviceCross);

        o.put("Car",serviceCar);
        o.put("Truck",serviceTruck);
        o.put("Moto",serviceMoto);
        o.put("Cross",serviceCross);

            }

}