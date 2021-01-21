package superKeyword;

public class Human implements Interface {
	protected String name;

	public Human(String name) {
		this.name = name;
	}
	
	public void drink() {
		System.out.println("A human needs to drink water");
	}

	@Override public String toString() {
		return String.format("[%s]", this.name);
	}		
}
