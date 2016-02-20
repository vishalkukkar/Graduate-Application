package gapp.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "application")
public class Application implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "application_id")
	private Integer id;

	@Column(unique = true)
	private String cin;

	@Column(name = "phone", unique = true)
	private String phoneNumber;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name = "citizenship")
	private String citizenship;

	@ManyToOne
	@JoinColumn(name = "program_id")
	private Program program;

	@ManyToOne
	@JoinColumn(name = "termstatus_id")
	private TermStatus termStatus;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "application")
	private Set<ApplicationStatus> applicationStatus;

	@OneToMany(mappedBy = "application")
	private Set<AdditionalFieldsvalueStore> additionalFieldsvalueStores;

	// Added newly

	@OneToMany(mappedBy = "application")
	private List<EducationalBackground> educationalBackground;

	// @OneToOne
	// private AcademicRecords academicRecords;
	//
	// added newly

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public TermStatus getTermStatus() {
		return termStatus;
	}

	public void setTermStatus(TermStatus termStatus) {
		this.termStatus = termStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ApplicationStatus> getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(Set<ApplicationStatus> applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Set<AdditionalFieldsvalueStore> getAdditionalFieldsvalueStores() {
		return additionalFieldsvalueStores;
	}

	public void setAdditionalFieldsvalueStores(Set<AdditionalFieldsvalueStore> additionalFieldsvalueStores) {
		this.additionalFieldsvalueStores = additionalFieldsvalueStores;
	}

	public List<EducationalBackground> getEducationalBackground() {
		return educationalBackground;
	}

	public void setEducationalBackground(List<EducationalBackground> educationalBackground) {
		this.educationalBackground = educationalBackground;
	}

}
