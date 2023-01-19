package ex04_practice;

public class MainClass {

	public static void main(String[] args) {

		Gun gun = new Gun();
		
		try {
			gun.reload(15);
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
