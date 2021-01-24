package polymorphism2;

public interface BadInterviewer {
	default void submitInterviweStatus() {
		System.out.println("BadInterviewer:UNDEFINED");
	}
}
