package ex03_functional_interface.ch02;

public class MainClass {
	
	public static void main(String[] args) {
		
		MyInterface myInterface = (a) -> System.out.println(a);
		myInterface.method(10);
		
	}
	
}
