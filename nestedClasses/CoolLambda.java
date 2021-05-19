package nestedClasses;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;

public class CoolLambda {
    class Hashira {
        String name;
        Integer age;

        Hashira(String name, int age) {
            this.name = name;
            this.age = age;
        }

        int compareByAge(Hashira p1, Hashira p2) {
            return p1.age.compareTo(p2.age);
        }
    }
    static <T, R> void performActionOnIteratorWithPredicate(Iterable<T> iterator, Predicate<T> tester, Function<T,R> mapper, Consumer<R> action) {
        for (var x : iterator) {
            if (tester.test(x)) {
                R data = mapper.apply(x);
                action.accept(data);
            }
        }
    }
    public static void main(String... args) {
        CoolLambda cl = new CoolLambda();
        List<String> names = List.of("john", "rengoku", "shinobu", "uzui", "mitsuri");

        performActionOnIteratorWithPredicate(
            names, 
            s -> s.indexOf("u") != -1, 
            String::toUpperCase,
            System.out::println
        );

        System.out.println("--------------------");
        List<Hashira> hashiras = new ArrayList<>();
        hashiras.add(cl.new Hashira("rengoku", 20));
        hashiras.add(cl.new Hashira("mitsuri", 19));
        performActionOnIteratorWithPredicate(hashiras, h -> true, h -> h.name.substring(0,1).toUpperCase().concat(h.name.substring(1,h.name.length())), System.out::println);

        System.out.println("--------------------");
        // hashiras.sort((a,b) -> cl.new Hashira(null, 0).compareByAge(a,b));//ok

        //Reference to an instance method of a particular object:
        hashiras.sort(cl.new Hashira(null, 0)::compareByAge);//you can't use class name to call compareByAge, because this method isn't static

        hashiras.stream().map(h -> h.name).forEach(System.out::println);
    }
}