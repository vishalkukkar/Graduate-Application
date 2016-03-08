package gapp.model.dao;

import java.util.List;

import gapp.model.User;

public interface UserDao {

	User getUserByEmail(String email);

	User getUser(Integer id);

	List<User> getUsers();
	
	User saveuser(User user);

}