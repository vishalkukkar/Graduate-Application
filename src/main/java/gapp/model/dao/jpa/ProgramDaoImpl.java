package gapp.model.dao.jpa;

import gapp.model.Department;
import gapp.model.Program;
import gapp.model.dao.ProgramDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProgramDaoImpl implements ProgramDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Program> getProgramByDeptId(int id) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Program where department_id = '" + id + "'", Program.class)
				.getResultList();

	}

	@Override
	@Transactional
	public Program saveProgram(Program program) {
		return entityManager.merge(program);

	}

	@Override
	public List<Program> getprogramcount() {
		return entityManager.createQuery("from Program order by id", Program.class).getResultList();
	}

	@Override
	public Program getProgramByProgAndDeptId(int progid, Department department) {
		return entityManager
				.createQuery("from Program p where p.department =:department " + "and p.id =:progid", Program.class)
				.setParameter("progid", progid).setParameter("department", department).getSingleResult();

	}

	@Override
	@Transactional
	public void removeProgram(Program program) {
		
		entityManager.remove(program);

	}

}
