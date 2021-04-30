package generics.bounds;

import java.util.List;
import java.util.function.Predicate;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.ArrayList;

public class UpperBound {
    static class Person {
        String name;
        Person(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return String.format("{{%s}}", name);
        }
    }
    interface Operators {}
    static class Doctor extends Person implements Operators {
        int operationsCount;
        Doctor(String name, int opsCount) {
            super(name);
            operationsCount = opsCount;
        }
    }

    //upper bounded method. Because its restricted to Person and its sub-types
    public <T extends Person> List<T> toList(T[] data, Predicate<T> predicate) {
        return Arrays.stream(data).filter(predicate).collect(Collectors.toList());
    }

    public static void main(String... args) {
        UpperBound upperBound = new UpperBound();
        // List<Integer> nbrs = upperBound.toList(new Integer[] {32, 56, 95, 0, 0, 0}, n -> n != 0);//won't compile because 'Integer' isn't a sub-type of Person
        Person[] people = new Person[] {new Person("john"), new Person("sara"), new Person("mark")};
        List<Person> mPeople = upperBound.toList(people, (p) -> p.name.indexOf('j') != -1);
        String values = mPeople.stream().parallel().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println("values => " + values);

        Doctor[] doctorsArray = new Doctor[] {new Doctor("john", 5), new Doctor("mery", 6), new Doctor("jack", 2)};
        List<Doctor> doctors = upperBound.toList(doctorsArray, (d) -> d.operationsCount > 3);
        List<Person> doctors2 = upperBound.toList(doctorsArray, (d) -> ((Doctor)d).operationsCount > 3);


        Person[] people2 = new Person[] {new Doctor("sam", 5), new Doctor("bell", 10), new Doctor("Elizabeth", 21)};
        // List<Doctor> superDoctors = upperBound.toList((Doctor[]) people2, (d) -> d.operationsCount > 7);//runtime exception, person object can't be converted to doctor object.

        Operators[] operators = new Operators[] {new Doctor("sam", 5), new Doctor("bell", 10), new Doctor("Elizabeth", 21)};
        // List<Person> r = upperBound.toList((Doctor[])operators, o -> true);//compiles successfully, but throws a classCastException at runtime

        var empty = Optional.empty();
        // var null1 = Optional.of(null);//won't compile
        var nullable = Optional.ofNullable(null);
        IntStream.range(1,6).parallel().forEachOrdered(System.out::print);

        int sum = List.of(3,2,5,7,1).stream().limit(1).peek(s -> {}).mapToInt(x -> x).peek(s -> {}).sum();//compiles successfully. x -> {} is allowed, its a valid implementation of a consumer
        System.out.println("\nsum = " + sum);

        int val = Stream.of(1,2,3,4,5,6,7,8,9,10).findFirst().get();//even with parallel will print (1)
        System.out.println("val = " + val);

        var l = new ArrayList<String>();
        // l.add(String::new);//won't compile
        l.add(new String());

    }
}