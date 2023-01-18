package ex01_practice;

public class MainClass {

	public static void main(String[] args) {

		try {
			String[] season = new String[4];
			
			season[0] = "spring";
			season[1] = "summer";
			season[2] = "autumn";
			season[3] = "winter";
			season[4] = "what??";
			
			for(String str : season) {
				System.out.println(str.substring(0, 4));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 발생");
		}
		
		
	}

}
