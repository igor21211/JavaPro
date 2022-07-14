package HomeWork_5.Auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Logic {

    Random random = new Random();

    public List<Person> generatePerson() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            String name = setName();
            int age = random.nextInt(10, 50);
            int lastDayFine = random.nextInt(100, 400);
            boolean drive = age > 16 ? true : false;
            personList.add(new Person(name, age, lastDayFine, drive));
        }
        return personList;
    }

    public String setName() {
        List<String> names = List.of(
                "Bob",
                "Ratel",
                "Ben",
                "Rodger",
                "Fill",
                "Kenny",
                "Gerard",
                "Niki",
                "Elena",
                "Tramp",
                "Gordan",
                "Mark"
        );
        int index = random.nextInt(6);
        return names.get(index);
    }

    public List<Person> validationPerson(List<Person> personList){
        List<Person> validationList = new ArrayList<>();
        return personList.stream().filter(person -> person.lastDayFine >=365 && person.drive).collect(Collectors.toList());
    }
}
