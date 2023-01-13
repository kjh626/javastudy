package practice02_Person_Array;

public class Person {		// 이런 형태 클래스 많이 만든다.

	// 필드
	private String name;
	private int age;
	
	// 생성자			(문제) new Person()
							//new Person("alice", 20)    2가지 방식이 가능하도록 생성자를 만들어라
	public Person() { }		// 디폴트 생성자는 생성자를 하나도 안 만들었을 때 안 써도 되는 거다. 이 생성자를 생략하면 new Person()를 못 만든다.
							// 이런 생성자는 name, age의 값은 null, 0이다 -> name, age 바꿔줄 메소드가 필요하다
	public Person(String name, int age) {	// 디폴트 생성자는 생성자를 하나라도 만들면 생성자를 만들어 줘야 한다. (자동이 아니게 됨)
		this.name = name;
		this.age = age;
	}
	

	//메소드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
