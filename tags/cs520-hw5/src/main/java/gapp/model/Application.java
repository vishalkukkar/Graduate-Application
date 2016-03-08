package gapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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

	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column
	private String cin;

	@Column(name = "phone")
	private String phoneNumber;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "citizenship")
	private String citizenship;
	
	@Column(name = "gre")
	private String gre;
	
	@Column(name = "TOEFL", nullable = true)
	private String toefl;

	@Column(name = "GPA")
	private String gpa;

	@Column(name = "Transcript")
	private String transcript;
	
	@ManyToOne
	@JoinColumn(name = "program_id")
	private Program program;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "termstatus_id")
	private TermStatus termStatus;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "application")
	@OrderBy("create_date desc")
	private Set<ApplicationStatus> applicationStatus;

	@OneToMany(mappedBy = "application")
	private Set<AdditionalFieldsvalueStore> additionalFieldsvalueStores;

	@OneToMany(mappedBy = "application",cascade = {CascadeType.ALL})
	private List<EducationalBackground> educationalBackground;
	
	
	public Integer getId() {
		return id;
	}

	public Application() {

	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getToefl() {
		return toefl;
	}

	public void setToefl(String toefl) {
		this.toefl = toefl;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public String getTranscript() {
		return transcript;
	}

	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}

	public String getGre() {
		return gre;
	}

	public void setGre(String gre) {
		this.gre = gre;
	}

	public Application(Integer id, String cin, String phoneNumber, String gender, Date date, String citizenship,
			String gre, String toefl, String gpa, String transcript, Program program, TermStatus termStatus, User user,
			Set<ApplicationStatus> applicationStatus, Set<AdditionalFieldsvalueStore> additionalFieldsvalueStores,
			List<EducationalBackground> educationalBackground) {
		
		this.id = id;
		this.cin = cin;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.date = date;
		this.citizenship = citizenship;
		this.gre = gre;
		this.toefl = toefl;
		this.gpa = gpa;
		this.transcript = transcript;
		this.program = program;
		this.termStatus = termStatus;
		this.user = user;
		this.applicationStatus = applicationStatus;
		this.additionalFieldsvalueStores = additionalFieldsvalueStores;
		this.educationalBackground = educationalBackground;
	}

	

}
