<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RTO Details</title>
</head>
<%@include file="a_header.jsp"%>
<body>
<div id=displayAdmin>
<center>
<a href="RtoDetailsAdmin1">Back</a>
<table border=1 cellpadding=5>

<%ArrayList th=(ArrayList)request.getAttribute("th");%> 
<tr><%
for(int i=0;i<th.size();i++)
{
%>
<th >
<%= th.get(i)%>
</th>
<%} %>
</tr>


<tr>
<%ArrayList state=(ArrayList)request.getAttribute("state"); 
for(int i=0;i<state.size();i++)
{
ArrayList values=(ArrayList)state.get(i);
%>
<tr>
<%for(int j=1;j<values.size();j++) 
{%>
<td>
<%= values.get(j)%>
</td>
<%} %>
</tr>
<%} %>
</tr>

</table>
</center>
</div>
</body>
</html>