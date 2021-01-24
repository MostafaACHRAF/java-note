package polymorphism;

public class Manager extends Employee {
	//This method overrid parent's method, even if it's return type is a subtype ot parent's method return type
	String name = "manager";

	public String doWork(Object arg) {
		System.out.println("A manager planify tasks and take care of his developers -_-");
		return null;
	}
}
