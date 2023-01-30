package ex05_InputStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.List;

import ex04_OutputStream.Person;

public class MainClass {

	public static void ex01() {
		
		File file = new File("C:" + File.separator + "storage", "ex01.bin");
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream(file);
			
			// 입력 단위
			// 1. int    : 1개 
			// 2. byte[] : 2개 이상 
			
			
			int c = 0;
			StringBuilder sb = new StringBuilder();
			while((c = fis.read()) != -1) {
				sb.append((char) c);
			}
			System.out.println(sb.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex02() {
		
		// 원래 깨져서 출력됨(바이트 스트림과 한글 처리의 문제 확인)
		
		File file = new File("C:" + File.separator + "storage", "ex02.bin");
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream(file);
			
			byte[] b = new byte[4]; 	// 한 번에 4바이트를 읽어 오시오.
			int readByte = 0;		// 실제로 읽은 바이트를 저장해 두시오.
			StringBuilder sb = new StringBuilder();
			
			while((readByte = fis.read(b)) != -1) {
				sb.append (new String(b, 0, readByte));    // 배열 b의 인덱스 0부터 readByte개 데이터를 사용한다.
			} 
			
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		// 원래 오류난다.
	}
	
	public static void ex02_complete() {
		
		// 바이트 입력 스트림을 문자 입력 스트림으로 변환하는 InputStreamReader
		
		File file = new File("C:" + File.separator + "storage", "ex02.bin");
		
		InputStreamReader isr = null;
		
		try {
			
			isr = new InputStreamReader(new FileInputStream(file));		// 더이상 바이트 기반 스트림이 아니다. => 파일 리더가 됐다고 생각하면 됨.
			
			char[] cbuf = new char[4]; 	// 한 번에 4글자를 읽어 오시오.
			int readCount = 0;		// 실제로 읽은 글자수를 저장해 두시오.
			StringBuilder sb = new StringBuilder();
			
			while((readCount = isr.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount);    // 배열 cbuf의 인덱스 0부터 readCount개 데이터를 사용한다.
			} 
			
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(isr != null) {
					isr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
	}
	
	public static void ex03() {
		
		File file = new File("C:" + File.separator + "storage", "ex03.bin");
		
		BufferedInputStream bis = null;
		
		try {
			
			bis = new BufferedInputStream(new FileInputStream(file));
			
			byte[] b = new byte[4];
			int readByte = 0;
			StringBuilder sb = new StringBuilder();
			
			while((readByte = bis.read(b)) != -1) {
				sb.append(new String(b,0,readByte));
			}
			
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex03_complete() {
		
		// 버퍼 기반으로 읽기
		File file = new File("C:" + File.separator + "storage", "ex03.bin");
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));	// 실무에서 자주나오는 패턴
			
			// line 쓰는 거 외워라~~☆
			String line = null;
			StringBuilder sb = new StringBuilder();
			
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex04() {
		
		// 단순하게 보는 거라 우린 순서를 봐야 된다.
		// String name, int age, double height, boolean isAlive 순으로 값이 저장된 ex04.dat 파일
		
		File file = new File("C:" + File.separator + "storage", "ex04.dat");
		
		DataInputStream dis = null;
		
		try {
			
			dis = new DataInputStream(new FileInputStream(file));
			
			// 입력(변수 타입에 따라서 메소드가 다름)
			String name = dis.readUTF();			// writeUTF에 대응
			int age = dis.readInt();				// writeInt에 대응
			double height = dis.readDouble();		// writeDouble에 대응
			boolean isAlive = dis.readBoolean();	// writeBoolean에 대응 
			
			System.out.println(name);
			System.out.println(age);
			System.out.println(height);
			System.out.println(isAlive);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dis != null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex05() {
		
		// Object는 거의 쓸 일 없을 것이다.
		// Person 객체가 3개 저장되어 있는 (List<Person> 2개, Person 1개) ex05.dat 파일
		
		File file = new File("C:" + File.separator + "storage", "ex05.dat");
		
		ObjectInputStream ois = null;
		
		try {
			
			ois = new ObjectInputStream(new FileInputStream(file));
			
			// 출력할 때 ArrayList랑 Person 이랑 구분하지 않음.
			
			// 입력. // Person클래스를 패키지에 안 옮기고 코드작성 -> import하면 됨.
			// readObject 메소드는 Object를 반환하므로 적절하게 캐스팅해야 한다.
			@SuppressWarnings("unchecked")
			List<Person> people = (List<Person>)ois.readObject();	// 이렇게 오브젝트를 캐스팅하는 게 확실하냐..라고 묻는 정도의 경고 => (안해도 되는데)경고 신경쓰이면 첫 번째거 고르면 people의 경고를 무시하겠다.
			Person person = (Person)ois.readObject();
			
			System.out.println(people);
			System.out.println(person);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		ex05();
	}

}
