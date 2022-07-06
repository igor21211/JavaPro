package HomeWork_2;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(4);

        System.out.println("Method addFirst: "+ list);

        list.addLast(7);
        list.addLast(9);
        list.addLast(10);

        System.out.println("method addLast: " + list);

        list.add(23);
        list.add(354);
        list.add(234);

        System.out.println("method add: " + list);

        list.add(1,10);
        list.add(2,20);
        list.add(3,30);

        System.out.println("method add By Index: " + list);

        list.set(2,300);
        list.set(3,300);

        System.out.println("method Set: " + list);

        System.out.println("method Get : " + list.get(2));
        System.out.println("method GetFirst : " + list.getFirst());
        System.out.println("method GetLast : " + list.getLast());

        list.remove(2);
        list.remove(3);

        System.out.println("method remove: " + list);

        System.out.println("method Contains true : " + list.contains(23));//true
        System.out.println("method Contains false : " + list.contains(23324234));//false

        System.out.println("Method isEmpty : " + list.isEmpty());
        System.out.println("Method Size : " + list.size());
        list.clear();
        System.out.println("Method Clear : " + list);
        System.out.println("Method Size After method clear: " + list.size());
        System.out.println("Method IsEmpty After method clear: " + list.isEmpty());

    }
}
