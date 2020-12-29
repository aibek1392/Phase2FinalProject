<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<div>
		<button style="background-color: green">
			<a href="Login.jsp">Login </a>
		</button>
	</div>
	<h1 style="margin-left: 20pt">Sign up</h1>
	<form
		style="width: 20%;; padding: 12px 20px;
			   margin: 8px 0; margin-left: 8px; 
			   display: inline-block; border: 1px solid #ccc; 
			   box-sizing: border-box;"
		action="registration" method="post">
		Name: <input
			style="width: 100%; padding: 12px 20px;
				   margin: 8px 0; display: inline-block;
				   border: 1px solid #ccc;
				   box-sizing: border-box;"
			type="text" name="name" required="required"> <br>
		Password:<input
			style="margin-left: 9px; width: 100%; 
			padding: 12px 20px; margin: 8px 0; display: inline-block;
		    border: 1px solid #ccc; box-sizing: border-box;"
			type="password" name="password" required="required"><br>
		<input type="submit" value="Register">
	</form>
</body>
</html>