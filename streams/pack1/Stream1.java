package pack1;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.function.UnaryOperator;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.Set;

public class Stream1 {
    private static class Person {
        String name;
        Person(String name) {
            this.name = name;
        }
    }

    private static class Item {
        int id;
        String title;
        double price;
        Item(int id, String title, double price) {
            this.id = id;
            this.title = title;
            this.price = price;
        }
    }

    private static class Order {
        String code;
        Person customer;
        LocalDate purchaseDate;
        List<Item> items;
        Order(String code, Person customer, List<Item> items, LocalDate purchaseDate) {
            this.customer = customer;
            this.items = items;
            this.purchaseDate = purchaseDate;
            this.code = code;
        }
        Stream<Item> getItemsAsStream() {
            return this.items.stream();
        }
    }

    public static void main(String... args) {
        Person customer1 = new Person("mostafa");
        Person customer2 = new Person("achraf");
        Person customer3 = new Person("fatima");
        Person customer4 = new Person("rahaf");

        Item item1 = new Item(1, "coffee", 12.5);
        Item item2 = new Item(2, "banana", 15);
        Item item3 = new Item(3, "choclate", 18.5);
        Item item4 = new Item(4, "cake", 22.3);

        // int sum = IntStream.generate(() -> (int) (Math.random() * 10)).takeWhile(n -> n != 3).sum();
        // System.out.println("Sum = " + sum);

        Stream.of(item1, item2, item3, item4).forEach(i -> System.out.println(i.title));

        Person[] customers = {customer1, customer2, customer3, customer4};
        Arrays.stream(customers).filter(c -> c.name.length() > 5).forEach(c -> System.out.println(c.name));

        int sum = Stream.of("one", "two", "three").mapToInt(s -> s.length()).filter(i -> i > 3).peek(i -> System.out.println(i)).sum();
        System.out.println("sum = " + sum);

        List<Item> items = Arrays.asList(item1,item2,item3,item4);
        Function<Item,String> getItemsTitles = i -> i.title;
        UnaryOperator<String> trimTitles = i -> i.trim();
        int total = items.stream().map(getItemsTitles.andThen(trimTitles)).mapToInt(i -> i.length()).peek(i -> System.out.println(i)).sum();
        System.out.println("total = " + total);

        System.out.println("###### flatmap");
        Order order1 = new Order("O-1213", customer1, Arrays.asList(item1, item2), LocalDate.now());
        Order order2 = new Order("O-0004", customer1, Arrays.asList(item3, item2), LocalDate.now());
        Order order3 = new Order("O-3004", customer3, Arrays.asList(item1, item4), LocalDate.now());
        Order order4 = new Order("O-1111", customer2, Arrays.asList(item1), LocalDate.now());
        Order order5 = new Order("O-7353", customer4, Arrays.asList(item1, item2, item4), LocalDate.now());
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);

        Predicate<Item> isBanana = item -> item.title.equals("banana");
        double totalPrice = orders.stream()
                                .flatMap(order -> order.getItemsAsStream())
                                .filter(isBanana.negate())
                                .peek(item -> System.out.println(item.title + "/" + item.price))
                                .mapToDouble(item -> item.price)
                                .sum();
        System.out.println("Total price of items that are not 'banana' is:" + totalPrice);

        System.out.println("######## Distinct,sorted,skip,takeWhile,dropWhile,limit");
        Stream.of("A","N","O","U","H","A","M","G","B","D","K","I")
                .distinct()
                .sorted()
                .forEach(s -> System.out.print(s + ","));

        System.out.println("\nSkip the first two charachters...");
        Stream.of("A","N","O","U","H","A","M","G","B","D","K","I")
                .distinct()
                .sorted()
                .skip(2)
                .forEach(s -> System.out.print(s + ","));

        System.out.println("\n Take while not 'M' (distinct and sorted stream)...");
        Stream.of("A","N","O","U","H","A","M","G","B","D","K","I")
                .distinct()
                .sorted()
                .takeWhile(s -> !s.equals("M"))
                .forEach(s -> System.out.print(s + ","));

        System.out.println("\nDrop while and limit three");
        Stream.of("A","N","O","U","H","A","M","G","B","D","K","I")
              .dropWhile(s -> !s.equals("M"))
              .limit(3)
              .forEach(s -> System.out.print(s + "."));

