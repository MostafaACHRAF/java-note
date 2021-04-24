package strings;

public class Strings {
    public static void main(String... args) {
        //# strings
        String s1 = new String(new char[]{'a','b','c'});
        String s2 = new String("abc");
        String s3 = s1.intern();//creates an internal copy of s1
        String s4 = s2.intern();

        System.out.println("s3: " + s3);
        System.out.println("s4: " + s4);
        System.out.println("s3 == s4: " + (s3 == s4));//true
        System.out.println("s1 == s2: " + (s1 == s2));//false
        System.out.println("s1 == s3: " + (s1 == s3));//false

        System.out.println("s1 + 1 + 1 => " + (s1 + 1 + 1));//abc11
        System.out.println("1 + s1 + 1 => " + (1 + s1 + 1));//1abc1
        System.out.println("1 + 1 +s1 => " + (1 + 1 + s1));//2abc
        System.out.println("s1 + (1 + 1) => " + (s1 + (1 + 1)));//abc2

        System.out.println("indexOf b: " + s1.indexOf("b", 2));
        System.out.println("indexOf 97: " + s1.indexOf(97, 2));//search '97' starting from position 2
        System.out.println("last index of c: " + s1.lastIndexOf('c'));//2; get index of last 'c'
        System.out.println("substring from 0 -> 1: " + s1.substring(0, 1));//a
    }
}