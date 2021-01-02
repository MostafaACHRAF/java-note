package interfaces2;

public interface Athlete {
	int DISTANCE=20;
	String COMPETITIONNAME = "IWWWC";
	void run(String place);
	default void eat(int l) {
		System.out.println("An athlete eat healthy food");
	}

	static void chooseACompetition() {
		System.out.println("An athlete can choose a competition");
	}
}
