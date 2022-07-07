package HomeWork_3;

import java.util.Objects;

public class Employee {

    int id;
    String name;
    String surname;
    long contact;

    public Employee(int id, String name, String surname, long contact) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                contact == employee.contact &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        int IdResult = (int) (id * 31 + name.length() + surname.length()+contact);
        return IdResult;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", contact=" + contact +
                '}';
    }
}
