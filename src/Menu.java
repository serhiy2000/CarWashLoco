import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Menu {



    public static void main() {

        HashMap <String, ArrayList> menuMap = new HashMap(); // creates menu for main entrance;
        ServiceList.fillHashMap(menuMap); // fills menu with data from ServiceList;

        System.out.print("We can make service to ");
        Set vehicles = menuMap.keySet();  // main menu list
        System.out.println(vehicles);
        System.out.println(vehicles.getClass());
//==============================================
        String input, key = "f";
        int roomMark = 1, serviceMark;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your choice:");
            input = sc.nextLine();


            if ((roomMark == 1) & menuMap.containsKey(input)) {
                key = input;
                roomMark = 2;
                System.out.println("you entered: " + key);
                ArrayList current = menuMap.get(key);
                System.out.println(current);


                if (menuMap.containsKey(key)) {
                    if ((roomMark == 2) & (menuMap.get(key).contains(input)))
                        System.out.println("Successfully added to basket");
                }

                if (input.equals("back") | input.equals("Back")) {
                    roomMark = 1;
                } // go one level up

                System.out.println(roomMark + "roomMark");
                System.out.println(menuMap.get(key).get(1));

            }
            } while (!(input.equals("q")));

        System.out.println("Cycle finished");



//===============================================

//        String key = "Car"; // here I'm trying to get list of services available for selected vehicle.
//        System.out.println("menumap"+menuMap.get(key));
//        System.out.println("menumap"+(menuMap.get(key).getClass()));


//
//        System.out.println(current.toArray());



    }


}


// =======
//Команда №2 (Сергій, Оля, Діма)
//Стоврити консольну автомийку:
//
//- автомийку повинена мати підтримку різних типів авто: легкові, вантажні, мотоцикли, кросовери
//- додати набір послух для кожного типу машин (чистка салону, мийка ззовні, загальна мийка, мийка мотора) (у кожної послуги повинна бути ціна)
//- при запуску апки вона повинна з вами привітатся
//- після того повинна запитати вас, яким у вас тип транспорту
//- після того як ви ввели тип транспорту аплікація показує вам всі можливі послуги для цього типу авто
//- якщо ви введете q програма повинна попрощатися з вами і вивести в консоль список послуг які ви обрали
//- на кожному кроці повинна бути можливість повернутися назад
//- повинна бути можливість вибрати одну послугу декілька разів.
//- якщо ви ввели неіснуючий тип траспорту чи послугу, програма повинна повідомити вас про це
//- (optional) якщо ви вкажете послугу, вона додється в чек
//- (optional) при введенні check програма повинна показати список послуг які були замовлені.


//        if (sc.hasNextInt()) {
//        int inputInt = sc.nextInt();
//        System.out.println("Спасибо! Вы ввели число " + inputInt);
//        } else {