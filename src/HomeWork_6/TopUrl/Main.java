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

public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();
        String fileName = "C:\\Git\\HillelJavaPro\\urls.txt";
        //Конвектирует данные из файла в лист
      List<String> list =  logic.convertUrlToList(fileName);
        // Обрезаем урл для подсчитки кол дуплей
      logic.splitUrl(list);
      //Переборка дуплей и запись количество дуплей в хешмеп в качестве значения и название урл которого дублирует ключ
        Map<String, Integer> topUrls = logic.makeHashMap(list);
        //Фильтрует и принтит результат
        logic.printTopUrls(topUrls);

    }
}
