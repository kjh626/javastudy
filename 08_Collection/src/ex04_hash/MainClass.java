package ex04_hash;

import java.util.HashSet;
import java.util.Set;

public class MainClass {
	
	public static void main(String[] args) {

		User user1 = new User("admin", "123456");
		User user2 = new User("admin", "123456");
		
		Set<User> set = new HashSet<User>();
		set.add(user1);
		set.add(user2);
		// 객체 비교할 때 이콜스가 없으면 참조값만 비교하기 때문에...
		// Set 내에서 비교를 못했기 때문에 중복 저장됨 -> 객체 비교할 때(이콜스가 필요하다) 객체 안에 해시코드, 이콜스 만들어줘야 한다.
		System.out.println(set);
		
	}

}
