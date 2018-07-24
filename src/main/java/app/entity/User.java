package app.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "USER_ID")
	private int id;

	private String username;

	private String password;
	
	private String email;

	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
