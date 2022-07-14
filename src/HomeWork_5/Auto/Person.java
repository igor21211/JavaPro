package HomeWork_5.Auto;

public class Person {

    String name;
    int age;

    int lastDayFine;
    boolean drive;

    public Person(String name, int age, int lastDayFine, boolean drive) {
        this.name = name;
        this.age = age;
        this.lastDayFine = lastDayFine;
        this.drive = drive;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", drive=" + drive +
                ", lastDayFine=" + lastDayFine +
                '}'+"\n";
    }
}
