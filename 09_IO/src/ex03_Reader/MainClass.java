package ex03_Reader;

import java.io.File;
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
			/*
			int c = fr.read();	// 1글자만 읽어오세요 의 뜻. 73이 'I'(대문자 'A': 65)
			c = fr.read();		// 두 번째로 읽은 것은 공백
			c = fr.read();		// 여기서는 a. 죽죽 -> m a boy 나올것
			c = fr.read();
			c = fr.read();
			c = fr.read();
			c = fr.read();
			c = fr.read();
			c = fr.read();
			c = fr.read();
			c = fr.read();
			c = fr.read();		// 더이상 읽을 게 없으면 -1이 나옴.
			*/
			
			int c;		// 1글자를 저장할 변수
			StringBuilder sb = new StringBuilder();
			while((c = fr.read()) != -1) {
				sb.append((char)c);
			}
			System.out.println(sb.toString());	// StringBuilder는 toString해서 확인해줘야한다.
			
			// StringBuilder에 읽어들인 것을 모조리 저장
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
	
	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex02.txt");
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
			char[] cbuf = new char[5];		// 5글자를 읽어 들이는 배열
			
			while(true) {
				
				// ex02.txt 읽는 과정
				//루프 ReadCount	cbuf		
				//1		5			a b c d e
				//2		2			f g c d e	한번 읽어들인 정보가 남아 있는 것. 모자라게 읽을 수 있다..
				//3		-1						그래서 항상 마지막에 불필요한 데이터가 있을 확률이 높다.
				
				int readCount = fr.read(cbuf);	// readCount : 읽어들인 글자의 개수 // fr.read(cbuf)에서 남아있는 글자수 만큼 읽어들인다. 5글자 읽고 2글자 읽고 
				if(readCount == -1) {
					break;
				}
				
				for(int i = 0; i < readCount; i++) {// readCount를 cbuf.length(5)로 바꿨을 때 쓰레기값을 볼 수 있음.
					System.out.print(cbuf[i]);	// 2번째 읽었을때 배열에 f g c d e 이렇게 쓰레기값(c d e)이 저장되어있다. 
				}
					
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
