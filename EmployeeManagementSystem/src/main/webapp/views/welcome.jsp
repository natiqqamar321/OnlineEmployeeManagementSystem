<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link rel="stylesheet" href="/css/welcome.css">
<title>Welcome page!!</title>
</head>
<body class="bg-inf0">
	<br>

	<h1 class="font-weight-bold text-center text-dark">Welcome to
		Employee Portal</h1>
	<marquee width="80%" direction="left" height="20px" class="text-info ">
		<b>Check Your Salary Details , Leave Details and Appraisal Details of ${name}
		</b>
	</marquee>
	<br>
	<img src="/image/abcd.jpg" width="100" height="100">
	<div class="container font-weight-bold">
        
		<div class="card text-center mt-4 p-2 bg-secondary float-right">
			<a href="logout"><button type="button"
					class="btn btn-danger text-center">Logout ${name}</button></a>
		</div>

		<div class="section">
			<div class="card text-center mt-2 p-5 bg-secondary"
				style="width: 10rem; height: 10rem">
				<a href="salarypage">
					<button type="button" class="btn btn-danger">View Salary
						Details</button>
				</a>
			</div>
		</div>

		<div class="section">
			<div class="card text-center mt-2 p-5 bg-secondary"
				style="width: 10rem; height: 10rem">
				<a href="leavepage">
					<button type="button" class="btn btn-success ">Apply Leave/Details</button>
				</a>
			</div>

			<div class="section">
				<div class="card text-center mt-2 p-5 bg-secondary"
					style="width: 10rem; height: 10rem">
					<a href="appraisalpage"><button type="button"
							class="btn btn-warning">View Appraisal Details</button></a>
				</div>
			</div>

		</div>
	</div>
</body>
</html>