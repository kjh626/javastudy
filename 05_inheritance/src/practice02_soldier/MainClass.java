package practice02_soldier;

public class MainClass {

	public static void main(String[] args) {

		Soldier soldier = new Soldier();
		
		//soldier.setGun(new Gun()); 	// 이렇게 객체 생성해줘도 된다.
		
		soldier.reload(1);
		soldier.shoot();
		
	}

}
