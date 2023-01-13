package practice02_Person_Array;

public class MainClass {

	public static void ex01() {
		
		String[] nameList = {"정숙", "상철", "미희"};
		int[] ageList = {20, 30, 40};
		
		// 배열의 생성
		Person[] arr = new Person[3]; // 지금 배열에 null값이 3개 들어가 있다. 필드랑 똑같다. 
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Person();		// 디폴트 타입으로.
			arr[i].setName(nameList[i]);
			arr[i].setAge(ageList[i]);
			System.out.println("이름 : " + arr[i].getName() + ", 나이 : " + arr[i].getAge());
			
		}
		
	}
	
	public static void ex02() {
		
		String[] nameList = {"정숙", "상철", "미희"};
		int[] ageList = {20, 30, 40};
		
		Person[] arr = new Person[3];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Person(nameList[i], ageList[i]);
			System.out.println("이름 : " + arr[i].getName() + ", 나이 : " + arr[i].getAge());
		}	// setter가 필요없다.
		
	}
	
	public static void ex03() {
		
		
		String[] nameList = {"정숙", "상철", "미희"};
		int[] ageList = {20, 30, 40};
		
		Home home = new Home(3);
		
		for(int i = 0; i < home.getArr().length; i++) {
			home.getArr()[i] = new Person(nameList[i], ageList[i]);
			System.out.println("이름 : " + home.getArr()[i].getName() + ", 나이 : " + home.getArr()[i].getAge());
			
		}
		
	}
	
	public static void main(String[] args) {
		ex03();
	}

}
