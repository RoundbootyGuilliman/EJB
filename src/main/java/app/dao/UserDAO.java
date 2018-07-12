package app.dao;

import app.entity.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserDAO {
	
	void saveUser(User user);
	List<User> getAllUsers();
	User getByEmail(String email);
	void deleteUser(String email);
}
