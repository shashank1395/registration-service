<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Registration Form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
        function validate(){
        	var firstName = document.getElementById('first_name');
        	var middleName = document.getElementById('middle_name');
        	var lastName = document.getElementById('last_name');
        	var emailId = document.getElementById('email_id');
        	var mobileNumber = document.getElementById('mobile_number');
        	var organizationName = document.getElementById('organization_name');
        	var designation = document.getElementById('designation');
        	var officeNumber = document.getElementById('office_number');
        	var pincode = document.getElementById('pin_code');
        	var city = document.getElementById('city');
        	var state = document.getElementById('state');
        	var country = document.getElementById('country');
        	var addressOne = document.getElementById('address_one');
        	var result = false;
        	var letters = /^[A-Za-z]+$/;
        	var addr;
        	if(addressOne.value!=""){
        		addr = true;
        	}else{
        		addressOne.style.borderColor = "red";
        		document.getElementById('errorAddress').innerHTML = "Please Enter Address";  	
        		document.getElementById('errorAddress').style.color = "red";
        		addr = false;
        	}
        	var fname = validateFirstName(firstName, letters);
        	var mname = true;
        	if(middleName.value!=""){
        		mname = validateMiddleName(middleName, letters);
        	}
        	var lname = validateLastName(lastName, letters);
        	var email = validateEmail(emailId);
        	var mobile = true;
        	if(mobileNumber.value!=""){
        		 mobile = validateMobileNumber(mobileNumber);
        	}        	
        	var orgName = validateOrganizationName(organizationName);
        	var desg = validateDesignation(designation, letters);
        	var officeNo = validateOfficeNumber(officeNumber);
        	var pin = validatePincode(pincode);
        	var cityResult = validateCity(city, letters);
        	var stateResult = validateState(state, letters);
        	var countryResult = validateCountry(country, letters);
        	if(fname && mname && lname && addr && email && mobile && orgName && desg && officeNo && pin && cityResult && stateResult && countryResult){
        		return true;
        	}else{
        		return false;
        	}
        }
        
        function validateFirstName(firstName, letters){
        	if(firstName.value!=""){
        		if(firstName.value.match(letters)){
            		return true;
            	}else{
            		firstName.style.borderColor = "red";
            		document.getElementById('error1').innerHTML = "First Name should contain only letters";  	
            		document.getElementById('error1').style.color = "red";
            		return false;
            	}
        	}else{
        		firstName.style.borderColor = "red";
        		document.getElementById('error1').innerHTML = "Please Enter First Name";  	
        		document.getElementById('error1').style.color = "red";
        		return false;
        	}       	
        }
        
        function validateMiddleName(middleName, letters){
        	if(middleName.value.match(letters)){
        		return true;
        	}else{
        		middleName.style.borderColor = "red";
        		document.getElementById('error2').innerHTML = "Middle Name should contain only letters"; 
        		document.getElementById('error2').style.color = "red";
        		return false;
        	}
        }
        
        function validateLastName(lastName, letters){
        	if(lastName.value!=""){
        		if(lastName.value.match(letters)){
            		return true;
            	}else{
            		lastName.style.borderColor = "red";
            		document.getElementById('error3').innerHTML = "Last Name should contain only letters";  
            		document.getElementById('error3').style.color = "red";
            		return false;
            	}
        	}else{
        		lastName.style.borderColor = "red";
        		document.getElementById('error3').innerHTML = "Please Enter Last Name";  
        		document.getElementById('error3').style.color = "red";
        		return false;
        	}
        }
        
        function validateEmail(emailId){
        	if(emailId.value!=""){
        		atpos = emailId.value.indexOf("@");
        		dotpos = emailId.value.lastIndexOf(".");
        		if(atpos<1 || (dotpos - atpos < 2 )){
        			emailId.style.borderColor = "red";
            		document.getElementById('error4').innerHTML = "Entered email address is invalid."; 
            		document.getElementById('error4').style.color = "red";
            		return false
        		}else{        		
            		return true;
            	}
        	}else{
        		emailId.style.borderColor = "red";
        		document.getElementById('error4').innerHTML = "Please enter email address"; 
        		document.getElementById('error4').style.color = "red";
        		return false;
        	}
        }
        
        function validateMobileNumber(mobileNumber){validateOfficeNumber
        	var format = /^\d{10}$/;
        	if(mobileNumber.value.match(format)){
        		return true;
        	}else{
        		mobileNumber.style.borderColor = "red";
        		document.getElementById('error5').innerHTML = "Mobile number entered is invalid."; 
        		document.getElementById('error5').style.color = "red";
        		return false;
        	}
        }
        
        function validateOrganizationName(organizationName){
        	var format = /^[0-9a-zA-Z]+$/;
        	if(organizationName.value!=""){
        		if(organizationName.value.match(format)){
            		return true;
            	}else{
            		organizationName.style.borderColor = "red";
            		document.getElementById('error6').innerHTML = "Organization Name should have only alphanumeric characters."; 
            		document.getElementById('error6').style.color = "red";
            		return false;
            	}
        	}else{
        		organizationName.style.borderColor = "red";
        		document.getElementById('error6').innerHTML = "Please enter Organization Name"; 
        		document.getElementById('error6').style.color = "red";
        		return false;
        	}
        }
        
        function validateDesignation(designation, letters){
        	if(designation.value!=""){
        		if(designation.value.match(letters)){
            		return true;
            	}else{
            		designation.style.borderColor = "red";
            		document.getElementById('error7').innerHTML = "Designation should contain only letters";  	
            		document.getElementById('error7').style.color = "red";
            		return false;
            	}
        	}else{
        		designation.style.borderColor = "red";
        		document.getElementById('error7').innerHTML = "Please enter designation";  	
        		document.getElementById('error7').style.color = "red";
        		return false;
        	}
        }
        
        function validateOfficeNumber(officeNumber){
        	var format = /^\d{10}$/;
        	if(officeNumber.value!=""){
        		if(officeNumber.value.match(format)){
            		return true;
            	}else{
            		officeNumber.style.borderColor = "red";
            		document.getElementById('error8').innerHTML = "Office number entered is invalid."; 
            		document.getElementById('error8').style.color = "red";
            		return false;
            	}
        	}else{
        		officeNumber.style.borderColor = "red";
        		document.getElementById('error8').innerHTML = "Please enter office number"; 
        		document.getElementById('error8').style.color = "red";
        		return false;
        	}
        }
        
        function validatePincode(pincode){
        	var format = /^\d{6}$/;
        	if(pincode.value!=""){
        		if(pincode.value.match(format)){
            		return true;
            	}else{
            		pincode.style.borderColor = "red";
            		document.getElementById('error9').innerHTML = "Pincode entered is invalid."; 
            		document.getElementById('error9').style.color = "red";
            		return false;
            	}
        	}else{
        		pincode.style.borderColor = "red";
        		document.getElementById('error9').innerHTML = "Please enter pincode"; 
        		document.getElementById('error9').style.color = "red";
        		return false;
        	}
        }
        
        function validateCity(city, letters){
        	if(city.value!=""){
        		if(city.value.match(letters)){
            		return true;
            	}else{
            		city.style.borderColor = "red";
            		document.getElementById('error10').innerHTML = "Please enter valid city";  	
            		document.getElementById('error10').style.color = "red";
            		return false;
            	}
        	}else{
        		city.style.borderColor = "red";
        		document.getElementById('error10').innerHTML = "Please enter city";  	
        		document.getElementById('error10').style.color = "red";
        		return false;
        	}
        }
        
        function validateState(state, letters){
        	if(state.value!=""){
        		if(state.value.match(letters)){
            		return true;
            	}else{
            		state.style.borderColor = "red";
            		document.getElementById('error11').innerHTML = "Please Enter valid state";  	
            		document.getElementById('error11').style.color = "red";
            		return false;
            	}
        	}else{
        		state.style.borderColor = "red";
        		document.getElementById('error11').innerHTML = "Please Enter state";  	
        		document.getElementById('error11').style.color = "red";
        		return false;
        	}
        }
        
        function validateCountry(country, letters){
        	if(country.value!=""){
        		if(country.value.match(letters)){
            		return true;
            	}else{
            		country.style.borderColor = "red";
            		document.getElementById('error12').innerHTML = "Please Enter valid country name.";  	
            		document.getElementById('error12').style.color = "red";
            		return false;
            	}
        	}else{
        		country.style.borderColor = "red";
        		document.getElementById('error12').innerHTML = "Please Enter country";  	
        		document.getElementById('error12').style.color = "red";
        		return false;
        	}
        }
        </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h3 id="form_header" name="registration" class="text-warning" align="center">Registration Form</h3>
            <div> </div>
            <c:url var="saveUrl" value="/register/save" />
            <form:form id="user_form" modelAttribute="attr" method="POST" action="${saveUrl}">
            <div>
            	<label for="first_name">First Name: </label>
                <form:input id="first_name" path="firstName" required="true" />
                <div id="error1"></div>
            </div>
            <div>
            	<label for="middle_name">Middle Name: </label>
                <form:input id="middle_name"   path="middleName" />
                <div id="error2"></div>
            </div>
            <div>
            	 <label for="last_name">Last Name: </label>
                <form:input id="last_name"   path="lastName" required="true" />
                <div id="error3"></div>
            </div>
            <div>
            	<label for="email_id">Email ID: </label>
                <form:input id="email_id"   path="emailId" required="true" />
                <div id="error4"></div>
            </div>
            <div>
            	<label for="mobile_number">Mobile Number: </label>
                <form:input id="mobile_number" type="number"   path="mobileNumber" />
                <div id="error5"></div>
            </div>
            <div>
            	<label for="organization_name">Organization Name: </label>
                <form:input id="organization_name"   path="organizationName" required="true" />
                <div id="error6"></div>
            </div>  
            <div>
            	<label for="designation">Designation: </label>
                <form:input id="designation"   path="designation" required="true" />
                <div id="error7"></div>
            </div>   
            <div>
            	 <label for="office_number">Office Number: </label>
                <form:input id="office_number" type="number"  path="officeNumber" required="true" />
                <div id="error8"></div>
            </div>
            <div>
            	<label for="address_one">Address 1: </label>
                <form:input id="address_one"   path="addressOne" required="true" />
                <div id="errorAddress"></div>
            </div>
            <div>
            	<label for="address_two">Address 2: </label>
                <form:input id="address_two"   path="addressTwo" />
            </div>   
            <div>
            	 <label for="landmark">Landmark: </label>
                <form:input id="landmark"   path="landmark" />
            </div>   
            <div>
            	 <label for="pin_code">Pincode: </label>
                <form:input id="pin_code" type="number"  path="pincode" />
                <div id="error9"></div>
            </div>  
            <div>
            	<label for="city">City: </label>
                <form:input id="city"   path="city" required="true" />
                <div id="error10"></div>
            </div>   	
            <div>
            	 <label for="state">State: </label>
                <form:input id="state"   path="state" required="true" />
                <div id="error11"></div>
            </div>                 
                <div>
                	<label for="country">Country: </label>
                <form:input id="country"   path="country" required="true" />
                <div id="error12"></div>
                </div>
                <div>
                	<label>Email Digest Frequency: </label>
                <select name="emailFrequency"  path="emailDigestFrequency">
  					<option value="weekly">Weekly</option>
  					<option value="daily">Daily</option>
 					<option value="biweekly">Biweekly</option>
  					<option value="monthly">Monthly</option>
				</select>
                </div>               
                <div> </div>
                <button id="saveBtn" type="submit" onclick="return validate()" class="btn btn-primary">Save</button>
            </form:form>
        </div>
    </body>
</html>
