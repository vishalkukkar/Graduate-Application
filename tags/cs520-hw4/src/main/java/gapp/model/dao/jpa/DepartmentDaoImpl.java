package gapp.model.dao.jpa;

import gapp.model.AdditionalFields;
import gapp.model.Department;
import gapp.model.dao.DepartmentDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public Department getDepartmentById(int id) {

		return entityManager.createQuery("from Department where id = '" + id + "'", Department.class).getSingleResult();
	}

	@Override
	@Transactional
	public Department savedepartment(Department department) {

		return entityManager.merge(department);

	}

	@Override
	@Transactional
	public AdditionalFields saveAddField(AdditionalFields additionalFields) {

		return entityManager.merge(additionalFields);
	}

}
