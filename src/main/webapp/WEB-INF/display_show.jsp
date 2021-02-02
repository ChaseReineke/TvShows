<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Display Show</title>
</head>
<body>
	<a class="dashboard" href="/dashboard">Dashboard</a>
	<div class="container">
		<h1><c:out value="${shows.title}"/></h1>
		<p>Network: <c:out value="${shows.network}"/></p>
		<p>Rating: <c:out value="${shows.rating}"/></p>
		<a href="/shows/edit/${shows.id}">Edit</a>
		<a href="/shows/delete/${shows.id}">Delete</a>
	</div>
</body>
</html>