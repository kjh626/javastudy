package ex02_random;

public class Ex01_Math_random {

	public static void ex01() {
		
		// java.lang.Math 클래스
		
		double randNumber = Math.random();	// 난수의 범위 0.0 <= 난수 < 1.0
		
		if(randNumber < 0.1) { // 10% 확률
			System.out.println("대박");
		} else {
			System.out.println("꽝");
		}
		
	}
	
	public static void main(String[] args) {
		ex01();
	
	}

}
