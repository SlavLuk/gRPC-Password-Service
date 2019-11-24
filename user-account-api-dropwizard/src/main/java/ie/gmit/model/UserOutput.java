package ie.gmit.model;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.protobuf.ByteString;

@XmlRootElement(name="UserOutput")
public class UserOutput {

	@XmlElement
	private int userId;
	@XmlElement
	private String userName;
	@XmlElement
	private String email;
	@XmlElement
	private ByteString hashedPassword;
	@XmlElement
	private ByteString salt;

	public UserOutput() {

	}

	public UserOutput(int userId,String userName,String email,ByteString hashedPassword,ByteString salt) {

		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.salt = salt;
		
	}

	@JsonProperty
	
	public ByteString getHashedPassword() {
		return hashedPassword;
	}

	@JsonProperty

	public ByteString getSalt() {
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

	public void setHashedPassword(ByteString hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public void setSalt(ByteString salt) {
		this.salt = salt;
	}



}
