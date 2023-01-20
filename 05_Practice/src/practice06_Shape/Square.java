package practice06_Shape;

public class Square implements Shape {
	
	private double width;
	
	public Square(double width) {
		super();
		this.width = width;
	}

	@Override
	public double getArea() {
		return width * width;
	}


}
