package function;

import java.util.List;
import java.io.FileNotFoundException;

public class MyStream {
    public static void main(String... args) {
        List<String> cities = List.of("bouznika", "mohammedia", "rabat", "casablanca", "fes");

        String biggestCity =  cities.stream()
                                    .filter(city -> city.contains("x"))
                                    .findFirst()
                                    .get();
        
        System.out.println("Biggest city: " + biggestCity);

        try {
            cities.stream().filter(c -> c.indexOf('b') != -1).findFirst().orElseThrow(() -> new FileNotFoundException());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}