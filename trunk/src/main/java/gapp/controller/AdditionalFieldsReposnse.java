package gapp.controller;

import java.io.Serializable;

public class AdditionalFieldsReposnse implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	Integer id;
	String name;
	String type;
	boolean isrequired;
	
	public AdditionalFieldsReposnse() {
	}
	
	public AdditionalFieldsReposnse(Integer id, String name, String type, boolean isrequired) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.isrequired = isrequired;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isIsrequired() {
		return isrequired;
	}
	public void setIsrequired(boolean isrequired) {
		this.isrequired = isrequired;
	}
	
	
	
	
	
	

}
