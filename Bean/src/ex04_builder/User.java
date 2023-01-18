package ex04_builder;

public class User {

	// User 필드(Builder 객체가 가진 값을 받아온다.) <- 그동안은 세터로 채우거나 생성자로 채웠었음.
	private String id;
	private String pw;
	
	// User 생성자
	public User(Builder builder) {	// Builder에서 this는 Builder임
		this.id = builder.id;
		this.pw = builder.pw;
	}
	
	// Builder 객체 반환
	public static Builder builder() {
		return new Builder();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}

	// Builder 클래스(내부 클래스)
	public static class Builder {
		
		// Builder 필드(여기로 값을 전달 받아서 User 필드로 전달한다.)
		private String id;
		private String pw;
		
		// 값을 받아오는 메소드
		// 1. 메소드명과 필드명을 동일하게 구성한다.
		// 2. 메소드 체이닝을 위해서 현재 객체를 반환한다. 
		public Builder id(String id) { // 반환타입을 클래스명(this)으로 바꿔주고 setId부분을 id로 바꿔줌(메소드명을 필드명과 동일하게), 그리고 현재 객체를 반환함.
			this.id = id;
			return this;
		}
		
		public Builder pw(String pw) {
			this.pw = pw;
			return this;
		}
		
		// User 객체 반환
		// Builder 필드 값을 가진 User 객체를 반환
		public User build() {
			return new User(this);	// this는 id,pw 값을 모두 가지고 있는 Builder객체. 		이렇게 생긴 생성자가 필요함
		}
		
	}
}
	

					/*	과정 참고 
					// user.setId("admin") -> 반환타입 : void => 실행결과가 없다(void니까)
					// user.setId("admin").setPw("123456") => 안 된다. 
					//  →이게 실행되려면 user.setId("admin")의 실행결과가 user면 된다. 그러면 user.setPw("123456") 메소드도 호출이 가능해진다.
					// 클래스 내부에서는 User를 this라고 부른다. 반환타입이 클래스명이 된다. this를 리턴해준다.
					/*
				 	 * public User setId(String id) {
					 *		this.id = id;
					 *		return this;
					 * } => 이렇게하면 user.setId("admin")의 실행결과가 user -> user.setId("admin").setPw("123456") 가능해짐.
					 */
