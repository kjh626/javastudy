package ex02_practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainClass2 {

	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "pracstorage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir,"ex01.txt");
		
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter(file);
			
			int c = 'I';
			char[] cbuf = {' ', 'a', 'm'};
			String str = " a girl.";
			
			fw.write(c);
			fw.write(cbuf);
			fw.write(str);
			
			System.out.println("ex01.txt 파일이 생성되었습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) {
					fw.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "pracstorage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir,"ex02.txt");
		
		try(FileWriter fw = new FileWriter(file)) {
			
			char[] cbuf = {'a','b','c','d','e','f','g'};
			String str = "abcdefg";
			
			fw.write(cbuf, 0, 3);
			fw.write(str, 3, 4);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex03() {
		
		File dir = new File("C:" + File.separator + "pracstorage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex03.txt");
		
		FileWriter fw = null;
		
		BufferedWriter bw = null;
		
		try {
			
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			bw.write("Hello Wolrd2");
			
			System.out.println("ex03.txt 파일이 생성되었다.");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex04() {
		
		File dir = new File("C:" + File.separator + "pracstorage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex04.txt");
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			
			bw.write("반갑습니다.");

			System.out.println("ex04.txt 파일이 생성되었다.");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex05() {
		
		File dir = new File("C:" + File.separator + "pracstorage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		File file = new File(dir, "ex05.txt");
		
		PrintWriter out = null;
		
		try {
			
			out = new PrintWriter(file);
			
			out.println("안녕하세요.");
			out.println("반갑습니다.");
			
			System.out.println("ex05.txt 파일이 생성되었다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		
		
	}
	
	public static void main(String[] args) {
		ex05();
	}

}
