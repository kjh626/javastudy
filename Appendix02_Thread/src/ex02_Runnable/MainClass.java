package ex02_Runnable;

public class MainClass {

	public static void main(String[] args) {
		
		// Runnable 객체인 new Soldier()를 Thread 객체를 생성할 때 전달해 준다.
		
		Thread sol1 = new Thread (new Soldier("김상사", new Gun(3)));	// new Soldier가 Runnable 객체, Runnable 객체를 Thread 타입으로 넣어준다.
		Thread sol2 = new Thread (new Soldier("박중사", new Gun(4)));
		
		sol1.start();
		sol2.start();
		// 누가 먼저 쏠 지 모른다. 아수라장으로 총을 쏜다.
	}
	
}
