package ex02_field;

public class MainClass {

	public static void main(String[] args) {
		
		School school = new School();    // 객체 생성
		
		school.name = "철산초";
		school.students = new Student[3];	// 배열 생성(학생이 3명)
		
		for(int i = 0; i < school.students.length; i++) {
			
			// Student 객체 생성
			school.students[i] = new Student(); // 학생 한 명 한 명을 의미할 것.
			
			school.students[i].name = "정숙";
			school.students[i].stuNo = "10101";
			
			// Score 객체 생성
			school.students[i].score = new Score();
			
			school.students[i].score.kor = 100;
			school.students[i].score.eng = 90;
			school.students[i].score.math = 80;
			
			System.out.println("학번 : " + school.students[i].stuNo);
			System.out.println("이름 : " + school.students[i].name);
			System.out.println("국어 : " + school.students[i].score.kor);
			System.out.println("영어 : " + school.students[i].score.eng);
			System.out.println("수학 : " + school.students[i].score.math);
			
		}
		
		
		
	}

}
