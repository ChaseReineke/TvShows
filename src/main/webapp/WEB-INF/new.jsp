<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new show</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<div>
		<h1>New Show</h1>
		<form:form action="/shows/new" method="post" modelAttribute="show">
			<p>
				<form:label path="title">Title</form:label>
				<form:errors path="title"/>
				<form:input path="title"/>
			</p>
			<p>
				<form:label path="network">Network</form:label>
				<form:errors path="network"/>
				<form:input path="network"/>
			</p>
			<p>
				<form:label path="rating">Rating (1-10)</form:label>
				<form:errors path="rating"/>
				<form:input type="number" path="rating"/>
			</p>
			<input type="submit" value="Add Show"/>
		</form:form>
	</div>
</body>
</html>