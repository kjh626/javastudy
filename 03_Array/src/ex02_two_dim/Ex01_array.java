package ex02_two_dim;

public class Ex01_array {

	// 2차원 배열은 가볍게
	
	public static void ex01() {
		
		// 2차원 배열 선언
		int[][] arr;
		
		// 2차원 배열 생성
		arr = new int[3][2];	// 3행 2열(길이가 2인 배열 3개가 있다.)
		
		// 2차원 배열 순회 (2가지 방식이 있다 but)															[0][0] [0][1]	0행 0열, 0행 1열
		// row major , column major (행 우선이다, 열 우선이다). java에서는 row major 방식을 사용			[1][0] [1][1]	2행 0열, 2행 1열
		// 위부터 가로로 →한 줄 →두 줄 →세 줄 , column major는 세로로 ↓한 줄, ↓두 줄					[2][0] [2][1]	-> [i],[j]
		
		for(int i = 0; i < 3; i++) {	// i : 행 번호
			for(int j = 0; j < 2; j++) {	// j : 열 번호
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();    // 안 쪽 for문이 끝나면 줄 바꿈 해주겠다.
		}
		
		
	}
	
	public static void ex02() {
		
		// 2차원 배열 선언 + 생성
		int[][] arr = new int[3][2];
		
		// 길이 확인
		System.out.println(arr.length);    // 3행이다.(1차원 배열이 3개 있다.)
		System.out.println(arr[0].length);    // 첫 번째 1차원 배열(의 이름) 길이. 참조값
		System.out.println(arr[1].length);    // 두 번째 1차원 배열(의 이름) 길이
		System.out.println(arr[2].length);    // 세 번째 1차원 배열(의 이름) 길이
	
		// 2차원 배열 순회 => 이렇게 쓰는 게 깔끔하다.
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void ex03() {
		
		// 2차원 배열 선언
		int[][] arr;
		
		// 2차원 배열 생성. 배열 길이 서로 다르려면 선언과 생성 따로 해야함
		arr = new int[3][];
		
		// 각 행이 가질 열을 생성하기(각 1차원 배열의 생성)
		arr[0] = new int[5];	// 첫 번째 1차원 배열의 길이는 5개
		arr[1] = new int[3];
		arr[2] = new int[2];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	public static void ex04() {
		
		// 2차원 배열 초기화
		
		int[][] arr = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		ex04();
	}

}
