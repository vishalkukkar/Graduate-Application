package gapp.web.model.dao;

import gapp.web.model.Application;
import gapp.web.model.Department;
import gapp.web.model.TermStatus;

import java.util.List;

public interface ApplicationDao {

	//Application getApplication(Integer id);

	List<Application> getApplications();

	List<Application> getApplicationByDepartmentAndTerm(Department department, TermStatus termStatus);
}
