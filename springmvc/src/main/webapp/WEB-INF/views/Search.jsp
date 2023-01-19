<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp" />
<%
StudentPOJO student = (StudentPOJO) request.getAttribute("student");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Student</title>
<style type="text/css">
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}

#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}

#data td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
	<fieldset>
		<legend>:::Search Details:::</legend>
		<form action="./search" method="post">
			<table>
				<tr>
					<td>Enter ID</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Search"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	if (student != null) {
	%>
	<table id="data">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Contact</th>
			<th>City</th>
			<th>Username</th>
			<th>Password</th>
		</tr>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getContact()%></td>
			<td><%=student.getCity()%></td>
			<td><%=student.getUsername()%></td>
			<td><%=student.getPassword()%></td>
		</tr>
	</table>
	<%
	}
	%>
	<%
	if (msg != null) {
	%>
	<h3 align="center">
		<%=msg%>
	</h3>
	<%
	}
	%>
</body>
</html>