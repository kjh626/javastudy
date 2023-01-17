package practice_ex01_String;

public class Ex01_String {

	public static void equals() {
	
		String str1 = "hello";
		String str2 = new String("HELLO");
		
		if(str1.equals(str2)) {
			System.out.println("str1과 str2는 같은 문자열이다.");
		} else {
			System.out.println("str1과 str2는 다른 문자열이다.");
		}
		
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println("str1과 str2는 같은 문자열이다.");
		} else {
			System.out.println("str1과 str2는 다른 문자열이다.");
		}
	}
	
	public static void length() {
		String str = "Hello\nWorld";
		int length = str.length();
		System.out.println("글자수 : " + length);
	}
	
	public static void charAt() {
		
		String name = "김정현";
		
		for(int i = 0; i < name.length(); i++) {
			System.out.println(name.charAt(i));
		}
		
		//name.length() 메소드 호출 횟수를 줄이기 위한 리팩토링
		for(int i = 0, length = name.length(); i < length; i++) {
			System.out.println(name.charAt(i));
		}
	}
	
	public static void substring() {
		
		String name = "김정현";
		
		String familyName = name.substring(0, 1);
		String givenName = name.substring(1);
		
		System.out.println(familyName);
		System.out.println(givenName);
		
	}
	
	public static void indexOf() {
		
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
		
		String slogan = "걱정한다고 걱정이 없어지면 걱정이 없겠네";
		
		int idx1 = slogan.lastIndexOf("걱정");
		System.out.println(idx1);
		
		int idx2 = slogan.lastIndexOf("민경태");
		System.out.println(idx2);
	}
	
	public static void startsWith() {
		
		String name = "민경태";
		
		if(name.startsWith("민")) {
			System.out.println("민씨다.");
		} else {
			System.out.println("민씨가 아니다.");
		}
	}
	
	public static void contains() {
		
		String email = "wjd1113@naver.com";
		
		if(email.contains("@")) {
			System.out.println("이메일이 맞다.");
		} else {
			System.out.println("이메일이 아니다.");
		}
	}
	
	public static void toCase() {
		
		String str = "I am a boy";
		
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
	}
	
	public static void trim() {
		
		String str = "   hahaha   hohoho   ";

		System.out.println("(" + str + ")");
		System.out.println("(" + str.trim() + ")");
	}
	
	public static void replace() {
		
		String str = "best of the best";
		
		String result = str.replace("best", "worst");
		System.out.println(result);
		
		String ip = "61.78.121.242";
		String replacedIp = ip.replace(".", "_");
		System.out.println(replacedIp);
		
	}
	
	public static void isEmpty() {
		
		String str = " ";
		if(str.trim().isEmpty()) {
			System.out.println("빈 문자열이다.");
		} else {
			System.out.println("빈 문자열이 아니다.");
		}
	
		if(str.isBlank()) {
			System.out.println("빈 문자열이다.");
		} else {
			System.out.println("빈 문자열이 아니다.");
		}
		
	}
	
	public static void format() {
		
		int number = 1000;
		
		System.out.println(String.format("%o", number));
		System.out.println(String.format("%d", number));
		System.out.println(String.format("%x", number));
		System.out.println(String.format("%X", number));
		
		// 문자열 형식 지정하기
		String str = "hi";
		System.out.println(String.format("%s", str));
		
		// 출력 폭 지정하기
		System.out.println(String.format("%10d", number));
		System.out.println(String.format("%-10d", number));
		System.out.println(String.format("%5s", str));
		System.out.println(String.format("%-5s", str));
		
	}
	
	public static void ex01() {
		
		String url = "https://comic.naver.com/webtoon/detail?titleId=758037&no=112&weekday=mon";
		
		String requestURI = url.substring(0, url.indexOf("?"));
		System.out.println(requestURI);
		
		String params = url.substring(url.indexOf("?") + 1);
		System.out.println(params);
	}
	
	public static void ex02() {
		
		String fullName = "apple.jpg"; //"a.p.p.l.e.tar.gz"
		
		String fileName = "";
		String extName = "";
		if(fullName.endsWith(".tar.gz")) {
			fileName = fullName.substring(0, fullName.lastIndexOf(".tar.gz"));
			extName = ".tar.gz";
		} else {
			fileName = fullName.substring(0, fullName.lastIndexOf("."));	
			extName = fullName.substring(fullName.lastIndexOf("."));
		}
		
		System.out.println(fileName);
		System.out.println(extName);
		
		String fileName2 = fullName.substring(0, fullName.lastIndexOf(".")); // apple.jpg lastIndexOf를 써야함.
		System.out.println(fileName2);	// apple
		
		String extName2 = fullName.substring(fullName.lastIndexOf(".") + 1); // apple.jpg lastIndexOf를 써야함.
		System.out.println(extName2);
		
	}
	
	
	public static void main(String[] args) {
		ex02();
	}

}
