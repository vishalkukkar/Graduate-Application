package gapp.web.model.dao.jpa;

import gapp.web.model.User;
import gapp.web.model.dao.UserDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUser(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> getUsers() {
		return entityManager.createQuery("from User order by id", User.class).getResultList();
	}

	@Override
	public User getUserByEmail(String email) {

		return entityManager.createQuery("from User where email = '" + email + "'", User.class).getSingleResult();
	}

}