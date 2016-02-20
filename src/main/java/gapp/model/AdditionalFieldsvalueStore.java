package gapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "additionalfieldsvaluestore")
public class AdditionalFieldsvalueStore implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String value;

	@OneToOne
	private AdditionalFields additionalFields;

	@ManyToOne
	private Application application;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public AdditionalFields getAdditionalFields() {
		return additionalFields;
	}

	public void setAdditionalFields(AdditionalFields additionalFields) {
		this.additionalFields = additionalFields;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
	
	

}
