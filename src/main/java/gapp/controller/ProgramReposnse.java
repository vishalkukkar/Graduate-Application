package gapp.controller;

import java.io.Serializable;

public class ProgramReposnse implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int progId;
	String name;

	public ProgramReposnse() {};

	public ProgramReposnse(int progId, String name) {

		this.progId = progId;
		this.name = name;
	}

	public int getProgId() {
		return progId;
	}

	public void setProgId(int progId) {
		this.progId = progId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProgramReposnse [progId=" + progId + ", name=" + name + "]";
	}
	
	

}
