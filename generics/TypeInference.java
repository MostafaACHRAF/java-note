package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TypeInference {
    static <T> T pick(T a1, T a2) {
        return a2;
    }

    public static void main(String... args) {
        Serializable s = pick("string", new ArrayList<String>());
        // String s2 = pick("string", new ArrayList<String>());//won't compile
        Object s2 = pick("string", new ArrayList<String>());//compiles
        // List<String> s3 = pick("string", new ArrayList<String>());//won't compile
        // Comparable<String> s3 = pick("string", new ArrayList<String>());//won't compile
        // Cloneable s3 = pick("string", new ArrayList<String>());//won't compile

        /**
            's' and 's2' works because type arguments 'String' and 'ArrayList' are subtypes of Serializable and Object
            So the inference algorithm could found a common type between all type arguments and return type
         */
    }
}