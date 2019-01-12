<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Applicant Details</title>
</head>
<script language="javascript">
function save()
{
	var result=document.getElementById("result").value;
	
	if(result.match("None"))
	{
		alert(result);
		alert(typeof result);
		return false;
	}else{
		alert(result);
		window.location=result;
	}
}
</script>
<%@include file="a_header.jsp"%>
<body>

<%

ArrayList list=(ArrayList)request.getAttribute("applDetails");
%>
<center>
<table cellpadding=10>
<tr>
<td>Application Number</td>
<td>:</td>
<td><%=list.get(0)%></td>
</tr>
<tr>
<td>Name</td>
<td>:</td>
<td><%=list.get(1)%></td>
</tr>
<tr>
<td>Address</td>
<td>:</td>
<td><%=list.get(2)%></td>
</tr>
<tr>
<td>State</td>
<td>:</td>
<td><%=list.get(3)%></td>
</tr>
<tr>
<td>RTO name</td>
<td>:</td>
<td><%=list.get(4)%></td>
</tr>
<tr>
<td>Test Date</td>
<td>:</td>
<td><%=list.get(5)%></td>
</tr>
<tr>
<td>Time Slot</td>
<td>:</td>
<td><%=list.get(6)%></td>
</tr>
<tr>
<td>Licence Type</td>
<td>:</td>
<td><%=list.get(7)%></td>
</tr>
<tr>
<td>Class Of Vehicle</td>
<td>:</td>
<td><%=list.get(8)%></td>
</tr>

<tr>
<td>Count Of Test</td>
<td>:</td>
<td><%=list.get(9)%></td>
</tr>

<tr>
<td>Test Result</td>
<td>:</td>
<td>
<select name=result id=result>
<option value="None">None</option>
<option value="AllocateLicence?result=1&appl_id=<%=list.get(0) %>&rto=<%=list.get(4)%>&l_type=<%=list.get(7) %>">Pass</option>
<option value="AllocateLicence?result=2&appl_id=<%=list.get(0) %>&rto=<%=list.get(4)%>&l_type=<%=list.get(7) %>">Fail</option>
</select>
</td>
</tr>
<tr>
<td></td>
<td><input type="button" name=save value="Save" onClick="return save()"></td>
<td></td>
</tr>
</table>
</center>
</body>
</html>