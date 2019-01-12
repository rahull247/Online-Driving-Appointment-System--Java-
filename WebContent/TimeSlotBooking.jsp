<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Slot Booking</title>
</head>
<%@include file="c_header.jsp" %>

<script>
function bookSlot()
{
	
	var radios = document.getElementsByName('slot');

	for (var i = 0, length = radios.length; i < length; i++) {
	    if (radios[i].checked) {
	        // do whatever you want with the checked radio
	        alert(radios[i].value);
	        window.location=radios[i].value;
	        // only one radio can be logically checked, don't check the rest
	        break;
	    }
	}
	
	
	
	}
</script>
<body>
<br><br>

<center><h1><font color=blue >Booking Appoinment For LL Test</font></h1></center>

<%ArrayList slots= (ArrayList)request.getAttribute("slots");
String l_type=(String)request.getAttribute("l_type");
String slot_date=(String)request.getAttribute("slot_date");
int appId=(Integer)request.getAttribute("appId");
%>
<center>
<h1>Select time slot for date <%=slot_date %></h1><br>
<br>
<table cellpadding=10>
<tr>
<th>Time Slot</th>
<th>Status</th>
</tr>
<% for(int i=0;i<slots.size();i++)
{%>
<tr>
<%
ArrayList  slot	=(ArrayList)slots.get(i);


	%>
<td><input type=radio name="slot" id="slot" value="AllocateSlot?appId=<%=appId%>&slot_id=<%=slot.get(0) %>"><%=slot.get(2) %></td>
<td><%=slot.get(3) %></td>
</tr>
<%} %>
</table>
<br><br>
<input type=submit value="Submit" onClick="return bookSlot()">
</center>
</body>
</html>