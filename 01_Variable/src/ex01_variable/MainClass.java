package ex01_variable;

public class MainClass {

	// single comment - 한 줄 주석(설명)
	/*
		multiple comment
		여러 줄 주석		
	*/
	
	/*
		키워드 이름 규칙
		1. 프로젝트 : 마음대로.
		2. 패키지 : 모두 소문자로 작성. 실무에서는 회사 도메인과 앱 이름으로 작성(com.samsung.galaxy)
		3. 클래스 : 첫 글자만 대문자로 작성하고 나머지는 소문자. Upper Camel Case 방식(HelloWorld).
		4. 메소드 : 첫 글자만 대문자로 작성하고 나머지는 소문자. Lower Camel Case 방식(helloWorld). 차이점 : 맨 첫 글자만 소문자
		5. 변수   : 첫 글자만 대문자로 작성하고 나머지는 소문자. Lower Camel Case 방식(helloWorld).
		6. 상수   : 모두 대문자로 작성. 단어 사이에 밑줄을 껴주는 방식으로 작성.(HELLO_WORLD , Snake Case 방식)
	 */
	
	/*
		main 메소드
		1. Java가 실행될 때 main 메소드가 실행된다.
		2. 열려있는 main 메소드가 없으면 최근에 실행에 성공한 main 메소드를 실행한다.
	 */
	
	public static void main(String[] args) {
		
		// 코드는 들여쓰기가 잘 되어 있어야 한다. (탭 키(스페이스 4개 짜리) 사용)
		
		// 변수 선언하기(1. 어떤 데이터를 저장할 것인가? 2. 어떤 이름을 사용할 것인가?)
		
		// 타입의 구분
		// 1. primitive type : 기본 타입(소문자로 되어 있음.), 값을 저장하는 타입.
		// 2. reference type : 참조 타입(첫 글자가 대문자로 되어 있음, 모든 클래스는 참조 타입), 값이 저장된 참조값을 저장하는 타입.
		
		
		// 논리 타입(참과 거짓을 저장)
		boolean isGood = true;
		boolean isAlive = false;
		System.out.println(isGood);
		System.out.println(isAlive);	
		
		// 문자 타입(Character) : 1글자('' 작음따옴표 활용)
		char ch1 = 'A';
		char ch2 = '홍';
		char ch3 = '\n';  // 라인 피드 - 줄 바꿈(역슬래시 n)
		char ch4 = '\t';  // 탭
		char ch5 = '\'';  // 작은따옴표를 쓰려면 \ + ' 이스케이프 처리 필요
		char ch6 = '\"';  // 큰 따옴표
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);
		System.out.println(ch6);
		
		// 정수 타입
		int age = 46;
		long money = 10000000000L; //100억
		System.out.println(age);
		System.out.println(money);
		
		// 정수 구분의 기준
		System.out.println(Integer.MAX_VALUE); // int = Integer
		
		// 실수 타입
		double leftEye = 0.7;
		double rightEye = 1.2;
		System.out.println(leftEye);
		System.out.println(rightEye);
		
		// 문자열 타입(여러 글자를 의미, 글자 수의 제한이 없음. 참조 타입)
		String name = "민경태"; // Java에서 기본 타입과 같은 사용법을 제공
		System.out.println(name);
		String country = new String("Korea"); // 대부분의 참조 타입 사용법
		System.out.println(country);
		
		// 상수 선언하기(final 키워드가 필요) -> final, 변수 이름 대문자로
		final double PI = 3.141592;
		System.out.println(PI);
		
		
		
		
		
		

	}

}
