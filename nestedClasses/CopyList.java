package nestedClasses;

import java.util.function.Supplier;
import java.util.List;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;

public class CopyList {
    static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST copy(SOURCE source, Supplier<DEST> supplier) {
        DEST result = supplier.get();
        for(T x : source) {
            result.add(x);
        }
        return result;
    }
    public static void main(String... args) {
        List<String> hashiras = List.of("Rengoku", "Mitsuri", "Uzui", "Tomioka", "Shinobu");

        Set<String> hashirasSet = copy(hashiras, () -> new HashSet<>());
        var hashirasSet2 = copy(hashiras, HashSet::new);//reference to a constructor
        // var hashirasSet2 = copy(hashiras, HashSet<String>::new);//you can use <> operator

        System.out.println(hashirasSet2 instanceof Set);
        hashirasSet.forEach(System.out::println);

    }
}