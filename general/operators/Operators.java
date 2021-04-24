package operators;

public class Operators {
    public static void main(String... args) {
        long a = (long) 5.6f;
        System.out.println("a: " + a);

        byte a1 = 'c' + 1; 
        System.out.println("a1: " + a1);

        // byte a2 = 23;
        // byte a3 = a2 / a1;//won't compile, because the resulting value is of type int

        // float a4 = 5/6; //will print 0.0, because 5 and 6 are of type int //print: 0.0
        // float a4 = (float) (5/6); //will print 0, because 5 and 6 are of type int //print: 0.0
        // int a4 = 5/6;//print 0
        float a4 = (float) 5/6; //will print the exact float value 0.83333 
        //if you want the exact float value, 5 or 6 must be float;
        System.out.println("a4: " + a4);

        // char x = 87;//will compile, chars are numbers
        //byte b = 'y' + 34;// will compile without explicit casting to (byte) 

        System.out.println("round 5/6: " + Math.round((double) 11/3 * 100) / 100.0);
        System.out.println("~5: " + ~5);//shoudl print -6

        byte b1 = 5;
        byte b2 = 6;
        System.out.println("(5 & 6) = " + (5 & 6));//4
        System.out.println("(5 | 6) = " + (5 | 6));//7
        System.out.println("(5 ^ 6) = " + (5 ^ 6));//3
        System.out.println("(b2 < b1 ^ b2 == 6) = " + (b2 > b1 ^ b2 != 6));//true
        System.out.println("(true || false) = " + (true || false));//true
        System.out.println("(true | false) = " + (true | false));//true
        // System.out.println("(true ^ false) = " + (true ^^ false));//won't compile

        if (false)
            System.out.println("true");
        else
            if (true)
                System.out.println("ifelse ture");
            
        var abc = b2 > b1 ? "test" : "nil";
        System.out.println(abc);//test

        char c = 'm';
        switch(c) {
            default:
                System.out.println("not found!");
                break;
            case 's': break;
            case 98:
            break;
            case 'm':
                System.out.println("Found! M");
        }
    }
}