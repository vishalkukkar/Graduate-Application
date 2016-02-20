package gapp.web.model.dao;

import java.util.List;

import gapp.web.model.TermStatus;

public interface TermStatusDao {

	List<TermStatus> gettermStatus();

	TermStatus getTermStatusByName(String name,String year);

	TermStatus getterm(Integer id);
}
