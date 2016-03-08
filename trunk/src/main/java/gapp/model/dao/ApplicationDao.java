package gapp.model.dao;


import gapp.model.AdditionalFieldsvalueStore;
import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.Department;
import gapp.model.EducationalBackground;
import gapp.model.Program;
import gapp.model.Status;
import gapp.model.TermStatus;
import gapp.model.User;

import java.util.List;

public interface ApplicationDao {

	//Application getApplication(Integer id);

	List<Application> getApplications();

	List<Application> getApplicationByDepartmentAndTerm(Department department, TermStatus termStatus);

	List<Application> getApplicationByUserId(int id);


	ApplicationStatus getApplicationStatusByApplicationId(int id);

	
	Application getApplicationByDepartmentIdAndUserId(User user, Department department, Program program, TermStatus term);

	Application save(Application application);

	EducationalBackground saveEduBackground(EducationalBackground educationalBackground);

	Status getStatusByName(String string);

	void saveAppStatus(ApplicationStatus applicationStatus);

	List<Status> getAllStatus();

	List<AdditionalFieldsvalueStore> getAllAdditionalValues();

	Application getAppById(Integer appId);

	//AcademicRecords getAcademicRecordsByAppId(Application App);
}
