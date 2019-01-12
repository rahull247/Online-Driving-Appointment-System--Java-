<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NO DETAILS</title>
</head>
<script type="text/javascript">
function Select(elm)
{
window.location = elm.value;
}
</script>
<%@include file="a_header.jsp"%>
<body>
<div id=forAllocated>
<select name="formal" onchange="javascript:Select(this)">

<%
if((Integer)request.getAttribute("allocatedFlag")==1)
{%>
	<option value="ForAllocated" selected>Allocated</option>
<%}
else{
%>
<option value="ForAllocated">Allocated</option>

<%}
if((Integer)request.getAttribute("unallocatedFlag")==1)
{
%>
	<option value="ForNotAllocated" selected>Unallocated</option>
<%}
else{
%>
<option value="ForNotAllocated">Unallocated</option>
<%} %>
</select>
<br>
<br>
<center>
<h1>No Details To Display</h1>
</center>
</div>
</body>
</html>