package polymorphism;

public class Developer extends Employee {
	//This method doesn't overrid parent's method, because it doesn't have the same parameters type
	String name = "Developer";

	public Object doWork(String arg) {
		System.out.println("A developer solve problems using code.");
		return null;
	}
}
