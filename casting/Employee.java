package casting;

public class Employee extends Person {
	private long salary;
	private String position;

	public Employee(String name, long salary, String position) {
		super(name);
		this.salary = salary;
		this.position = position;
	}

	public long getSalary() {
		return this.salary;
	}

	public String getPosition() {
		return this.position;
	}

	@Override public String toString() {
		return String.format("{name: %s, position: %s, salary: %s}", name, salary, position);
	}
}
