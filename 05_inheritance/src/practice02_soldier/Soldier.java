package practice02_soldier;

public class Soldier {
	
	// 필드
	private Gun gun;	// 초기값은 null
	
	// 생성자
	public Soldier() {
		gun = new Gun();  // 메인 클래스의 디폴트 생성자가 new Gun()까지 해준다. => 상속 안 쓰고 하는 방법
						// 객체를 사용하려면 선언을 하고(필드에 gun선언함), 생성을 꼭 해줘야 한다.
						// static의 경우 객체 생성 안 하고도 씀. -> static 요소는 클래스를 통해 호출함
	}
	
	/*
	// 객체를 꼭 생성자에서 new Gun()해서 생성해줄 필요는 없다.
	//	이렇게 getter setter 이용해서 메인클래스에서 셋으로 new Gun()해줘도 됨.
	public Gun getGun() {
		return gun;
	}
	
	public void setGun(Gun gun) {
		this.gun = gun;
	}
	*/
	
	
	// 메소드
	public void reload(int bullet) {
		gun.reload(bullet);	// NullPointerException 왜냐 gun생성자를 안 넣어줘서
	}
	

	public void shoot() {
		gun.shoot();
	}

}
