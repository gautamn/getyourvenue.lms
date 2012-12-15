package com.getyourvenue.lms.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.getyourvenue.lms.model.User;
import com.getyourvenue.lms.service.IUserService;

@Controller
public class LoginController {

	static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private IUserService userService;

	@RequestMapping("/login")
	public ModelAndView preprocessLoginForm() {

		logger.debug("Printing Hello World for Login!!!");
		
		return new ModelAndView("login", "command", new User());
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute("user")User user, BindingResult result) {

		logger.debug("Validating User with credentials Email:"+user.getEmail()+" and Password:"+user.getPassword());
		boolean isValidUser=this.userService.isValidUser(user.getEmail(), user.getPassword());
		ModelAndView inValidUserView = new ModelAndView("login", "command", new User());
		
		if(isValidUser){
			
			logger.debug("The user has valid credentials!!!");
			return new ModelAndView("welcome"); /*Redirection is required here*/
		}
		else{
			inValidUserView.addObject("invalidUserMsg", "Credentials did not match!!!");
		}
		
		return inValidUserView;
	}
}
