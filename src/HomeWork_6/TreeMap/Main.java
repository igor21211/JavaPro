package HomeWork_6.TreeMap;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {


        Random random = new Random();
        // Creating a new tree and inserting 10 million random numbers into it.
        LogicBinarySearchTree<Integer> tree = new LogicBinarySearchTree<>();
        int limit = 100;
        for (int i = 0; i < limit; i++) {
            int val = random.nextInt(0,limit);
            tree.insert(val);
        }



        System.out.println("Method contains: " + tree.contains(5));

        System.out.println("Method depht: " + tree.depth());


        System.out.println(tree.toString());


        System.out.println();
        System.out.println("Method do with Consumer and sort all element of tree in assorting asc");
        System.out.println("====================================");


        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                 System.out.println(integer);
            }
        };
        tree.inOrderTraversal(consumer);





    }
}