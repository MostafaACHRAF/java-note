package referenceVariables;

import java.util.Arrays;

public class Main3 {
	public static void main(String[] args) {
		System.out.println("******* Reference variable of type {interface} *******");
		Coder programer = new Programer();
		// programer.id = 2345;
		// programer.name = "Sosito";
		// System.out.println(programer.id + " - " + programer.name);
		// String[] languages = programer.getLanguages();
		// Arrays.stream(languages).forEach(System.out::println);
		programer.code();
		/*Our fancy reference variable can only access methods and variables of {interface}*/
	}
}
