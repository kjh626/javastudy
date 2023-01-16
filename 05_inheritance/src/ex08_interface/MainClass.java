package ex08_interface;

public class MainClass {

	public static void main(String[] args) {

		// 현재 가장 안전한 코드
		Person person = new Student();
		
		person.eat();
		person.sleep();
		person.study();
	}

}
