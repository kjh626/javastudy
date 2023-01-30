package ex04_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

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
	
	public static void ex03() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex03.bin");
		
		BufferedOutputStream bos = null;	// 쓸 거만 선언해라
		
		try {
			
			bos = new BufferedOutputStream(new FileOutputStream(file));
			
			bos.write("반갑습니다\n또만나요".getBytes("UTF-8"));	// 오타만 내지 않으면 String으로 적으면 된다.
			
			
			// try의 마지막 부분에 bos.close()가 쓰일 수도 있다.(bos를 다 쓰고 난 다음에..). 현실적으로는 여기에도 많이 씀.
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) {
					bos.close();	// 권장 위치는 여기임
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ex03.bin 파일의 크기 : " + file.length() + "바이트");
		
	}
	
	public static void ex04() {
		
		// 변수를 그대로 출력하는 DataOutputStream
		// 한글 처리를 할 때 자주 쓴다. String값을 주로 씀.
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex04.dat");
		
		DataOutputStream dos = null;
		
		try {
			// Buffered처럼 보조 스트림이다.
			dos = new DataOutputStream(new FileOutputStream(file));
			
			// 출력할 변수
			String name = "에밀리";
			int age = 30;
			double height = 180.5;
			boolean isAlive = true;
			
			// 출력(변수 타입에 따라서 메소드가 다름)
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeDouble(height);
			dos.writeBoolean(isAlive);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos != null) {
					dos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ex04.dat 파일의 크기 : " + file.length() + "바이트");
	}
	
	public static void ex05() {
		
		// 객체를 그대로 출력하는 ObjectOutputStream
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex05.dat");
		
		ObjectOutputStream oos = null;
				
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
		
			// 출력할 객체
			List<Person> people = Arrays.asList(
				new Person("에밀리", 30, 180.5, true),
				new Person("제시카", 35, 190.5, true)
			);
			
			// 출력할 객체
			Person person = new Person();
			person.setName("제임스");
			person.setAge(40);
			person.setHeight(170.5);
			person.setAlive(false);
			
			// 출력 => 직렬화가 필요하다.
			oos.writeObject(people);
			oos.writeObject(person);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ex05.dat 파일의 크기 : " + file.length() + "바이트");
				
	}
	
	public static void main(String[] args) {
		ex05();
	}
	
}
