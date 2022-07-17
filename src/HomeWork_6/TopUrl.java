package HomeWork_6;

import java.awt.image.ImageProducer;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class TopUrl {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Git\\HillelJavaPro\\urls.txt";
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String,Integer> topUrls = new HashMap<>();

        list.replaceAll((s -> s.split("/")[0]));

        for (int i = 0; i < list.size(); i++) {
            String tempChar = list.get(i);


            if (!topUrls.containsKey(tempChar)) {
                topUrls.put(tempChar, 1);
            } else {
                topUrls.put(tempChar, topUrls.get(tempChar) + 1);
            }
        }


//
//        topUrls.entrySet()
//                .stream()
//                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
//                .forEach(x -> System.out.println(x));
//



    }
}
