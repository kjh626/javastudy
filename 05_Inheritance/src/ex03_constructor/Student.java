package ex03_constructor;

/*
	this  : 현재 객체	this() : 현재 객체의 생성자
	super : 부모 객체	super() : 부모 객체의 생성자
*/

/*
	상속 관계의 생성자
	1. 자식 클래스는 "반드시" 부모 클래스를 "먼저" 생성한다.
	2. 자식 클래스의 생성자를 호출하면 "반드시" 부모 클래스의 생성자가 "먼저" 호출된다.
	3. 부모 클래스의 생성자가 "디폴트 생성자" 형식이면 자식 클래스에서 부모 클래스의 생성자 호출을 생략할 수 있다.
	4. 부모 클래스의 생성자를 호출할 때 super()를 사용한다.
*/

public class Student extends Person {

	// 생성자
	public Student() {
		super();  // 생략 가능한 부모 클래스의 생성자 호출(매개변수가 없는 디폴트 형식의 생성자는 생략 가능). but 디폴트 형식의 생성자가 아니면 반드시 적어줘야 한다.
		System.out.println("Student 생성");
	}
	
	/************************************/
	
	// 필드
	private String school;
	
	// 생성자 -> 메뉴 - Source - Generate Constructor ~ Field - 맨 위에서 생성자 고를 수도 있다.
	public Student(String name, String school) {
		super(name);
		this.school = school;
	}
	
	// 메소드
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	
	
	
}
