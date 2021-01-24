package polymorphism;

public class Main {
	public static void main(String... args) {
		Employee employee = new Employee();
		Employee developer = new Developer();
		Manager manager = new Manager();

		System.out.println(employee.name);
		employee.doWork(null);

		System.out.println(developer.name); //Will display "employee" because reference variable's type is Employee, and because variables are bound at compile time the referenced object's type doesn't matter
		developer.doWork(null);

		System.out.println(manager.name);
		manager.doWork(null);

	}
}
