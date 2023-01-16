package ex07_abstract;

public class MainClass {

	public static void main(String[] args) {

		// 현재 가장 안전한 코드
		Person person = new Student();	// new Person이 막힘.
		// Person[] 타입으로 new Studnet, Alba 등 을 넣어서 배열(여러 명)로 관리할 수 있다.
		// Person 타입에 자식들을 넣어서 저장할 수 있다. => 상속의 목적 : 부모타입으로 자식들을 저장하기 위해서
		
		
		person.eat();
		person.sleep();
		person.study();
		
	}

}
