package ex06_downcasting;

public class MainClass {

	public static void ex01() {
		
		// upcasting
		Person person = new Student();		// 부모 타입에 저장. 업캐스팅의 문제점 해결 방법 2가지 - 
											// 1) 부모 클래스에도 메소드 만들고 자식 클래스 메소드 오버라이드, 2) 다운캐스팅
		
		// downcasting
		Student student = (Student) person;	// 자식 타입에 저장
		
		student.eat();
		student.sleep();
		student.study();
		
	}
	
	public static void ex02() {
		
		// Person
		Person person = new Person();		
		
		// 잘못된 캐스팅
		Student student = (Student) person;	// 자식 타입에 저장
		
		// 잘못된 캐스팅은 컴파일 오류로 걸러지지 않는다. 
		student.eat();
		student.sleep();
		student.study();	// 오류 발생 부분(person은 study가 없기 때문에)
		
	}
	
	public static void ex03() {
		
		// Person
		Person person = new Person();	// person을 객체라고 부른다. = 인스턴스라고도 부른다.
		
		// Student 객체(인스턴스, instance)가 맞다면 Student 타입으로 캐스팅하자. = 걸러주기 작업(오류 발생 안 하도록)
		if(person instanceof Student) {	// person이 Student 객체라면
			
			Student student = (Student) person;
			student.eat();
			student.sleep();
			student.study();
			
			// 추천하는 코드 형식!! => person.eat(); , person.sleep(); 코드(두 코드)와 ((Student)person).study(); 코드가 다른 곳에 있음을 알 수 있음. 
			person.eat();
			person.sleep();
			// 다른 스타일의 코드. 똑같은 의미임.
			/* Student student = (Student) person;
			student.study(); */
			((Student)person).study();

			
			
			// if 안에 들어온 것은 Student라고 본다. 그래서 person.에 study 뜬다. => 이클립스가 도와주는 것(몰라도 됨) 
			((Student) person).study();
		}
		
	}
	
	
	public static void main(String[] args) {
		ex03();
	}

}
