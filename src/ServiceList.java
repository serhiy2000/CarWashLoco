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

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "ServiceList{" +
                "vehicle='" + vehicle + '\'' +
                ", service='" + service + '\'' +
                ", price=" + price +
                '}'+'\n';
    }

    public static void fillArrayListCar(Set o){
        String vehicle = "Car";
        ServiceList service1 = new ServiceList(vehicle,"Wash body", 100);
        ServiceList service2 = new ServiceList(vehicle,"Clean salon", 100);
        ServiceList service3 = new ServiceList(vehicle,"Clean tires", 20);
        ServiceList service4 = new ServiceList(vehicle,"Polish", 500);
            o.add(service1);
            o.add(service2);
            o.add(service3);
            o.add(service4);

        }

    public static void fillArrayListTruck(ArrayList o){

        String vehicle = "Truck";
        ServiceList service1 = new ServiceList(vehicle,"Wash body", 100);
        ServiceList service2 = new ServiceList(vehicle,"Clean salon", 100);
        ServiceList service3 = new ServiceList(vehicle,"Clean tires", 20);
        ServiceList service4 = new ServiceList(vehicle,"Polish", 500);

            o.add(service1);
            o.add(service2);
            o.add(service3);
            o.add(service4);

        }

    public static void fillArrayListMoto(ArrayList o){

        String vehicle = "Moto";
        ServiceList service1 = new ServiceList(vehicle,"Wash body", 100);
        ServiceList service2 = new ServiceList(vehicle,"Clean salon", 100);
        ServiceList service3 = new ServiceList(vehicle,"Clean tires", 20);
        ServiceList service4 = new ServiceList(vehicle,"Polish", 500);

            o.add(service1);
            o.add(service2);
            o.add(service3);
            o.add(service4);

        }

    public static void fillArrayListCross(ArrayList o){

        String vehicle = "Cross";
        ServiceList service1 = new ServiceList(vehicle,"Wash body", 100);
        ServiceList service2 = new ServiceList(vehicle,"Clean salon", 100);
        ServiceList service3 = new ServiceList(vehicle,"Clean tires", 20);
        ServiceList service4 = new ServiceList(vehicle,"Polish", 500);

            o.add(service1);
            o.add(service2);
            o.add(service3);
            o.add(service4);

        }

    public static void fillHashMap (HashMap o){

        ArrayList serviceCar = new ArrayList<>();
        ServiceList.fillArrayListCar(serviceCar);

        ArrayList serviceTruck = new ArrayList<>();
        ServiceList.fillArrayListTruck(serviceTruck);

        ArrayList serviceMoto = new ArrayList<>();
        ServiceList.fillArrayListMoto(serviceMoto);

        ArrayList serviceCross = new ArrayList<>();
        ServiceList.fillArrayListCross(serviceCross);

        o.put("Car",serviceCar);
        o.put("Truck",serviceTruck);
        o.put("Moto",serviceMoto);
        o.put("Cross",serviceCross);
    }



}