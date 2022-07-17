package HomeWork;

public class main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();


        list.add(23);
        list.add(354);
        list.add(234);

        System.out.println("method add: " + list);
        System.out.println();
        System.out.println("method getFirst: "+ list.getFirst());
        System.out.println();
        System.out.println("method getLast: "+ list.getLast());



        list.add(1,10);
        list.add(2,20);
        list.add(3,30);

        System.out.println("method add by index: " + list);


        list.set(2,300);
        list.set(3,300);

        System.out.println("method Set bt Index: " + list);

        System.out.println("method Get : " + list.get(2));

        list.remove(2);
        list.remove(3);

        System.out.println("method remove: " + list.toString());

        System.out.println("method Contains true : " + list.contains(30));//true
        System.out.println("method Contains false : " + list.contains(23324234));//false

        System.out.println("Method isEmpty : " + list.isEmpty());
        System.out.println("Method Size : " + list.size());
        list.clear();
        System.out.println("Method Clear : " + list);
        System.out.println("Method Size After method clear: " + list.size());
        System.out.println("Method IsEmpty After method clear: " + list.isEmpty());

    }
}
