package gapp.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "academicrecords")
public class AcademicRecords implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "academicrecords_id")
	private Integer id;

	@Column(name = "TOEFL", nullable = true)
	private String toefl;

	@Column(name = "GPA")
	private String gpa;

	@Column(name = "Transcript")
	private String transcript;

	@OneToOne
	Application application;
	public Integer getId() {
		return id;
	}

	
	public Application getApplication() {
		return application;
	}


	public void setApplication(Application application) {
		this.application = application;
	}


	public void setId(Integer id) {
		this.id = id;
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

}
