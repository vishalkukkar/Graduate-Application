package gapp.web.model.dao;

import gapp.web.model.Department;

import java.util.List;

public interface DepartmentDao {

	List<Department> getDepartments();

	Department getDepartmentByName(String name);
}
