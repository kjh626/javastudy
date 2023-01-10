package ex01_field;

public class User {

	/*
		필드
		1. 클래스가 가지는 변수
	 	2. 일반 변수와 달리 자동으로 초기화가 된다.(배열이랑 똑같음)
	*/
	
	String id;    // null
	String pw;    // null  // String은 특별한 개체임. *** 클래스는 모두 다 new ~~();를 해줘야 함 ***
	int point;    // 0 
	boolean isVip;    // false
	Address addr;    // 초기값: null. Address타입의 addr -> NullPointerException오류 뜬다. null이라서. -> Address addr = new Address(); 해줘야 한다. 
	
	
	
}
