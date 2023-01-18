package ex03_singleton;

public class MainClass {

	public static void main(String[] args) {

		// User 객체 가져오기
		User user1 = User.getInstance();
		User user2 = User.getInstance();
		
		// 같은 User인가?
		System.out.println(user1 == user2);  	// true : 참조값이 같다. 저장된 주소가 같다. 물리적으로 같다
		
		Practice_Person person1 = Practice_Person.getInstance();
		Practice_Person person2 = Practice_Person.getInstance();
		
		System.out.println(person1 == person2);
		
		
	}

}
