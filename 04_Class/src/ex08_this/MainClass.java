package ex08_this;

public class MainClass {

	public static void main(String[] args) {
		
		// User 객체 생성
		User user = new User("admin", "123456");	// 생성자 하나만 만들었다. id, pw 전달 꼭 해야함.
		
		// user에 저장된 값은 생성된 user 객체의 참조값이다.
		System.out.println(user);
		
		// user 객체의 this값 확인
		user.printThis();			// 객체를 부르는 방법이 다르다. 외부에서, 내부에서 부른다.
		
		// user 객체의 필드값 확인
		user.info();
	}
}
