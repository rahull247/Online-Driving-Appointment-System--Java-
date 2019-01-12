<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application No.</title>
</head>
<%@include file="c_header.jsp"%>
<body>
<% int arr=(Integer)request.getAttribute("appid");
 %>
<center><font size=18> Your Web Application No :-<%=arr %>
</font>
</center>


</body>
</html>