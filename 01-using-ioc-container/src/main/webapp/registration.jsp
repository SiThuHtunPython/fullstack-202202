<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using IoC Container</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-4">
		<h1>Using IoC Container</h1>
		<h3>${classTeacher}'s ${course.name} Students List</h3>
		
		<div>
			<c:url var="addNew" value="/registration-edit">
				<c:param name="registrationId" value="${course.id}"></c:param>
				<c:param name="RclassTeacher" value="${classTeacher}"></c:param>
				<c:param name="RclassStartDate" value="${classStartDate}"></c:param>
			</c:url>
			<a class="btn btn-primary" href="${addNew}">Add New Student</a>
		</div>
		
		<c:choose>
			<c:when test="${ empty register }">
				<div class="alert alert-warning">
						There is no students for ${classTeacher}'s ${course.name}. Please create new student.
					</div>
			</c:when>
			
			<c:otherwise>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Registration ID</th>
							<th>Teacher</th>
							<th>Start Date</th>
							<th>Student</th>
							<th>Phone</th>
							<th>Email</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="c" items="${register}">
							 <tr>
							 	<td>${c.openClass.id}</td>
							 	<td>${c.openClass.teacher}</td>
							 	<td>${c.openClass.startDate}</td>
							 	<td>${c.student}</td>
							 	<td>${c.phone}</td>
							 	<td>${c.email}</td>
							 </tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
		
	</div>
</body>
</html>





