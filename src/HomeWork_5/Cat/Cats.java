package HomeWork_5.Cat;

public class Cats {
    public String name;
    public Integer age;
    public String city;

    public Cats(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Cats() {
    }

    @Override
    public String toString() {
        return "Cats {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}'+"\n";
    }
}
