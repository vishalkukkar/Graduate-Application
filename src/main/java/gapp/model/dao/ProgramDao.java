package gapp.model.dao;



import gapp.model.Department;
import gapp.model.Program;

import java.util.List;

public interface ProgramDao {

	// Application getApplication(Integer id);

	List<Program> getProgramByDeptId(int id);
	
	Program getProgramByProgAndDeptId(int progid,Department department);

	Program saveProgram(Program program);

	List<Program> getprogramcount();

	void removeProgram(Program program);
}
