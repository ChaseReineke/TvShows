<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Edit Show</h1>
	</div>
	
	<div>
		<div>
			<a href="/dashboard">Dashboard</a>
			<a href="/logout">Logout</a>
		</div>
	</div>
	
	<p><c:out value="${ show.title }"/></p>
	<p><c:out value="${ show.network }"/></p>
	
	<div>
		<div>
						
			<div>
				<form:form action="/shows/edit/{id}" method="post" modelAttribute="show">
					<form:label path="title">Show Title</form:label>
					<form:errors path="title"></form:errors>
					<form:input path="title"/>
					
					<form:label path="network">Network</form:label>
					<form:errors path="network"></form:errors>
					<form:textarea path="network"/>
					
					
					
					<input class="submit" type="submit">
				</form:form>
			</div>		
		</div>
	</div>

	
</body>
</html>