package thisKeyword;

public class Me implements Interface {
	public void run() {
		// You can't change the distance because interface constants are final!
		// this.distance = 9000;
		System.out.println(this + " => Me run for :" + this.distance + "...");
	}
}
