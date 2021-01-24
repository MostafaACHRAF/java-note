package polymorphism2;

public interface Interviewer {
	default void submitInterviewStatus() {
		System.out.println("Interviewer:ACCEPT");
	}
}
