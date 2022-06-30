package HomeWork.HomeWork_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println("1 add method: " + list);

        list.add(3,10);

        System.out.println("2 add by value: " + list);

        System.out.println("get method: " + list.get(2));

        list.set(0,10);
        System.out.println("set method: " + list);

        list.remove(1);
        System.out.println("remove method: " + list);

        list.remove(new Integer(6));
        System.out.println("remove by value: " + list);

        System.out.println("isEmpty method: " + list.isEmpty());

        list.clear();

        System.out.println("after method clear: " + list);

        System.out.println("after method clear works method isEmpty: " + list.isEmpty());



    }
}
