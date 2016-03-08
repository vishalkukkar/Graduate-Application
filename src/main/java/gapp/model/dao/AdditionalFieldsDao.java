package gapp.model.dao;

import java.util.List;

import gapp.model.AdditionalFields;
import gapp.model.AdditionalFieldsvalueStore;
import gapp.model.Department;

public interface AdditionalFieldsDao {

	List<AdditionalFields> getAdditionalFieldByDepartment(Department department);

	AdditionalFields getFieldByFieldAndDeptId(int fieldId, Department department);

	void removeField(AdditionalFields additionalField);

	AdditionalFields getAdditionalFieldById(int parseInt);

	void save(AdditionalFieldsvalueStore additionalFieldsvalueStore);

	AdditionalFieldsvalueStore getAddValueById(int parseInt);

}