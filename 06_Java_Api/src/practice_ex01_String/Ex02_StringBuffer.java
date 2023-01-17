package practice_ex01_String;

public class Ex02_StringBuffer {

	public static void main(String[] args) {

		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("ba");
		stringBuffer.append("na");
		stringBuffer.append("na");
		
		String str = stringBuffer.toString();
		System.out.println(str);
		
	}

}
