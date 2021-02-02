<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login + Registration</title>
</head>
<body>
	<h1>Show Reviewer </h1>

	<h2>Login + Registration</h2>

	<h3>Register</h3>
					
	<form:form action="/process_registration" method="post" modelAttribute="user">
				
				
		<form:errors class="errors" path="username"></form:errors>
		<form:input path="username" placeholder="username"></form:input>
						
		<form:errors class="errors" path="email"></form:errors>
		<form:input path="email" placeholder="email"></form:input>
						
		<form:errors class="errors" path="password"></form:errors>
		<form:input path="password" placeholder="password"></form:input>
						
		<form:errors class="errors" path="confirmation"></form:errors>
		<form:input path="confirmation" placeholder="confirm password"></form:input>
						
		<input class="submit" type="submit">

	</form:form>

	<h3>Login</h3>
					
	<form:form action="/process_login" method="post" modelAttribute="user">
				
		<form:errors class="errors" path="email"></form:errors>
		<form:input path="email" placeholder="email"></form:input>
						
		<form:errors class="errors" path="password"></form:errors>
		<form:input path="password" placeholder="password"></form:input>
			
						
		<input class="submit" type="submit">

	</form:form>

</body>
</html>