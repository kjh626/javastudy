package ex01_File;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MainClass {

	/*
		File 클래스
		1. java.io 패키지
		2. 파일, 디렉터리(폴더)를 관리하는 클래스이다.
		3. 객체 생성 방법 
			1) new File(경로, 파일)
			2) new File(파일)
		4. 경로 구분 방법
			1) 윈도우 : 백슬래시(\)로 경로구분
			2) 리눅스 : 슬래시(/)
	
	*/
	
	public static void ex01() {
		
		// File.separator : 플랫폼에 따라서 자동으로 경로 구분자를 사용한다.
		
		// 디렉터리 관련 필수 작업 
		// 역슬래시 2개 넣어줘야 한다.(\\) 이래야 하나(\)라고 인식함
		//File dir = new File("C:\\storage");   // C드라이브 아래 storage 폴더를 의미한다.
		File dir = new File("C:" + File.separator + "storage");
		
		// 없으면 만들고, 있으면 지운다. => ★★★★ 필수로 할 줄 알아야 한다. ★★★★
		if(dir.exists() == false) {	// exists : 폴더가 있으면. 이라는 뜻
			dir.mkdirs();		// make directories
			System.out.println("C:" + File.separator + "storage 생성 완료");
		} else {
			//dir.deleteOnExit(); 	// JVM 실행이 끝나면 지운다.
			dir.delete();		// 지금 바로 지운다.
			System.out.println("C:" + File.separator + "storage 삭제 완료");
		}
		
	}
	
	public static void ex02() throws IOException {	// 예외 처리를 ex02 메소드를 호출한 곳으로 넘긴다.
		// 권장 방법
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();		// 폴더 없으면 만들어라
		}
		
		File file = new File(dir, "myfile.txt");
		if(file.exists() == false) {
			file.createNewFile();	// 반드시 예외 처리가 필요한 코드이다. (IOException - Checked Exception)
		} else {
			file.delete();
		}
		
	}

	public static void ex03() throws IOException {
		
		File dir = new File("C:" + File.separator + "storage");
		
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "myfile.txt");
		
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		// 파일의 정보 확인
		System.out.println("파일명 : " + file.getName());
		System.out.println("디렉터리명 : " + file.getParent());	// 파일은 폴더를 부모라고 부른다는 것을 알 수 있음
		System.out.println("경로명 : " + file.getPath());   // 파일명 + 디렉터리명
		
		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());	// 파일이면 true
		
		long lastModified = file.lastModified();	// 최종 수정일의 타임 스탬프 값이 나온다.
		System.out.println("최종 수정일 : " + lastModified);
		
		String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(lastModified);	// 이때 졸았음 한번 더 보셈
		System.out.println("최종 수정일 : " + lastModifiedDate);
		
		long size = file.length(); 		// 파일의 크기가 바이트 단위로 저장
		long kb = (size / 1024) + (size % 1024 != 0 ? 1 : 0);		// 5바이트 -> 1kb로 보여주듯이.
		System.out.println("파일 크기 : " + kb + "KB");	// 킬로 바이트 출력(1024바이트 = 1킬로바이트)
	} 
	
	public static void ex04() {
		
		File dir = new File("C:" + File.separator + "Program Files");
		
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isHidden() == false) {	// 숨긴 파일이 아닌 경우에~
				System.out.println(files[i].getName());
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {		// main 메소드를 호출하는 곳으로 예외 처리를 넘긴다.(개발자가 try-catch 하지 않겠다.)
		ex04();
	}

}
