<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<%
			if (session.getAttribute("name") != null) {
			out.println("<button><a href='logout'>Logout</a></button>");
			out.print("<h1 >Welcome  " + session.getAttribute("name") + "</h1>");

		}else if (session.getAttribute("name") == null) {
			out.println("<p style='color:red'>You have to login first</p>");
			request.getRequestDispatcher("Login.jsp").include(request, response);
		}
		%>
	</div>
</body>
</html>