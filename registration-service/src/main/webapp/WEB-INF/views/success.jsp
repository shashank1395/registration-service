<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>Registration Success</title>
</head>
<body>
	Registration completed successfully
	<br />
	<p>Confirmation mail has been sent to the registered email address.</p>
	<a href='<c:url value='/register/index'/>'>Home</a>
</body>
</html>
