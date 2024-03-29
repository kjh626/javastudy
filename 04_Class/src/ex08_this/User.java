package ex08_this;

public class User {

	/*
	 	this
	 	1. 현재 객체의 참조값
	 	2. 클래스 내부에서만 사용할 수 있다.
	 	3. 클래스의 구성 요소 (필드, 메소드)를 호출할 때 사용할 수 있다.
	 		1) 필드 	: this.필드 <- 그나마 이거 씀
	 		2) 메소드 	: this.메소드()
	*/
	
	// 필드
	String id;	// this.id
	String pw;	// this.pw
	
	// 생성자
	User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	// 메소드
	void printThis() {
		System.out.println(this);
	}
	
	void info() {
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw); // 메인의 "admin", "123456" -> 생성자 User(id,pw)에 전달, "admin", "123456"를 (필드의) this.id, this.pw에 전달 
	}
	
}
