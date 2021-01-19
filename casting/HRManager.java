package casting;

import java.util.List;

public class HRManager extends Person implements Interviewer {
	//This derived class won't inherite the constructors of its parent
	
	public HRManager(String name) {
		super(name);
	}

	public void conductAnInterview(List<Person> candidates) {
		final int candidatesCount = candidates.size();
		System.out.println(String.format("HRManager conducts an interview with: (%s) candidates.", candidatesCount));
	}
}
