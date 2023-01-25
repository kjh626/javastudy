package practice;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

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
		// 실행했을 때 글자수를 2자리로 맞추는 것도 연습하면 좋다.
	}
	
	// 문제2. C:\Program Files\Java\jdk-11.0.17 경로의 파일 목록을 아래와 같이 출력하시오.
	/*
	2023-01-04  오후 02:19    <DIR>          bin
	2023-01-04  오후 02:19    <DIR>          conf
	2023-01-04  오후 02:19    <DIR>          include
	2023-01-04  오후 02:19    <DIR>          jmods
	2023-01-04  오후 02:19    <DIR>          legal
	2023-01-04  오후 02:19    <DIR>          lib
	2023-01-04  오후 02:19               160 README.html
	2023-01-04  오후 02:19             1,302 release
	               2개 파일               1,462 바이트
	*/
	public static void ex02() {
		
		String sep = File.separator;
		File dir = new File("C:" + sep + "Program Files" + sep + "Java" + sep +"jdk-11.0.17");
		if(dir.exists()) {	// 오타가 있을 경우를 대비해서 이프 해준다.
			
			File[] list = dir.listFiles();
			
			int fileCount = 0;
			long totalFileSize = 0;
			for(File file : list) {	// 인덱스 굳이 사용할 필요 없으니까
				if(file.isHidden()) {
					continue;	// 히든은 제외하겠다.
				}
				String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd  a hh:mm").format(file.lastModified());
				String directory = file.isDirectory() ? "<DIR>" : "";
				String size = "";
				if(file.isFile()) {
					long length = file.length();
					size = new DecimalFormat("#,##0").format(length);
					fileCount++;
					totalFileSize += length;
				}
				String name = file.getName();
				String result = String.format("%s%9s%9s %s\n", lastModifiedDate, directory, size, name);
				System.out.print(result);
				}
			System.out.println(fileCount + "개 파일" + new DecimalFormat("#,##0").format(totalFileSize)+ "바이트");
		}
	}
		/*
		int count = 0;
		long size = 0;
		
		// 날짜
		long lastModified = dir.lastModified();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		// 사이즈
		
		// 파일명
		for(int i = 0; i < files.length; i++) {
			long day = files[i].lastModified();
			String dayList = sdf.format(day);
			if(files[i].isHidden() == false) {
				System.out.print(dayList +"\t");
				System.out.print((dir.isDirectory() ? "<DIR>": "") + "\t");
				System.out.print(files[i].length() + "\t");
				System.out.println(files[i].getName());
			}
			if(file.isFile()) {
				count++;
				size += files[i].length();
			}
		}
		System.out.println("\t\t" + count + "개 파일" + "\t\t" + size + "바이트");
		*/
	
		// 문제3. C:\storage 디렉터리를 삭제하시오.
		// 파일이 저장된 디렉터리는 지워지지 않으므로 먼저 디렉터리에 저장된 파일을 삭제해야 한다.
		public static void ex03() {

			File dir = new File("C:" + File.separator + "storage");
			
			File file = new File(dir, "myfile.txt");
			if(file.exists()) {
				file.delete();
			}
			
			if(dir.exists()) {
				dir.delete();
			}
		}
	
	public static void main(String[] args) {
		ex03();
	}

}
