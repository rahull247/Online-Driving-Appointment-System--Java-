<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homepage</title>
</head>
<body>
<%@include file="c_header.jsp"%>

<center>
<div id="homeLinks" align="center">
<table rows=1 cols=2 Border=3 bordercolor="red" cellspacing="30"
	cellpadding="20">
	<tr> 
		<td>
		<ul type="DISC">
			<li><a href="">Apply online for</a>
			<ul type="Circle">
			<%int dlflag=0; %>
				<li><a href="FormDetails?dlflag=<%=0 %>">New Learners Licence</a>
				<li><a href="FormDetails?dlflag=<%=1 %>">New Driving Licence</a>
			</ul>
			<li><a href="PrintAppForm.jsp">Print Application form</a>
			<li><a href="Instructions.jsp">Instructins For LL / DL</a>
			
			<li><a href="SlotBookingPage1.jsp">Appointment for slot booking</a>
		</ul>
		</td>
		<td width="50%" height="110">
		<ul type="DISC">
			<li><a href="SearchWebApplicationNo.jsp">Search Web Application Number</a>
			<li><a href="RtoDetailsAdmin1?cflag=<%=1 %>">List of RTO in a State</a>
			
		</ul>
		</td>
	</tr>
</table>
</div>
</center>
</body>
</html>