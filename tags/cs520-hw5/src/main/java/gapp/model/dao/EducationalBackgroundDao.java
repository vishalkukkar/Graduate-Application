package gapp.model.dao;


import java.util.List;

import gapp.model.EducationalBackground;

public interface EducationalBackgroundDao {

	List<EducationalBackground> getEduByappId(int appid);

	EducationalBackground getByeduId(Integer backId);

	void remove(EducationalBackground edu);

}