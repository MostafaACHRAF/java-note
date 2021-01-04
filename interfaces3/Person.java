package interfaces3;

public class Person implements SubInterface1 {
	public void haveFun() {
		System.out.println("Drink some water");
		//doesn't work : System.out.println("And do : " + SubInterface1.printAMessage());
		//Won't work, becase Person doesn't implement BaseInterface1 directly!: System.out.println(BaseInterface1.super.printAMessage());
		System.out.println("==> " + SubInterface1.super.printAMessage());
		//Won't work: System.out.println(BaseInterface.super.printAMessage());

		SubInterface1.super.saySomething();
		SubInterface1.super.doSomething();
	}

	public void doSomething() {
		System.out.println("Person: Play chess");
	}
}
