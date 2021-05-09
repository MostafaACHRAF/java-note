package nestedClasses;

import java.util.stream.Stream;
import java.util.function.Predicate;

public class Lambda {
    public static void main(String... args) {
        int min = 2;
        // min = 3;//will cause a compilation error on line 14. Because local variables must be final or effectively final in order to be used in lambda expressions

        if (min > 0) {
            int max = 7;
            // max = 9;//will cause a compilation error on line 14. Because local variables must be final or effectively final in order to be used in lambda expressions
            Predicate<String> p = s -> s.length() >= min && s.length() < max;
            Stream.of("mostafa", "asharf", "rahaf").filter(p).forEach(System.out::println);
        }
    }
}