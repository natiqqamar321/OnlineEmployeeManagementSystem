<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.springboot.project.entity.Message"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>salary page</title>
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
</head>
<body>
	<h1 class="text-center mt-5">${name} Salary Details</h1>
	<br>
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
	<br>

	<div align="center">
		<div class="container">

			<table class="table table-dark">
				<caption>
					<h2 class="text-center">salary Details</h2>
				</caption>
				<tr>
					<th>Salary</th>
					<th>Transactions</th>
				</tr>
				<c:forEach var="user" items="${salaries}">
					<tr>
						<td>${user.salary}</td>
						<td>${user.timestamp}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="row">
				<!--here you have to connect this href with welcome page  -->
				<a href="backtowelcome"><button class="btn btn-danger"
						style="width: 53.5%; position: absolute; margin-left: 15%;">Back
						to Welcome</button></a>
			</div>
		</div>
	</div>
</body>
</html>