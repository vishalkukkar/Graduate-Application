package gapp.model.dao.jpa;

import gapp.model.AdditionalFields;
import gapp.model.AdditionalFieldsvalueStore;
import gapp.model.Department;
import gapp.model.dao.AdditionalFieldsDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AddtionalFieldDaoImpl implements AdditionalFieldsDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<AdditionalFields> getAdditionalFieldByDepartment(Department department) {

		return entityManager
				.createQuery("from AdditionalFields a where a.department =:department ", AdditionalFields.class)
				.setParameter("department", department).getResultList();

	}

	@Override
	public AdditionalFields getFieldByFieldAndDeptId(int fieldId, Department department) {
		return entityManager
				.createQuery("from AdditionalFields a where a.department =:department " + "and a.id =:fieldId", AdditionalFields.class)
				.setParameter("fieldId", fieldId).setParameter("department", department).getSingleResult();

	}

	@Override
	@Transactional
	public void removeField(AdditionalFields additionalField) {
		entityManager.remove(additionalField);
	}

	@Override
	public AdditionalFields getAdditionalFieldById(int pId) {
		return entityManager.createQuery("from AdditionalFields where id = '" + pId + "'", AdditionalFields.class).getSingleResult();
		
	}

	@Override
	@Transactional
	public void save(AdditionalFieldsvalueStore additionalFieldsvalueStore) {
		entityManager.merge(additionalFieldsvalueStore);
		
	}

	@Override
	public AdditionalFieldsvalueStore getAddValueById(int id) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from AdditionalFieldsvalueStore where id = '" + id + "'", AdditionalFieldsvalueStore.class).getSingleResult();
		
	}

}