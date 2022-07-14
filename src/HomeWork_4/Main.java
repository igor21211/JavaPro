package HomeWork_4;

public class Main {
    public static void main(String[] args) {
        HashMapLogik<String, String> myMap = new HashMapLogik<>();
        myMap.insert("1", "a");
        System.out.println("Method insert and method get:  " + myMap.get("1"));
        System.out.println();
        myMap.insert("1", "b");
        System.out.println("Method insert change value in same node: " + myMap.get("1"));
        System.out.println();
        System.out.println("Method isEmpty before delete: " + myMap.isEmpty() );
        myMap.delete("1");
        System.out.println();
        System.out.println("Method isEmpty after delete:  " + myMap.isEmpty());
        myMap.insert("1","a");
        myMap.insert("1","a");
        myMap.insert("1","a");
        System.out.println();
        System.out.println("We are add the same key and value and You can see that copy key and value My Hash Map dont save: " + myMap.size());


        myMap.insert("2","a");
        myMap.insert("3","a");
        myMap.insert("4","a");
        myMap.insert("5","a");
        myMap.insert("6","a");
        myMap.insert("7","a");

        System.out.println();
        System.out.println("We can see that the same value but another key save on the Map " + myMap.size());

        myMap.insert("8","a");
        myMap.insert("9","a");
        myMap.insert("10","a");
        myMap.insert("11","a");
        myMap.insert("12","a");
        myMap.insert("13","a");
        myMap.insert("14","a");
        myMap.insert("15","a");
        myMap.insert("16","a");
        myMap.insert("17","a");
        myMap.insert("18","hello i am 18-g element!");

        System.out.println();
        System.out.println("Its example work method to*2 array hashtable: " + myMap.size());
        System.out.println(myMap.get("18"));





    }
}
