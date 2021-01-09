package interfaces4;

public class XClass implements Interface1 {
	public void printMaxDistance() {
		final int maxDistance = Interface1.calculateMaxDistance();
		System.out.println(maxDistance);
	}

	public void hiking() {
		System.out.println("I love hiking");
	}

	//public void eat() {
	//	System.out.println("I love burger");
	//}
}
