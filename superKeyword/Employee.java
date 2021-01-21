package superKeyword;

public class Employee extends Human {
	private String subName;

	public Employee(String name, String subName) {
		super(name);
		this.subName = subName;
	}
	
	public void drink() {
		System.out.println(String.format("*** %s / %s ***", this.name, super.name)); // Because there is no collision we can use 'this' and 'super' interchangeably
		super.drink(); // call parent methos using the keyword 'super'
		System.out.println("An employee drinks a lot of coffee");
	}

	@Override public String toString() {
		return String.format("%s (%s)", super.name, this.subName);
	}

	public void print() {
		System.out.println("Employee...");
	}
}
