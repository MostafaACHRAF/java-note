package interfaces;

import java.time.LocalDateTime;

public interface Interviewer {
	void conductInterview();

	default void conductADebrief() {
		System.out.println("conduct a debrief");
	}

	char submitInterviewStatus();

	static int bookAnInterviewRoom(LocalDateTime time, int nbrOfMinutes) {
		System.out.println("book the room number: 2344");
		System.out.println("in: " + time.toString());
		System.out.println("for: " + nbrOfMinutes + "minutes");
		return 1;
	}
}
