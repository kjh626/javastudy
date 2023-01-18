package ex03_singleton;

public class Practice_Person {

	private static Practice_Person person = new Practice_Person();
	
	private Practice_Person() { }
	
	public static Practice_Person getInstance() {
		return person;
	}
	
}
