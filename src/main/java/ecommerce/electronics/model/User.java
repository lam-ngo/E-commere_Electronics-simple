package ecommerce.electronics.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId", nullable=false, updatable=false)
	private Long userId;
	
	@Column(name="userName", nullable=false, unique=true)
	private String userName;
	
	@Column(name="hashPassword", nullable=false)
	private String hashPassword;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="phoneNumber", nullable=false)
	private String phoneNumber;
	
	@Column(name="dateOfBirth", nullable=false)
	private Date dateOfBirth; 
	
	@Column(name="country", nullable=false)
	private String country;

	public User() {}
	
	public User(Long userId, String userName, String hashPassword, String email, String phoneNumber, Date dateOfBirth,
			String country) {
		this.userId = userId;
		this.userName = userName;
		this.hashPassword = hashPassword;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", hashPassword=" + hashPassword + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", country=" + country
				+ "]";
	}
}
