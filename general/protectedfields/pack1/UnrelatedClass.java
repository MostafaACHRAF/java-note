package protectedfields.pack1;

public class UnrelatedClass {
    public UnrelatedClass() {
        Class1 class1 = new Class1();
        System.out.println(class1.serialUID);//can access protected fields of all classes of the same package
    }
}