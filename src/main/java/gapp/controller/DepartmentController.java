package gapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import gapp.model.AdditionalFields;
import gapp.model.Application;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.User;
import gapp.model.dao.AdditionalFieldsDao;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.UserDao;

@Controller
@SessionAttributes("department")
public class DepartmentController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private ApplicationDao applicationDao;

	@Autowired
	private ProgramDao programDao;

	@Autowired
	private AdditionalFieldsDao additionalFieldsdao;

	@RequestMapping("/departments.html")
	public String list(ModelMap model) {
		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> program = programDao.getprogramcount();

		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", program);

		return "departments";

	}

	@RequestMapping("/viewDepartment.html")
	public String add(@RequestParam Integer id, ModelMap model) {

		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> programs = programDao.getprogramcount();

		Department department = departmentDao.getDepartmentById(id);
		List<AdditionalFields> additionalField = additionalFieldsdao.getAdditionalFieldByDepartment(department);
		List<Program> program = programDao.getProgramByDeptId(id);

		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", programs);

		model.put("department", department);
		model.put("program", program);
		model.put("additionalfield", additionalField);

		return "viewDepartment";

	}

	@RequestMapping(value = "/adddepartment.html", method = RequestMethod.GET)
	public String add(ModelMap model) {

		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> program = programDao.getprogramcount();
		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", program);
		model.put("department", new Department());
		return "adddept";
	}

	@RequestMapping(value = "/adddepartment.html", method = RequestMethod.POST)
	public String add(@ModelAttribute Department department, BindingResult result) {
		department = departmentDao.savedepartment(department);
		// redirect to user list
		return "redirect:departments.html"; // why not user/list ???
	}

	@RequestMapping(value = "/addprograms.html", method = RequestMethod.GET)
	public String addprogram(@RequestParam Integer id, ModelMap model) {

		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> program = programDao.getprogramcount();

		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", program);

		Department department = departmentDao.getDepartmentById(id);
		Program p = new Program();
		model.put("program", p);
		model.put("departmentId", id);
		model.put("departmentname", department);
		return "addprograms";
	}

	@RequestMapping(value = "/addprograms.html", method = RequestMethod.POST)
	public String addprogram(@ModelAttribute Program program, @RequestParam(name = "departmentId") Integer departmentId,
			BindingResult result) {

		Department department = departmentDao.getDepartmentById(departmentId);
		program.setDepartment(department);
		program = programDao.saveProgram(program);
		return "redirect:departments.html"; // why not user/list ???
	}

	@RequestMapping(value = "/addfield.html", method = RequestMethod.GET)
	public String addfield(@RequestParam Integer id, ModelMap model) {

		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> program = programDao.getprogramcount();
		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", program);

		AdditionalFields additionalFields = new AdditionalFields();
		Department department = departmentDao.getDepartmentById(id);
	//	additionalFields.setIsRequired(true);
		model.put("AdditionalFields", additionalFields);
		model.put("departmentId", id);
		model.put("departmentname", department);

		return "addfield";
	}

	@RequestMapping(value = "/addfield.html", method = RequestMethod.POST)
	public String addfield(@ModelAttribute AdditionalFields additionalFields,
			@RequestParam(name = "departmentId") Integer departmentId, BindingResult result) {

		Department department = departmentDao.getDepartmentById(departmentId);
		additionalFields.setDepartment(department);
		additionalFields = departmentDao.saveAddField(additionalFields);
		return "redirect:departments.html"; // why not user/list ???
	}

	@RequestMapping(value = "/editDepartment.html", method = RequestMethod.GET)
	public String Edit(@RequestParam Integer id, ModelMap model) {

		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> programs = programDao.getprogramcount();
		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", programs);

		Department department = departmentDao.getDepartmentById(id);
		List<AdditionalFields> additionalField = additionalFieldsdao.getAdditionalFieldByDepartment(department);
		List<Program> program = programDao.getProgramByDeptId(id);
		model.put("department", department);
		model.put("program", program);
		model.put("additionalfield", additionalField);

		// user = userDao.saveuser(user);
		// status.setComplete();
		// return "redirect:list.html";

		return "editDepartment";
	}

	@RequestMapping(value = "/editDepartment.html", method = RequestMethod.POST)
	public String Edit(@RequestParam Integer id, @ModelAttribute Department department, SessionStatus status) {

		department = departmentDao.savedepartment(department);

		status.setComplete();
		return "redirect:editDepartment.html?id=" + department.getId();
	}

	@RequestMapping(value = "/RemoveProgram.html", method = RequestMethod.GET)
	public String RemoveProgram(@RequestParam Integer id, @RequestParam Integer departmentId, ModelMap model) {

		int deptId = departmentId;
		int progId = id;

		System.out.println("program" + progId + " and dept id" + deptId);
		Department department = departmentDao.getDepartmentById(deptId);
		Program program = programDao.getProgramByProgAndDeptId(progId, department);

		System.out.println("****************************************\n\n");
		System.out.println("program to delete" + program);
		System.out.println("\n\n****************************************");
		programDao.removeProgram(program);

		// return "{status:\"delete\"}";

		return "redirect:/editDepartment.html?id=" + deptId;

	}

	@RequestMapping(value = "/RemoveField.html", method = RequestMethod.GET)
	public String RemoveField(@RequestParam Integer id, @RequestParam Integer departmentId, ModelMap model) {

		int deptId = departmentId;
		int fieldId = id;

		System.out.println("field id" + fieldId + " and dept id" + deptId);
		Department department = departmentDao.getDepartmentById(deptId);
		AdditionalFields additionalField = additionalFieldsdao.getFieldByFieldAndDeptId(fieldId, department);

		System.out.println("***************\n\n" + additionalField);
		additionalFieldsdao.removeField(additionalField);

		return "redirect:/editDepartment.html?id=" + deptId;

	}

	@RequestMapping(value = "/addProgramsForEditPage.html", method = RequestMethod.GET)
	public String EditAddprograms(@RequestParam Integer id, ModelMap model) {

		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> program = programDao.getprogramcount();

		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", program);

		Department department = departmentDao.getDepartmentById(id);
		Program p = new Program();
		model.put("program", p);
		model.put("departmentId", id);
		model.put("departmentname", department);

		return "addProgramsForEditPage";
	}

	@RequestMapping(value = "/addProgramsForEditPage.html", method = RequestMethod.POST)
	public String EditAddprograms(@ModelAttribute Program program,
			@RequestParam(name = "departmentId") Integer departmentId, BindingResult result) {

		Department department = departmentDao.getDepartmentById(departmentId);
		program.setDepartment(department);
		program = programDao.saveProgram(program);
		return "redirect:/editDepartment.html?id=" + departmentId;

	}

	@RequestMapping(value = "/addFieldForEditPage.html", method = RequestMethod.GET)
	public String EditAddField(@RequestParam Integer id, ModelMap model) {

		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> program = programDao.getprogramcount();
		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", program);

		AdditionalFields additionalFields = new AdditionalFields();
		Department department = departmentDao.getDepartmentById(id);
		model.put("AdditionalFields", additionalFields);
		model.put("departmentId", id);
		model.put("departmentname", department);

		return "addFieldForEditPage";
	}

	@RequestMapping(value = "/addFieldForEditPage.html", method = RequestMethod.POST)
	public String EditAddField(@ModelAttribute AdditionalFields additionalFields,
			@RequestParam(name = "departmentId") Integer departmentId, BindingResult result) {

		Department department = departmentDao.getDepartmentById(departmentId);
		additionalFields.setDepartment(department);
		additionalFields = departmentDao.saveAddField(additionalFields);
		return "redirect:/editDepartment.html?id=" + departmentId;
	}

	// Add new department -in single page add field and program implementation

	/*@RequestMapping(value = "/AddNewDepartment.html", method = RequestMethod.GET)
	public String addNewDept(ModelMap model) {

		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> program = programDao.getprogramcount();
		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", program);
		model.put("department", new Department());

		return "AddNewDepartment";

	}

	@RequestMapping(value = "/AddNewDepartment.html", method = RequestMethod.POST)
	public String addNewDept(@ModelAttribute Department department,@RequestParam Integer Textbox1, BindingResult result) {
		// department = departmentDao.savedepartment(department);
		// // redirect to user list
		
		System.out.println("textbox1"+Textbox1);
		return "redirect:AddNewDepartment.html?id=" + department.getId();
	}*/

}