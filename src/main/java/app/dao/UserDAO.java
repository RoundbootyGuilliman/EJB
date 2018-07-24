package app.dao;

import app.entity.User;

import javax.ejb.Local;

@Local
public interface UserDAO {
	
	void saveUser(User user);
	User getByEmail(String email);
	void deleteUser(String email);
}
