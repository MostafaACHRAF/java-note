package function;

import java.util.function.Predicate;
import java.util.function.DoublePredicate;
import java.util.function.DoubleFunction;
import java.util.function.BiFunction;
import java.util.function.Supplier;

//A functional interface
interface Lambda {
    int calculate(int a, int b);
}

public class MyLambda {
    private Lambda lampda = (var a, var b) -> a * b;
    private int getCalculatedValueOf(int a, int b) {
        return lampda.calculate(a,b);
    }
    private void setFormula(Lambda lampda) {
        this.lampda = lampda;
    }
    public static void main (String... args) {
        MyLambda myLambda = new MyLambda();

        var val = myLambda.getCalculatedValueOf(5, 6);
        System.out.println("val: " + val);

        myLambda.setFormula((var a, var b) -> a + b); 

        var newVal = myLambda.getCalculatedValueOf(5, 6);
        System.out.println("new val: " + newVal);

        DoublePredicate p = (s) -> s > 0;//if you try to specify a type using '<>' the code won't compile
        DoubleFunction<Integer> f = (double i) -> (int) (i * 10.0);//accepts one parameter, the output value will be of type Integer, while the input value is of type Double.
        BiFunction<Integer, Integer, Double> bf = (a, b) -> (double) a / b;//accepts three params, the first two are the input types, and the last one is the output type.

        String city = "Saitama";
        // Supplier<String> sup = () -> city.toUpperCase();//can be replaced with city::toUpperCase;
        Supplier<String> sup = city::toUpperCase;
        System.out.println("city: " + sup.get());

        BiFunction<Integer, Integer, String> bee = (a, b) -> city.substring(a, b);
        BiFunction<Integer, Integer, String> bee2 = city::substring;//bee2 is equivalent to bee, using method reference
        // String value = bee2.apply(4, 5);//this line should compile successfully.


    }
}