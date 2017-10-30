package ecommerce.electronics.model;


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
	
	@Column(name = "role", nullable = false)
    private String role;

	public User() {}
	
	public User(String userName, String hashPassword, String email, String role) {
		
		this.userName = userName;
		this.hashPassword = hashPassword;
		this.email = email;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
