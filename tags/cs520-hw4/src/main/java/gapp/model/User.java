package gapp.model;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;

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

	@Column(name = "email", unique = true)
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

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public boolean isValidUser(User user) {
		try {
			System.out.println("email" + this.email.equals(user.getEmail()));
			System.out.println("passord" + this.password.equals(user.getPassword()));
			if (user != null && this.email.equals(user.getEmail()) && this.password.equals(user.getPassword()))
				return true;
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public void setUserTypesInSession(HttpSession session) {

		for (UserRoles role : this.role) {
			if (role.getName().equalsIgnoreCase("ADMIN")) {
				session.setAttribute("LoginUserRole", "Admin");
				session.setAttribute("AdminUser", this);
			}
			if (role.getName().equalsIgnoreCase("Staff")) {
				session.setAttribute("LoginUserRole", "Staff");
				session.setAttribute("StaffUser", this);
			}
			if (role.getName().equalsIgnoreCase("student")) {
				session.setAttribute("LoginUserRole", "Student");
				session.setAttribute("StudentUser", this);
			}
		}

	}

	public User() {
	};

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

	public List<Application> getApplication() {
		return application;
	}

	public User(Integer id, String first_name, String last_name, String email, String password, List<UserRoles> role,
			List<Application> application) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.application = application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", application=" + application + "]";
	}

}
