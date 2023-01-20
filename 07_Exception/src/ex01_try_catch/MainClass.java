package ex01_try_catch;

import java.io.FileReader;
import java.util.Scanner;

public class MainClass {

	public static void ex01() {
		
		try {
		
			String[] season = new String[4];
			
			season[0] = "spring";
			season[1] = "summer";
			season[2] = "autumn";
			season[3] = "winter";
			season[4] = "what??";	// 이미 배열의 길이는 4로 만들어서 [4]는 쓸 수 없다.
			
			
			for(String str : season) {		// season[3]이 null -> str에 null 저장
				System.out.println(str.substring(0, 3));	// 그래서  null.substring이 됨. 예외처리가 없어도 돌아간다. unchecked exception
			}
		} catch (Exception e) {	// 3가지 정도의 옵션 . 관습적으로 e라고 적는다.(예외 객체의 이름 : e)
			System.out.println("ArrayIndexOutOfBoundsException 발생");	//NullPointerException, RuntimeException
			// 모든 예외는 Exception으로 처리 가능
		}
		
		
	}
	
	public static void ex02() {
		
		String input = "1,2,3,,4,5";
		String[] numbers = input.split(",");	// , 로 분리해주세요
		int[] iNumbers = new int[numbers.length];
		
		try {
			for(int i = 0; i < numbers.length; i++) {
				iNumbers[i] = Integer.parseInt(numbers[i]);
				System.out.println(iNumbers[i]);
			}
		} catch(NumberFormatException e) {	// unchecked이기 때문에. UnChecked Exception이므로 RuntimeException 가능
			System.out.println("NumberForamatException 발생");
		}
		// UnChecked Exception 은 try,catch가 없어도 동작한다.
	}
	
	public static void ex03() {
		// 예외가 2가지 이상일 때
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("덧셈식을 입력하시오(예: 1+2) >>> ");
			String expr = sc.next();
			String[] item = expr.split("[+]");	// split은 정규식을 받아온다.(모르는 내용) => 저거 5개 중 하나 라는 뜻
			// => 1, 2 -> 이렇게 2개로 쪼개짐
			int number1 = Integer.parseInt(item[0]);
			int number2 = Integer.parseInt(item[1]);
			System.out.println(number1 + number2);
			sc.close();		// scanner끝남
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("+를 포함해서 입력하세요.");
		} catch(NumberFormatException e) {
			System.out.println("정수 덧셈만 가능합니다.");
		} catch(Exception e) {	// 마지막 catch 블록은 Exception으로 모든 예외를 처리한다.
			System.out.println("예외가 발생했습니다.");
		}
	}
	
	public static void ex04() {
		
		//Checked Exception
		try {
			FileReader fr = new FileReader("sample.txt");	// 파일이 없으면 어떡할 건지 대비책을 세워야 한다. -> try,catch 없으면(unhandled exception) 실행 못함
			fr.close();
		} catch(Exception e) {
			System.out.println("예외가 발생하였다.");
		}
	}
	
	public static void main(String[] args) {
		ex02();
		// 7장 이후 부터가 우선적으로 공부해야할 내용이다.
	}
	
}
