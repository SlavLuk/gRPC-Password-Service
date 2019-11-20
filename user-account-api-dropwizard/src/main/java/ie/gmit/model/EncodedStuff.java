package ie.gmit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EncodedStuff {

	private String hashedPassword;
	private String salt;

	public EncodedStuff() {

	}
	@JsonProperty
	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	@JsonProperty
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
