package gapp.model.dao;

import java.util.List;

import gapp.model.TermStatus;

public interface TermStatusDao {

	List<TermStatus> gettermStatus();

	TermStatus getTermStatusByName(String name,String year);

	TermStatus getterm(Integer id);
}
