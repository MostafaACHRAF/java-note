package generics;

import java.util.List;

public class PayLoadList {
    static interface PayLoad<E,P> extends List<E> {
        void setPayLoad(int index, P val);
    }

    public static void main(String... args) {
        PayLoad<String, Integer> p1 = null;
        PayLoad<String, Double> p2 = null;
        PayLoad<String, String> p3 = null;
        // p1 = p2;//won't compile. Incompatible types
    }
}