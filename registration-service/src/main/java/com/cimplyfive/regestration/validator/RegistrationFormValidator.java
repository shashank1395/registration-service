package com.cimplyfive.regestration.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cimplyfive.regestration.model.RegistrationModel;

@Component
public class RegistrationFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return RegistrationModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.valid.firstname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.valid.lastname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "NotEmpty.valid.emailId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organizationName", "NotEmpty.valid.organizationName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation", "NotEmpty.valid.designation");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officeNumber", "NotEmpty.valid.officeNumber");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressOne", "NotEmpty.valid.addressOne");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pincode", "NotEmpty.valid.pincode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty.valid.city");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "NotEmpty.valid.state");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.valid.country");
	}

}
