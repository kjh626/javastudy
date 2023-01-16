package re_exam;

import java.util.Arrays;

public class MainClass {

	// 문제1. 절대값 구하기
	public static void ex01() {
		int number = -5;
		/*
		int absNumber; 
		if(number >= 0) {
			absNumber = number;
		} else {
			absNumber = -number;	// absNumber = number * -1;  둘 다 맞다.
		}
		*/
		// if 1줄로 바꾸기
		int absNumber = (number >= 0) ? number : -number;	// 삼항연산자
		System.out.println(absNumber);
		
	}
	
	// 문제2. 나이에 따른 구분하기
	// 0 ~ 7	: 미취학아동
	// 8 ~ 13	: 초등학생
	// 14 ~ 16	: 중학생
	// 17 ~ 19	: 고등학생
	// 20 ~ 100	: 성인
	// 나머지 	: 잘못된 나이
	public static void ex02() {
		String strAge = "30";
		int age = Integer.parseInt(strAge);
		if(age < 0 || age > 100) {	// && || 구분 잘 하기
			System.out.println("잘못된 나이");
		} else if(age <= 7) {
			System.out.println("미취학아동");
		} else if(age <= 13) {
			System.out.println("초등학생");
		} else if(age <= 16) {
			System.out.println("중학생");
		} else if(age <= 19) {
			System.out.println("고등학생");
		} else {
			System.out.println("성인");
		}
		// switch문 쓰는 곳은 주로 단순 문자열들 (case "board/list.do") 웹페이지 주소 잘라내서
	}
	
	// 문제3. 삼각형 넓이 구하기
	public static void ex03() {
		// casting에 관한 문제
		int width = 3;
		int height = 3;
		/*
		double area = width * height / 2;
		double area = (double) width * height / 2;
		double area = width * (double) height / 2;
		double area = (double) width * (double) height / 2;
		double area = width * height / 2.0;
		*/
		double area = width * height * 0.5;
		System.out.println("삼각형 넓이 : " + area);
		
	}
	
	// 문제4. 월 -> 계절과 마지막 일 출력하기
	// 1월 -> 겨울,31일 / 2월 -> 겨울,28일 / 3월 -> 봄,31일 / 4월 -> 봄,30일
	public static void ex04() {
		/*
			month % 12 / 3 
			겨울 : 0
			봄	 : 1
			여름 : 2
			가을 : 3 
		*/
		int month = 1;
		String[] season = {"겨울", "봄", "여름", "가을"};
		int[] lastDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};		// 0은 dummy node : 아무것도 안 함. 그냥 넣은 거임
		if(month < 0 || month > 12) {
			System.out.println(month + "월은 잘못된 입력입니다.");
			return;
		}
		System.out.println(month + "월은 " + season[month % 12 / 3] + "입니다.");
		System.out.println(month + "월은 " + lastDay[month] + "일까지 있습니다.");
	}
	
	// 문제5. 10과 가까운 수 찾기
	public static void ex05() {
		int a = 8;
		int b = 11;
		// 큰 수에서 작은 수를 빼는 방식
		int diff1 = (a > 10) ? a - 10 : 10 - a ;	// 2
		int diff2 = (b > 10) ? b - 10 : 10 - b ; 	// 1
		
		System.out.println("10과 가까운 수는 " + (diff1 < diff2 ? a : b) + "입니다.");
	}
	
	// 문제6. money 분리하기
	public static void ex06() {
		// 배열 활용
		int money = 87654;
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1}; 
		int[] count = new int[unit.length];
		/*
		count[0] = money / unit[0];  => 1
		money = money % unit[0];  => 37654
		
		count[1] = money / unit[1]; => 3
		money = money % unit[1]; => 7654
		*/
		
		for(int i = 0; i < unit.length; i++) {
			count[i] = money / unit[i]; 
			money %= unit[i];
			System.out.println(unit[i] + "원권 : " + count[i] + "개");
		}
		
		// 다른 출력하는 방법 (Arrays라는 클래스: 배열의 출력을 도와줌)
		System.out.println(Arrays.toString(unit));
		System.out.println(Arrays.toString(count));
		
	}
	
	// 문제7. 2차원 배열에 구구단 결과 저장하기
	/*
	  2  4  6  8 10 12 14 16 18
	  3  6  9 12 15 18 21 24 27
	  4  8 12 16 20 24 28 32 36
	  5 10 15 20 25 30 35 40 45
	  6 12 18 24 30 36 42 48 54
	  7 14 21 28 35 42 49 56 63
	  8 16 24 32 40 48 56 64 72
	  9 18 27 36 45 54 63 72 81
	*/
	public static void ex07() {
		
		int[][] arr = new int[8][9];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (i + 2) * (j + 1);
				System.out.print(  String.format("%3d", arr[i][j]));
			}
			System.out.println();
		}
		
		System.out.println("-----");
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(  Arrays.toString(arr[i]));
		}
		
		System.out.println("-----");

		// 향상 for문( 2차원 배열 )
		for(int[] a : arr) {
			System.out.println(  Arrays.toString(a));
		}
		
		// 이런 거 연습하려면 테트리스 T 자 90도 돌리는 것 배열에서 규칙을 찾아보자.
		/*	1 1 1 1 1 	0 0 0 0 1
			0 0 1 0 0 	0 0 0 0 1
			0 0 1 0 0	1 1 1 1 1
			0 0 1 0 0	0 0 0 0 1 
			0 0 1 0 0	0 0 0 0 1
		 */
	}
	
	
	public static void main(String[] args) {
		ex07();
	}

}
