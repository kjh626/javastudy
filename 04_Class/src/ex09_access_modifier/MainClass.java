package ex09_access_modifier;

public class MainClass {

	public static void main(String[] args) {

		// User 객체 생성하기
		User user = new User();
		
		// user 객체에 id 전달하기. // "admin"을 setId메소드에 전달 이후 setId의 id를 필드의 id로 전달.(직접 전달X, 메소드 거쳐서 가야함)
		user.setId("admin");
	
		// user 객체의 id 확인하기
		System.out.println(user.getId());
		
		// user 객체에 pw 전달하기
		user.setPw("123456");
		
		// user 객체의 pw 확인하기
		System.out.println(user.getPw());
	}

}
