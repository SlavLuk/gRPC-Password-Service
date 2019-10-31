package ie.gmit.ds;

public class User {

	private int userId;
	private String password;
	private static User user; 
	
	private User() {
		
	}
	
	public static User getInstance() {
		
		if(user ==null) {
			
			user = new User();
		}
		
		return user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
