package ex03_constructor;

public class MainClass {

	public static void main(String[] args) {
		
		Student student = new Student(); // Pesrson 생성자가 왜 나오지? 의심
		
		/************************************/
		
		Student student2 = new Student("정숙", "가산중학교");
		System.out.println(student2.getName());
		System.out.println(student2.getSchool());
		
		// 연습
		Alba alba = new Alba("상철", "가산대", "맥도날드");
		System.out.println(alba.getName());
		System.out.println(alba.getSchool());
		System.out.println(alba.getCompany());
		
	}

}
