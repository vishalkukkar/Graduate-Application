package gapp.web.model.dao;

import java.util.List;

import gapp.web.model.User;

public interface UserDao {

	User getUserByEmail(String email);

	User getUser(Integer id);

	List<User> getUsers();

}