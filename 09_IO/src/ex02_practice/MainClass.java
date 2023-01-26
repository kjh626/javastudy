package ex02_practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	
	public static void main(String[] args) {
		ex01();
	}

}
