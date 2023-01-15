package ex01_one_dim;

public class Ex01_array {

	/*
		배열이란?
		1. 여러 개의 변수를 하나의 이름으로 관리 자료 구조
		2. 배열의 구성 요소
			1) 배열명 : 모든 변수의 대표 이름
			2) 인덱스 : 각 변수를 구분하기 위한 위치 정보. 0부터 시작하는 정수값.

	*/
	
	/*
		배열의 사용방법
		1. 배열의 선언
			1) int[] arr;   // 권장
			2) int arr[];
		2. 배열의 생성
			arr = new int[5];
	*/
	
	
	
	/*
 		배열요소
		1) 배열의 각 변수를 의미
		2) 배열명[인덱스]
		3) 배열이 생성되면 자동으로 초기화된다.
			0, 0, 0, false, null 값으로 초기화된다. (값이 없음을 의미)
			변수(int a;)는 garbage를 갖고 있다. 
	 */
	
	public static void ex01() {
		
		// 배열 선언
		int[] arr;
		
		// 배열 생성
		arr = new int[5];
		
		// 배열 요소 -> 자동으로 0으로 초기화된다.
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
	}
	
	public static void ex02() {
		
		// 배열 선언 + 생성 (한번에 처리)
		int[] arr = new int[5];
		
		// 배열 요소 순회(하나씩 접근하기), [i] 인덱스 (i = 0; i < 5)
		for(int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}
		// ex01, ex02 완벽히 동일한 코드. 우리가 쓸 것은 ex02이다
		
	}
	
	public static void ex03() {
		
		// 배열 길이
		int length = 5;
		
		// 배열 선언 + 생성
		int[] arr = new int[length];  // 길이가 length인 배열
		
		// 배열 순회 ( 배열의 인덱스(i)는 0으로 시작, 못 바꿈)
		for(int i = 0; i < length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void ex04() {    // 배열 가장 흔한 경우
		
		// 배열 선언 + 생성
		int[] arr = new int[5];
		
		// 배열 순회(base)
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

	public static void ex05() {    // 연습
		
		// 점수를 배열로 관리하기
		int[] scores = new int[5];
		
		// 각 점수를 배열에 저장
		scores[0] = 100;
		scores[1] = 70;
		scores[2] = 50;
		scores[3] = 65;
		scores[4] = 13;
		
		// 합계(평균), 최댓값/최솟값
		int total = 0; // Zero의미
		int max = 0; // 0인 것은 Zero를 의미하는 것이 아니고 가장 작은 값을 초기화로 갖는 것
		int min = 100; //  가장 큰 값 초기화. 0으로 잡아놓으면 알고리즘이 잘못된 것. => 가지고 있는 정수 범위에서 가장 큰 값을 잡아놔야 한다.
		// 0 ~ 100 인지 모를 경우 어떻게 ? -> ex06
		
		for(int i = 0; i < scores.length; i++) {
			total += scores[i];
			if(max < scores[i]) { // 최댓값 찾기. 처음 시작 0, 0보다 큰 점수 찾기 scores[0] = 100; 0에서 max=100으로 갱신. -> 70점 불러와도 100이 더 큼. max값 100 유지.
				max = scores[i];
			}
			if(min > scores[i]) { // 최솟값 찾기.
				min = scores[i];
			}
		}
		System.out.println("합계 : " + total + "점");
		System.out.println("평균 : " + total / (double) scores.length + "점"); // 298 / 5.0 -> 298.0 / 5.0 = 59.6
		System.out.println("최대 : " + max + "점");
		System.out.println("최소 : " + min + "점");
	}
	
	public static void ex06() {    // 연습(추천하는 알고리즘: 첫번째 요소를 초기화로 저장)
		
		// 점수를 배열로 관리하기
		int[] scores = new int[5];
		
		// 각 점수를 배열에 저장
		scores[0] = 100;
		scores[1] = 70;
		scores[2] = 50;
		scores[3] = 65;
		scores[4] = 13;
		
		// 배열의 첫 번째 요소를 초기화로 저장하고,
		// 배열의 두 번째 요소부터 순회한다.
		
		// 합계(평균), 최댓값/최솟값
		int total = scores[0]; // 초기화 값 첫 번째 요소로 저장
		int max = scores[0]; // 초기화 값 첫 번째 요소로 저장
		int min = scores[0]; // 초기화 값 첫 번째 요소로 저장
		
		for(int i = 1; i < scores.length; i++) { // i = 0을 1로 바꿔줌. 그러면 첫 번째 요소 2번 접근하지 않게 된다.
			total += scores[i]; // 첫 번째 요소의 값을 2번 더하게 됨 ( [0]100 + [0]100 ) : 2번 접근
			if(max < scores[i]) { 
				max = scores[i];
			}
			if(min > scores[i]) { 
				min = scores[i];
			}
		}
		System.out.println("합계 : " + total + "점");
		System.out.println("평균 : " + total / (double) scores.length + "점");
		System.out.println("최대 : " + max + "점");
		System.out.println("최소 : " + min + "점");
	}
	
	public static void ex07() {
		
		// 배열 초기화(자동으로 0, 원하는 값으로 초기화해도 된다)
		int[] arr = {10, 20, 30};
		
		// 배열 순회
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void ex08() {    // 2장 switch의 ex02를 다시 만들어 본다. 0~6을 인덱스로 쓴다.
		
		String[] weekName = {"토", "일", "월", "화", "수", "목", "금"};
		
		int day = 13;
		
		//System.out.println(day + "일은 " + ?? + "요일이다.");
		System.out.println(day + "일은 " + weekName[day % weekName.length] + "요일이다."); // day % 7 => day % weekName.length
	}

	public static void ex09() {    // 연습 2장 else_if의 ex03을 다시 만들어 본다.(똑같진 않음) 
		
		// month % 12 / 3를 쓸거다.
		// 겨울은 나머지 값이 0,1,2 -> 3으로 나눠보면 몫이 0, 봄은 나머지값이 3,4,5 -> 3으로 나눠보면 몫이 1, ... 
		
		String[] season = {"겨울", "봄", "여름", "가을"};
		
		int month = 10;
		
		System.out.println(month + "월은 " + season[month % 12 / 3] + "이다.");
	}
	
	public static void main(String[] args) {
		ex08();
	}

}
