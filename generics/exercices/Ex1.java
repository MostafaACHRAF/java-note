package generics.exercices;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

public class Ex1 {
    static <T> int countElements(List<T> list, Predicate<T> property) {
        int count = 0;
        for (T n : list) {
            if (property.test(n)) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 5, 7, 9, 11);

        int oddsCount = countElements(numbers, n -> n % 2 != 0);
        int evensCount = countElements(numbers, n -> n % 2 == 0);

        System.out.println("odds count = " + oddsCount);
        System.out.println("evens count = " + evensCount);
    }
}