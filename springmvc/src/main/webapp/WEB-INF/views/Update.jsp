<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp" />
<%
StudentPOJO student = (StudentPOJO) request.getAttribute("student");
List<StudentPOJO> students = (List<StudentPOJO>) request.getAttribute("students");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
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
	<%
	if (student != null) {
	%>
	<fieldset>
		<legend>:::Update Student:::</legend>
		<form action="./updateData" method="post">
			<table>
				<tr hidden="true">
					<td>ID</td>
					<td><input type="text" value="<%=student.getId()%>" name="id"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" value="<%=student.getName()%>" name="name">
					</td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" value="<%=student.getEmail()%>" name="email">
					</td>
				</tr>
				<tr>
					<td>Contact</td>
					<td><input type="text" value="<%=student.getContact()%>" name="contact">
					</td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" value="<%=student.getCity()%>" name="city">
					</td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" value="<%=student.getUsername()%>" name="username">
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" value="<%=student.getPassword()%>" name="password">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	} else {
	%>
	<fieldset>
		<legend>:::Select Student:::</legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Enter ID</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Select"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	if (msg != null) {
	%>
	<h3 align="center">
		<%=msg%>
	</h3>
	<%
	}
	%>
	<%
	if (students != null) {
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
		<%
		for (StudentPOJO studentData : students) {
		%>
		<tr>
			<td><%=studentData.getId()%></td>
			<td><%=studentData.getName()%></td>
			<td><%=studentData.getEmail()%></td>
			<td><%=studentData.getContact()%></td>
			<td><%=studentData.getCity()%></td>
			<td><%=studentData.getUsername()%></td>
			<td><%=studentData.getPassword()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	}
	%>
</body>
</html>