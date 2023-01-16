package practice04_Shape;

	// 상속으로 작성해보기

public class Square_Inheritance extends Rectangle{

	
	// 필드 필요 없음(Rectangle이 가지고 있음)
	
	// 생성자 (Source 의 superclass 사용)
	public Square_Inheritance(double width) {
		super(width, width);
	}
	
	// 메소드 만들 필요 X, 부모 메소드 사용 가능하기에

}
