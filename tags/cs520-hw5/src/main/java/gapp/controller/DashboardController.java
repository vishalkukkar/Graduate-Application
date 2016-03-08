package gapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import gapp.model.Application;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.User;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.UserDao;

@Controller
@SessionAttributes("dashboard")
public class DashboardController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private ApplicationDao applicationDao;

	@Autowired
	private ProgramDao programDao;

	@RequestMapping("/dashboard.html")
	public String list(ModelMap model) {

		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> program = programDao.getprogramcount();

		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", program);

		return "dashboard";

	}

	

}
