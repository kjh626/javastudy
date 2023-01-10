package ex01_one_dim;

public class Ex02_reference {

	public static void ex01() {

		
		int[] arr;  // 위치 정보(reference = address)
		
		arr = new int[5];
		
		System.out.println(arr);    // 5개 배열 요소의 참조(주소, 번지) 값 / @ 뒷부분이 참조값. => 어떤 의미를 가지고 있는지만 알고 있어라.
	
	}
	
	public static void ex02() {  // 일반 변수와 참조는 다르다. 참조는 아래처럼 똑같이 만들어 줄 수 있다.
		
		int[] a = new int[5]; // 메모리에 a라는 번지(0x10번지)가 생김. 거기에 배열(변수 5개) 저장. 첫 번째 주소를 대표로 쓰겠다. ([0]는 0x10번지, [1]은 0x14번지, [2]는 0x18번지, ...) int는 4바이트. 
		int[] b; // 메모리에 b가 생김. 배열은 참조를 저장(값을 저장X). 
		
		b = a; // b가 길이가 5인 배열이 됨. b에 (a (0x10번지))가 들어감. a도 배열, b도 배열. 둘다 0x10번지. a 와 b는 완전히 똑같다.
		
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		// b[0] = 100;
		// System.out.println(a[0]); // 100이 나온다.
		
		/*
	        |-------|
	      a | 0x123 |─────┐
	        |-------|          │
	        |  ...  |          │
	        |-------|          │
	   a[0] |   0   | 0x123    │
	        |-------|          │
	   a[1] |   0   |          │
	        |-------|          │
	   a[2] |   0   |          │ b = a;
	        |-------|          │
	   a[3] |   0   |          │
	        |-------|          │
	   a[4] |   0   |          │
	        |-------|          │
	        |  ...  |          │
	        |-------|          │
	      b | 0x123 |◀────┘
	        |-------|
		*/
	}
	
	public static void ex03() {    // 심화 (부담없이 들어라)
		
		// 생성된 배열의 크기를 늘이는 방법. (배열의 길이를 늘리는 것은 불가능) but 아래 방법으로 가능
		
		// 기존 배열
		int[] a = new int[5];			// a는 0x10번지에 5가지 요소가 있다 [1,2,3,4,5]
		
		// 신규 배열
		int[] b = new int[10];			// b는 0x20(가정)번지에 10가지 요소가 있다. [0,0,0,0,0,0,0,0,0,0]
		
		// 기존 배열 요소 -> 신규 배열 요소
		for(int i = 0; i < a.length; i++) {
			b[i] = a[i];    // a 배열의 5개의 요소가 b 배열로 넘어감.		// [1,2,3,4,5,0,0,0,0,0]
		}
		
		// 기존 배열의 참조값을 신규 배열의 참조값으로 수정
		a = b;		// a를 0x20번지로!
		
		// 기존 배열이 신규 배열로 변경되었으므로 확인
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]); // 10개로 늘어나있다.
		}
		// <몰라도 되는 이론 공부>
		// => 0x10번지에 [1,2,3,4,5]는 덮어쓰기 돼서 사라짐.(garbage) -> 메모리의 garbage가 됨. 아무도 쓰지 않는 데이터(garbage는 Java가 garbage collector를 통해 처리함)
		// System.gc(); => Garbage Collector 호출 코드. 하지만 넣을 필요 없다. Java가 스스로 한다.
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
