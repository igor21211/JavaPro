package Car;

import java.util.Objects;

public class Car {
    public String color;
    public int yearOfCreate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearOfCreate == car.yearOfCreate && Objects.equals(color, car.color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", yearOfCreate=" + yearOfCreate +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, yearOfCreate);
    }
}
