package HomeWork_5.BookHomeWork;

import java.util.*;


public class Logic {
    public static HashMap<String, Set<String>> library;

    String author = "Stephen King";
    String author2 = "Brem Stoker";
    String author3 = "Edgar Allan Poe";

    public Set<String> setKingBook(Set<String> books) {
        books.add("The Dark Tower IV: Wizard and Glass");
        books.add("Rita Hayworth and the Shawshank Redemption");
        books.add("The Dead Zone");
        books.add("The Green Mile");
        books.add("11/22/63");
        return books;

    }

    public Set<String> setBremBook(Set<String> books) {
        books.add("The Lady of the Shroud");
        books.add("Jewel of the Seven Stars");
        books.add("The Lair of the White Worm");
        books.add("Mystery Of The Sea");
        books.add("Dracula");
        return books;
    }

    public Set<String> setAllanBook(Set<String> books) {
        books.add("THE TELL-TALE HEART");
        books.add("THE CASK OF AMONTILLADO");
        books.add("THE FALL OF THE HOUSE OF USHER");
        books.add("THE PIT AND THE PENDULUM");
        books.add("THE MASQUE OF THE RED DEATH");
        return books;
    }

    public HashMap<String, Set<String>> createdMap(){
        HashMap<String, Set<String>> library = new HashMap<>();
        Set<String> autors = new HashSet<>();
        library.put(author,setKingBook(autors));
        library.put(author2,setBremBook(autors));
        library.put(author3,setAllanBook(autors));
        return library;
    }

    public void getLibrary(HashMap<String, Set<String>> library) {
        System.out.println("Hello, you came to the biggest library");
        System.out.println("We have authors: " + library.keySet());
        System.out.println("What authors you want to read?: ");
        Scanner scanner = new Scanner(System.in);
        String autor = scanner.nextLine();
        System.out.println(library.get(autor));

    }



}
