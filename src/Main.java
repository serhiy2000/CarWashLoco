import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap menuMap = new HashMap();
        ServiceList.fillHashMap(menuMap);

        String key = "Car";
        System.out.println("menumap"+menuMap.get(key));

        Set vehicles = menuMap.keySet();

        System.out.println(vehicles);

//        ArrayList current = menuMap.get(key);  // doesn't work. cannot get Array from the map.
//        System.out.println(current);
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