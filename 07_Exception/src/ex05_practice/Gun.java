package ex05_practice;

public class Gun {

	private int bullet;
	public static final int MAX_BULLET = 10;
	
	// 총알 넣기
	public void reload(int bullet) throws RuntimeException {
		if(this.bullet + bullet > MAX_BULLET) {	
			throw new RuntimeException("장전 불가능"); // 메시지, 예외 코드
		}											
		this.bullet += bullet;
		System.out.println(this.bullet + "발 장전 완료");
	}
	
	// 총 쏘기
	public void shoot() throws RuntimeException {	
		if(bullet == 0) {
			throw new RuntimeException("총알 부족");
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
