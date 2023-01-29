package practice02;

public class PracitceClass {

	public static void main(String[] args) {
		int[] arr = new int[100];
		int[] count = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10);
			count[arr[i]]++;
		}
		System.out.println(count[0]++);
		System.out.println(count[0]);
		System.out.println(count[0]++);
		System.out.println(count[0]);
	}

}
