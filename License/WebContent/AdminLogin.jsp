<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authorized Login</title>
</head>
<%@include file="c_header.jsp"%>
<body>
<form method="POST" action="ValidateAdmin">
<center>

<p>Username:- <input type="text" name="username" required pattern="\w+"></p>
<p>Password:- <input type="password" name="pwd1" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"></p>

<p><input type="submit"></p>
 <span style="color:red;">${errMsg}</span>

<br><br>
<font color="red" size="12">For Authenticated Persons Only</font>
</center>
</form>
</body>
</html>