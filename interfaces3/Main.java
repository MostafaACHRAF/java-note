package interfaces3;

public class Main {
	public static void main(String... args) {
		Person p = new Person();
		p.haveFun();
		System.out.println(p.printAMessage());

		System.out.println("-------");

		SubInterface1 p2 = new Person();
		p2.haveFun();
		System.out.println(p.printAMessage());

		System.out.println("-------");

		p.showMe();
		p2.showMe();
		p.doSomething();
		System.out.println("Sum = " + BaseInterface3.calculateSum(5, 7));
	}
}
