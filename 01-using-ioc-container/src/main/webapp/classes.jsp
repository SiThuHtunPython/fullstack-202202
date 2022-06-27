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
		
		<h3>Course For ${course.name}</h3>
		
		<div>
			<c:url var="addNew" value="/class-edit">
				<c:param name="courseId" value="${course.id}"></c:param>
			</c:url>
			<a class="btn btn-primary" href="${addNew}">Add New Class</a>
		</div>
		
		<c:choose>
			<c:when test="${ empty classes }">
				<div class="alert alert-warning">
						There is no class for ${course.name}. Please create new course.
					</div>
			</c:when>
			
			<c:otherwise>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Course</th>
							<th>Teacher</th>
							<th>Start Date</th>
							<th>Fees</th>
							<th>Duration</th>
							<th>Description</th>
							<th></th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="c" items="${classes}">
							 <tr>
							 	<td>${c.id}</td>
							 	<td>${c.course.name}</td>
							 	<td>${c.teacher}</td>
							 	<td>${c.startDate}</td>
							 	<td>${c.course.fees}</td>
							 	<td>${c.course.duration} Months</td>
							 	<td>${c.course.description}</td>
							 	<td>
									<c:url var="registration" value="/registration">
										<c:param name="openClassId" value="${c.course.id}"></c:param>
										<c:param name="openClassTeacher" value="${c.teacher}"></c:param>
										<c:param name="openClassDate" value="${c.startDate}"></c:param>
									</c:url>
									<a href="${registration}">Students</a>
								</td>
							 </tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>





