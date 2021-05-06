package pack1;

import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        // Planet p1 = Planet.EARTH;//won't compile: case sensible
        Planet p1 = Planet.Earth;
        Planet p2 = Planet.Mars;
        // Planet p3 = new Planet();//Won't compile: enums can't be instantiated
        
        System.out.println(p1 == p2);//false

        Arrays.stream(Planet.values()).forEach(p -> System.out.print(p + " "));

        double myWeightOnEarth = Double.parseDouble(args[0]);

        for (var u : Universe.values()) {
            System.out.printf("Your weight on %s is %f%n", u, u.surfaceWeight(myWeightOnEarth));
        }
    }
}