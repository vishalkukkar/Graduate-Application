package gapp.controller;

import gapp.model.User;
import gapp.model.dao.UserDao;
import gapp.model.validator.UserValidator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "loginuser" })
public class LoginController {

	@Autowired
	private UserDao userDao;

	@Autowired
	UserValidator userValidator;

	@RequestMapping(value = "/blank.html")
	public String blankPage(ModelMap models) {

		return "blank";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(@RequestParam Integer id,ModelMap models) {
		
		if(id==0){
			models.put("loginuser", new User());
			models.put("id",0);
			return "login";
		}
		else
			models.put("loginuser", new User());
			models.put("id",1);
			return "login";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String login(@ModelAttribute User loginuser, BindingResult bindingResult, HttpSession session) {
		userValidator.validate(loginuser, bindingResult);
		if (bindingResult.hasErrors())
			return "login";
		User user = null;

		try {
			user = userDao.getUserByEmail(loginuser.getEmail());
			System.out.println("user print" + user);
		} catch (Exception e) {
			System.out.println("exception catched");
		}
		if (loginuser.isValidUser(user)) {

			session.setAttribute("loggedInUser", user);
			user.setUserTypesInSession(session);
			String superRole = (String) session.getAttribute("LoginUserRole");

			System.out.println("superrole" + superRole);
			if (superRole.equals("Admin")) {
				return "redirect:/departments.html";
			} else if (superRole.equals("Staff")) {
				return "redirect:/blank.html";
			} else {
				return "redirect:/blank.html";
			}
		} else {
			return "redirect:/login.html?id=1";
		}
	}

	@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	public String logout(ModelMap models, HttpSession session) {
		System.out.println("************************");
		session.removeAttribute("loggedInUser");
		session.invalidate();
		return "redirect:/login.html?id=0";
	}
}
