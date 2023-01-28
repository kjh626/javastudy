package ex03_practice;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "pracstorage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "ex01.txt"); 
		
		FileReader fr = null;
		
		
		try {
			fr = new FileReader(file);
			
			//int c = fr.read();
			
		int c;
		StringBuilder sb = new StringBuilder();
		while((c = fr.read()) != -1) {
			sb.append((char)c);
		}
		System.out.println(sb.toString());
		
		}catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "pracstorage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "ex02.txt"); 
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(file);
			char[] cbuf = new char[5];
			int readCount = 0;
			StringBuilder sb = new StringBuilder();
			
			while((readCount = fr.read(cbuf)) != -1) {
				
				sb.append(cbuf, 0, readCount);
				
			}
			
			/*
			while(true) {
				readCount = fr.read(cbuf);
				
				if(readCount == -1) {
					break;
				}
				
				for(int i = 0; i < readCount; i++) {
					System.out.print(cbuf[i]);
				}
			}
			*/
			
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		ex02();
	}

}
