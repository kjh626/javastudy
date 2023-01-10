package ex05;

public class Ex05 {

	// 문제5. 1부터 100 사이의 모든 짝수와 홀수를 각각 더한 결과를 모두 출력하시오.
	// 예시
	// 짝수 합은 2550입니다.
	// 홀수 합은 2500입니다.
	
	public static void ex05() {
		
		int total1 = 0;
		int total2 = 0;
		int count = 100;
		
		for(int a = 1; a <= count; a++) {
			if(a % 2 == 0) {
				total1 += a;
				if(a == count) {
					System.out.println("짝수 합 : " + total1);
				}
			}
			else {
				total2 += a;
				if(a == count - 1) {
					System.out.println("홀수 합 : " + total2);
				}
			}
		}
		
		/*
		for(int a = 1; a <= count; a++) {
			if(a % 2 == 0) {
				total1 += a;
				if(a == count) {
					System.out.println("짝수 합 : " + total1);
				}
			}
		}
		
		for(int b = 1; b <= count; b++) {
			if(b % 2 == 1) {
				total2 += b;
				if(b == count - 1) {
					System.out.println("홀수 합 : " + total2);
				}
			}
		}
		*/
		
	}
	
	public static void main(String[] args) {
		ex05();
	}
}
