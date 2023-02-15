package ex01_Thread;

public class MainClass {

	public static void main(String[] args) {

		Calculator myCalc = new Calculator("영희"); // myCalc 스레드 생성
		myCalc.start(); // start 메소드는 run 메소드를 스스로 호출한다. main은 myCalc 스레드의 동작 시작만 처리하고 동작 완료까지 기다리지 않는다.
		
		Calculator yourCalc = new Calculator("상철"); // yourCalc 스레드 생성 => 멀티스레드환경
		yourCalc.start(); // start 메소드는 run 메소드를 스스로 호출한다. main은 yourCalc 스레드의 동작 시작만 처리하고 동작 완료까지 기다리지 않는다.
		
		// myCalc 스레드가 yourCalc 스레드보다 먼저 실행된다는 보장이 전혀 없다.
		// 스레드 실행 순서를 정하는 건 개발자가 아니라 JVM이다.
		// 스레드 실행 순서 정하기를 스케줄링이라고 한다. firstin/ shortest~~/ ... 상당히 많은 스케줄링 방법이 있는데 이것은 JVM이 한다.  
		
		System.out.println("main 메소드를 종료합니다.");
		
	}

}
