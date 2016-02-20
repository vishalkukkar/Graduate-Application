package gapp.model.dao;

import java.util.List;
import gapp.model.UserRoles;

public interface UserRoleDao {

	List<UserRoles> getUserByRole(String role);

}