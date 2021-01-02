package interfaces2;

public class Developer implements Runner, Athlete {
	
	public void run() {
		System.out.println("A developer can run");
		System.out.println("Distance : " + Athlete.DISTANCE);
		System.out.println("A developer can paraticipate in: " + Athlete.COMPETITIONNAME);
		//In the above two lines, if we don't use interface's names to call static variables, a compilation error will rise.
	}

	public void run(String place) {
		System.out.println("A developer can run in : " + place);
	}

	static void chooseACompetition() {
		System.out.println("A developer can choose a competition");
	}
}
