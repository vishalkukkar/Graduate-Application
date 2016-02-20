package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "termstatus")
public class TermStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "termstatus_id")
	private Integer id;

	@Column
	private String year;

	@Column
	private String term;

	@OneToMany(mappedBy = "termStatus")
	private List<Application>  application;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}
	
	

}
