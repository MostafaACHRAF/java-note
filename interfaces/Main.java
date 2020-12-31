package interfaces;

import java.time.LocalDateTime;

public class Main {
	public static void main(String... args) {
		Interviewer manager = new Manager();
		manager.conductInterview();
		manager.conductADebrief();
		Interviewer.bookAnInterviewRoom(LocalDateTime.now(), 15);

		//manager.bookAnInterviewRoom(LocalDateTime.now(), 18);
		//The above line won't be compiled, because we can't call interfac's static methods using reference variable. We must use "interface name"

		//manager.bookAnInterviewRoom();
		//The above line won't compile, because "manager" reference variable is of type "Interviewer" and our interface hasn't a method with this signature!

		Manager.bookAnInterviewRoom();

	}
}
