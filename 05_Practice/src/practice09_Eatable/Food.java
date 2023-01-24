package practice09_Eatable;

public class Food {

	// 필드
	private String foodName;
	private int foodCalorie;
	
	// 생성자
	public Food(String foodName, int foodCalorie) {
		super();
		this.foodName = foodName;
		this.foodCalorie = foodCalorie;
	}

	// 메소드
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodCalorie() {
		return foodCalorie;
	}

	public void setFoodCalorie(int foodCalorie) {
		this.foodCalorie = foodCalorie;
	}
	
	public void eat() {
		System.out.println(foodName + " " + foodCalorie + "kcal를 먹습니다.");
	}
	
	
}
