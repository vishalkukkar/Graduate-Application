package gapp.model.dao.jpa;

import gapp.model.Application;
import gapp.model.Department;
import gapp.model.TermStatus;
import gapp.model.dao.ApplicationDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ApplicationDaoImpl implements ApplicationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Application> getApplications() {
		return entityManager.createQuery("from Application order by id", Application.class).getResultList();

	}

	@Override
	public List<Application> getApplicationByDepartmentAndTerm(Department department, TermStatus termStatus) {

		return entityManager
				.createQuery("from Application a where a.program.department =:department "
						+ "and a.termStatus =:termStatus", Application.class)
				.setParameter("department", department).setParameter("termStatus", termStatus).getResultList();

	}

}