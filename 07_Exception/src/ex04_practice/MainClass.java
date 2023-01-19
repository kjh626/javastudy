package ex04_practice;

public class MainClass {

	public static void main(String[] args) {

		Gun gun = new Gun();
		
		try {
			gun.reload(9);
			for(int n = 0; n < 11; n++) {
				gun.shoot();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}