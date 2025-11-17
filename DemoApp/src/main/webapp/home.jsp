<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String userEmail = (String)session.getAttribute("email_key");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to the JSP Page</h1>
<h2>Welcome to the App, <%=userEmail %></h2>
</body>
</html>