package thisKeyword;

public interface Interface {
	int distance = 34568;
	void run();
	static void init() {
		System.out.println("Init...");
	}
	default void doo() {
		Interface.init();
		System.out.println(this);
		this.run();
		System.out.println(this.distance + " KM");
	}
}
