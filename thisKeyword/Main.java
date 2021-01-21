package thisKeyword;

public class Main {
	public static void main(String... args) {
		Person person = new Person();
		Person person2 = new Person("fatima", (short) 20);

		System.out.println(person);
		person.printAMessage();

		System.out.println(person2);
		person2.printAMessage();
	}
}
