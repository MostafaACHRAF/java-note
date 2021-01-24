package polymorphism2;

public class Main2 {
	public static void main(String... args) {
		Interviewer manager1 = new Manager();
		Manager manager2 = new Manager();

		//At compile time both reference variable has access to 'submitInterviewStatus'. And at runtime both reference variables will call the overriding method in Manager class.
		manager1.submitInterviewStatus();
		manager2.submitInterviewStatus();
	}
}
