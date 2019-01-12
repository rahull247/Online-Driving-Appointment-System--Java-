<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="c_header.jsp"%>
<script type="text/javascript"> 

function validate()
{
	var uname=document.AdminLogin.username.value;
	var pwd=document.AdminLogin.password.value;
	
	if(uname=="" || pwd=="")
		{
		alert("Fill all the details correctly");
		return false;
		}
	else
		return true;
	}


</script>
<center>
<form action="AdminLogin" name="AdminLogin" method="post" onsubmit="return validate()">
<br>
<h3>Login For Authorized Persons Only</h3><br><br>
Username&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username" ><br><br>
Password&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" ><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Login" onClick="">
</form>
</center>
</body>
</html>