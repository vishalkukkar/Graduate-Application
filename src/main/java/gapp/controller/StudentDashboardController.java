package gapp.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.security.SecureRandom;
import java.math.BigInteger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
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
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gapp.model.AdditionalFields;
import gapp.model.AdditionalFieldsvalueStore;
import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.Department;
import gapp.model.EducationalBackground;
import gapp.model.Program;
import gapp.model.Status;
import gapp.model.TermStatus;
import gapp.model.User;
import gapp.model.dao.AdditionalFieldsDao;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.EducationalBackgroundDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.TermStatusDao;
import gapp.model.dao.UserDao;

@Controller
@SessionAttributes("studentdashboard")
public class StudentDashboardController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private ApplicationDao applicationDao;

	@Autowired
	private ProgramDao programDao;

	@Autowired
	private EducationalBackgroundDao educationalBackgroundDao;

	@Autowired
	private AdditionalFieldsDao additionalFieldsDao;

	@Autowired
	private TermStatusDao termStatusDao;

	private SecureRandom random = new SecureRandom();

	public String getRandomString(String filename) {
		StringBuilder sb = new StringBuilder();
		String extension = filename.split("\\.")[1];
		String temp = new BigInteger(100, random).toString(32);
		sb.append(temp).append(".").append(extension);
		System.out.println("file");
		return sb.toString();
	}

	@RequestMapping("/Studentdashboard.html")
	public String viewapp(ModelMap model, @RequestParam int id) {
		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplicationByUserId(id);
		List<Program> program = programDao.getprogramcount();
		// List<Status> status = applicationDao.getAllStatus();

		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", program);
		model.put("userid", id);

		return "studentdashboard";

	}

	@RequestMapping("/viewapplication.html")
	public String add(@RequestParam Integer id, @RequestParam Integer deptid, @RequestParam Integer progid,
			@RequestParam(name = "appId") int appId, ModelMap model) {

		// TermStatus termStatus = termStatusDao.getterm(termid);
		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> programs = programDao.getprogramcount();
		// List<AdditionalFields> additionalFields = additionalFieldsDao.g
		model.put("File", "File");
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("users", users);
		model.put("programs", programs);

		System.out.println("department id****************" + deptid);

		User user = userDao.getUser(id);
		Department department = departmentDao.getDepartmentById(deptid);

		Application application = applicationDao.getAppById(appId);
		List<EducationalBackground> educationalBackground = educationalBackgroundDao.getEduByappId(application.getId());

		model.put("user", user);
		model.put("userid", id);
		model.put("application", application);
		model.put("educationalBackground", educationalBackground);
		model.put("department", department);
		model.put("deptId", deptid);
		return "viewapplication";

	}

	@RequestMapping(value = "/Editapplication.html", method = RequestMethod.GET)
	public String editApplication(@RequestParam Integer id, @RequestParam Integer deptid, @RequestParam Integer progid,
			@RequestParam(name = "appId") Integer appId,@RequestParam(name="termname") String termname, ModelMap model) {

		// TermStatus termStatus = termStatusDao.getterm(termId);
		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplications();
		List<Program> programs = programDao.getprogramcount();
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("users", users);
		model.put("programs", programs);
		model.put("File","File");
		model.put("Number","Number");
		model.put("Text","Text");
		System.out.println("department id****************" + deptid);

		User user = userDao.getUser(id);
		Department department = departmentDao.getDepartmentById(deptid);
		// Program program = programDao.getProgramById(progid);
		List<Program> allprograms = programDao.getProgramByDeptId(deptid);
		/*
		 * Application application =
		 * applicationDao.getApplicationByDepartmentIdAndUserId(user,
		 * department, program, termStatus);
		 */
		Application application = applicationDao.getAppById(appId);
		List<EducationalBackground> educationalBackground = educationalBackgroundDao.getEduByappId(application.getId());
		model.put("user", user);
		model.put("userid", id);
		model.put("application", application);
		model.put("educationalBackground", educationalBackground);

		model.put("department", department);
		model.put("allprograms", allprograms);
		model.put("selectedprog", progid);
		model.put("selectedterm",termname);
		return "editapplication";

	}

	@RequestMapping(value = "/Editapplication.html", method = RequestMethod.POST, params = "editsubmit")
	public String editApplication(

			@RequestParam("uploadfile[]") MultipartFile[] multiplefiles,
			@RequestParam(name = "textvalue[]", required = false) String[] textvalue,
			@RequestParam(name = "numbervalue[]", required = false) String[] numbervalue,
			@RequestParam(name = "addfieldPair[]", required = false) String[] addfieldPair,

			@RequestParam(name = "university[]", required = false) String[] university,
			@RequestParam(name = "degree[]", required = false) String[] degree,
			@RequestParam(name = "major[]", required = false) String[] major,
			@RequestParam(name = "startDate[]", required = false) String[] startDate,
			@RequestParam(name = "endDate[]", required = false) String[] endDate,
			@RequestParam(name = "educount", required = false) int count,

			@RequestParam(name = "firstname", required = false) String firstname,
			@RequestParam(name = "lastname", required = false) String lastname,
			@RequestParam(name = "email", required = false) String email,

			@RequestParam(name = "termname") String termname,
			@RequestParam(name = "termyear", required = false) String termyear,
			@RequestParam(name = "termId", required = false) int termId,

			@RequestParam(name = "deptId") Integer deptId, @RequestParam(name = "progId") Integer progId,

			@RequestParam(value = "uploadtrascript", required = false) MultipartFile file,
			@RequestParam(name = "userId") int userId, @ModelAttribute Application application, BindingResult result,
			RedirectAttributes redirectAttributes, HttpSession session,

			SessionStatus sessionstatus, ModelMap model, HttpSession session1)
					throws IllegalStateException, IOException, ParseException, MultipartException {

		if (result.hasErrors()) {
			System.out.println("resulr error" + result.getAllErrors());

		}
		

		// save user to application
		User user = userDao.getUser(userId);
		application.setUser(user);

		// save transcript file
		if (file != null && !file.isEmpty() && !file.getOriginalFilename().equals("") && !file.equals(null)) {
			String filename = getRandomString(file.getOriginalFilename());

			file.transferTo(new File(getFileDirectory(), filename));
			application.setTranscript(filename);
			System.out.println("department name" + deptId);

		}

		System.out.println("application print" + application.toString());
		System.out.println(application.getDate() + "cin" + application.getCin());

		// save program
		Program program = programDao.getProgramById(progId);
		application.setProgram(program);

		// save term status
		TermStatus termStatus = termStatusDao.getterm(termId);
		termStatus.setTerm(termname);
		termStatus.setYear(termyear);
		application.setTermStatus(termStatus);

		// save application
		System.out.println("get date" + application.getDate());
		application.setDate(new Date());
		Application app = applicationDao.save(application);

		String fId = "";
		String type = "";
		String value = "";
		int updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];
					value = filestore[2];
					System.out.println("\n\nfid = " + fId + "\ntype" + type + "\n value"+value);
					if (type.equals("File")) {

						//Department department = departmentDao.getDepartmentById(deptId);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));
						AdditionalFieldsvalueStore additionalFieldsvalueStore = additionalFieldsDao.getAddValueById(Integer.parseInt(value));
						additionalFieldsvalueStore.setApplication(app);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);

						if (multiplefiles != null && multiplefiles.length > 0 && !multiplefiles[updatecount].equals("")
								&& !(multiplefiles[updatecount]).isEmpty() && (multiplefiles[updatecount]) != null
								&& (multiplefiles[updatecount]).getBytes().length > 0) {

							String storeFile = getRandomString(multiplefiles[updatecount].getOriginalFilename());
							multiplefiles[updatecount].transferTo(new File(getFileDirectory(), storeFile));

							additionalFieldsvalueStore.setValue(storeFile);

						}

						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}

				}

			}
		} catch (Exception e) {
			System.out.println("exception" + e.getCause());

		}

		// number in additional field

		updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					// System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];
					value = filestore[2];

					System.out.println("\nNUMBER\nfid = " + fId + "\ntype" + type + "\n value"+value);
					if (type.equals("Number")) {

						Department department = departmentDao.getDepartmentById(deptId);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));

						System.out.println("department---" + department.getName() + "\n\nadd field"
								+ additionalFields.getFieldName());
						AdditionalFieldsvalueStore additionalFieldsvalueStore = additionalFieldsDao.getAddValueById(Integer.parseInt(value));
						additionalFieldsvalueStore.setApplication(app);
						System.out.println("application" + app.getId());

						System.out.println("\nnumber[updatecount]" + numbervalue[updatecount]);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);
						//if (numbervalue.length > 0 && !numbervalue[updatecount].equals("")) {
							additionalFieldsvalueStore.setValue(numbervalue[updatecount]);
						//}
						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}
				}

			}
		} catch (Exception ex) {
			System.out.println("exception" + ex.getCause());

		}

		// additional field text
		updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];
					value = filestore[2];
					System.out.println("\nText\nfid = " + fId + "\ntype" + type + "\n");

					if (type.equals("Text")) {

						Department department = departmentDao.getDepartmentById(deptId);
						System.out.println("-------FID-------" + fId);
						System.out.println("--------type------" + type);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));

						System.out.println("department---" + department.getName() + "\n\nadd field"
								+ additionalFields.getFieldName());
						AdditionalFieldsvalueStore additionalFieldsvalueStore = additionalFieldsDao.getAddValueById(Integer.parseInt(value));
						additionalFieldsvalueStore.setApplication(app);
						System.out.println("application" + app.getId());

						System.out.println("\ntextvalue[updatecount]" + textvalue[updatecount]);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);
						//if (textvalue.length > 0 && !textvalue[updatecount].equals("")) {
							additionalFieldsvalueStore.setValue(textvalue[updatecount]);
						//}
						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}
				}

			}
		} catch (Exception ex) {
			System.out.println("exception" + ex.getCause());
		}
		
		
		// if submitted then get status submit and add it to application status
		Status status = applicationDao.getStatusByName("Submitted");

		// save Apllication Status to submitted
		ApplicationStatus applicationStatus = new ApplicationStatus();
		applicationStatus.setApplication(app);
		applicationStatus.setComment("application submitted after edit");

		// save start and end date with parcer

		applicationStatus.setCreate_date(new Date());
		applicationStatus.setRevised_date(new Date());
		applicationStatus.setStatus(status);
		applicationDao.saveAppStatus(applicationStatus);

		// save edu background

		System.out.println("count" + count);

		for (int i = 0; i < count; i++) {
			if (major.length == 0 && university.length == 0 && degree.length == 0 && startDate.length == 0
					&& endDate.length == 0) {

				System.out.println("in this block\n\n\n");

			} else {
				EducationalBackground educationalBackground = new EducationalBackground();

				try {
					if (university.length != 0)
						educationalBackground.setUniversityname(university[i]);

					if (degree.length != 0)
						educationalBackground.setDegreeEarned(degree[i]);

					if (major.length != 0)
						educationalBackground.setMajor(major[i]);

					if (startDate.length != 0)
						educationalBackground.setStartDate(startDate[i]);

					if (endDate.length != 0)
						educationalBackground.setEndDate(endDate[i]);
					educationalBackground.setApplication(app);
					//EducationalBackground educationalBackground2 =
							applicationDao
							.saveEduBackground(educationalBackground);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("exception thrown\n\n\n" + e.getMessage());
					e.printStackTrace();
				}
			}

		}

		sessionstatus.setComplete();
		return "redirect:Studentdashboard.html?id=" + userId;
	}
	
	
	@RequestMapping(value = "/Editapplication.html", method = RequestMethod.POST, params = "editsave")
	public String editApplication(

			@RequestParam("uploadfile[]") MultipartFile[] multiplefiles,
			@RequestParam(name = "textvalue[]", required = false) String[] textvalue,
			@RequestParam(name = "numbervalue[]", required = false) String[] numbervalue,
			@RequestParam(name = "addfieldPair[]", required = false) String[] addfieldPair,

			@RequestParam(name = "university[]", required = false) String[] university,
			@RequestParam(name = "degree[]", required = false) String[] degree,
			@RequestParam(name = "major[]", required = false) String[] major,
			@RequestParam(name = "startDate[]", required = false) String[] startDate,
			@RequestParam(name = "endDate[]", required = false) String[] endDate,
			@RequestParam(name = "educount", required = false) int count,

			@RequestParam(name = "firstname", required = false) String firstname,
			@RequestParam(name = "lastname", required = false) String lastname,
			@RequestParam(name = "email", required = false) String email,

			@RequestParam(name = "termname") String termname,
			@RequestParam(name = "termyear", required = false) String termyear,
			@RequestParam(name = "termId", required = false) int termId,
			@RequestParam(name = "dummy", required = false) String dummy,

			@RequestParam(name = "deptId") Integer deptId, @RequestParam(name = "progId") Integer progId,

			@RequestParam(value = "uploadtrascript", required = false) MultipartFile file,
			@RequestParam(name = "userId") int userId, @ModelAttribute Application application, BindingResult result,
			RedirectAttributes redirectAttributes, HttpSession session,

			SessionStatus sessionstatus, ModelMap model, HttpSession session1)
					throws IllegalStateException, IOException, ParseException, MultipartException {

		if (result.hasErrors()) {
			System.out.println("resulr error" + result.getAllErrors());

		}
		

		// save user to application
		User user = userDao.getUser(userId);
		application.setUser(user);

		// save transcript file
		if (file != null && !file.isEmpty() && !file.getOriginalFilename().equals("") && !file.equals(null)) {
			String filename = getRandomString(file.getOriginalFilename());

			file.transferTo(new File(getFileDirectory(), filename));
			application.setTranscript(filename);
			System.out.println("department name" + deptId);

		}

		System.out.println("application print" + application.toString());
		System.out.println(application.getDate() + "cin" + application.getCin());

		// save program
		Program program = programDao.getProgramById(progId);
		application.setProgram(program);

		// save term status
		TermStatus termStatus = termStatusDao.getterm(termId);
		termStatus.setTerm(termname);
		termStatus.setYear(termyear);
		application.setTermStatus(termStatus);

		// save application
		System.out.println("get date" + application.getDate());
		application.setDate(new Date());
		Application app = applicationDao.save(application);

		String fId = "";
		String type = "";
		String value = "";
		int updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];
					value = filestore[2];
					System.out.println("\n\nfid = " + fId + "\ntype" + type + "\n value"+value);
					if (type.equals("File")) {

						//Department department = departmentDao.getDepartmentById(deptId);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));
						AdditionalFieldsvalueStore additionalFieldsvalueStore = additionalFieldsDao.getAddValueById(Integer.parseInt(value));
						additionalFieldsvalueStore.setApplication(app);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);

						if (multiplefiles != null && multiplefiles.length > 0 && !multiplefiles[updatecount].equals("")
								&& !(multiplefiles[updatecount]).isEmpty() && (multiplefiles[updatecount]) != null
								&& (multiplefiles[updatecount]).getBytes().length > 0) {

							String storeFile = getRandomString(multiplefiles[updatecount].getOriginalFilename());
							multiplefiles[updatecount].transferTo(new File(getFileDirectory(), storeFile));

							additionalFieldsvalueStore.setValue(storeFile);

						}

						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}

				}

			}
		} catch (Exception e) {
			System.out.println("exception" + e.getCause());

		}

		// number in additional field

		updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					// System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];
					value = filestore[2];

					System.out.println("\nNUMBER\nfid = " + fId + "\ntype" + type + "\n value"+value);
					if (type.equals("Number")) {

						Department department = departmentDao.getDepartmentById(deptId);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));

						System.out.println("department---" + department.getName() + "\n\nadd field"
								+ additionalFields.getFieldName());
						AdditionalFieldsvalueStore additionalFieldsvalueStore = additionalFieldsDao.getAddValueById(Integer.parseInt(value));
						additionalFieldsvalueStore.setApplication(app);
						System.out.println("application" + app.getId());

						System.out.println("\nnumber[updatecount]" + numbervalue[updatecount]);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);
						//if (numbervalue.length > 0 && !numbervalue[updatecount].equals("")) {
							additionalFieldsvalueStore.setValue(numbervalue[updatecount]);
						//}
						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}
				}

			}
		} catch (Exception ex) {
			System.out.println("exception" + ex.getCause());

		}

		// additional field text
		updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];
					value = filestore[2];
					System.out.println("\nText\nfid = " + fId + "\ntype" + type + "\n");

					if (type.equals("Text")) {

						Department department = departmentDao.getDepartmentById(deptId);
						System.out.println("-------FID-------" + fId);
						System.out.println("--------type------" + type);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));

						System.out.println("department---" + department.getName() + "\n\nadd field"
								+ additionalFields.getFieldName());
						AdditionalFieldsvalueStore additionalFieldsvalueStore = additionalFieldsDao.getAddValueById(Integer.parseInt(value));
						additionalFieldsvalueStore.setApplication(app);
						System.out.println("application" + app.getId());

						System.out.println("\ntextvalue[updatecount]" + textvalue[updatecount]);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);
						//if (textvalue.length > 0 && !textvalue[updatecount].equals("")) {
							additionalFieldsvalueStore.setValue(textvalue[updatecount]);
						//}
						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}
				}

			}
		} catch (Exception ex) {
			System.out.println("exception" + ex.getCause());
		}
		
		
		// if submitted then get status submit and add it to application status
		Status status = applicationDao.getStatusByName("Not Submitted");

		// save Apllication Status to submitted
		ApplicationStatus applicationStatus = new ApplicationStatus();
		applicationStatus.setApplication(app);
		applicationStatus.setComment("application submitted after edit");

		// save start and end date with parcer

		applicationStatus.setCreate_date(new Date());
		applicationStatus.setRevised_date(new Date());
		applicationStatus.setStatus(status);
		applicationDao.saveAppStatus(applicationStatus);

		// save edu background

		System.out.println("count" + count);

		for (int i = 0; i < count; i++) {
			if (major.length == 0 && university.length == 0 && degree.length == 0 && startDate.length == 0
					&& endDate.length == 0) {

				System.out.println("in this block\n\n\n");

			} else {
				EducationalBackground educationalBackground = new EducationalBackground();

				try {
					if (university.length != 0)
						educationalBackground.setUniversityname(university[i]);

					if (degree.length != 0)
						educationalBackground.setDegreeEarned(degree[i]);

					if (major.length != 0)
						educationalBackground.setMajor(major[i]);

					if (startDate.length != 0)
						educationalBackground.setStartDate(startDate[i]);

					if (endDate.length != 0)
						educationalBackground.setEndDate(endDate[i]);
					educationalBackground.setApplication(app);
					//EducationalBackground educationalBackground2 =
					applicationDao
							.saveEduBackground(educationalBackground);
				} catch (ArrayIndexOutOfBoundsException e) {
					
					System.out.println("exception thrown\n\n\n" + e.getMessage());
					e.printStackTrace();
				}
			}

		}

		sessionstatus.setComplete();
		return "redirect:Studentdashboard.html?id=" + userId;
	}

	/*@RequestMapping(value = "/Editapplication.html", method = RequestMethod.POST, params = "editsave")
	public String editApplication(@RequestParam(name = "university", required = false) String university,
			@RequestParam(name = "degree", required = false) String degree,
			@RequestParam(name = "major", required = false) String major,
			@RequestParam(name = "dummy", required = false) String dummy,
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate,

			@RequestParam(name = "firstname", required = false) String firstname,
			@RequestParam(name = "lastname", required = false) String lastname,
			@RequestParam(name = "email", required = false) String email,

			@RequestParam(name = "termname") String termname,
			@RequestParam(name = "termyear", required = false) String termyear,
			@RequestParam(name = "termId", required = false) int termId,

			@RequestParam(name = "deptId") Integer deptId, @RequestParam(name = "progId") Integer progId,

			@RequestParam(value = "uploadtrascript", required = false) MultipartFile file,
			@RequestParam(name = "userId") int userId,

			@ModelAttribute("application") Application application, BindingResult result, SessionStatus sessionstatus,
			ModelMap model) throws IllegalStateException, IOException, ParseException, MultipartException {
		return "";

	}*/

	@RequestMapping(value = "/addapplication.html", method = RequestMethod.GET)
	public String addapp(ModelMap model, @RequestParam int id) {
		List<User> users = userDao.getUsers();
		List<Department> departments = departmentDao.getDepartments();
		List<Application> applications = applicationDao.getApplicationByUserId(id);
		List<Program> program = programDao.getprogramcount();

		model.put("users", users);
		model.put("departments", departments);
		model.put("applications", applications);
		model.put("programs", program);
		model.put("educount", 1);

		// User user = userDao.getUser(id);
		Application application = new Application();
		model.put("application", application);
		model.put("userid", id);
		return "addapplication";

	}

	@Autowired
	private ServletContext context;

	private File getFileDirectory() {

		String path = context.getRealPath("/WEB-INF/files/");
		File file = new File(path);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("file created");
			}
		}
		return file;
	}

	@RequestMapping(value = "/addapplication.html", method = RequestMethod.POST, params = "submit")
	public String addapp(@ModelAttribute Application application, BindingResult result,
			RedirectAttributes redirectAttributes, @RequestParam(value = "file", required = false) MultipartFile file,

			@RequestParam("uploadfile[]") MultipartFile[] multiplefiles,
			@RequestParam(name = "textvalue[]", required = false) String[] textvalue,
			@RequestParam(name = "numbervalue[]", required = false) String[] numbervalue,
			@RequestParam(name = "addfieldPair[]", required = false) String[] addfieldPair,
			
//			@RequestParam(name = "uploadFileFieldName[]", required = false) String[] uploadFileFieldName,
//			@RequestParam(name = "TextFieldName[]", required = false) String[] TextFieldName,
//			@RequestParam(name = "NumberFieldName[]", required = false) String[] NumberFieldName,
			

			@RequestParam(name = "university[]", required = false) String[] university,
			@RequestParam(name = "degree[]", required = false) String[] degree,
			@RequestParam(name = "major[]", required = false) String[] major,
			@RequestParam(name = "startDate[]", required = false) String[] startDate,
			@RequestParam(name = "endDate[]", required = false) String[] endDate,
			@RequestParam(name = "educount", required = false) int count,

			@RequestParam(name = "termname") String termname,
			@RequestParam(name = "termyear", required = false) String termyear,
			@RequestParam(name = "deptId") Integer deptId,
			@RequestParam(name = "userid", required = false) Integer userid,
			@RequestParam(name = "progId") Integer progId, ModelMap model, HttpSession session,
			SessionStatus sessionstatus) throws IllegalStateException, IOException, ParseException, MultipartException {

		if (result.hasErrors()) {
			return "redirect:/Studentdashboard.html?id=" + userid;

		}

		// handle program errror
		if (progId == null || progId == 0) {
			System.out.println("**************in if**************");
			//Department dept = departmentDao.getDepartmentById(deptId);
			System.out.println("\n\n\n\nerror\n\n" + result.getAllErrors());
			session.setAttribute("programerror", "Please select program to save/submit application");
			return "redirect:/addapplication.html?id=" + userid;

		}
		// save transcript file
		if (file != null && !file.isEmpty() && !file.getOriginalFilename().equals("") && !file.equals(null)) {
			String filename = getRandomString(file.getOriginalFilename());

			file.transferTo(new File(getFileDirectory(), filename));
			application.setTranscript(filename);
			System.out.println("department name" + deptId);

		}

		// save user
		User user = userDao.getUser(userid);
		application.setUser(user);

		// save program
		Program program = programDao.getProgramById(progId);
		application.setProgram(program);

		// save term status
		TermStatus termStatus = new TermStatus();
		termStatus.setTerm(termname);
		termStatus.setYear(termyear);
		application.setTermStatus(termStatus);

		// save application
		application.setDate(new Date());
		Application app = applicationDao.save(application);

		// ***********************

		String fId = "";
		String type = "";
		int updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];
					System.out.println("\n\nfid = " + fId + "\ntype" + type + "\n");
					if (type.equals("File")) {

						//Department department = departmentDao.getDepartmentById(deptId);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));
						AdditionalFieldsvalueStore additionalFieldsvalueStore = new AdditionalFieldsvalueStore();
						additionalFieldsvalueStore.setApplication(app);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);

						if (multiplefiles != null && multiplefiles.length > 0 && !multiplefiles[updatecount].equals("")
								&& !(multiplefiles[updatecount]).isEmpty() && (multiplefiles[updatecount]) != null
								&& (multiplefiles[updatecount]).getBytes().length > 0) {

							String storeFile = getRandomString(multiplefiles[updatecount].getOriginalFilename());
							multiplefiles[updatecount].transferTo(new File(getFileDirectory(), storeFile));

							additionalFieldsvalueStore.setValue(storeFile);

						}

						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}

				}

			}
		} catch (Exception e) {
			System.out.println("exception" + e.getCause());

		}

		// number in additional field

		updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					// System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];

					if (type.equals("Number")) {

						Department department = departmentDao.getDepartmentById(deptId);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));

						System.out.println("department---" + department.getName() + "\n\nadd field"
								+ additionalFields.getFieldName());
						AdditionalFieldsvalueStore additionalFieldsvalueStore = new AdditionalFieldsvalueStore();
						additionalFieldsvalueStore.setApplication(app);
						System.out.println("application" + app.getId());

						System.out.println("\nnumber[updatecount]" + numbervalue[updatecount]);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);
						if (numbervalue.length > 0 && !numbervalue[updatecount].equals("")) {
							additionalFieldsvalueStore.setValue(numbervalue[updatecount]);
						}
						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}
				}

			}
		} catch (Exception ex) {
			System.out.println("exception" + ex.getCause());

		}

		// additional field text
		updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];
					System.out.println("\n\nfid = " + fId + "\ntype" + type + "\n");

					if (type.equals("Text")) {

						Department department = departmentDao.getDepartmentById(deptId);
						System.out.println("-------FID-------" + fId);
						System.out.println("--------type------" + type);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));

						System.out.println("department---" + department.getName() + "\n\nadd field"
								+ additionalFields.getFieldName());
						AdditionalFieldsvalueStore additionalFieldsvalueStore = new AdditionalFieldsvalueStore();
						additionalFieldsvalueStore.setApplication(app);
						System.out.println("application" + app.getId());

						System.out.println("\ntextvalue[updatecount]" + textvalue[updatecount]);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);
						if (textvalue.length > 0 && !textvalue[updatecount].equals("")) {
							additionalFieldsvalueStore.setValue(textvalue[updatecount]);
						}
						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}
				}

			}
		} catch (Exception ex) {
			System.out.println("exception" + ex.getCause());
		}

		// get status submitted and add it to application status
		Status status = applicationDao.getStatusByName("Submitted");
		// save Apllication Status to submitted
		ApplicationStatus applicationStatus = new ApplicationStatus();
		applicationStatus.setApplication(app);
		applicationStatus.setComment("application submitted");
		applicationStatus.setCreate_date(new Date());
		applicationStatus.setRevised_date(new Date());
		applicationStatus.setStatus(status);
		applicationDao.saveAppStatus(applicationStatus);

		System.out.println("count" + count);
		for (int i = 0; i < count; i++) {
			if (major.length == 0 && university.length == 0 && degree.length == 0 && startDate.length == 0
					&& endDate.length == 0) {

			} else {
				EducationalBackground educationalBackground = new EducationalBackground();

				try {
					if (university.length != 0)
						educationalBackground.setUniversityname(university[i]);

					if (degree.length != 0)
						educationalBackground.setDegreeEarned(degree[i]);

					if (major.length != 0)
						educationalBackground.setMajor(major[i]);

					if (startDate.length != 0)
						educationalBackground.setStartDate(startDate[i]);

					if (endDate.length != 0)
						educationalBackground.setEndDate(endDate[i]);

					educationalBackground.setApplication(app);
					//EducationalBackground educationalBackground2 =
					applicationDao
							.saveEduBackground(educationalBackground);

				} catch (ArrayIndexOutOfBoundsException exc) {
					
					System.out.println("exception" + exc.getMessage());

				}
			}

		}

		sessionstatus.setComplete();
		session.removeAttribute("programerror");
		return "redirect:/Studentdashboard.html?id=" + userid;

	}

	@RequestMapping("/download.html")
	public String downloadfile(@RequestParam String filename, HttpServletResponse response) throws IOException {

		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);

		// read file
		FileInputStream in = new FileInputStream(new File(getFileDirectory(), filename));
		OutputStream out = response.getOutputStream();

		// write it to response

		byte buffer[] = new byte[2048];
		int bytesread;

		while ((bytesread = in.read(buffer)) > 0)
			out.write(buffer, 0, bytesread);
		in.close();
		return null;

	}

	@RequestMapping(value = "/addapplication.html", method = RequestMethod.POST, params = "save")
	public String addapp(@ModelAttribute Application application, BindingResult result,
			RedirectAttributes redirectAttributes, @RequestParam(value = "file", required = false) MultipartFile file,

			@RequestParam("uploadfile[]") MultipartFile[] multiplefiles,
			@RequestParam(name = "textvalue[]", required = false) String[] textvalue,
			@RequestParam(name = "numbervalue[]", required = false) String[] numbervalue,

			@RequestParam(name = "uploadFileFieldName[]", required = false) String[] uploadFileFieldName,
			@RequestParam(name = "TextFieldName[]", required = false) String[] TextFieldName,
			@RequestParam(name = "NumberFieldName[]", required = false) String[] NumberFieldName,
			@RequestParam(name = "addfieldPair[]", required = false) String[] addfieldPair,

			@RequestParam(name = "university[]", required = false) String[] university,
			@RequestParam(name = "degree[]", required = false) String[] degree,
			@RequestParam(name = "major[]", required = false) String[] major,
			@RequestParam(name = "startDate[]", required = false) String[] startDate,
			@RequestParam(name = "endDate[]", required = false) String[] endDate,
			@RequestParam(name = "educount", required = false) int count,
			@RequestParam(name = "dummy", required = false) String dummy,

			@RequestParam(name = "termname") String termname,
			@RequestParam(name = "termyear", required = false) String termyear,
			@RequestParam(name = "deptId") Integer deptId,
			@RequestParam(name = "userid", required = false) Integer userid,
			@RequestParam(name = "progId") Integer progId, ModelMap model, HttpSession session,
			SessionStatus sessionstatus) throws IllegalStateException, IOException, ParseException, MultipartException {

		if (result.hasErrors()) {
			return "redirect:/Studentdashboard.html?id=" + userid;

		}

		if (progId == null || progId == 0) {
			session.setAttribute("programerror", "Please select Department and program to save/submit application");
			return "redirect:/addapplication.html?id=" + userid;

		}
		// save transcript file
		if (file != null && !file.isEmpty() && !file.getOriginalFilename().equals("") && !file.equals(null)) {
			String filename = getRandomString(file.getOriginalFilename());

			file.transferTo(new File(getFileDirectory(), filename));
			application.setTranscript(filename);
			System.out.println("department name" + deptId);

		}

		// save user
		User user = userDao.getUser(userid);
		application.setUser(user);

		// save program
		Program program = programDao.getProgramById(progId);
		application.setProgram(program);

		// save term status
		TermStatus termStatus = new TermStatus();
		termStatus.setTerm(termname);
		termStatus.setYear(termyear);
		application.setTermStatus(termStatus);

		// save application
		SimpleDateFormat dateFormat = new SimpleDateFormat("m/d/yy");
		Date today = dateFormat.parse(dateFormat.format(new Date()));
		System.out.println("today" + today);
		application.setDate(today);
		Application app = applicationDao.save(application);

		// -------------------------Additional fields
		// store----------------------------------//

		String fId = "";
		String type = "";
		int updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];
					System.out.println("\n\nfid = " + fId + "\ntype" + type + "\n");
					if (type.equals("File")) {

						//Department department = 
								departmentDao.getDepartmentById(deptId);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));
						AdditionalFieldsvalueStore additionalFieldsvalueStore = new AdditionalFieldsvalueStore();
						additionalFieldsvalueStore.setApplication(app);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);

						if (multiplefiles != null && multiplefiles.length > 0 && !multiplefiles[updatecount].equals("")
								&& !(multiplefiles[updatecount]).isEmpty() && (multiplefiles[updatecount]) != null
								&& (multiplefiles[updatecount]).getBytes().length > 0) {

							String storeFile = getRandomString(multiplefiles[updatecount].getOriginalFilename());
							multiplefiles[updatecount].transferTo(new File(getFileDirectory(), storeFile));

							additionalFieldsvalueStore.setValue(storeFile);

						}

						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}

				}

			}
		} catch (Exception e) {
			System.out.println("exception" + e.getCause());

		}

		// number in additional field

		updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					// System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];

					if (type.equals("Number")) {

						Department department = departmentDao.getDepartmentById(deptId);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));

						System.out.println("department---" + department.getName() + "\n\nadd field"
								+ additionalFields.getFieldName());
						AdditionalFieldsvalueStore additionalFieldsvalueStore = new AdditionalFieldsvalueStore();
						additionalFieldsvalueStore.setApplication(app);
						System.out.println("application" + app.getId());

						System.out.println("\nnumber[updatecount]" + numbervalue[updatecount]);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);
						if (numbervalue.length > 0 && !numbervalue[updatecount].equals("")) {
							additionalFieldsvalueStore.setValue(numbervalue[updatecount]);
						}
						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}
				}

			}
		} catch (Exception ex) {
			System.out.println("exception" + ex.getCause());

		}

		// additional field text
		updatecount = 0;
		try {
			if (addfieldPair.length > 0) {
				for (int j = 0; j < addfieldPair.length; j++) {
					System.out.println("\n\nj value" + j);
					System.out.println("add fields\n" + addfieldPair[j]);
					String filestore[] = addfieldPair[j].split(":");
					fId = filestore[0];
					type = filestore[1];
					System.out.println("\n\nfid = " + fId + "\ntype" + type + "\n");

					if (type.equals("Text")) {

						Department department = departmentDao.getDepartmentById(deptId);
						System.out.println("-------FID-------" + fId);
						System.out.println("--------type------" + type);
						AdditionalFields additionalFields = additionalFieldsDao
								.getAdditionalFieldById(Integer.parseInt(fId));

						System.out.println("department---" + department.getName() + "\n\nadd field"
								+ additionalFields.getFieldName());
						AdditionalFieldsvalueStore additionalFieldsvalueStore = new AdditionalFieldsvalueStore();
						additionalFieldsvalueStore.setApplication(app);
						System.out.println("application" + app.getId());

						System.out.println("\ntextvalue[updatecount]" + textvalue[updatecount]);
						additionalFieldsvalueStore.setAdditionalFields(additionalFields);
						if (textvalue.length > 0 && !textvalue[updatecount].equals("")) {
							additionalFieldsvalueStore.setValue(textvalue[updatecount]);
						}
						additionalFieldsDao.save(additionalFieldsvalueStore);
						updatecount = updatecount + 1;

					}
				}

			}
		} catch (Exception ex) {
			System.out.println("exception" + ex.getCause());
		}

		// if submitted then get status submit and add it to application status
		Status status = applicationDao.getStatusByName("Not Submitted");
		// save Apllication Status to submitted
		ApplicationStatus applicationStatus = new ApplicationStatus();
		applicationStatus.setApplication(app);
		applicationStatus.setComment("application submitted");
		applicationStatus.setCreate_date(new Date());
		applicationStatus.setRevised_date(new Date());
		applicationStatus.setStatus(status);
		applicationDao.saveAppStatus(applicationStatus);

		for (int i = 0; i < count; i++) {
			if (major.length == 0 && university.length == 0 && degree.length == 0 && startDate.length == 0
					&& endDate.length == 0) {

			} else {
				EducationalBackground educationalBackground = new EducationalBackground();

				try {
					if (university.length != 0)
						educationalBackground.setUniversityname(university[i]);

					if (degree.length != 0)
						educationalBackground.setDegreeEarned(degree[i]);

					if (major.length != 0)
						educationalBackground.setMajor(major[i]);

					if (startDate.length != 0)
						educationalBackground.setStartDate(startDate[i]);

					if (endDate.length != 0)
						educationalBackground.setEndDate(endDate[i]);

					educationalBackground.setApplication(app);
					applicationDao.saveEduBackground(educationalBackground);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		sessionstatus.setComplete();
		session.removeAttribute("programerror");
		return "redirect:/Studentdashboard.html?id=" + userid;

	}

	// ajax for get program
	@RequestMapping(value = "/getProgram.html", method = RequestMethod.GET)
	public String getProgram(@RequestParam(name = "departmentId") Integer departmentId, HttpServletResponse response) {

		List<Program> programs = programDao.getProgramByDeptId(departmentId);
		JSONObject jsonObject = new JSONObject();
		List<ProgramReposnse> programResponse = new ArrayList<ProgramReposnse>();
		for (Program p : programs) {
			programResponse.add(new ProgramReposnse(p.getId(), p.getName()));
		}
		jsonObject.append("programs", programResponse);
		response.setContentType("application/json");
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;

	}

	// ajax to display additional field
	@RequestMapping(value = "/getAdditionalField.html", method = RequestMethod.GET)
	public String getAdditionalField(@RequestParam(name = "departmentId") Integer departmentId,
			HttpServletResponse response) {

		List<AdditionalFields> additionalFields = additionalFieldsDao
				.getAdditionalFieldByDepartment(departmentDao.getDepartmentById(departmentId));
		JSONObject jsonObject = new JSONObject();
		List<AdditionalFieldsReposnse> additionalFieldsReposnse = new ArrayList<AdditionalFieldsReposnse>();

		for (AdditionalFields a : additionalFields) {

			additionalFieldsReposnse.add(
					new AdditionalFieldsReposnse(a.getId(), a.getFieldName(), a.getFieldType(), a.getIsRequired()));
			System.out.println("id" + a.getId());
			System.out.println("name" + a.getFieldName());
			System.out.println("type" + a.getFieldType());
			System.out.println("isrequired" + a.getIsRequired());
			System.out.println("additionalFieldsReposnse" + additionalFieldsReposnse);
		}
		jsonObject.append("additionalFieldsReposnse", additionalFieldsReposnse);
		response.setContentType("application/json");
		try {
			System.out.println("json object" + jsonObject);
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ajax to remove educational background
	@RequestMapping(value = "/RemoveEdu.html", method = RequestMethod.POST)
	public String RemoveEdu(@RequestParam(name = "backId") Integer backId, HttpServletResponse response) {

		System.out.println("edu background id**********\n\n\n" + backId);
		JSONObject jsonObject = new JSONObject();
		EducationalBackground edu = educationalBackgroundDao.getByeduId(backId);

		System.out.println("educational background" + edu);
		educationalBackgroundDao.remove(edu);

		jsonObject.append("backgroundId", backId);
		response.setContentType("application/json");
		try {
			System.out.println("json object" + jsonObject);
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

}