package ex04_op_number;

public class MainClass {

	// ex01 메소드 정의
	public static void ex01() {
		
		int a = 5;
		int b = 2;
		
		int add = a + b;
		int sub = a - b;
		int mul = a * b;
		int div = a / b; // 몫을 계산
		int mod = a % b; // 나머지 구하는 값 연산자로 % 씀
		
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(div);
		System.out.println(mod);
		
	}
	
	// ex02 메소드 정의(연습)
	public static void ex02() {
		
		int a = 5;
		int b = 2;
		
		double div = (double) a / b;
		
		System.out.println(div); // 2.5
		
	}
	
	// ex03 메소드 정의(연습)
	public static void ex03() {
		
		int second = 90;
		
		int min = second / 60; // 1
		int sec = second % 60; // 30
		
		System.out.println(min);
		System.out.println(sec);
	
	}
	
	// ex04 메소드 정의
	public static void ex04() {
		
		// 1 증가 : ++
		// 1 감소 : --
		
		// 전위 연산(pre operator)
		// ++a 또는 --a
		// 변수 a의 값을 1 증가(감소)시킨 뒤에 사용하시오.
		
		int a = 10;
		System.out.println(++a);
		
		// 후위 연산(post operator)
		// b++ 또는 b--
		// 변수 b의 값을 사용한 뒤에 1을 증가(감소)시키시오.
		
		int b = 10;
		System.out.println(b++);
		System.out.println(b);
		
	}

	// ex05 메소드 정의
	public static void ex05() {
		
		// 대입 연산
		// 등호(=)의 오른쪽 값을 왼쪽으로 보내는 연산
		
		int a;
		a = 10;
		System.out.println(a);
		
	}
	
	// ex06 메소드 정의
	public static void ex06() {
		
		int x = 10;
		int y = 20;
		
		// x 와 y 의 값을 교환 (백업을 먼저 해둔 다음에 덮어쓰기)
		int temp;
		temp = x;
		x = y;
		y = temp;
		// t = a ,a = b, b = t; 한줄로 요약
		System.out.println(x);  // 20
		System.out.println(y);  // 10
		
	}
	
	// ex07 메소드 정의
	public static void ex07() {
		
		// 복합 대입 연산자
		
		int account = 10000;
		
		account += 5000; // account = account + 5000; 두 식은 같은 식이라고 이해하면 됨.
		System.out.println(account);
		
		account -= 50000; // account = account - 50000;
		System.out.println(account);
		
	}
	
	// ex08 메소드 정의(연습)
	public static void ex08() {
		
		long account = 123456;
		
		// 5% 이자 받으면 얼마?
		// account = account + (account * 0.05); long + double 은 안 된다. 강제로 캐스팅이 필요.
		double result;
		result = account * 1.05;  //result = account + account * 0.05;
		
		System.out.println(result);
		
	}
	
	
	public static void main(String[] args) {
		ex08();  // ex08 메소드를 호출
	}

}
