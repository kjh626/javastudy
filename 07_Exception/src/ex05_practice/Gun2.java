package ex05_practice;

public class Gun2 {

	private int bullet;
	public static final int MAX_BULLET = 10;
	
	public void reload(int bullet) throws GunException {
		if(this.bullet + bullet > MAX_BULLET) {
			throw new GunException("장전 불가능", "A-1");
		}
		this.bullet += bullet;
		System.out.println(this.bullet + "발 장전 완료");
	}
	
	public void shoot() throws GunException {	
		if(bullet == 0) {
			throw new GunException("총알 부족", "A-2");
		}
		bullet--;
		System.out.println("빵! " + bullet + "발 남았음");
	}

	public int getBullet() {
		return bullet;
	}

	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	
}
