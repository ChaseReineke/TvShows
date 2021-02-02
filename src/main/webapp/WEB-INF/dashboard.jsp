<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<meta charset=ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
		
	
	<div>
    	<div>
    		<table>
    			<thead>
    				<a href="shows/new">Add new shows</a>
        			<tr>
            			<th>ID</th>
            			<th>Show Title</th>
            			<th>Network</th>
            			<th>Rating</th>
            			<th class="text-center">Action</th>
        			</tr>
    			</thead>
    			<tbody>
					<c:forEach items="${show}" var="shows">
					<tr>
						<td><c:out value="${shows.id}"/></td>
						<td><a href="/shows/${shows.id}"><c:out value="${shows.title}"/></a></td>
						<td><c:out value="${shows.network}"/></td>
						<td><c:out value="${shows.rating}"/></td>
						<td><a href="/shows/delete/${shows.id}">Delete</a></td>
					</tr>
					</c:forEach>
				</tbody>
    		</table>
    	</div>
	</div>
</body>
</html>