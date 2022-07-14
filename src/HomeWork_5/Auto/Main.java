package HomeWork_5.Auto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();
        List<Person> personList = logic.generatePerson();
        System.out.println("Generate random Person: ");
        System.out.println(personList);
        List<Person> validateList = logic.validationPerson(personList);
        System.out.println("Person list after validate " );
        System.out.println(validateList);
    }
}
