package casting;

public class Person {
	protected String name;

	public Person() {}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override public String toString() {
		return String.format("{name: %s}", name);
	}
}
