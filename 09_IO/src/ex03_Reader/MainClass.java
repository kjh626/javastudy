package ex03_Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

	/*
		Reader
		1. 문자 기반의 입력 스트림이다.
		2. Reader끝나는 이름의 클래스는 모두 문자 기반의 입력 스트림이다. (입력 : (문자를) 읽는다 개념. 내보내는 것이 아니다. )
		3. 문자를 읽어들이는 스트림이다.(파일로 내용을 읽는다. 서버가 보낸 내용을 읽는다.)
	*/
	
	public static void ex01() {	// for문을 못 써서 어렵다.
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "ex01.txt");
		
		FileReader fr = null;
		
		try {			// 읽어들이는 통로를 만드는 것. 저장할 변수가 필요해짐. 변수의 타입은 int로 한다(char 쓰지마). 그냥 매뉴얼이라고 생각
			fr = new FileReader(file);
			int c = fr.read();	// 1글자만 읽어오세요 의 뜻
			
			System.out.println((char)c);	// 73이 대문자 I (대문자 'A': 65)
			// 보여줄 땐 문자로 보여주고 싶어서 (char) 붙여줌
			
		} catch (IOException e) {	// FileNotFoundException은 IOExceiption을 상속함. IOException이 함께 처리할 수 있다.
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
		ex01();
	}

}
