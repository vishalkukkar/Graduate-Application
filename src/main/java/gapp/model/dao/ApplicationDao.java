package gapp.model.dao;

import gapp.model.Application;
import gapp.model.Department;
import gapp.model.TermStatus;

import java.util.List;

public interface ApplicationDao {

	//Application getApplication(Integer id);

	List<Application> getApplications();

	List<Application> getApplicationByDepartmentAndTerm(Department department, TermStatus termStatus);
}
