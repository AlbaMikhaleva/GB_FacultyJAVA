package Level2.Lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeWorkL2L3_PhoneBook {


    public static void main(String[] args) {

        HashMap<String, List<String>> phoneBook = new HashMap<>();

        createContact(phoneBook, "Smith", "89096465352");
        createContact(phoneBook, "Smith", "88006465352");
        createContact(phoneBook, "Joan", "89665094453");
        createContact(phoneBook, "Brown", "89097645369");
        createContact(phoneBook, "Brown", "89243452536");
        createContact(phoneBook, "Brown", "+79376344365");

        printValues(phoneBook);
    }

    public static void createContact(HashMap<String, List<String>> phoneBook, String name, String number) {

        if (!phoneBook.containsKey(name)) { // проверка на наличие имени в телефонной книге
            phoneBook.putIfAbsent(name, new ArrayList<>());
            phoneBook.get(name).add(number);
        } else {
            phoneBook.get(name).add(number);
        }
    }

    public static void printValues(HashMap<String, List<String>> phoneBook) {

        for (Map.Entry<String, List<String>> pair : phoneBook.entrySet()) {

            String k = pair.getKey();
            List <String> v = pair.getValue();
            System.out.println(k + " | " + v);
        }

    }

}
