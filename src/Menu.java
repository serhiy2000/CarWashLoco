import java.lang.reflect.Array;
import java.util.*;

public class Menu {



    public static void main() {

        HashMap <String, ArrayList> menuMap = new HashMap(); // creates menu for main entrance;
        ServiceList.fillHashMap(menuMap); // fills menu with data from ServiceList;

        System.out.print("We can make service to: ");
        Set vehicles = menuMap.keySet();  // main menu list

        System.out.println(vehicles); // this class is HashMap-KeySet
//==============================================
        String input, key = "f", service = ";";
        int roomMark = 1;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your choice:");
            input = sc.nextLine();

            if ((roomMark == 1) & menuMap.containsKey(input)) {
                key = input;
                roomMark = 2;
                System.out.println("You entered: " + key + "." + '\n' + "We can offer following services:" + '\n' +  "===============================");
                System.out.println(menuMap.get(key));
            }


                if (menuMap.containsKey(key)) {
                    if ((roomMark == 2) & (menuMap.get(key).contains(input)))
                        System.out.println("Successfully added to basket");
                }

                if (input.equals("back") | input.equals("Back")) {
                    roomMark = 1;
                    System.out.println(vehicles);
                } // go one level up


            ArrayList newnew = menuMap.get(key);  // here I can get the Arraylist (serviceCar) fom map.
            System.out.println(newnew.get(1).getClass()+" = newnew.get(1).getClass()");

//            QUESTION !!!!!!

            System.out.println(newnew.get(1)); // QUESTION - how can I get element index[1] - "Clean salon" from this array?


            } while (!(input.equals("q")));

        System.out.println("Cycle finished");



//===============================================

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


