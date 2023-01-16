package ex05_upcasting;

public class Person {

	public void eat() {
		System.out.println("먹는다.");
	}

	public void sleep() {
		System.out.println("잔다.");
	}
	
	// 자식 클래스가 가지고 있는 메소드
	public void study() {
		// 본문 비워둬도 된다., 필요없는 메소드 처럼 보이기도 함.
	}
	
	// 후손 클래스가 가지고 있는 메소드
	public void work() {
		
	}
	// 호출되지만 진짜 실행되는 것은 아님, 다른 걸로 바뀌어서 실행됨
}
