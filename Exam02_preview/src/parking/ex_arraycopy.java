package parking;

import java.util.Arrays;

public class ex_arraycopy {

	public static void main(String[] args) {

		String[] srcArray = { "10", "20", "30", "40", "50", "60", "70" };
		String[] destArray = new String[srcArray.length - 1];
		int removeIndex = 2;
		
		System.out.println("2번째 인덱스의 요소 삭제 전: " + Arrays.toString(srcArray));
		
		System.arraycopy(srcArray, 0, destArray, 0, removeIndex);
		System.out.println("0부터 2번째 인덱스까지 복사: " + Arrays.toString(destArray));
		
		System.arraycopy(srcArray, removeIndex + 1, destArray, removeIndex, srcArray.length - removeIndex - 1);
		System.out.println("나머지 값을 복사: " + Arrays.toString(destArray));
		
		
		//arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
		/*
		 Object src
		- 복사하고자 하는 소스로 원본 배열입니다.
				
		int srcPos
		- 복사하고자 하는 소스(Object src)에서 데이터를 읽을 시작 위치입니다.
		
		Object dest
		- 원본 배열에서 복사한 데이터를 할당하려는 배열입니다.
		- 즉, 새로운 배열입니다.
		
		int destPos
		- 새로운 배열(Object dest)의 시작 위치입니다.
		- 0으로 설정하는 경우 복사한 데이터가 새로운 배열의 인덱스 0부터 할당됩니다.
		- 3으로 설정하는 경우 복사한 데이터가 새로운 배열의 인덱스 3부터 할당됩니다.
		
		int length
		- 원본 배열에서 복사되는 데이터 개수입니다.
		 */
		// removeIndex + 1  => 3 이다. arraycopy의 두번째 부분은 Object src의
		// [0]~[1] 까지 2(removeIndex)개 복사.
		// 원본 [3](removeIndex + 1)부터 40,50,60,70 부터 읽음. => [2]([removeIndex]) 부분을 건너 뛰는것. 
		// 새로운 배열 [2](removeIndex)부터 시작
		// 복사되는 개수는 원본배열 길이 - removeIndex - 1 => 7-2-1 = 4
		// Why?  removeIndex 는 2 처음 2개 복사했으니까 2 빼주고, 새로운 배열 길이가 srcArray.length - 1 이라 1을 빼주나?
		
		
	}

}
