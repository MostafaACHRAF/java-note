package interfaces4;

public interface Interface1 {
	// 1- If you change this method's type to abstract method, the implementing classes won't compile
	// 2- If you change this method's type to default the code that uses this method won't compile
	static int calculateMaxDistance() {
		return 3400;
	}

	// 1- If you change this method's type from abstract to static, the code using this method won't compile only if the reference variable used to call this method is of type 'interface'.
	// 2- If you change this method's type from abastract to default, the classes implementing this interface will compile.
	abstract void hiking();

	// 1- If you chabge this method's type from default to abstract, the implementing classes if they didn't override the default method, the implementing classes won't compile. 
	// 2- If you change this method's type from default to static, the code that calls this method won't compile if the variable used to call this mehod is of type 'interface'.
	static void eat() {
		System.out.println("Eat bread");
	}

}
