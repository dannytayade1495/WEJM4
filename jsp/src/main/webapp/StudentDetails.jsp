<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String name = request.getParameter("name");
String email = request.getParameter("email");
String contact = request.getParameter("contact");
String city = request.getParameter("city");
%>
<%!Connection connection;
	PreparedStatement preparedStatement;
	int result;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
	<table>
		<tr>
			<td>NAME :</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>EMAIL :</td>
			<td><%=email%></td>
		</tr>
		<tr>
			<td>CONTACT :</td>
			<td><%=contact%></td>
		</tr>
		<tr>
			<td>CITY :</td>
			<td><%=city%></td>
		</tr>
	</table>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wejm4", "root", "root");
	preparedStatement = connection.prepareStatement("insert into student values (?, ?, ?, ?)");
	preparedStatement.setString(1, name);
	preparedStatement.setString(2, email);
	preparedStatement.setString(3, contact);
	preparedStatement.setString(4, city);
	result = preparedStatement.executeUpdate();
	%>
	<h3>
		<%=result%>
		row inserted..!!
	</h3>

</body>
</html>