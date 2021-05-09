package nestedClasses;

public class Anonymous {
    interface Greeting {
        void greet();
        void greetSomeone(String someone);
    }

    void sayHello() {
        class FrenchGreeting implements Greeting {
            String someone;
            @Override
            public void greet() {
                greetSomeone("tout le monde!");
            }
            @Override
            public void greetSomeone(String someone) {
                this.someone = someone;
                System.out.println(lang + ": Salut " + this.someone);
            }

            void foo() {System.out.println("Foooo");} //you can define new methods inside a local inner class
        }

        FrenchGreeting frGreeting = new FrenchGreeting();

        Greeting enGreeting = new Greeting() {
            static final String lang = "en";
            @Override public void greet() {greetSomeone("world!");}
            @Override public void greetSomeone(String someone) {System.out.println(lang + ": Hello " + someone);}
            public void foo() { System.out.println("foo");} //Won't compile if you try to invoke this method, because you can't add new methods inside an anonymous inner class!
        };

        Greeting esGreeting = new Greeting() {
            static final String lang = "es";
            @Override public  void greet() {greetSomeone("mundo!");}
            @Override public  void greetSomeone(String someone) {System.out.println(lang + ": Holla " + someone);}
        };

        frGreeting.greet();
        esGreeting.greet();
        enGreeting.greet();
        // enGreeting.foo();//won't compile, because you can't add new methods into an anonymous class
        frGreeting.foo();//will compile because, frGreeting isn't an anonymous class, its a local inner class
    }

    static String defaultLang = "en";
    static String lang = "fr";
    interface Bye {
        String lang = Anonymous.lang;
        // String fallBack = fallBackLang;//won't compile because 'fallBackLang' isn't static
        void sayBye();
    }

    static void sayBye() {
        Bye enBye = new Bye() {//can access static and instance fields of the outer class
            @Override public void sayBye() {System.out.println(defaultLang + ": Bye!");}
        };

        // static Bye frBye = new Bye() {//You can't use 'static' access modifier inside a method!
        Bye frBye = new Bye() {
            @Override public void sayBye() {defaultLang = "fr"; System.out.println(defaultLang + ": Au revoir!");}
        };
        enBye.sayBye();
        frBye.sayBye();
    }


    public static void main(String... args) {
        Anonymous a = new Anonymous();
        a.sayHello();
        Anonymous.sayBye();
    }
}