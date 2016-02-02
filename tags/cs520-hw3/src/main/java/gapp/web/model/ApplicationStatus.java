package gapp.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "applicationstatus")
public class ApplicationStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "applicationstatus_id")
	private Integer id;

	@OneToOne
	private Status status;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date;

	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date revised_date;

	@Column
	private String comment;

	@ManyToOne
	@JoinColumn(name = "application_id")
	private Application application;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getRevised_date() {
		return revised_date;
	}

	public void setRevised_date(Date revised_date) {
		this.revised_date = revised_date;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
