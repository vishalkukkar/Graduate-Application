package gapp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "department_id")
	private Integer id;

	@Column(name = "department_name")
	private String name;

	@OneToMany(mappedBy = "department")
	private Set<Program> programs;
	
	@OneToMany(mappedBy = "department")
	private List<AdditionalFields> additionalFields;

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

	public Set<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}

	public List<AdditionalFields> getAdditionalFields() {
		return additionalFields;
	}

	public void setAdditionalFields(List<AdditionalFields> additionalFields) {
		this.additionalFields = additionalFields;
	}

}
