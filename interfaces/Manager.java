package interfaces;

public class Manager extends Employee {
	public void conductInterview() {
		System.out.println("A manager conduct an interview");
	}

	public void conductADebrief() {
		System.out.println("A manager conduct a debrief");
	}

	public char submitInterviewStatus() {
		return 0;
	}

	static void bookAnInterviewRoom() {
		System.out.println("manager book an interview room");
	}
}
