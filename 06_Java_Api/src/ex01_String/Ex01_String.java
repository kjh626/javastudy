package ex01_String;

public class Ex01_String {

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
	
	public static void startsWith() {
		
		// startsWith
		// 문자열이 지정된 정규식 패턴(Regular Expression)으로 시작하면 true 반환
		
		// endsWith
		// 문자열이 지정된 정규식 패턴(Regular Expression)으로 끝나면 true 반환

		// matches
		// 문자열이 지정된 정규식 패턴(Regular Expression)을 포함하면 true 반환
		
		String name = "민경태";
		
		if(name.startsWith("민")) {
			System.out.println("민씨다.");
		} else {
			System.out.println("민씨가 아니다.");
		}
		
		
	}
	
	public static void contains() {
		
		// contains
		// 문자열이 지정된 CharSequence(String, char[] 등)를 포함하면 true 반환
		
		// 참고
		// public interface CharSequence { }		// CharSequence라고 써있으면 String이라고 생각하면 OK.
		// public class String  implements CharSequence { } 
		
		String email = "wjd1113@naver.com";
		
		if(email.contains("@")) {
			System.out.println("이메일이 맞다.");
		} else {
			System.out.println("이메일이 아니다.");
		}
		
	}
	
	public static void toCase() {
		
		// toUpperCase 
		// 대문자로 변환
		
		// toLowerCase
		// 소문자로 변환
		
		String str = "I am a boy";
		
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
	} 
	
	public static void trim() {
		
		// trim
		// 문자열의 앞뒤에 포함된 공백 문자(스페이스, 탭, 엔터 등)를 제거
		// 주로 파일 이름 읽을 때 쓸 수 있음.
		
		String str = "   hahaha   hohoho   ";
		
		System.out.println("(" + str + ")");
		System.out.println("(" + str.trim() + ")");	// 중간 거는 안 건드림.
		
	}
	
	public static void replace() {
		
		// replace
		// 기존 문자열을 새로운 문자열로 변환한 결과를 반환
		
		// replace 사용법
		// replace(String str1, String str2)
		// 모든 str1을 str2로 변환
		
		String str = "best of the best";
		String result = str.replace("best", "worst");
		System.out.println(result);
		
		// replaceAll => 잘 모르니까 쓰지마라. replace 써라
		// 정규식 패턴(Regular Expression)을 만족하는 부분을 변환한 결과를 반환
		// 정규식 패턴의 예) [0-9] [a-z] [0-9a-z] [0-9a-z]{4,20}
		
		String ip = "61.78.121.242";
		String replacedIp = ip.replaceAll(".", "_") ; // 61_78_121_242 -> 마침표 대신 밑줄이면 좋겠다. /// 정규식에서 마침표는 모든 글자를 의미.
		System.out.println(replacedIp);				// replaceAll을 썼을 때 61_78_121_242로 안 나오고 다른 정답이 나옴
		
	}
	
	public static void isEmpty() {
		
		// isEmpty
		// 빈 문자열이면 true 반환
		// 빈 문자열("") : 문자열의 길이가 0이면 빈 문자열이다.
		
		String str = " ";
		if(str.trim().isEmpty()) {
			System.out.println("빈 문자열이다.");
		} else {
			System.out.println("빈 문자열이 아니다.");		// " " 띄어쓰기 하나 들어간 것도 빈 문자열 아니다. -> trim()을 쓰면 빈 문자열로 만들 수 있다.
		}
		
		// isBlank
		// 빈 문자열이거나 공백 문자로만 구성되었다면 true 반환
		// JDK 11 이후에서만 사용 가능
		if(str.isBlank()) {
			System.out.println("빈 문자열이다.");
		} else {
			System.out.println("빈 문자열이 아니다.");		
		}
		
	}
	
	public static void format() {
		
		// format => 읽어보기만 해라
		// 문자열을 지정한 형식으로 반환
		
		// 숫자 형식 지정하기(전산에서 공부해야 할 숫자:2,8,10,16진수)
		int number = 1000;
		
		System.out.println(String.format("%o", number));	// %o : 8진수으로 표시하시오.
		System.out.println(String.format("%d", number));	// %d : 10진수로 표시하시오.
		System.out.println(String.format("%x", number));	// %x : 16진수로 표시하시오.(0~9, a, b, c, d, e, f)	그나마 16진수 쓸 수 있다.
		System.out.println(String.format("%X", number));	// %X : 16진수로 표시하시오.(0~9, A, B, C, D, E, F) 
		
		// 문자열 형식 지정하기
		String str = "hi";
		System.out.println(String.format("%s", str));	// %s : 문자열로 표시하시오.
		
		// 출력 폭 지정하기
		System.out.println(String.format("%10d", number));	// %10d  : 10자리로 표시하시오. 숫자는 오른쪽에 표시하시오. 앞에 6자리 있음.
		System.out.println(String.format("%-10d", number));	// %-10d : 10자리로 표시하시오. 숫자는 왼쪽에 표시하시오. 뒤에 6자리 있음.
		System.out.println(String.format("%5s", str));		// %5s  : 5자리로 표시하시오. 문자열은 오른쪽에 표시하시오. 
		System.out.println(String.format("%-5s", str));		// %-5s : 5자리로 표시하시오. 문자열은 왼쪽에 표시하시오. 
		
	
	}
	
	public static void ex01() {
		
		String url = "https://comic.naver.com/webtoon/detail?titleId=758037&no=112&weekday=mon";
		
		String requestURI = url.substring(0, url.indexOf("?"));	// https://comic.naver.com/webtoon/detail 이 들어갈까?/ ?는 주소상 1개만 들어간다.
		System.out.println(requestURI);
		
		String params = url.substring(url.indexOf("?") + 1);	// ? 뒷 자리 구하기
		System.out.println(params);
	}
	
	public static void ex02() {

		
		String fullName = "a.p.p.l.e.tar.gz";	// a.p.p.l.e.jpg 도 가능하기에..
		
		String fileName = "";
		String extName = "";
		if(fullName.endsWith(".tar.gz")) {
			fileName = fullName.substring(0, fullName.lastIndexOf(".tar.gz"));
			extName = ".tar.gz";
		} else {
			fileName = fullName.substring(0, fullName.lastIndexOf("."));	// apple
			extName = fullName.substring(fullName.lastIndexOf("."));		// .jpg 		이름을 바꾸는...
		}
		
		System.out.println(fileName);
		System.out.println(extName);
		
		String fileName2 = fullName.substring(0, fullName.lastIndexOf(".")); // apple.jpg lastIndexOf를 써야함.
		System.out.println(fileName2);	// apple
		
		String extName2 = fullName.substring(fullName.lastIndexOf(".") + 1); // apple.jpg lastIndexOf를 써야함.
		System.out.println(extName2);	// jpg

		
		
	}
	
	
	public static void main(String[] args) {
		replace();
	}

}
