package ex01_practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MainClass {

	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "pracstorage");
		
		if(dir.exists() == false) {
			dir.mkdirs();
			System.out.println("C:" + File.separator + "pracstorage 생성 완료");
		} else {
			dir.delete();
			System.out.println("C:" + File.separator + "pracstorage 삭제 완료");
		}
	}

	public static void ex02() throws IOException {
		
		File dir = new File("C:" + File.separator + "pracstorage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "myfile.txt");
		if(file.exists() == false) {
			file.createNewFile();
		} else {
			file.delete();
		}
	}
	
	public static void ex03() throws IOException {
		
		File dir = new File("C:" + File.separator + "pracstorage");
		
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "myfile.txt");
		
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		// 파일의 정보 확인
		System.out.println("파일명 : " + file.getName());
		System.out.println("디렉터리명 : " + file.getParent());
		System.out.println("경로명 : " + file.getPath());
		
		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());
		
		long lastModified = file.lastModified();	// 최종 수정일의 타임 스탬프
		System.out.println("최종 수정일 : " + lastModified);
		
		String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(lastModified);
		System.out.println("최종 수정일 : " + lastModifiedDate);
		
		long size = file.length();
		long kb = (size / 1024) + (size % 1024 != 0 ? 1 : 0);
		System.out.println("파일 크기 : " + kb + "KB");
	}
	
	public static void ex04() {
		
		File dir = new File("C:" + File.separator + "Program Files");
		
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isHidden() == false) {
				System.out.println(files[i].getName());
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		ex04();
	}

}
