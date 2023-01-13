package practice02_soldier;

public class Gun {
	
	// 필드
	private String model;
	private int bullet;
	private final int MAX_BULLET = 20;

	// 매소드
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getBullet() {
		return bullet;
	}
	
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	// 총알 넣기
	public void reload(int bullet) {
		if(this.bullet == MAX_BULLET) {
			return;
		}
		this.bullet += bullet;
		this.bullet = (this.bullet > MAX_BULLET) ? MAX_BULLET : this.bullet;
	}
	
	// 총 쏘기
	public void shoot() {
		if(bullet == 0) {
			System.out.println("헛빵");
			return;
		}
		bullet--;
		System.out.println("빵");
	}
	
	
	
	
	
}
