package Car;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.color = "green";
        car1.yearOfCreate = 1997;
        System.out.println(car1.hashCode());

        Car car2 = new Car();
        car2.color = "green";
        car2.yearOfCreate = 1997;
        System.out.println(car2.hashCode());

        System.out.println(car1.equals(car2));
        Set<Car> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);

        System.out.println(cars.toString());
    }
}
