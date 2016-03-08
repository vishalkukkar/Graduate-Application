package gapp.model.dao.jpa;

import gapp.model.EducationalBackground;
import gapp.model.dao.EducationalBackgroundDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EducationalBackgroundDaoImpl implements EducationalBackgroundDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<EducationalBackground> getEduByappId(int appid) {
		return entityManager.createQuery("from EducationalBackground eb where eb.application = '" + appid + "'",
				EducationalBackground.class).getResultList();

	}

	@Override
	public EducationalBackground getByeduId(Integer backId) {

		return entityManager
				.createQuery("from EducationalBackground  where id = '" + backId + "'", EducationalBackground.class)
				.getSingleResult();

	}

	@Override
	@Transactional
	public void remove(EducationalBackground edu) {
		entityManager.remove(edu);

	}

}