package HomeWork_6.TopUrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Logic {
    /**
     * It takes a file name as a parameter, reads the file, and returns a list of strings
     *
     * @param fileName The name of the file to read.
     * @return A list of strings
     */
    public List<String> convertUrlToList(String fileName) {
        List<String> list = new ArrayList<>();
        try (
                BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            list = br.lines().collect(Collectors.toList());

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * It takes a list of strings, splits each string on the "/" character, and returns the first part of the split string
     *
     * @param list The list of urls to be split
     * @return A list of strings
     */
    public List<String> splitUrl(List<String> list) {
        list.replaceAll((s -> s.split("/")[0]));
        return list;
    }

    /**
     * It takes a list of strings and returns a map of strings to integers
     *
     * @param list a list of strings
     * @return Map<String, Integer>
     */
    public Map<String, Integer> makeHashMap(List<String> list) {
        Map<String, Integer> topUrls = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String tempChar = list.get(i);

            //Условный оператор который считает кол и урл
            if (!topUrls.containsKey(tempChar)) {
                topUrls.put(tempChar, 1);
            } else {
                topUrls.put(tempChar, topUrls.get(tempChar) + 1);
            }
        }
        return topUrls;
    }

    /**
     * We're taking a map, converting it to a stream, sorting it by value in reverse order, limiting it to the top 10, and
     * then printing it out
     *
     * @param map The map that contains the url and the number of times it was accessed.
     */
    public void printTopUrls(Map<String, Integer> map){
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).limit(10)
                .forEach(x -> System.out.println(x));
    }
}