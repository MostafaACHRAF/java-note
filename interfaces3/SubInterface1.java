package interfaces3;

public interface SubInterface1 extends BaseInterface1, BaseInterface2, BaseInterface3 {
	default String printAMessage() {
		return "SubInterface1: Distraction";
	}

	default void showMe() {
		final String msg1 = BaseInterface1.super.printAMessage();
		final String msg2 = BaseInterface2.super.printAMessage();
		System.out.println(msg1 + " - " + msg2);
		BaseInterface3.super.doSomething();
	}
}
