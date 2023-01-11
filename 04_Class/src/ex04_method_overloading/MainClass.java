package ex04_method_overloading;

public class MainClass {

	public static void main(String[] args) {

		// Calculator 객체 선언
		Calculator calc;
		
		// Calculator 객체 생성
		calc = new Calculator();
		
		// addition(double a, double b) 호출
		double result = calc.addition(1.5, 2.5); 	// return 받은 값을 저장할 수 있도록 result 를 만들어준다.
		System.out.println(result);
		
		// addition(double[] numbers) 호출
		double[] arr = {1.1, 2.2, 3.3};		// 배열 만듦.
		double result2 = calc.addition(arr);
		System.out.println(result2);
		
	}

}
