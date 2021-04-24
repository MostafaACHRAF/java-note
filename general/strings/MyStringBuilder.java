package strings;

public class MyStringBuilder {

    class Foo {
        String bee(int a) {
            return null;

        }

        Integer bee(String a) {
            return null;
        }
    }
    public static void main(String... args) {
        // StringBuilder str = new StringBuilder();//create a stringbuilder object with a capacity of 16 character (auto-expands)
        // StringBuilder str = new StringBuilder(100);//stringbuilder with a capacity of 100
        StringBuilder str = new StringBuilder("Mostafa");//a stringbuilder object initialized with a value

        str.append('a');//append 'a' to str
        str.append("bc");//append "bc" to str
        str.insert(0, "I'm ");//insert "I'm " at position 0
        str.insert(11, ' ');//insert a space
        str.delete(13, 16);//accepts two params. Delete characters from 13 to 14 (14 isn't included)
        str.insert(str.length(), new Object());
        str.reverse();

        System.out.println("str: " + str);

        StringBuilder str2 = new StringBuilder(str.substring(str.lastIndexOf("a"), str.length()));
        System.out.println("str2: " + str2);

        str2.insert(0, "af");
        str2.reverse();
        System.out.println("str2: " + str2);

        String s = "sssssss";
        System.out.println("last s index: " + (s.lastIndexOf('s')));


        // StringBuilder s2 = new StringBuilder("sssssss");
        // System.out.println("last s2 index: " + (s2.indexOf('s')));//won't compile because s2 is a stringBuilder
        

    }
}