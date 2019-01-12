<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New RTO</title>
</head>
<script type="text/javascript">
var code=request.getElementById("code");
var code=request.getElementById("code");
var code=request.getElementById("code");
var code=request.getElementById("code");



</script>
<%@include file="a_header.jsp"%>
<body>
<center>
<br>
<form name=newRTO method=POST action=AddNewRTO >
<table cellpadding=10>
<tr>
<td>State</td>
<td><input type=text name=state value=<%=request.getParameter("state") %> readonly></td>
</tr>
<tr>
<td>RTO Code</td>
<td><input type=text name=rto_code id=code></td>
</tr>
<tr>
<td>RTO Name</td>
<td><input type=text name=rto_name id=name></td>
</tr>
<tr>
<td>RTO Address</td>
<td><textarea rows="4" cols="50" name=rto_addr id=addr ></textarea></td>
</tr>
<tr>
<td>PIN code</td>
<td><input type=number name=rto_pin id=pinco></td>
</tr>
<tr>
<td>RTO Phone No</td>
<td><input type=number name=rto_phone id=phone></td>
</tr>
<tr>
<td></td>
<td><input type=submit name=addRto value="ADD RTO"></td>
</tr>
</table>
</form>
</center>
</body>
</html>