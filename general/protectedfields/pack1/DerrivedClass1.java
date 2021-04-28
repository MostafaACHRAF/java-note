package protectedfields.pack1;

public class DerrivedClass1 extends Class1 {
    public DerrivedClass1() {
        System.out.println(serialUID);
        Class1 class1 = new Class1();
        System.out.println("class1 of parent class => " + class1.serialUID);//this code will compile because the derrived class exist in the same package as the base class. 
        //So it can access base class protocted fields using instance varialbes
    }

    public static void main(String... args) {
        DerrivedClass1 derrivedClass1 = new DerrivedClass1();
    }
}