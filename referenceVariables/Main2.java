package referenceVariables;

public class Main2 {
	public static void main(String... args) {
		System.out.println("******* A reference variable of type {super class} *******");
		Person programer = new Programer();
		programer.name = "Riri";
		System.out.println(programer.name);
		// String[] languages = programer.getLanguages();
		// Arrays.stream(languages).forEach(System.out::println);
		// programer.code();
		/* Our reference variable can only access methods and variables of {Person}*/
	}
}
