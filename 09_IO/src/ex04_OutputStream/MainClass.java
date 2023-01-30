package ex04_OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass {

	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex01.bin");   // 바이너리 파일이라는 뜻, 이진 데이터
		
		FileOutputStream fos = null;	// int, byte[] 만 보낼 수 있다.
		
		try {
			
			fos = new FileOutputStream(file);
			
			// 출력 단위
			// 1. int    : 1개 출력
			// 2. byte[] : 2개 이상 출력
			
			int c = 'A';
			String str = "pple";
			byte[] b = str.getBytes();		// str 데이터를 알아서 byte배열로 바꿔줬을 것.
			
			// 출력
			fos.write(c);
			fos.write(b);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
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
