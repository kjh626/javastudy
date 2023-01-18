package ex03_singleton;

public class User {
	
	// 싱글톤 : 객체를 "하나만" 만들 수 있다.
	// User를 하나만 만들 수 있다. 2개 이상 안 됨. 
	// 하나 만들어 놓고 계속 가져다 쓸 수 있게 해준다.
	
	// 이런 패턴으로 만든다고 생각해얄듯
	
	// static 필드 (미리 User를 만들어 둔다.)
	private static User user = new User();
	
	// private 생성자 (외부에서는 생성자를 호출할 수 없다) => 외부에서는 User를 만들 수 없다.
	private User() {
		
	}
	
	// static 메소드 (static 필드를 사용하기 위해서)
	// user 필드를 외부에서 사용할 수 있도록 반환하는 일종의 Getter
	public static User getInstance() {	// getInstance : user(객체) 가져가세요
		return user;
	}
	
}
