package ex06_Object;

public class MainClass {

	/*
		java.lang.Object 클래스
		1. 모든 클래스의 최상위 슈퍼 클래스이다.
		2. 별도의 슈퍼 클래스를 명시하지 않는 경우 Object 클래스가 슈퍼 클래스이다.
		3. 모든 것을 저장할 수 있는 만능 타입이다.
		4. Object 타입으로 저장된 객체는 Object 클래스의 메소드만 호출할 수 있으므로 다시 원래 객체의 타입으로 캐스팅해서 사용해야 한다.
	*/
	
	/*
		Object 클래스의 주요 메소드
		1. equals 
			1) 동등 비교할 때 사용하는 메소드
			2) 동등 비교하는 객체들의 참조값을 비교함(객체의 값을 비교하지 못함)
			3) 객체의 값으로 동등 비교를 수행하기 위해서는 equals 메소드를 "오버라이드"해야 한다.
		2. toString 
			1) 문자열로 변환할 때 사용하는 메소드
			2) "객체이름 + @ + 참조값" 형식으로 변환함
			3) 원하는 형식으로 변경하려면 toString 메소드를 "오버라이드" 해야 함
	*/
	
	
	public static void ex01() {
		
		Object person = new Person();		// Object 클래스는 모든 객체를 저장할 수 있다.
		
			if(person instanceof Person) {
				((Person) person).eat();	// Object 객체는 사용하기 위해서 항상 캐스팅해야 한다.
				((Person) person).sleep();
			}
	}
	
	public static void ex02() {
		
		// name이 같으면 같은 Person으로 처리하기로 한 시스템
		
		Person person1 = new Person("홍길동");
		Person person2 = new Person("홍길동");		// person1, person2 서로 참조값이 다르다(저장위치가 다르다). new하면 무조건 새로운 객체
		
		if(person1.equals(person2)) {		// Object 클래스의 equals는 참조값을 비교한다. 내용물이 아무리 같아도 서로 다른 객체라면 다르다고 인식한다.
			System.out.println("같은 Person이다.");
		} else {
			System.out.println("다른 Person이다.");		// name이 같으면 의 코드를 안 짜줌. equals 오버라이드해야 된다.
		}
	}
	
	public static void ex03() {
		
		Person person = new Person("홍길동");
		
		System.out.println(person);			// 똑같은 두 내용이 출력됨. 
		System.out.println(person.toString());	// system.out 으로 출력할 때 toString 메소드는 호출을 생략함, 자동으로 반영된다.
		
	}
	
	public static void main(String[] args) {

		ex03();
	}

}
