package protectedfields.pack2;

import protectedfields.pack1.Class1;

public class DerrivedClass2 extends Class1 {
    public DerrivedClass2() {
        System.out.println(serialUID);
        Class1 class1 = new Class1();
        System.out.println("base serialUID = " + class1.serialUID);//won't compile because DerrivedClass2 not int the same package as Class1.
        //So it can't access base class protected fields using instance variables.
    }
}