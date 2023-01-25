package ex06_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainClass {

	public static void ex01() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("동태전");
		list.add("동그랑땡");
		list.add("배추전");
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			String food = itr.next();
			System.out.println(food);
		}
		
	}
	
	public static void ex02() {
		
		Set<Integer> set = new HashSet<Integer>();
		
		set.add(10);
		set.add(12);
		set.add(13);
		
		Iterator<Integer> itr = set.iterator();
		
		while(itr.hasNext()) {
			Integer number = itr.next();
			System.out.println(number);
		}
		
	}
	
	public static void ex03() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "김정현");
		map.put("age", 31);
		map.put("isAlive", true);
		
		Set<String> keySet = map.keySet();
		
		Iterator<String> itr = keySet.iterator();
		
		while(itr.hasNext()) {
			String key = itr.next();
			Object value = map.get(key);
			System.out.println(key + ":" + value);
		}
		
	}
	
	
	public static void main(String[] args) {
		ex03();
	}

}
