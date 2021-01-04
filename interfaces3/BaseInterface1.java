package interfaces3;

public interface BaseInterface1 {
	void haveFun();
	default String printAMessage() {
		return "Hello 2021";
	}
}
