package app.security;

public class Authentication {
	
	private String username;
	private String password;
	private String authority = "";
	
	public Authentication() {
	}
	
	public Authentication(String username, String password, String authority) {
		this.username = username;
		this.password = password;
		this.authority = authority;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAuthority() {
		return authority;
	}
}
