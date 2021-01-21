package thisKeyword;

public class Person {
	String name;
	short age;

	public Person() {
		// The use of 'this' keyword isn't obligatory in the live below.
		this.name = "mostafa";
		this.age = 26;
	}

	public Person(String name, short age) {
		// In the line below, the use of 'this' keyword is obligatory.
		// Because 'name' parameter claches with 'name' instance variable.
		this();
		this.name = name;
		this.age = age;
	}

	private double getRandomNumber() {
		return Math.random() * this.age;
	}

	public void printAMessage() {
		System.out.println(this.getRandomNumber() + " is the calculated value! By: " + this);
	}

	@Override public String toString() {
		return String.format("{name: %s, age: %s}", name, age);
	}
}
