package ex04_practice;

public class MainClass {

	public static void main(String[] args) {

		//User user = new User();
		//Builder builder = user.builder();
		
		User user = User.builder()
						.id("admin")
						.pw("123456")
						.build();
		
		System.out.println(user);
		
		
	}

}
