package app.security;

import app.dao.UserDAO;
import app.entity.User;
import app.util.MD5Encoder;

import javax.inject.Inject;

public class AuthenticationManager {
	
	@Inject
	private UserDAO userDAO;
	
	public Authentication authenticate(String email, String password) throws AuthenticationException {
		
		User user = userDAO.getByEmail(email);
		String encodedPassword = MD5Encoder.encode(password);
		if (user != null && encodedPassword.equals(user.getPassword())) {
			return new Authentication(user.getUsername(), password, user.getRole());
		}
		throw new AuthenticationException("Bad Credentials");
	}
}
