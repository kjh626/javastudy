package ex05_lombok;

public class MainClass {

	public static void main(String[] args) {

		User user = new User();
		
		user.setId("admin");
		user.setPw("123456");
		
		System.out.println(user.getId());
		System.out.println(user.getPw());
		System.out.println(user);
		
		User user2 = User.builder()
						.id("master")
						.pw("654321")
						.build();
		System.out.println(user2);
		
		
		Practice_Student student = new Practice_Student();
		
		student.setName("김정현");
		student.setStuNo("987654");
		
		System.out.println(student.getName());
		System.out.println(student.getStuNo());
		System.out.println(student);
		
		Practice_Student student2 = Practice_Student.builder()
									.name("김정현")
									.stuNo("987654")
									.build();
		System.out.println(student2);
		
	}

}
