package practice03_Watch;

public class Watch {
	
	// 필드
	private int hour;  // 0 ~ 23
	private int minute;  // 0 ~ 59
	private int second;  // 0 ~ 59
	
	// 생성자
	public Watch(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	// 메소드
	public void addHour(int hour) {
		if(hour >= 24) {
			this.hour += hour % 24; 
			return;
		}
		this.hour += hour;
	}
	
	public void addMinute(int minute) {
		if(minute >= 60) {
			this.hour = hour + (minute / 60);
			this.minute += minute % 60; 
			return;
		}
		this.minute += minute;
	}
	
	public void addSecond(int second) {
		if(second >= 3600) {
			this.hour = hour + (second / 3600);
			this.minute += (second - 3600) / 60;  
		} else {
			this.minute = second / 60;
		}
		this.second += second % 60;
	}
	
	public void see() {
		System.out.println(hour + "시" + minute + "분" + second + "초");
	}


}
