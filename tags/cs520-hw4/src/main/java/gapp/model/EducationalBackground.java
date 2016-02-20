package gapp.model;

import java.io.Serializable;
import java.util.Date;

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

	@Column
	private String degree;

	@Column(name = "university_name", nullable = false)
	private String Universityname;

	@Column(name = "startDate", nullable = false)
	private Date startDate;

	@Column(name = "endDate", nullable = false)
	private Date endDate;

	@Column(name = "degree_earned", nullable = false)
	private String degreeEarned;

	@Column(name = "major", nullable = false)
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getUniversityname() {
		return Universityname;
	}

	public void setUniversityname(String universityname) {
		Universityname = universityname;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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
