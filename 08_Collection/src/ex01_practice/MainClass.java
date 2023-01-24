package ex01_practice;

public class MainClass {

	public static void main(String[] args) {

		Box<Integer> box1 = new Box<Integer>();
		
		box1.setItem(10);
		System.out.println(box1.getItem());
		
		Box<String> box2 = new Box<>();
		box2.setItem("hello");
		System.out.println(box2.getItem());
	}

}
