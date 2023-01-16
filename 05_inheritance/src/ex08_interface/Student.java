package ex08_interface;

/*
	용어 정리
	
	1. 클래스를 상속 받는다. extends 키워드를 사용한다.
		public class Person { }
		public class Student extends Person { }
		
	2. 인터페이스를 구현한다. implements 키워드를 사용한다. (extends와 기능은 동일하다 생각해라)
		public interface Person { }
		public class Student implements Person { }
*/
public class Student implements Person {

	@Override
	public void study() {

		System.out.println("공부한다.");
		
	}

	
}
