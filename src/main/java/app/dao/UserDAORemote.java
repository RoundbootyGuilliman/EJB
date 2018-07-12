package app.dao;

import app.entity.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserDAORemote {
	
	void saveUser(User user);
	List<User> getAllUsers();
	User getByEmail(String email);
	void deleteUser(String email);
}
