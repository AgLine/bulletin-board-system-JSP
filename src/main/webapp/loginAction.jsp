<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty property="userID" name="user"/>
<jsp:setProperty property="userPassword" name="user"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>bulletin board system JSP</title>
</head>
<body>
	<%
		UserDAO userDAO = new UserDAO();
		int result;
	%>
</body>
</html>