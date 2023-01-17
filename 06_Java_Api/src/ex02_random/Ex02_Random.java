package ex02_random;

import java.util.Random;

public class Ex02_Random {

	/*	원래 모든 클래스의 이름은 패키지 이름을 포함해서 적어야 한다.
		
		import
		1. 어떤 패키지에 속한 클래스인지 명시하는 코드입니다.
		2. java.util.Random 클래스의 경우 import java.util.Random; 방식으로 사용된다.
		3. import java.util.*; 방식으로 java.util 패키지의 모든 클래스를 import할 수 있다.
		4. import를 생략할 수 있는 경우 ( -> 이 두 가지가 아니면 무조건 import로 들어와야 한다.)
			1) java.lang 패키지의 경우(java의 가장 기본 패키지)
			2) 동일한 패키지의 클래스
		***** 5. import 방식 : 클래스를 입력할 때 "항상" 자동완성을 이용한다. *****
	*/
	/*
		java.util.Random : import해서 쓴다.
		1. 시드(seed)를 이용해서 난수를 생성한다.
		2. 기본적으로 현재 시간을 시드(seed)로 사용한다.
		3. 동일한 시드(seed)를 사용하면 동일한 난수가 발생한다.
	*/
	public static void ex01() {
		
		Random random = new Random();		// Math.random()을 더 자주 쓴다.
		
		// 실수 난수
		double RandNumber1 = random.nextDouble();	// 0.0 <= 난수 < 1.0
		System.out.println(RandNumber1);
		
		// 정수 난수
		int RandNumber2 = random.nextInt();	// int 범위 내의 난수 발생
		System.out.println(RandNumber2);
		
		int RandNumber3 = random.nextInt(10);	// 10개(0 ~ 9) 난수 발생
		System.out.println(RandNumber3);
		
	}
	
	public static void main(String[] args) {
		ex01();
	}

}
