<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.springboot.project.entity.Message"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>appy for leave</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Sans&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/salarypage.css">

</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">

				<h1 class="text-center mt-5 font-weight-bold">Apply for Leave</h1>
				<hr class="bg-white">
				<h6 class="text-center">Please fill the details related to
					leave</h6>
				<%
				Message m = (Message) session.getAttribute("msg");
				if (m != null) {
				%>
				<div class="alert <%=m.getCssClass()%>" role="alert">
					<%=m.getContent()%>
				</div>
				<%
				session.removeAttribute("msg");
				}
				%>

				<form action="leavesuccess">
					<div class="credentials">

						<div class="form-group text-center ">
							<br>
							<h2>${name} Total leave available: ${leaves}</h2>
							<label>Select Your Leave Date</label> <br> <input
								class="form-control" required="" type="date" name="date">
						</div>

						<div class="form-group text-center">
							<label>Leave Description</label>
							<textarea class="form-control" required="" name="description" rows="7"
								cols="50"></textarea>
						</div>

						<button type="submit" class="btn btn-warning"
							style="width: 70%; position: absolute; margin-left: 12%;">submit
							Details</button>
					</div>

				</form>
				<br> <br>
				<div class="row">
					<!--here you have to connect this href with welcome page  -->
					<a href="leavedetails"><button class="btn btn-success"
							style="width: 70%; position: absolute; margin-left: 14%;">Check
							leave Details</button></a>
				</div>

			</div>
		</div>
	</div>

</body>
</html>