        System.out.println("\n####### findAny,findFirst,anyMatch,allMatch,noneMatch");
        String[] colors = {"green","blue","red","black","gray","orange"};
        boolean anyGreen = Arrays.stream(colors).anyMatch(s -> "green".equals(s));
        boolean nonBlue = Arrays.stream(colors).noneMatch(s -> "blue".equals(s));
        boolean allOrange = Arrays.stream(colors).allMatch(s -> "orange".equals(s));
        Optional<String> firstColor = Arrays.stream(colors).findFirst();
        Optional<String> anyColor = Arrays.stream(colors).findAny();
        long nbrOfcolorsContainingR = Arrays.stream(colors).filter(s -> s.indexOf('r') != -1).count();
        OptionalDouble colorsLenghtAverage = Arrays.stream(colors).mapToInt(s -> s.length()).average();
        Optional<String> maxColor = Arrays.stream(colors).max((s1, s2) -> s1.compareTo(s2));
        Optional<String> minColor = Arrays.stream(colors).min((s1, s2) -> s1.compareTo(s2));
        System.out.println("anyGreen:" + anyGreen + " nonBlue: " + nonBlue + " allOrange: " + allOrange);
        System.out.println("First color: " + firstColor);
        System.out.println("Any color: " + anyColor);
        System.out.println("Count of colors containing 'R' is: " + nbrOfcolorsContainingR);
        System.out.println("Average of colors lenght is: " + (colorsLenghtAverage.isPresent() ? colorsLenghtAverage.getAsDouble() : 0));
        System.out.println("Max color is: " + maxColor);
        System.out.println("Min color is: " + minColor);

        System.out.println("######### Reduce");
        Optional<String> concatenatedStrings = Stream.of("A","B","C").reduce((s1, s2) -> s1 + " * " + s2);
        System.out.println("concatenated strings = " + (concatenatedStrings.isPresent() ? concatenatedStrings.get() : "NIL"));

        System.out.println("######### Reduce with identity");
        String concatenatedStrings2 = Stream.of("N","O","H","A").reduce("", (s1, s2) -> s1 + "," + s2);
        System.out.println("Concatenated strings2 = " + concatenatedStrings2);

        System.out.println("######### Reduce with parallel mode");
        String concatenatedStrings3 = Stream.of("M","O","S","T","A","F","A").reduce("", (s1, s2) -> s1 + " - " + s2, (s1, s2) -> s1.substring(0,1) + s2);
        System.out.println("Concatenated strings3 = " + concatenatedStrings3);

        Stream.of("A","B","A","C").dropWhile(s -> !s.equals("B")).limit(2).forEach(s -> System.out.println(s));

        String concatenatedItems = orders.stream().flatMap(o -> o.getItemsAsStream()).parallel().reduce("", (s,i) -> i.title + "," + s, (s1,s2) -> s1 + s2);
        System.out.println("Concatenated items: " + concatenatedItems);

        System.out.println("######## DoubleSummaryStatistics using Collectors.summarizingDouble");
        DoubleSummaryStatistics summary = items.stream().collect(Collectors.summarizingDouble(item -> item.price));
        System.out.println("Summary statistics = " + summary);

        System.out.println("######## Mapping and joining using Collector");
        String joinedItemsTitles = items.stream().collect(Collectors.mapping(i -> i.title, Collectors.joining(";")));
        System.out.println("Joined items titles => " + joinedItemsTitles);

        System.out.println("####### Gathering using collector");
        List<Item> expensiveItems = items.stream().filter(i -> i.price > 15).collect(Collectors.toList());
        expensiveItems.forEach(i -> System.out.println(i.title + ":" + i.price));

        System.out.println("####### CollectingAndThen / averagingDouble using Collector");
        final NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.UK);
        String formattedPrices = items.stream().collect(Collectors.collectingAndThen(Collectors.averagingDouble(i -> i.price), price -> formatter.format(price)));
        System.out.println("Formatted prices in UK currency : " + formattedPrices);

        System.out.println("###### GroupingBy and PartitioningBy with Collectors");
        Map<Boolean, List<Item>> map1 = items.stream().collect(Collectors.partitioningBy(i -> i.price > 15));
        Map<Integer, List<Item>> map2 = items.stream().collect(Collectors.groupingBy(item -> item.title.length()));
        for (Map.Entry<Boolean, List<Item>> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().stream().collect(Collectors.mapping(item -> item.title, Collectors.joining(","))));
        }
        for (Map.Entry<Integer, List<Item>> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().stream().collect(Collectors.mapping(item -> item.title, Collectors.joining(","))));
        }

        System.out.println("###### FlatMapping and Filtering using Collectors");
        Map<String,Set<Item>> map3 = orders.stream().collect(Collectors.groupingBy(o -> o.customer.name, Collectors.flatMapping(o -> o.getItemsAsStream(), Collectors.toSet())));
        for (Map.Entry<String, Set<Item>> entry : map3.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().stream().collect(Collectors.mapping(i -> i.title, Collectors.joining(";"))));
        }

        Map<String, Set<Order>> map4 = orders.stream().collect(Collectors.groupingBy(o -> o.customer.name, Collectors.filtering(o -> o.items.size() > 2, Collectors.toSet())));
        for(Map.Entry<String, Set<Order>> entry : map4.entrySet()) {
            System.out.println(entry.getKey() + " -> " + (entry.getValue().stream().collect(Collectors.mapping(o -> o.code, Collectors.joining(",")))));
        }
    }
}