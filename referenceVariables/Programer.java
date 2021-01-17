package referenceVariables;

public class Programer extends Person implements Coder {
	private String[] languages;

	public Programer() {
		languages = new String[] {"java","php","js"}; 
	}

	public void code() {
		System.out.println("A programer can code!");
	}

	public String[] getLanguages() {
		return languages;
	}
}
