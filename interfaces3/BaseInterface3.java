package interfaces3;

public interface BaseInterface3 {
	int identifier = 50;

	static int calculateSum(int a, int b) {
		return a + b;
	}

	default void doSomething() {
		System.out.println("BaseInterface3: do something...");
	}
}
