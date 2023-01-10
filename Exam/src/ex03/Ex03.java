package ex03;

public class Ex03 {
	
	// 문제3. 구구단을 모두 출력하지 말고 5 x 5 = 25까지만 출력하시오.
	// 예시
	// 2 x 1 = 2
	// 2 x 2 = 4
	// ...
	// 5 x 5 = 25
	
	public static void ex03() {
		
		for(int dan = 2; dan <= 9; dan++) {
			for(int n = 1; n <=9; n++) {
				System.out.println(dan + " x " + n + " = " + (dan * n));
				if(dan == 5 && n == 5) {
					System.out.println(dan + " x " + n + " = " + (dan * n));
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ex03();
	}
}
