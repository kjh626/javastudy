package ex04_throws;

public class MainClass {

	public static void main(String[] args) {

		Gun gun = new Gun();
		
		try {
			gun.reload(11);	   // reload 메소드 호출 <- throws RuntimeException : reload 메소드를 호출하는 곳으로 예외를 던지겠다.
			for(int n = 0; n < 11; n++) {
				gun.shoot();
			}					// 예외 발생할 시 발생된 예외는 자동으로 catch로 전달된다.
		} catch(Exception e) {	// 예외 발생 X(10발), 아무일 없음. 예외 발생하면(11발) throw 받는다.
			System.out.println(e.getMessage());	
		}
		
	}	// 메소드(총알 넣기, 총 쏘기) 2가지(많으면) 이상이면 이런 방법으로 try,catch를 1번만 써서 처리할 수 있다.
}
