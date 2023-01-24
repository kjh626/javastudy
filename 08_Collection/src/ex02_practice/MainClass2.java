package ex02_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ex02_List.User;

public class MainClass2 {

	public static void ex01() {
		
		List<String> list = new ArrayList<String>();
		
		
		// 추가
		list.add("summer");
		list.add("autumn");
		list.add("frog");
		list.add("winter");
		list.add(0, "spring");
		
		// 삭제
		// list.remove("frog");
		list.remove(3);
		
		// 수정
		list.set(2, "fall");
		
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(0));
		
	}
	
	public static void ex02() {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		System.out.println("리스트 길이" + list.size());
		
		System.out.println("첫 번째 요소 " + list.get(0));
		System.out.println("마지막 요소 " + list.get(list.size() -1));
		
		int total = 0;
		for(int i = 0, length = list.size(); i < length; i++) {
			total += list.get(i);
		}
		System.out.println("모든 요소의 합 " + total);
		
	}
	
	public static void ex03() {
		
		List<User2> userList = new ArrayList<User2>();
		
		for(int i = 0; i < 3; i++) {
			User2 user = new User2("user", "123456");
			userList.add(user);
		}
		
		for(int i = 0, length = userList.size(); i < length; i++) {
			System.out.println(userList.get(i).getId());
			System.out.println(userList);
		}
		
	}
	
	public static void main(String[] args) {
		ex03();
	}

}
