package com.cimplyfive.regestration.controller;


import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cimplyfive.regestration.model.RegistrationModel;
import com.cimplyfive.regestration.service.RegistrationService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@Resource(name = "registrationService")
	private RegistrationService service;

	@Autowired
	@Qualifier("registrationFormValidator")
	private Validator validator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		logger.debug("index()");
		model.addAttribute("attr", new RegistrationModel());
		return "registration";
	}

	/**
	 * save method stores the data in mongodb.
	 * 
	 * @param registrationModel
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("attr") @Valid RegistrationModel registrationModel, BindingResult result) {
		logger.debug("save() : {}", registrationModel);
		if (result.hasErrors()) {
			return "registration";
		} else {
			service.createCollection();
			boolean saveResult = service.saveRegistrationData(registrationModel);
			if (saveResult == true) {
				service.sendCOnfirmationMail(registrationModel);
			}
			return "success";
		}
	}

}
