package gapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "educationalbackground")
public class EducationalBackground implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "educationalbackground_id")
	Integer id;
	private static final long serialVersionUID = 1L;



	@Column(name = "university_name")
	private String Universityname;
	
	/*@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "M/dd/yyyy")*/
	@Column(name = "startDate")
	private String startDate;
	
	/*@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "M/dd/yyyy")*/
	@Column(name = "endDate")
	private String endDate;

	@Column(name = "degree_earned")
	private String degreeEarned;

	@Column(name = "major")
	private String major;

	// @ManyToOne
	// @JoinColumn(name = "user_id")
	// private User user;

	@ManyToOne
	@JoinColumn(name = "application_id")
	private Application application;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getUniversityname() {
		return Universityname;
	}

	public void setUniversityname(String universityname) {
		Universityname = universityname;
	}

	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDegreeEarned() {
		return degreeEarned;
	}

	public void setDegreeEarned(String degreeEarned) {
		this.degreeEarned = degreeEarned;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
