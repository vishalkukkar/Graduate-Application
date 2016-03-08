package gapp.model.dao.jpa;

import gapp.model.User;
import gapp.model.dao.UserDao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

		try {
			return entityManager.createQuery("from User where email = '" + email + "'", User.class).getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	@Transactional
	public User saveuser(User user) {
		return entityManager.merge(user);
	}

}