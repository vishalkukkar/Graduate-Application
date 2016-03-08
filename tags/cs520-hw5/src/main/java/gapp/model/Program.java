package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "programs")
public class Program implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "program_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@OneToMany(mappedBy = "program")
	private List<Application> application;

	@Column(name = "program_name")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department getDeptarment() {
		return department;
	}

	public void setDeptarment(Department deptarment) {
		this.department = deptarment;
	}

	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Program [id=" + id + ", department=" + department + ", application=" + application + ", name=" + name
				+ "]";
	}

	
}
