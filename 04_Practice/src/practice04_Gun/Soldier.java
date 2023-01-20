package practice04_Gun;

public class Soldier {

	private Gun gun;	// 초기값은 null
	
	public Soldier() {
		gun = new Gun();
	}
	
	public void reload(int bullet) {
		gun.reload(bullet);
	}
	
	public void shoot() {
		gun.shoot();
	}
}
