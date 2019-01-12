<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RTO Details</title>
</head>
<%int cflag=Integer.parseInt(request.getParameter("cflag")); %>
<%if(cflag==0)
	{%>
<%@include file="a_header.jsp"%>
<%}
else
{%>
<%@include file="a_header.jsp"%>
<%} %>
<script type="text/javascript">
function AddRTO()
{
	var state=document.getElementById("state");
window.location = "AddNewRTO.jsp?state="+state.value;
}
</script>

<body>
<div id=RtoAdmin>
<form method=get action="RtoDetailsAdmin2">
<center>
<table  cellpadding=15>
<tr >
<td colspan="2">
<select name="state" id="state"> State
 <%ArrayList arr=(ArrayList)request.getAttribute("state"); 

for(int j=0;j<arr.size();j++)
{
	ArrayList f=(ArrayList)arr.get(j);
	for(int i=0;i<f.size();i++)
	{
	%> 
	<option value="<%= f.get(i)%>"><%=f.get(i)%></option>
 <%
	}
}

%>
</select>
</td>
</tr>
<tr>
<td>
<center><input type="submit" value="View RTO details"></center>
</td>
<%if(cflag==0)
	{%>
<td><input type=button value="Add New RTO" onClick=AddRTO()></td>
<%} %>
</tr>
</table>
</center>
</form>
</div>
</body>
</html>