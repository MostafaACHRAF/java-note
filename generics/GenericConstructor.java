package generics;

public class GenericConstructor {
    /**
        Generic classes can have generic constructors with different type parameters
     */
    static class GenericClass<T> {
        // X field;//won't compile 'X' type param is recognized inside the constructor only.
        <X> GenericClass(X x) {
            System.out.println(x.getClass().getName());
        }
    }

    /**
        Non generic classes can have generic constructors
     */
    static class NonGenericClass {
        <E> NonGenericClass(E e) {
            System.out.println(e.getClass().getName());
        }
    }

    <T> T foo(T t) {
        return t;
    }

    public static void main(String... args) {
        // NonGenericClass c1 = new NonGenericClass<String>("hello world");//won't compile because the class isn't generic! though the constructor is generic.
        NonGenericClass c1 = new NonGenericClass("hello world");
        // GenericClass<Number> c2 = new GenericClass<Integer>(5);//won't compile
        GenericClass<Number> c2 = new GenericClass<>(5);//ok
        GenericClass<Number> c3 = new GenericClass(5);//ok//triggerts an unchecked warnings

        GenericConstructor gc = new GenericConstructor();
        Integer v = gc.foo(5);//ok
        // Integer v2 = gc.<Integer>(5);//won't compile. Works only with static methods
        var v3 = gc.foo("eee");//v3 infered as a string.
    }
}