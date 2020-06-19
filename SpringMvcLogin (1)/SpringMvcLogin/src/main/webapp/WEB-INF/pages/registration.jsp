<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="addUser" method="get">
		 
		Name: <input type="text" name="name"><br> 
		password: <input type="password" name="password"><br> 
		email:<input type="email" name="email"><br> 
		<input type="submit" value="registration">

	</form>
	<h3>Already hava an Account </h3><a href="login">Click on login!</a>
</body>
</html>