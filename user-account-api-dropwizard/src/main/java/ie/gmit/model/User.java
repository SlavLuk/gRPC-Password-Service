package ie.gmit.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {

	private int userId;
	private String userName;
	private String email;	
	private String hashedPassword;
	private String salt;
	private String password;
	
	public User() {}
	
//	public User(int userId, String userName, String email) {
//		
//		this.userId = userId;
//		this.userName = userName;
//		this.email = email;
//		
//		
//	}
	
	public EncodedStuff getHashPass() {
		
		return new EncodedStuff();
	}
	@JsonProperty
	public int getUserId() {
		return userId;
	}
	@JsonProperty
	public String getUserName() {
		return userName;
	}
	@JsonProperty
	public String getEmail() {
		return email;
	}
	@JsonProperty
	public String getPassword() {
		return password;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
