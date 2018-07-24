package app.service.impl;

import app.dao.UserDAO;
import app.entity.User;
import app.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO userDAO;
	
	
	@Override
	public boolean registerNewUserAccount(User user) {

		if (emailExists(user.getEmail())) {
			return false;
		}
		userDAO.saveUser(user);
		
		return true;
	}
	
	private boolean emailExists(String email) {
		User user = userDAO.getByEmail(email);
		return user != null;
	}
}