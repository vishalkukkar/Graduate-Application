package gapp.model.dao.jpa;

import gapp.model.TermStatus;
import gapp.model.dao.TermStatusDao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TermStatusDaoImpl implements TermStatusDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TermStatus getterm(Integer id) {
		return entityManager.find(TermStatus.class, id);
	}

	@Override
	public List<TermStatus> gettermStatus() {
		return entityManager.createQuery("from TermStatus order by id", TermStatus.class).getResultList();
	}

	@Override
	public TermStatus getTermStatusByName(String term,String year) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from TermStatus t where t.term =:term "
				+ "and t.year =:year", TermStatus.class).setParameter("term",term).setParameter("year",year)
				.getSingleResult();

	}

}