package HomeWork_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1,"igor","Shpura",984256792);
        Employee employee2 = new Employee(2,"Nadya","Petrova",984223423);
        Employee employee3 = new Employee(3,"Oleg","Sidorov",984253453);
        Employee employee4 = new Employee(4,"Irina","Petrova",984245646);

        HashSet<Employee> setEmployee = new HashSet<>();
        setEmployee.add(employee1);
        setEmployee.add(employee2);
        setEmployee.add(employee3);
        setEmployee.add(employee4);

        System.out.println(setEmployee);
        System.out.println(setEmployee.size());

        //Создаем одинаковый обьект
        Employee employee5 = new Employee(1,"igor","Shpura",984256792);
        setEmployee.add(employee5);

        //так как мы переопределили equals и написали своб реализацию HashCode то новый обьект не попал в сет т.к. сет не хранит дпуликаты
        System.out.println(setEmployee.size());

        System.out.println(employee1.equals(employee5));

        //Если обьекты равны то и HashCode  у них одинаков
        System.out.println(employee1.hashCode());
        System.out.println(employee5.hashCode());

    }
}
