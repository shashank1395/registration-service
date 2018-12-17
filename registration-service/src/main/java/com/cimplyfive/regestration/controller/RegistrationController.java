package com.cimplyfive.regestration.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cimplyfive.regestration.model.RegistrationModel;
import com.cimplyfive.regestration.service.RegistrationService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Resource(name="registrationService")
	private RegistrationService service;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("attr", new RegistrationModel());
		return "registration";
	}
	
	/**
	 * save method stores the data in db.
	 * @param registrationModel
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("attr") RegistrationModel registrationModel) {
		boolean result = service.saveRegistration(registrationModel);
//		if(result == true) {
//			service.sendCOnfirmationMail(registrationModel);
//		}
		return "redirect:index";
	}

}
