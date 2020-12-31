package interfaces;

public abstract class Employee implements Interviewer {
	public static int identifier;

	public void conductInterview() {
		System.out.println("employee conduct an interview");
	}
}
