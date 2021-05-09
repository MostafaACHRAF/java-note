package nestedClasses;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.List;

public class CoolLambda {
    static <T, R> void performActionOnIteratorWithPredicate(Iterable<T> iterator, Predicate<T> tester, Function<T,R> mapper, Consumer<R> action) {
        for (var x : iterator) {
            if (tester.test(x)) {
                R data = mapper.apply(x);
                action.accept(data);
            }
        }
    }
    public static void main(String... args) {
        List<String> names = List.of("john", "rengoku", "shinobu", "uzui", "mitsuri");

        performActionOnIteratorWithPredicate(
            names, 
            s -> s.indexOf("u") != -1, 
            String::toUpperCase,
            System.out::println
        );
    }
}