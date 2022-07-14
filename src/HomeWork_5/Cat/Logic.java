package HomeWork_5.Cat;

import java.util.*;

public class Logic {
    Random random = new Random();




    public List<Cats> getCats(){
        List<Cats> cats = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String name = setName();
            Integer age = random.nextInt(1,7);
            String city = setCity();
            cats.add(new Cats(name,age,city));
        }
        return cats;
    }


    public String setName(){
        List<String> names = List.of(
                "Kity",
                "Molly",
                "Ben",
                "Rodger",
                "Bob",
                "Laptop",
                "lally"
        );
       int index = random.nextInt(6);
        return names.get(index);
    }

    public String setCity(){
        List<String> city = List.of(
                "Odesa",
                "Kyiv",
                "Lviv",
                "Harkiv",
                "Poltava",
                "Frankivsk",
                "Donetsk"
        );
        int index = random.nextInt(6);
        return city.get(index);
    }
    public List<Cats> goNewYork(List<Cats> cats){

        for (Cats cat: cats){
            cat.city = "New York";
        }
        return cats;
    }





    public void mainMethod(){
        List<Cats> cats = getCats();
        System.out.println("Before moving: ");
        System.out.println(cats);
        System.out.println("GO to NEW YORK");
        System.out.println("After moving: ");
        goNewYork(cats);
        System.out.println(cats);


    }

}
