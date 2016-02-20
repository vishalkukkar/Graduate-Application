package gapp.web.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@ManyToMany
	@JoinColumn(name = "role_id")
	private List<UserRoles> role;

	// @OneToMany(mappedBy = "user")
	// private List<EducationalBackground> educationalBackground;
	//
	// @OneToOne
	// private AcademicRecords academicRecords;

	@OneToMany(mappedBy = "user")
	List<Application> application;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRoles> getRole() {
		return role;
	}

	public void setRole(List<UserRoles> role) {
		this.role = role;
	}

	// public List<EducationalBackground> getEducationalBackground() {
	// return educationalBackground;
	// }
	//
	// public void setEducationalBackground(List<EducationalBackground>
	// educationalBackground) {
	// this.educationalBackground = educationalBackground;
	// }
	//
	// public AcademicRecords getAcademicRecords() {
	// return academicRecords;
	// }
	//
	// public void setAcademicRecords(AcademicRecords academicRecords) {
	// this.academicRecords = academicRecords;
	// }

	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	@Override
	public String toString() {
		return "User [application=" + application + "]";
	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
//				+ ", password=" + password + ", role=" + role + ", application=" + application + "]";
//	}
	
	
	
	

}
