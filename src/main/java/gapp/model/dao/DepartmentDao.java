package gapp.model.dao;

import gapp.model.AdditionalFields;
import gapp.model.Department;

import java.util.List;

public interface DepartmentDao {

	List<Department> getDepartments();

	Department getDepartmentByName(String name);

	Department getDepartmentById(int id);

	Department savedepartment(Department department);

	AdditionalFields saveAddField(AdditionalFields additionalFields);

	List<AdditionalFields> getAdditionalField(Department departmentById);
	

}
