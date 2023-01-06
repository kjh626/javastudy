package ex05_op_condition;

public class MainClass {

	public static void ex01() {
		
		int a = 3;
		int b = 4;
		
		boolean result1 = a > b;
		boolean result2 = a >= b;
		boolean result3 = a < b;
		boolean result4 = a <= b;
		boolean result5 = a == b; // == : 같다
		boolean result6 = a != b; // != : 같지 않다
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
		
	}
	
	public static void ex02() {
		
		// 논리 연산
		// 1. 논리 AND : &&, 모든 조건이 true이면 true, 아니면 false
		// 2. 논리 OR  : ||, 하나의 조건이라도 true이면 true, 아니면 false
		// 3. 논리 NOT : ! , 조건이 true이면 false, 조건이 false이면 true

		int a = 10;
		int b = 10;
		
		boolean result1 = (a == b) && (b == 10); // 둘 다 true
		boolean result2 = (a == 10) && (b == 20);
		
		System.out.println(result1);
		System.out.println(result2);
		
		boolean result3 = (a == 10) || (b == 10);
		boolean result4 = (a == 10) || (b == 20);
		
		System.out.println(result3);
		System.out.println(result4);
		
		boolean result5 = !(a == 10);
		boolean result6 = !(a == 20);
		System.out.println(result5);
		System.out.println(result6);
		
	}
	
	public static void ex03() {
		
		// Short Circuit Evaluation
		// 1. 논리 AND의 경우 조건의 결과가 false인 경우가 발생하면 더 이상 동작하지 않는다. 최종 결과가 false로 정해졌기 때문이다. (순차적으로 진행하면서)
		// 2. 논리 OR의 경우 조건의 결과가 true인 경우가 발생하면 더 이상 동작하지 않는다. 최종 결과가 true로 정해졌기 때문이다.
		
		int a = 10;
		int b = 10;
		
		boolean result1 = (a == 20) && (++b == 11);
		
		System.out.println(b); // 10인 이유 : 처음부터 false가 나와서 더 이상 동작하지 않는다. 
		System.out.println(result1);
		
		boolean result2 = (a == 10) || (++b == 11);
		
		System.out.println(b); // 여전히 10이다. true가 나왔기 때문에
		System.out.println(result2);
		
	}
	
	public static void ex04() { // 연습
		
		int score = 85;
		
		boolean result1 = (score >= 70) && (score < 80); // 70점대는 true 아니면 false
		
		System.out.println(result1);
		
		boolean result2 = (score / 10) == 7; // 몫을 구해서하는 방법도 있다.
		
		System.out.println(result2);
		
	}

	public static void ex05() {
		
		// 조건 연산
		// (조건식) ? (true 일 때 처리) : (false 일 때 처리) <- 삼항 연산자
		
		int score = 50; // 간단하게 합격 불합격 나타내기
		
		String result = (score >= 60) ? "합격" : "불합격";
		
		System.out.println(result);
		
	}
	
	public static void ex06() { // 연습
		
		int n = 4;
		
		String result = (n % 2 == 1) ? "홀수" : "짝수" ; // 짝수, 홀수
		
		System.out.println(result);
		
	}
	
	public static void ex07() { // 연습
		
		int n = 0;
		
		String result = (n != 0 && n % 3 == 0) ? "3의 배수" : (n % 2 == 0) ? "짝수" : "홀수"; // 짝수, 홀수, 3의 배수
		
		System.out.println(result); // 0을 3의 배수라고 착각하는 취약점이 있다. n != 0 을 넣어주면 됨
	}
	
	
	
	public static void main(String[] args) {
		ex07();
		
		
	}

}
