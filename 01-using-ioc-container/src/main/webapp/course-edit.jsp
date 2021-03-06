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
		
		<h3>Course Edit</h3>
		
		<div class="row">
			<div class="col-4">
				<c:url var="save" value="/courses"></c:url>
				<form action="${save}" method="post">
					<div class="mb-3">
						<label class="form-label">Name</label>
						<input name="name" type="text" placeholder="Enter Course Name" required="required" class="form-control" />
					</div>
					
					<div class="mb-3">
						<label class="form-label">Duration</label>
						<input name="duration" type="number" placeholder="Enter Course Duration" required="required" class="form-control" />
					</div>
					
					<div class="mb-3">
						<label class="form-label">Fees</label>
						<input name="fees" type="number" placeholder="Enter Course Fees" required="required" class="form-control" />
					</div>
					
					<div class="mb-3">
						<label class="form-label">Description</label>
						<textarea name="description" cols="30" rows="10" class="form-control"></textarea>
					</div>
					
					<input type="submit" class="btn btn-primary" value="Save Course" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>