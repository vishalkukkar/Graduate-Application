package gapp.model.dao;

import java.util.List;

import gapp.model.AdditionalFields;
import gapp.model.Department;

public interface AdditionalFieldsDao {

	List<AdditionalFields> getAdditionalFieldByDepartment(Department department);

	AdditionalFields getFieldByFieldAndDeptId(int fieldId, Department department);

	void removeField(AdditionalFields additionalField);

}