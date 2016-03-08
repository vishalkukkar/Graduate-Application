package gapp.model.dao.jpa;



import gapp.model.AdditionalFieldsvalueStore;
import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.Department;
import gapp.model.EducationalBackground;
import gapp.model.Program;
import gapp.model.Status;
import gapp.model.TermStatus;
import gapp.model.User;
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
				.createQuery(
						"from Application a where a.program.department =:department " + "and a.termStatus =:termStatus",
						Application.class)
				.setParameter("department", department).setParameter("termStatus", termStatus).getResultList();

	}

	@Override
	public List<Application> getApplicationByUserId(int id) {
		return entityManager.createQuery("from Application where user_id = '" + id + "'", Application.class)
				.getResultList();

	}

	@Override
	public ApplicationStatus getApplicationStatusByApplicationId(int id) {
		return entityManager
				.createQuery("from ApplicationStatus where application_id = '" + id + "'" + "order by create_date",
						ApplicationStatus.class)
				.getSingleResult();

	}

	

	@Override
	public Application getApplicationByDepartmentIdAndUserId(User user, Department department, Program program,TermStatus termStatus) {
		return entityManager
				.createQuery("from Application a where a.program.department =:department " + "and a.user =:user "
						+ "and a.program =:program "+"and a.termStatus =:termStatus", Application.class)
				.setParameter("user", user).setParameter("department", department).setParameter("program", program).setParameter("termStatus", termStatus)
				.getSingleResult();

	}
	
	@Override
	public Status getStatusByName(String status) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Status where statusName = '" + status + "'", Status.class).getSingleResult();
		
	}
	
	
	@Override
	public List<AdditionalFieldsvalueStore> getAllAdditionalValues() {
		return entityManager.createQuery("from AdditionalFieldsvalueStore ", AdditionalFieldsvalueStore.class).getResultList();
		
	}


	
	@Override
	public List<Status> getAllStatus() {
		return entityManager.createQuery("from Status ", Status.class).getResultList();
		
		
	}
	@Override
	public Application save(Application application) {
		return entityManager.merge(application);
		
	}

	@Override
	public EducationalBackground saveEduBackground(EducationalBackground educationalBackground) {
		return entityManager.merge(educationalBackground);
		
	}

	@Override
	public void saveAppStatus(ApplicationStatus applicationStatus) {
		entityManager.merge(applicationStatus);
		
	}

	@Override
	public Application getAppById(Integer appId) {
		return entityManager.createQuery("from Application where id = '" + appId + "'", Application.class).getSingleResult();
	}

	
	

	

//	@Override
//	public AcademicRecords getAcademicRecordsByAppId(Application App) {
//		return entityManager.createQuery("from academicrecords where application = '" + App + "'", AcademicRecords.class).getSingleResult();
//
//	}

}