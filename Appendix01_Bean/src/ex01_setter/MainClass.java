package ex01_setter;

public class MainClass {
		// Bean 만드는 3가지 방법 : setter, constructor, singleton / + 1 : builder
	public static void main(String[] args) {

		// User 객체(Bean) 생성
		
		User user = new User();
		
		// setter를 이용한 필드 값 저장
		user.setId("admin");
		user.setPw("123456");
		
		// 필드 값 확인
		System.out.println(user);
		
	}

}
