<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<jsp:include page="NavBar.jsp"/>
	<%StudentPOJO student = (StudentPOJO)request.getAttribute("student");
	String msg = (String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>

	<form action="./add" method="post">
		<table>
			<tr>
				<td>Name : </td>
				<td>
				<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td>Email : </td>
				<td>
				<input type="text" name="email">
				</td>
			</tr>
			<tr>
				<td>Contact : </td>
				<td>
				<input type="text" name="contact">
				</td>
			</tr>
			<tr>
				<td>City : </td>
				<td>
				<input type="text" name="city">
				</td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="Add">
				</td>
			</tr>
		</table>
	</form>
	<%if (msg != null) { %>
		<h3> <%= msg %> </h3>
	<%} %>

</body>
</html>