<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
body {
	background-color: #FFFACD;
}
}
</style>
<title>Appraisal Page!!</title>
</head>
<body>
     
	<h2 class="text-center mt-5">${name} Appraisal Details</h2>
	<hr>
	<br>
    <div class="container">
		<table class="table table-dark">

			<tr>
				<th>Position</th>
				<th>Department</th>
				<th>Supervisor</th>
				<th>Review_from</th>
				<th>Review_end</th>
				<th>PerformancereView</th>
			</tr>

			<tr>
				<td>${pos}</td>
				<td>${dep}</td>
				<td>${sup}</td>
				<td>${af}</td>
				<td>${ae}</td>
				<td>${ar}</td>
			</tr>

		</table>
	</div>

	<div class="row">
		<!--here you have to connect this href with welcome page  -->
		<a href="backtowelcome"><button class="btn btn-danger"
				style="width: 70%; position: absolute; margin-left: 15%;">Back
				to Welcome</button></a>
	</div>
</body>
</html>