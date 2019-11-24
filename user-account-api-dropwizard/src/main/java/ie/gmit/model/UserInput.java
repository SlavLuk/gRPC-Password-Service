package ie.gmit.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="UserInput")
public class UserInput {

	@XmlElement
	private int userId;
	@XmlElement
	private String userName;
	@XmlElement
	private String email;
	@XmlElement
	private String password;
	
	public UserInput() {}
	
	public UserInput(int userId, String userName, String email,String password) {
		
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		
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




	
}
