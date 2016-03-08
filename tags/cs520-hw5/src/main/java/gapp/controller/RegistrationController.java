package gapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import gapp.model.User;
import gapp.model.UserRoles;
import gapp.model.dao.UserDao;
import gapp.model.dao.UserRoleDao;
import gapp.model.validator.UserValidator;

@Controller
@SessionAttributes("register")
public class RegistrationController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserValidator uservalidator;

	@Autowired
	private UserRoleDao userRoleDao;

	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.put("registeruser", new User()); 
		return "register";
	}

	@RequestMapping(value = "/register.html", method = RequestMethod.POST)
	public String add(@ModelAttribute User registeruser, BindingResult result, ModelMap model) { // no
		//

		uservalidator.validate(registeruser, result);
		if (result.hasErrors())

		{
			model.put("registeruser", new User());
			return "register";
		}
		User user;
		try {
			user = userDao.getUserByEmail(registeruser.getEmail().toLowerCase());

			if (!user.equals(null)) {

				model.put("registeruser", new User());
				model.put("error", "This email id is already registered");
				return "register";
			}

			User user1 = userDao.getUserByEmail(registeruser.getEmail().toUpperCase());
			if (!user1.equals(null)) {

				model.put("registeruser", new User());
				model.put("error", "This email id is already registered");
				
				return "register";
			}

		} catch (Exception e) {

			List<UserRoles> userRoles = userRoleDao.getUserByRole("student");

			registeruser.setRole(userRoles);
			registeruser = userDao.saveuser(registeruser);

		}

		return "redirect:login.html?id=0";
	}

}
