package practice06_Person_Array;

public class Home {

	// 필드
	private Person[] arr;		// 집집마다 사람의 수는 다르다.		arr은 선언밖에 안 되어 있다.
	private int count;
	
	// 생성자
	public Home(int count) {
		
		arr = new Person[count];	// 배열은 선언하고, 생성을 해야지 사용할 수 있다.
		this.count = count;
	}

	//메소드
	public Person[] getArr() {
		return arr;
	}
	public void setArr(Person[] arr) {
		this.arr = arr;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
