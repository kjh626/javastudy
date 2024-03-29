package practice06_Shape;

public class MainClass {

	public static void main(String[] args) {
		
		
		// Shape은 Circle의 부모, Circle 업캐스팅함. 업캐스팅 문제점 해결 -> interface로 구현함.
		Shape circle = new Circle(1.5);
		
		System.out.println("원의 면적 : " + circle.getArea());
		
		Shape rectangle = new Rectangle(1.5, 2.5);	// 너비가 1.5 , 높이가 2.5 인 사각형
		System.out.println("사각형 면적 : " + rectangle.getArea());
		
		Shape square = new Square(1.5);	// 너비, 높이가 1.5인 정사각형
		System.out.println("정사각형 면적 : " + square.getArea());
		
		Shape square2 = new Square_Inheritance(1.5);	// 너비, 높이가 1.5인 정사각형
		System.out.println("정사각형 면적 : " + square2.getArea());
	}

}
