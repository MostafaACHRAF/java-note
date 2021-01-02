package interfaces2;

public interface Runner {
	int DISTANCE=39;
	double COMPETITIONNAME = 0;
	void run();
	default void eat() {
		System.out.println("A runner must eat well and drink a lot of water");
	}

	static int chooseACompetition() {
		System.out.println("A runner can choose a competition");
		return 1;
	}
}
