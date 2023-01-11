package ex05_ellipsis;

public class Calculator {

	/*
		매개변수 생략
		1. 전달되는 인수의 개수가 정해지지 않았을 경우에 사용한다.
		2. 말 줄임표(...)를 활용한다.
		3. 실제로는 배열로 처리된다. -> ... 은 배열이구나 라고 생각하면 됨.
	*/
	
	double addition(double... numbers) {
		double total = 0.0;
		for(int i = 0; i < numbers.length; i++) {
			total += numbers[i];
		}
		return total;
	}
	
	
	
}
