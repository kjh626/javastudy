package practice06_Shape;

public class Circle implements Shape {

	// 필드
	private double radius;
	
	// 생성자
	public Circle(double radius) {
		super();						// 이 생성자 (public Circle)<- 타입을 Shape으로 잡음. Shape circle = new Circle(1.5);
		this.radius = radius;			// 왜 타입을 Shape으로? 인터페이스 구현하니까.implements 하니까.
	}
	
	
	@Override
	public double getArea() {
		return PI * radius * radius;
	}


}
