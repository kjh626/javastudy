package practice;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MainClass {

	// 문제 1. 현재 시간을 이용하여 디렉터리를 생성하시오.
	// 예시)
	// C:\14\31\30
	// 변수 3개 선언, 시, 분, 초
	public static void ex01() {
		// Calendar 나 LocalTime 쓰면 된다.
		
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		
		/*
		LocalDateTime now = LocalDateTime.now();
		
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		*/
		String sep = File.separator;	// 줄여서 쓰자.
		File dir = new File("C:" + sep + hour + sep + minute + sep + second);
		if(dir.exists() == false) {
			dir.mkdirs();
		} 
		
	}
	
	
	public static void main(String[] args) {
		ex01();
	}

}
