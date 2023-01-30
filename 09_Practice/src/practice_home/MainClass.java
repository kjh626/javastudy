package practice_home;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainClass {

	// 문제4. 사용자로부터 입력 받은 문자열을 C:\storage\diary.txt 파일로 보내시오.
	// 총 5개 문장을 입력 받아서 보내시오.
	public static void ex04() {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sentences = new String[5];
		System.out.println("5문장을 입력하세요.");
		for(int i = 0; i < sentences.length; i++) {
			sentences[i] = sc.nextLine();
		}
		
		File dir = new File("C:" + File.separator + "pracstorage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "diary.txt");
		
		try(PrintWriter out = new PrintWriter(file)) {
			
			for(int i = 0; i < sentences.length; i++) {
				out.println(sentences[i]);
			}
			
			System.out.println("diary.txt 파일이 생성되었다.");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
		
	}
	// 문제5. 예외가 발생한 경우 예외 메시지와 예외 발생시간을 저장한 C:\storage\log.txt 파일을 생성하시오.
	// 예시)
	// 2023-01-26 12:08:30 / by zero
	public static void ex05() {
		
		try {
			
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
			
			// 로그파일 만들기
			File dir = new File("C:" + File.separator + "pracstorage");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			File file = new File(dir, "log.txt");
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
				
				bw.write(dateTime + " " + className + " " + message + "\n");
				// bw.newLine();
				
				System.out.println("예외 메시지가 log.txt 파일에 기록되었습니다.");
			} catch(IOException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	// 문제6. C:\storage\diary.txt 파일을 C:\storage2\diary.txt 파일로 이동하시오.
	// 이동에 소요된 시간을 출력하시오.
	
	public static void ex06() {
		
		File from = new File("C:" + File.separator + "pracstorage", "diary.txt");
		
		File toDir = new File("C:" + File.separator + "storage2");
		if(toDir.exists() == false) {
			toDir.mkdirs();
		}
		File to = new File(toDir, from.getName());
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			
			long startTime = System.currentTimeMillis();
			
			br = new BufferedReader(new FileReader(from));
			bw = new BufferedWriter(new FileWriter(to));
			
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
			
			bw.close();
			br.close();
			
			if(from.length() == to.length()) {
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
	
	// 문제 8. C:\GDJ61\installer\eclipse-jee-2021-03-R-win32-x86_64.zip 파일을
	// C:\storage\eclipse.zip으로 복사하시오.
	public static void ex08() {
		
		String sep = File.separator;
		File from = new File("C:" + sep + "GDJ61" + sep + "installer", "eclipse-jee-2021-03-R-win32-x86_64.zip");
		File to = new File("C:" + sep + "storage", "eclipse.zip");	
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
			
			bin = new BufferedInputStream(new FileInputStream(from));
			bout = new BufferedOutputStream(new FileOutputStream(to));
			
			byte[] b = new byte[1024];
			int readByte = 0;
			while((readByte = bin.read(b)) != -1) {
				bout.write(b, 0, readByte);
			}
			
			System.out.println("복사 완료되었습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bout != null) { bout.close(); }
				if(bin != null) { bin.close(); }
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ex08();
	}

}
