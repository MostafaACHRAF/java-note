package polymorphism2;

// If if this class implements two interfaces who has inheritence relation and define the same default method, this class will compile successfully, because the interface 'Interviewer' extends 'BadInterviewer'
// So The decalaration of 'BadInterviewer' is redundant and has not impact.
// If the interface 'Interviewer' is no longer extends 'BadInterviewer', then the class manager will conpile successfully. 

public class Manager implements Interviewer, BadInterviewer {
	//Overrids interface's default method, so this is a polymorphism ^.^
	public void submitInterviweStatus() {
		System.out.println("Manager:ACCEPT");
	}
}
