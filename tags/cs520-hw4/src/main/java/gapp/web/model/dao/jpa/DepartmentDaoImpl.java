package gapp.web.model.dao.jpa;

import gapp.web.model.Department;
import gapp.web.model.dao.DepartmentDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Department> getDepartments() {
		return entityManager.createQuery("from Department order by id", Department.class).getResultList();

	}

	@Override
	public Department getDepartmentByName(String name) {

		return entityManager.createQuery("from Department where name = '" + name + "'", Department.class)
				.getSingleResult();
	}
}
