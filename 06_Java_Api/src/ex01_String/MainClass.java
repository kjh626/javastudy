package ex01_String;

public class MainClass {

	public static void literal() {
		
		// 문자열 리터럴(Literal)
		String str1 = "hello";
		String str2 = "hello";
		
		// 문자열 리터럴은 Java에 의해서 최적화되기 때문에
		// 동일한 리터럴("hello")을 2번 이상 사용하면
		// 기존에 사용한 리터럴을 재사용한다.("hello"라는 리터럴이 2개 이상 만들어 지지 않는다.)
		
		/*
	        |-------|
	   str1 | 0x123 |
	        |-------|
	   str2 | 0x123 |
	        |-------|
	   		|  ...  |
	        |-------|
	        |"hello"| 0x123 
	        |-------|
		*/
		// 참조값이 같다는 의미이다. 저장된 문자열이 같다는 의미가 아니다.
		System.out.println(str1 == str2);
	}
	
	public static void stringObject() {
		
		// 문자열 객체(Object)
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		// 문자열 객체는 언제나 새로 생성된다. => 메모리에 "hello"가 2개 들어감
		
		/*
	        |-------|
	   str1 | 0x123 |
	        |-------|
	   str2 | 0x456 |
	        |-------|
	   		|  ...  |
	        |-------|
	        |"hello"| 0x123 
	        |-------|
	   		|  ...  |
	        |-------|
	        |"hello"| 0x456
	        |-------|
		*/		
		// 참조값이 다르다는 의미이다. 저장된 문자열이 다르다는 의미가 아니다.
		System.out.println(str1 == str2);	// false . 다르다고 나온다.

		// => 문자열은 ==으로 비교하는 게 아니다.
	}
	
	public static void equals() {
		
		// equals 메소드 (문자열(String) 전용)
		// 비교하는 문자열이 동일하면 true, 아니면 false 를 반환
		
		String str1 = "hello";
		String str2 = new String("HELLO");

		// 대소문자도 일치해야 함.
		if(str1.equals(str2)) {
			System.out.println("str1과 str2는 같은 문자열이다.");
		} else {
			System.out.println("str1과 str2는 다른 문자열이다.");
		}
		
		// 대소문자는 무시함
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println("str1과 str2는 같은 문자열이다.");
		} else {
			System.out.println("str1과 str2는 다른 문자열이다.");
		}
		
	}
	
	public static void length() {
		
		// length 메소드
		// 문자열의 길이(글자수)를 반환
		
		String str = "Hello\nWorld";
		int length = str.length();		// 배열의 길이는 arr.length => ()가 없다. 필드라고 부름
		System.out.println("글자수 : " + length);	// \n 은 1글자로 보인다.
		
	}

	public static void charAt() {
		
		// charAt 메소드
		// 문자열의 특정 인덱스의 문자(char)를 반환
		
		String name = "김정현";
		
		for(int i = 0; i < name.length(); i++) {	// length() 는 메소드를 여러 번 호출. 성능이 떨어진다. -> 리팩토링 해야 할 코드이다.	// 리팩토링 : 코드수정.
			System.out.println(name.charAt(i));
		}
		
		/*
		name.length() 메소드 호출 횟수를 줄이기 위한 리팩토링
		for(int i = 0, length = name.length(); i < length; i++) {
			System.out.println(name.charAt(i));
		}
		 */
		
	}
	
	public static void substring() {
		
		// substring 메소드
		// 문자열의 일부 문자열을 반환
		
		// substring 사용법
		// 1. substring(int begin) : 인덱스 begin부터 끝까지 반환 (시작만 정해주면 거기서부터 끝까지)
		// 2. substring(int begin, int end) : 인덱스 begin부터 end "이전"까지 반환(begin <= 추출범위 < end). end는 포함하지 않는다.
		
		String name = "김정현";  // 인덱스 : 0,1,2
		
		String familyName = name.substring(0, 1);	// 0포함 1이전까지 = 한 글자
		String givenName = name.substring(1);
		
		System.out.println(familyName);
		System.out.println(givenName);
		
	}

	public static void indexOf() {
		
		// indexOf
		// 특정 문자열의 인덱스 정보를 반환(int 값)
		// 발견된 첫 번째 문자열의 인덱스 정보를 반환
		// 발견된 문자열이 없는 경우 -1을 반환
		
		// indexOf 사용법
		// 1. indexOf(String str) : 인덱스 0부터 str을 검색
		// 2. ifdexOf(String str, int index) : 지정한 index부터 str을 검색(from index)
		
		String slogan = "걱정한다고 걱정이 없어지면 걱정이 없겠네";
		
		int idx1 = slogan.indexOf("걱정");
		int idx2 = slogan.indexOf("걱정", idx1 + 1);
		int idx3 = slogan.indexOf("걱정", idx2 + 1);
		
		int idx4 = slogan.indexOf("민경태");
		
		System.out.println(idx1);
		System.out.println(idx2);
		System.out.println(idx3);
		System.out.println(idx4);
		
	}
	
	public static void lastIndexOf() {
		
		// lastIndexOf
		// 발견된 마지막 문자열의 인덱스를 반환
		// 나머지 특성은 indexOf와 동일
		
		String slogan = "걱정한다고 걱정이 없어지면 걱정이 없겠네";
		
		int idx1 = slogan.lastIndexOf("걱정");
		
		int idx2 = slogan.lastIndexOf("민경태");
		
		System.out.println(idx1);
		System.out.println(idx2);
		
	}
	
	public static void ex01() {
		
		String url = "https://comic.naver.com/webtoon/detail?titleId=758037&no=112&weekday=mon";
		
		String requestURI = url.substring(0, url.indexOf("?"));	// https://comic.naver.com/webtoon/detail 이 들어갈까?/ ?는 주소상 1개만 들어간다.
		System.out.println(requestURI);
		
		String params = url.substring(url.indexOf("?") + 1);	// ? 뒷 자리 구하기
		System.out.println(params);
	}
	
	public static void ex02() {
		
		String fullName = "apple.jpg";
		
		String fileName = fullName.substring(0, fullName.indexOf(".")); // apple
		System.out.println(fileName);
		
		String extName = fullName.substring(fullName.indexOf(".") + 1); // jpg
		System.out.println(extName);
		
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
