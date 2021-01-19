package casting;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String... args) {
		Employee emp = new Employee("mostafa", 12000, "Software Engineer");
		Person person1 = new Person("rahaf");
		Person person2 = new Employee("fatima", 20000, "Entrepreneur");
		HRManager manager = new HRManager("Achraf");

		List<Person> people = (List<Person>) Arrays.asList(emp, person1, person2, manager);
		
		for (Person p : people) {
			if (p instanceof HRManager) {
				//The object is of type person, and this object doesn't have this method. You must cast this object to HRManager to be able to use the below method.
				((HRManager) p).conductAnInterview(people);
			} else {
				System.out.println(p);
			}
		}
		
	}
}
