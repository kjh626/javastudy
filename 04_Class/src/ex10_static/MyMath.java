package ex10_static;

public class MyMath {

	// 스태틱 메소드는 클래스 메소드라고도 부른다.
	// 보통 객체가 메소드를 불러온다 (객체는 참조값을 가진다)
	// 다른 경우 : Parsing할 때 Integer.~~~ 는 클래스(Integer)가 메소드를 불러온다.

	
	/*
		static
		1. 정적 요소
		2. 객체 생성 이전에 클래스 영역에 만들어지는 요소
		3. 객체마다 생성되지 않고 클래스별로 1개씩만 생성됨
		4. 클래스를 이용해서 호출하기 때문에 클래스 변수, 클래스 메소드라고 부름.
	
	
	*/
	
	// 필드
	public static final double PI = 3.141592; // ctrl + shift + x,y : 대,소문자로 변경
	// static final : 누구든지 사용할 수 있다 => private쓰지 않고 public을 쓴다.
	
	// 메소드
	public double getCircleArea(double radius) {
		return PI * radius * radius; 
	}
	
	
	
	
	public static double max(double... numbers) {
		double max = Double.MIN_VALUE;
		for(int i = 0; i < numbers.length; i++) {
			if(max < numbers[i]) {
				max = numbers[i];
			}
		}
		return max;
	}
	
	// 최솟값 짜보기
	public static double min(double... numbers) {
		double min = Double.MAX_VALUE;
		for(int i = 0; i < numbers.length; i++) {
			if(min > numbers[i]) {
				min = numbers[i];
			}
		}
		return min;
	}
	
}
