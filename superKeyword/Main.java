package superKeyword;

public class Main {
	public static void main(String... args) {
		Human employee = new Employee("mostafa", "sasa");
		employee.drink();
		System.out.println(employee);
		((Employee) employee).print(); // cast is obligatory, because reference variable of type Human can't see print method
	}
}
