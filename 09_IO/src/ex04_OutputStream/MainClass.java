package ex04_OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
	
	public static void ex02() {
		// 바이트 스트림을 사용할 때 한글 데이터가 문제가 될 수 있다.
		// => 인코딩해서 내보내는 방법을 알아야 함.
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex02.bin");
		
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream(file);
			
			String str = "안녕하세요";
			
			// getBytes(Charset charset)
			byte[] b = str.getBytes(StandardCharsets.UTF_8);
			
			// getBytes(String charsetName)
			// byte[] b = str.getBytes("UTF-8");
			
			fos.write(b);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ex02.bin 파일의 크기 : " + file.length() + "바이트");
		
	}
	
	public static void main(String[] args) {
		ex02();
	}
	
}
