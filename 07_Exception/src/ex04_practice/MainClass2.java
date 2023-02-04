package ex04_practice;

public class MainClass2 {

	public static void main(String[] args) {

		Gun2 gun = new Gun2();
		
		try {
			gun.reload(8);
			for(int n = 0; n < 11; n++) {
				System.out.println(gun.getBullet());
				gun.shoot();
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
