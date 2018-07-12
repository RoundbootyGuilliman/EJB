package app.security;

import java.util.Arrays;

public class AuthenticationManager {
	
	public Authentication authenticate(String username, String password) throws AuthenticationException {
		if (username.equals(password)) {
			return new Authentication(username, password, "USER");
		}
		throw new AuthenticationException("Bad Credentials");
	}
}
