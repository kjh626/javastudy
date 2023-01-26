package ex02_practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainClass {

	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex02_practice.txt");
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file);
			
			int c = 'I';
			char[] cbuf = {' ', 'a', 'm', ' ', 'a'};
			String str = " 바보";
			
			fw.write(c);
			fw.write(cbuf);
			fw.write(str);
			
			System.out.println("ex02_practice.txt 파일이 생성되었습니다.");
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
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex02.txt");
		
		try(FileWriter fw = new FileWriter(file)) {
			char[] cbuf = {'a','b','c','d','e'};
			String str = "abcde";
			
			fw.write(cbuf, 0, 2);
			fw.write(str, 2, 3);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex03() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex03.txt");
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			bw.write("Hello World");
			
			System.out.println("ex03.txt 파일이 생성되었다.");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex04() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex04.txt");
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			
			bw.write("안녕하세요");
			
			System.out.println("ex04.txt 파일이 생성되었다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex05() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex05.txt");
		
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(file);
			
			out.println("안녕하세요.");
			out.println("반갑습니다.");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		
	}
	
	public static void main(String[] args) {
		ex05();
	}

}
