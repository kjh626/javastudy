package ex03_practice;

public class MainClass {

	public static void main(String[] args) {
		
		Practice_Person person1 = Practice_Person.getInstance();
		Practice_Person person2 = Practice_Person.getInstance();
		
		System.out.println(person1 == person2);
		
	}
	
}
