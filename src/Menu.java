import java.util.*;

public class Menu {

    public static void main() {

        HashMap <String, ArrayList> menuMap = new HashMap(); // creates menu for main entrance;
        ServiceList.fillHashMap(menuMap); // fills menu with data from ServiceList;

        LinkedHashSet <ServiceList> basket = new LinkedHashSet<>();
        LinkedHashSet <Basket> bill = new LinkedHashSet<>();

        Set vehicles = menuMap.keySet();  // main menu list

//==============================================
        String input, key = "f", service = ";";
        int roomMark = 1, serviceMark = 0;
        ArrayList <ServiceList> currentServiceList = new ArrayList<>();
        Boolean checker;
        Integer positionMark = 99;

        do {
            checker = false;
            Scanner sc = new Scanner(System.in);
            if (roomMark ==1) System.out.print("We can make service to: \n"+vehicles + "\n");

            System.out.println("Please enter your choice:");
            input = sc.nextLine();


            if ((roomMark == 1) & menuMap.containsKey(input)) {
                key = input;
                roomMark = 2;
                System.out.println("You entered: " + key + "." + '\n' + "We can offer following services:");
                System.out.println(menuMap.get(key));
                currentServiceList = menuMap.get(key);

            } // shows service list for the selected vehicle

            if (input.equals("print") | input.equals("Print")){
                System.out.println("In the basket we have:");
                System.out.println(basket);
                System.out.println("In the bill we have:");
                System.out.println(bill);
            } // prints basket and bill

            // Check if input equals service

                for (int i = 0; i < currentServiceList.size(); i++) {
                    ServiceList serviceList = currentServiceList.get(i);
                    String ss = (serviceList.getService());

                    if (input.equals(ss)) {
                        positionMark = i;
                        System.out.println("You ordered "+ ss + " for "+key);
                        checker = true;
                    }
                }

            if ((menuMap.containsKey(key)) & (checker == true)) {

                ArrayList <ServiceList> current = menuMap.get(key);
                ServiceList addServiceList = current.get(positionMark);

                Basket.addServiceBasket(addServiceList, basket, bill);
            }

            if (input.equals("bill") | input.equals("Bill")) {
                System.out.println("Your current bill:");
                System.out.println(bill);
                }

            if (input.equals("back") | input.equals("Back")) {   // go one level up
                    roomMark = 1;

                }
            System.out.println("Incorrect input. Please try again.");

        } while (!(input.equals("q")));

        System.out.println("Thank you.\nYou ordered:");
        Basket.billPrint(bill);



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


