package ex06_Object;

public class MainClass {

	/*
		java.lang.Object 클래스
		1. 모든 클래스의 최상위 슈퍼 클래스이다.
		2. 별도의 슈퍼 클래스를 명시하지 않는 경우 Object 클래스가 슈퍼 클래스이다.
		3. 모든 것을 저장할 수 있는 만능 타입이다.
		4. Object 타입으로 저장된 객체는 Object 클래스의 메소드만 호출할 수 있으므로 다시 원래 객체의 타입으로 캐스팅해서 사용해야 한다.
	*/
	public static void ex01() {
		
		Object person = new Person();		// Object 클래스는 모득 객체를 저장할 수 있다.
		
			if(person instanceof Person) {
				((Person) person).eat();	// Object 객체는 사용하기 위해서 항상 캐스팅해야 한다.
				((Person) person).sleep();  
			}
	}
	
	public static void main(String[] args) {

		ex01();
	}

}
