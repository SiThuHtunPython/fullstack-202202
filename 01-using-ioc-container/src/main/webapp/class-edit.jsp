<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using IoC Container</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-4">
		<h1>Using IoC Container</h1>

		<h3>Class Edit</h3>

		<div class="row">
			<div class="col-4">
				<c:url var="save" value="/classes"></c:url>
				<form action="${save}" method="post">
					<div class="mb-3">
						<label class="form-label">Course ID</label> <input
							value="${course.id}" name="course_id" type="text"
							placeholder="Enter Course ID" required="required"
							class="form-control" readonly />
					</div>

					<div class="mb-3">
						<label class="form-label">Teacher</label> <input name="teacher"
							type="text" placeholder="Enter Teacher Name" required="required"
							class="form-control" />
					</div>

					<div class="mb-3">
						<label class="form-label">Start Date</label> <input
							name="startDate" type="date" placeholder="Enter Start Date"
							required="required" class="form-control" />
					</div>

					<input type="submit" class="btn btn-primary" value="Save Class" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>