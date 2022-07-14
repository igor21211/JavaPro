import java.util.HashMap;
import java.util.HashSet;

public class Lessons_4 {
    public static void main(String[] args) {
        HashMap<Integer,String> map1 = new HashMap<>();
        map1.put(11111,"Igor");
        map1.put(22222,"Igor");
        map1.put(33333,"Igor");
        map1.put(44444,"Igor");
        map1.put(55555,"Igor");


        System.out.println(map1);

        map1.put(11111,"Igor2");

        System.out.println(map1);

        map1.putIfAbsent(7777,"Igor3");
        map1.putIfAbsent(7777,"Igor3");// добавляет если нету в колекции

        System.out.println(map1);

        System.out.println(map1.get(11111));
        map1.remove(44444);

        System.out.println(map1);
        System.out.println();

        System.out.println(map1.containsValue("Igor"));
        System.out.println(map1.containsValue("Oleg"));
        System.out.println();
        System.out.println(map1.containsKey(22222));
        System.out.println(map1.containsKey(44444));
        System.out.println();
        System.out.println(map1.keySet());
        System.out.println();
        System.out.println(map1.values());

    }
}
