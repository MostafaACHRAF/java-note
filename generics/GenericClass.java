package generics;

public class GenericClass {
    static class Pair<K,V> {
        K key;
        V value;
        Pair(K key,V value) {
            this.key = key;
            this.value = value;
        }
    }

    static <K,V> boolean compare(Pair<K,V> pair1, Pair<K,V> pair2) {
        return pair1.key.equals(pair2.key) && pair1.value.equals(pair2.value);
    }

    interface A {}
    interface B {}

    static class C<T extends Pair & A & B> {}

    //D must implement A & B & extends Pair, in order to be a type param for (C) object references
    static class D<K,V> extends Pair<K, V> implements A,B {
        D(K key, V value) {
            super(key, value);
        }
    }

    public static void main(String... args) {
        Pair p1 = new Pair("dd", "p1");
        Pair<Integer, String> p2 = new Pair<>(6, "p4");
        boolean isEquals = GenericClass.<Integer, String> compare(p1, p2);
        System.out.println("is equals: " + isEquals);

        Double b = Double.valueOf(5.5);
        int a = b.intValue();

        C<D> c = new C<>();
        // C cc = new C();//ok
        // C ccc = new C<>();//ok
    }


}