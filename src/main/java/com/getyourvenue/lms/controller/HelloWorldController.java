package com.getyourvenue.lms.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.getyourvenue.lms.service.IUserService;

@Controller
public class HelloWorldController {

	static Logger logger = Logger.getLogger(HelloWorldController.class);

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld() {

		logger.debug("Printing Hello World!!!");
		ModelAndView model = new ModelAndView("hello");
		model.addObject("userList", this.userService.listUsers());
		return model;
	}

}
