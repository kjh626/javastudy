package practice02_soldier;

public class Soldier {
	
	// 필드
	private Gun gun;	// 초기값은 null
	
	// 생성자
	public Soldier() {
		gun = new Gun();  // 메인 클래스의 디폴트 생성자가 new Gun()까지 해준다. => 상속 안 쓰고 하는 방법
	}
	
	// 메소드
	public void reload(int bullet) {
		gun.reload(bullet);	// NullPointerException 왜냐 gun생성자를 안 넣어줘서
	}
	
	public void shoot() {
		gun.shoot();
	}

}
