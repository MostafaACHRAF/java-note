package referenceVariables;

import java.util.Arrays;

public class Main1 {
	public static void main(String... args) {
		System.out.println("******** Reference variable of type {derived class} *******");
		Programer programer = new Programer();
		programer.name = "Mostafa";
		System.out.println(programer.name);
		String[] data = programer.getLanguages();
		Arrays.stream(data).forEach(System.out::println);
		programer.code();
		/* The reference variable can access attributes and methods of {Programer, Person, Coder}*/
	}
}
