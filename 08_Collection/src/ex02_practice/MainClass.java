package ex02_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
	
	public static void ex01() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("서울");
		list.add("부산");
		list.add("인천");
		list.add("대구");
		list.add("울산");
		list.add("광주");
		
		list.remove("울산");
		//list.remove(0);
		
		list.set(0, "경기도");
		
		System.out.println(list);
	}

	public static void ex02() {
		
		List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
		
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(list.size()-1)); 
		
		int total = 0;
		for(int i = 0, length = list.size(); i < length; i++) {
			total += list.get(i);
		}
		System.out.println("총합은 : " + total);
		
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
