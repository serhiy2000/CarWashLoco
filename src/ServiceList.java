import java.util.*;

public class ServiceList {

    String vehicle;
    String service;
    int price;

    public String getService() {
        return service;
    }

    public int getPrice() {
        return price;
    }

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
        return '\n'+service  +
                ", price=" + price;
    }

    public static void fillArrayListCar(ArrayList o){

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

    public static int checkService (String currentService, ArrayList <ServiceList> al) {

        int positionMark = 0;
        for (int i=0; i<al.size(); i++){
            System.out.println(al.get(i));
            ServiceList serviceList = al.get(i);
            String ss = (serviceList.getService());

            if (currentService.equals(ss)) {
                positionMark = i;
                System.out.println("CheckService method works");
            }
        }

        return positionMark;
    }



}