<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>STUDENT FORM</title>
</head>
<body>

	<form action="./StudentDetails.jsp" method="post">
		<table>
			<tr>
				<td>NAME :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>EMAIL :</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>CONTACT :</td>
				<td><input type="text" name="contact"></td>
			</tr>
			<tr>
				<td>CITY :</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td><input type="submit" value="send"></td>
			</tr>
		</table>
	</form>

</body>
</html>