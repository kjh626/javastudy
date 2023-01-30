package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

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
		String sep = File.separator;
		
		File[] files = dir.listFiles();
		
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
		
		/* 저장된 파일이 myfile.txt 뿐이라는 걸 알고 있어서 이런 코드가 나왔죠.
		File file = new File(dir, "myfile.txt");
		if(file.exists()) {
			file.delete();
		}
		*/

		// 이건 저장된 모든 파일을 지운다는 코드입니다.(디렉터리는 없다는 가정이요.)
		File[] files = dir.listFiles();
		if(files != null) {			
			for(File file : files) {
				if(file.isFile()) {
					file.delete();
				}
			}
		}
		
		if(dir.exists()) {
			dir.delete();
		}
	}

	// 문제4. 사용자로부터 입력 받은 문자열을 C:\storage\diary.txt 파일로 보내시오.
	// 총 5개 문장을 입력받아서 보내시오. 문장 중간에는 띄어쓰기 들어가게끔 해라
	public static void ex04() {
			
			
		// 1. String 배열을 쓰는 방법.
		// 2. 배열 안 만들고 입력 받자마자 바로 보내는 것. 
		
		Scanner sc = new Scanner(System.in);
		
		String[] sentences = new String[5];
		System.out.println("5문장을 입력하세요.");
		// sentences[01234] = sc.nextLine();	// nextLine을 써야 엔터 치기 전까지 입력을 다 받을 수 있다.
		for(int i = 0; i < sentences.length; i++) {
			sentences[i] = sc.nextLine();
		}
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "diary.txt");
		
		//FileWriter, bufferd.., printWriter 3개 중에 고민해야겠지..
		
		try (PrintWriter out = new PrintWriter(file)) {
			for(int i = 0; i < sentences.length; i++) {
				out.println(sentences[i]);
			}
			
			System.out.println("diary.txt 파일이 생성되었다.");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
		
		//2번 방법 조금 써봄
		/*
		Scanner sc = new Scanner(System.in);
		
		PrintWriter out = null;
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "diary.txt");
		try {
			out = new PrintWriter(file);
		for(int i = 0; i < 5; i++) {	// 횟수가 정해져 있을 때는 for문이 좋다.
			out.println(sc.nextLine());
		}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		System.out.println("diary.txt 파일이 생성되었다.");
		sc.close();
		*/
		
		/*
		// try(PrintWriter out = new PrintWriter(file)) {
			for(int i = 0; i < 5; i++) { 
			out.println(sc.nextLine());
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("diary.txt 파일이 생성되었다.");
		sc.close();
		//
		*/
		
		/* 내 풀이
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "diary.txt");
		
		PrintWriter out = null;
		Scanner sc = new Scanner(System.in);
		String[] sentences = new String[5];
		try {
			out = new PrintWriter(file);
			for(int i = 0; i < sentences.length; i++) {
				sentences[i] = sc.nextLine();
				out.println(sentences[i]);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		sc.close();
		*/
	}
		
	// 문제5. 예외가 발생한 경우 예외 메시지와 예외 발생기간을 저장한 C:\storage\log.txt 
	// 예시)	// catch블록에서 파일 생성을 해야한다.
	// 2023-01-26 12:08:30 / by zero
	public static void ex05() {
		
		try { 	// try 그냥 크게 잡아줌
			
			Scanner sc = new Scanner(System.in);
			
				
			System.out.print("첫 번째 정수를 입력하세요 >>> ");
			int number1 = sc.nextInt();
			
			System.out.print("두 번째 정수를 입력하세요 >>> ");
			int number2 = sc.nextInt();
			
			int add = number1 + number2;
			int sub = number1 - number2; 
			int mul = number1 * number2;
			int div = number1 / number2;
	
			System.out.println(number1 + "+" + number2 + "=" + add);
			System.out.println(number1 + "-" + number2 + "=" + sub);
			System.out.println(number1 + "*" + number2 + "=" + mul);
			System.out.println(number1 + "/" + number2 + "=" + div);
			
			sc.close();
		
		} catch(Exception e) {
			
			// 날짜
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String dateTime = dtf.format(now);
			
			// 예외 클래스 이름
			String className = e.getClass().getName();
			// 예외 메시지
			String message = e.getMessage();
			
			// 로그 파일 만들기
			File dir = new File("C:" + File.separator + "storage");
			if(dir.exists() == false) {
				dir.mkdirs();
			}

			File file = new File(dir, "log.txt");
			
			// 생성 모드 (언제나 새로 만든다.) 		new FileWriter(file)
			// 추가 모드 (기존 내용에 추가한다.)	new FileWriter(file, true)
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {	// true만 넣어주면 추가모드(누적)
				
				bw.write(dateTime + " " + className + " " + message + "\n");
				//bw.newLine()	 \n을 대신할 수 있는 코드. BufferedWriter만 제공하는 메소드
				System.out.println("예외 메시지가 log.txt 파일에 기록되었습니다.");
			} catch(IOException e2) {
				e2.printStackTrace();
			}
			
		}
	}
	
	// 문제 6. C:\storage\diary.txt 파일을 C:\storage2\diary.txt 파일로 이동하시오. (복사한 다음에 지우시오.)
	// 이동에 소요된 시간을 출력하시오.
	public static void ex06() {
		/*	내 풀이
		File file = new File("C:" + File.separator + "storage", "diary.txt");
		BufferedReader br = null;
		PrintWriter out = null;
		
		try {
			
			long nanoTime1 = System.nanoTime();
			
			br = new BufferedReader(new FileReader(file));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			String content = sb.toString();
			System.out.println(content);
			
			File dir = new File("C:" + File.separator + "storage2");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			File copyFile = new File(dir, "diary.txt");
			
			if(copyFile.exists() == false) {
				out = new PrintWriter(copyFile);
				out.println(content);
				file.deleteOnExit();
			}
			
			long nanoTime2 = System.nanoTime();
			System.out.println("작업수행시간 : " + (nanoTime2 - nanoTime1) + "ns");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			try {
				if(br != null) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		*/
		File from = new File("C:" + File.separator + "storage", "diary.txt");		// 복사할 파일
				
		File toDir = new File("C:" + File.separator + "storage2");				// 복사 장소
		if(toDir.exists() == false) {
			toDir.mkdirs();
		}
		File to = new File(toDir, from.getName());		// 복사된 파일
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			
			long startTime = System.currentTimeMillis();

			br = new BufferedReader(new FileReader(from));	// "C:" + File.separator + "storage", "diary.txt"
			bw = new BufferedWriter(new FileWriter(to));	// "C:" + File.separator + "storage2", "diary.txt" -> 파일이 생성됨.
			
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
			
			bw.close();	
			br.close();			// finally 안 쓰고 여기서 clsoe()했네?
			
			if(from.length() == to.length()) {  // 복사 성공했다면 삭제  ==> 파일 크기를 비교해서 같으면 삭제한다.
				from.deleteOnExit();
			}

			long stopTime = System.currentTimeMillis();
			
			System.out.println("이동에 걸린 시간 : " + (stopTime - startTime) + "밀리초");
			
		} catch(IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	// 문제 7. System.in은 키보드로부터 바이트 데이터를 입력 받는 InputStream이다.
	// System.in으로부터 문장 1개를 입력 받아서 출력하시오.
	// Scanner 대신 BufferedReader를 사용하시오.
	public static void ex07() {
		
		// 바이트 스트림을 문자 스트림으로 바꿔라.
		
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("문장 입력 >>> ");
			String sentence = br.readLine();
			
			System.out.println("입력된 문장 : " + sentence);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// 문제 8. 키보드로부터 하나의 문장을 입력 받은 뒤 C:\storage\ex08.txt 파일에 출력하시오.
	// Scanner와 DataOutputStream을 사용하시오.
	public static void ex08() {
		
		Scanner sc = new Scanner(System.in);
		DataOutputStream dos = null;
		
		try {
			
			dos = new DataOutputStream(new FileOutputStream(new File("C:" + File.separator + "storage", "ex08.txt")));	// 파일 선언 없이 한번에 해봄.
			
			System.out.print("문장 입력 >>> ");
			String sentence = sc.nextLine();
			
			dos.writeUTF(sentence);
			
			sc.close(); 	// 안 해도 되는건데, 안 쓰면 경고메시지 뜨니까 기분나빠서 써준다.
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// 문제 9. C:\GDJ61\installer\eclipse-jee-2021-03-R-win32-x86_64.zip 파일을
	// C:\storage\eclipse.zip으로 복사하시오.
	public static void ex09() {
		// 뭐든지 복사할 수 있다.
		String sep = File.separator;
		File from = new File("C:" + sep + "GDJ61" + sep + "installer", "eclipse-jee-2021-03-R-win32-x86_64.zip");
		File to = new File("C:" + sep + "storage", "eclipse.zip");
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
			
			bin = new BufferedInputStream(new FileInputStream(from));		// 우리 자리의 파일 이고
			bout = new BufferedOutputStream(new FileOutputStream(to));		// 이게 서버측에 올라갈 파일이 될 것임.
			
			byte[] b = new byte[1024];		// 1kb씩 옮기겠다.
			int readByte = 0;
			while((readByte = bin.read(b)) != -1) {
				bout.write(b, 0, readByte);  	// 배열 b의 index 0부터 readByte개 데이터를 사용한다.
			}
			
			System.out.println("복사 완료되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bout != null) { bout.close(); }
				if(bin != null) { bin.close(); }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		ex08();
	}

}
