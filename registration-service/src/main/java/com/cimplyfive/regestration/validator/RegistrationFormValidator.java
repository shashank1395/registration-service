package com.cimplyfive.regestration.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cimplyfive.regestration.model.RegistrationModel;

@Component
public class RegistrationFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return RegistrationModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.valid.firstname",
				"First name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.valid.lastname",
				"Last name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "NotEmpty.valid.emailId", "Email Id is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organizationName", "NotEmpty.valid.organizationName",
				"Organization name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation", "NotEmpty.valid.designation",
				"Designation is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officeNumber", "NotEmpty.valid.officeNumber",
				"Ofice number is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressOne", "NotEmpty.valid.addressOne",
				"Address is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pincode", "NotEmpty.valid.pincode", "pincode is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty.valid.city", "City is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "NotEmpty.valid.state", "State is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.valid.country", "Country is Required");
		RegistrationModel model = (RegistrationModel) target;
		Pattern numberPattern = Pattern.compile("[6-9][0-9]{9}");
		Pattern pincodePattern = Pattern.compile("[0-9]{6}");
		String regx = "[a-zA-Z]+\\.?";
		String emailRegx = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern emailPattern = Pattern.compile(emailRegx);
		Pattern letters = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
		if (!StringUtils.isEmpty(model.getMobileNumber())) {
			Matcher numberMatch = numberPattern.matcher(model.getMobileNumber());
			if (!(numberMatch.find() && numberMatch.group().equals(model.getMobileNumber()))) {
				errors.rejectValue("mobileNumber", "InvalidNumber.valid.mobileNumber", "Invalid mobile number entered");
			}
		}
		if (!StringUtils.isEmpty(model.getOfficeNumber())) {
			Matcher numberMatch = numberPattern.matcher(model.getOfficeNumber());
			if (!(numberMatch.find() && numberMatch.group().equals(model.getOfficeNumber()))) {
				errors.rejectValue("officeNumber", "InvalidNumber.valid.officeNumber", "Invalid office number entered");
			}
		}
		if (!StringUtils.isEmpty(model.getPincode())) {
			Matcher numberMatch = pincodePattern.matcher(model.getPincode());
			if (!(numberMatch.find() && numberMatch.group().equals(model.getPincode()))) {
				errors.rejectValue("pincode", "InvalidPincode.valid.pincode", "Invalid pincode entered");
			}
		}
		if (!StringUtils.isEmpty(model.getFirstName())) {
			Matcher lettersMatch = letters.matcher(model.getFirstName());
			if (!(lettersMatch.matches())) {
				errors.rejectValue("firstName", "InvalidFirstName.valid.firstName", "Invalid First Name Entered");
			}
		}
		if (!StringUtils.isEmpty(model.getMiddleName())) {
			Matcher lettersMatch = letters.matcher(model.getMiddleName());
			if (!(lettersMatch.matches())) {
				errors.rejectValue("middleName", "InvalidMiddleName.valid.middleName", "Invalid Middle Name Entered");
			}
		}
		if (!StringUtils.isEmpty(model.getLastName())) {
			Matcher lettersMatch = letters.matcher(model.getLastName());
			if (!(lettersMatch.matches())) {
				errors.rejectValue("lastName", "InvalidLastName.valid.lastName", "Invalid Last Name Entered");
			}
		}
		if (!StringUtils.isEmpty(model.getCity())) {
			Matcher lettersMatch = letters.matcher(model.getCity());
			if (!(lettersMatch.matches())) {
				errors.rejectValue("city", "InvalidCity.valid.city", "Invalid City Entered");
			}
		}
		if (!StringUtils.isEmpty(model.getState())) {
			Matcher lettersMatch = letters.matcher(model.getState());
			if (!(lettersMatch.matches())) {
				errors.rejectValue("state", "Invalidstate.valid.state", "Invalid State Entered");
			}
		}
		if (!StringUtils.isEmpty(model.getOrganizationName())) {
			Matcher lettersMatch = letters.matcher(model.getOrganizationName());
			if (!(lettersMatch.matches())) {
				errors.rejectValue("organizationName", "InvalidOrganization.valid.organizationName",
						"Invalid Organization Name Entered");
			}
		}
		if (!StringUtils.isEmpty(model.getCountry())) {
			Matcher lettersMatch = letters.matcher(model.getCountry());
			if (!(lettersMatch.matches())) {
				errors.rejectValue("country", "InvalidCountry.valid.country", "Invalid Country Entered");
			}
		}
		if (!StringUtils.isEmpty(model.getDesignation())) {
			Matcher lettersMatch = letters.matcher(model.getDesignation());
			if (!(lettersMatch.matches())) {
				errors.rejectValue("designation", "InvalidDesignation.valid.designation",
						"Invalid Designation Entered");
			}
		}
		if (!StringUtils.isEmpty(model.getEmailId())) {
			Matcher emailMatch = emailPattern.matcher(model.getEmailId());
			if (!(emailMatch.matches())) {
				errors.rejectValue("emailId", "InvalidEmail.valid.emailId", "Invalid Email Entered");
			}
		}
	}
}
