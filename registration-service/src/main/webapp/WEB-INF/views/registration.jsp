<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3 id="form_header" class="text-warning"
			align="center">Registration Form</h3>
		<div></div>
		<c:url var="saveUrl" value="/register/save" />
		<form:form id="user_form" modelAttribute="attr" method="POST"
			action="${saveUrl}">
			<table border='0' width='480px' cellpadding='0' cellspacing='0'
				align='center'>
				<tr>
					<td><label for="first_name">First Name: </label></td>
					<td><form:input id="first_name" path="firstName" /></td>
					<td><font color="red"> <form:errors path="firstName"></form:errors></font><br />
					</td>
				</tr>
				<tr>
					<td><label for="middle_name">Middle Name: </label></td>
					<td><form:input id="middle_name" path="middleName" /></td>
					<td><font color="red"> <form:errors path="middleName"></form:errors></font><br />
					</td>
				</tr>
				<tr>
					<td><label for="last_name">Last Name: </label></td>
					<td><form:input id="last_name" path="lastName" /></td>
					<td><font color="red"> <form:errors path="lastName"></form:errors></font><br />
					</td>
				</tr>
				<tr>
					<td><label for="email_id">Email ID: </label></td>
					<td><form:input id="email_id" path="emailId" /></td>
					<td><font color="red"> <form:errors path="emailId"></form:errors></font><br />
					</td>
				</tr>
				<tr>
					<td><label for="mobile_number">Mobile Number: </label></td>
					<td><form:input id="mobile_number" path="mobileNumber" /></td>
					<td><font color="red"> <form:errors path="mobileNumber"></form:errors></font><br />
					</td>
				</tr>
				<tr>
					<td><label for="organization_name">Organization Name:
					</label></td>
					<td><form:input id="organization_name" path="organizationName" /></td>
					<td><font color="red"> <form:errors
								path="organizationName"></form:errors></font><br /></td>
				</tr>
				<tr>
					<td><label for="designation">Designation: </label></td>
					<td><form:input id="designation" path="designation" /></td>
					<td><font color="red"> <form:errors path="designation"></form:errors></font><br />
					</td>
				</tr>
				<tr>
					<td><label for="office_number">Office Number: </label></td>
					<td><form:input id="office_number" path="officeNumber" /></td>
					<td><font color="red"> <form:errors path="officeNumber"></form:errors></font><br />
					</td>
				</tr>
				<tr>
					<td><label for="address_one">Address 1: </label></td>
					<td><form:input id="address_one" path="addressOne" /></td>
					<td><font color="red"> <form:errors path="addressOne"></form:errors></font><br />
					</td>
				</tr>
				<tr>
					<td><label for="address_two">Address 2: </label></td>
					<td><form:input id="address_two" path="addressTwo" /></td>
				</tr>
				<tr>
					<td><label for="landmark">Landmark: </label></td>
					<td><form:input id="landmark" path="landmark" /></td>
				</tr>
				<tr>
					<td><label for="pin_code">Pincode: </label></td>
					<td><form:input id="pin_code" path="pincode" /></td>
					<td><font color="red"> <form:errors path="pincode"></form:errors></font><br />
					</td>
				</tr>
				<tr>
					<td><label for="city">City: </label></td>
					<td><form:input id="city" path="city" /></td>
					<td><font color="red"> <form:errors path="city"></form:errors></font><br />
					</td>
				</tr>
				<tr>
					<td><label for="state">State: </label></td>
					<td><form:input id="state" path="state" /></td>
					<td><font color="red"> <form:errors path="state"></form:errors></font><br />
					</td>
				</tr>
				<tr>
					<td><label for="country">Country: </label></td>
					<td><form:input id="country" path="country" /></td>
					<td width='250px'><font color="red"> <form:errors
								path="country"></form:errors></font><br /></td>
				</tr>
				<tr>
					<td width='250px'><label>Email Digest Frequency: </label></td>
					<td><select name="emailFrequency" path="emailDigestFrequency">
							<option value="weekly">Weekly</option>
							<option value="daily">Daily</option>
							<option value="biweekly">Biweekly</option>
							<option value="monthly">Monthly</option>
					</select></td>
				</tr>
			</table>
			<table border='0' width='480px' cellpadding='0' cellspacing='0'
				align='center'>
				<tr>
					<td align='center'>
						<button id="saveBtn" type="submit" onclick="return validate()"
							class="btn btn-primary">Save</button>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
