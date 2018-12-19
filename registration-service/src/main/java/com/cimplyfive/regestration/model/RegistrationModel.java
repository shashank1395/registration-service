package com.cimplyfive.regestration.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author shashank
 *
 */
public class RegistrationModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]+$")
	@Size(min = 1, max = 20)
	private String firstName;

	@Pattern(regexp = "^[A-Za-z]+$")
	@Size(min = 1, max = 20)
	private String middleName;

	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]+$")
	@Size(min = 1, max = 20)
	private String lastName;

	@NotEmpty
	@Email
	private String emailId;
	
	private String mobileNumber;

	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]+$")
	@Size(min = 1, max = 20)
	private String organizationName;

	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]+$")
	private String designation;

	@NotEmpty
	@Pattern(regexp = "^[0-9]{10}$")
	private String officeNumber;

	@NotEmpty
	private String addressOne;

	private String addressTwo;

	private String landmark;

	@NotEmpty
	@Pattern(regexp = "^[0-9]{6}$")
	private String pincode;

	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]+$")
	private String city;

	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]+$")
	private String state;

	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]+$")
	private String country;

	private String emailDigestFrequency;

	public RegistrationModel() {
		super();
	}

	public RegistrationModel(String fname, String mname, String lname, String email, String mobile, String orgname,
			String desg, String officeNo, String addrOne, String addrTwo, String landmark, String pin, String city,
			String state, String country, String freq) {
		super();
		this.firstName = fname;
		this.middleName = mname;
		this.lastName = lname;
		this.emailId = email;
		this.mobileNumber = mobile;
		this.organizationName = orgname;
		this.designation = desg;
		this.officeNumber = officeNo;
		this.addressOne = addrOne;
		this.addressTwo = addrTwo;
		this.landmark = landmark;
		this.pincode = pin;
		this.city = city;
		this.state = state;
		this.country = country;
		this.emailDigestFrequency = freq;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public String getOrganizationName() {
		return organizationName;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public String getOfficeNumber() {
		return officeNumber;
	}
	
	public String getAddressOne() {
		return addressOne;
	}
	
	public String getAddressTwo() {
		return addressTwo;
	}
	
	public String getLandmark() {
		return landmark;
	}
	
	public String getPincode() {
		return pincode;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getEmailFrequency() {
		return emailDigestFrequency;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	
	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}
	
	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}
	
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmailFrequency(String emailFrequency) {
		this.emailDigestFrequency = emailFrequency;
	}

}
