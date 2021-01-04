package interfaces3;

public interface BaseInterface2 {
	void haveFun();
	default String printAMessage() {
		return "I see a beautifull blue sky";
	}

	default void saySomething() {
		System.out.println("Hi");
	}
}
