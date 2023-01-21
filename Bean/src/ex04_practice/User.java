package ex04_practice;

public class User {
	
	private String id;
	private String pw;
	
	public User(Builder builder) {
		this.id = builder.id;
		this.pw = builder.pw;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}
	public static class Builder {
		
		private String id;
		private String pw;
		
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		
		public Builder pw(String pw) {
			this.pw = pw;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}


}
