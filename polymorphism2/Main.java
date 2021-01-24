package polymorphism2;

public class Main {
	public static void main(String... args) {
		CleanCoder developer = new Developer();
		Developer backendDeveloper = new BackendDeveloper();
		Developer frontendDeveloper = new FrontendDeveloper();

		developer.code();
		backendDeveloper.code();
		frontendDeveloper.code();
	}
}
