package ex02_constructor;

public class MainClass {

	public static void main(String[] args) {

		// User 객체 생성
		User user = new User("admin", "123456");	// 실제로는 생성자를 통해 쓰기 보다는 setter를 많이 씀.
		
		// 필드값 확인
		System.out.println(user);
		
	}

}
