package ie.gmit.model;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement(name="UserToString")
public class UserToString{

	@XmlElement
	private int userId;
	@XmlElement
	private String userName;
	@XmlElement
	private String email;
	@XmlElement
	private String hashedPassword;
	@XmlElement
	private String salt;

	public UserToString() {

	}

	public UserToString(int userId,String userName,String email,String hashedPassword,String salt) {

		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.salt = salt;
		
	}

	@JsonProperty
	
	public String getHashedPassword() {
		return hashedPassword;
	}

	@JsonProperty

	public String getSalt() {
		return salt;
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
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}



}
