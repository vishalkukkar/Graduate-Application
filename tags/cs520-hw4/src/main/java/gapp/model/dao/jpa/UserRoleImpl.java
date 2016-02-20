package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.UserRoles;
import gapp.model.dao.UserRoleDao;

@Repository
public class UserRoleImpl implements UserRoleDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<UserRoles> getUserByRole(String role) {

		return entityManager.createQuery("from UserRoles where name = '" + role + "'", UserRoles.class).getResultList();

	}

}
