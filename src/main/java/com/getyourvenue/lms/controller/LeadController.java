package com.getyourvenue.lms.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.getyourvenue.lms.service.ILmsService;


@Controller
public class LeadController {

	static Logger logger = Logger.getLogger(LeadController.class);

	@Autowired
	private ILmsService lmsService;
	
	@RequestMapping("/createLeadAction")
	public ModelAndView createLeadAction(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("viewLead");
		model.addObject("leadHeader",lmsService.saveLead(request));
		return model;
	}
	
	@RequestMapping("/createlead")
	public ModelAndView getAlliedService() {
		ModelAndView model = new ModelAndView("createlead");
		model.addObject("alliedList",lmsService.getAllAlliedServices());
		return model;
	}
	
	@RequestMapping("/editLead")
	public ModelAndView editLead(HttpServletRequest request) {
		String leadId = request.getParameter("leadid").trim();
		ModelAndView model = null;
		//Getting a single Lead View
		if(leadId!=null && !"".equals(leadId)){
			model = new ModelAndView("editLead");
			model.addObject("leadHeader", lmsService.viewLead(leadId));
		}
		else{
			model = new ModelAndView();
		}
		return model;
	}
	
	@RequestMapping("/editLeadAction")
	public ModelAndView editLeadAction(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("viewLead");
		model.addObject("leadHeader", lmsService.editLeadAction(request));
		return model;
	}
	@RequestMapping("/viewLead")
	public ModelAndView viewLead(HttpServletRequest request) {
		String leadId = request.getParameter("leadid").trim();
		ModelAndView model = null;
		//Getting a single Lead View
		if(leadId!=null && !"".equals(leadId)){
			model = new ModelAndView("viewLead");
			model.addObject("leadHeader", lmsService.viewLead(leadId));
		}
		else{
			model = new ModelAndView();
		}
		return model;
	}
	@RequestMapping("/viewLeadList")
	public ModelAndView viewLeadList(HttpServletRequest request) {
		//Getting Lead List
		ModelAndView model = new ModelAndView("viewLeadList");
		model.addObject("leadHeaderList", lmsService.viewLeadList(request));
		return model;
	}
}
