package nestedClasses;

public class LocalInnerClass {

    static void foo() {}
    void neziko() {}

    static void validatePhoneNumber(String number) {
        String REGEX = "[^0-9]";//effectively final because its assigned once.
        // REGEX = "";//The line (18) won't compile because 'REGEX' reassigned twice. It isn't final of effectively final!

        //order matters, this class must be the first declaration in that case! To instantiate phoneNumber objects
        class PhoneNumber {
            // private static final String REGEX = "[^0-9]";
            private static final int NUMBER_LENGTH = 10;
            private String phoneNumber;
            private boolean isValid;//accessible, though its private

            // final static int a = 0;//will compile because 'a' is a constant
            // static int a = 0;//won't compile because 'a' isn't final, thus it isn't a constant


            private PhoneNumber(String number) {//We still can instantiate the class even if it has a private constructor
                foo();//compiles, because foo is a static method. And because this local class is defined in a static method, it can only access outer class's static members
                // neziko();//won't compile, because this method isn't static, it can't be referenced in a static context

                phoneNumber = number;
                if (number.replaceAll(REGEX, "").length() == 10) {
                    isValid = true;
                }
                
                class A {}
            }
            @Override
            public String toString() {
                return phoneNumber;
            }
        }
        PhoneNumber phoneNumber = new PhoneNumber(number);

        if (phoneNumber.isValid) {
            System.out.println("Valid phone number: " + phoneNumber);
        } else {
            System.out.println("Phone number is invalid: " + phoneNumber);
        }

    }

    public static void main(String... args) {
        String n1 = "06-01-94-30-00";
        String n2 = "005-9658";
        validatePhoneNumber(n1);
        validatePhoneNumber(n2);
    }
}