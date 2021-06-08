<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
body {
	background-color: #FFFACD;
}

th{
text-align: center;
}
.container {
    padding-right: 0px;
    padding-left: 96px;
    margin-right: auto;
    margin-left: auto;
}
}
</style>
<title>Leave Deatails</title>
</head>
<body> 
<div class="container">

<br>
		<table class="table table-dark text-center">
			<caption class="text-center" >
				<h1>${name} Leave History</h1>
			</caption>
			<tr class="text-center p-15">
				<th>Date of Leave</th>
				<th>Description Of Leave</th>
			</tr>
			<c:forEach var="user" items="${viewLeave}">
				<tr>
				   
					<td>${user.date}</td>
					<td>${user.description}</td>
					
				</tr>
			</c:forEach>
			
		</table>
		<hr>
		<div class="row">
					<!--here you have to connect this href with welcome page  -->
					<a href="backtowelcome"><button class="btn btn-success"
							style="width: 70%; position: absolute; margin-left: 8%;">Back to Welcome page</button></a>
				</div>
	</div>
</body>
</html>