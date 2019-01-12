<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Slot Cancellation</title>
</head>

<%@include file="c_header.jsp" %>

<script>
function goBack()
{
	window.location="SlotBookingPage1.jsp";
	}
</script>
<body>
<center>

<h1> 
Appointment Successfully Canceled...
</h1>

<input type=button value="Back to Slot Booking..." onClick="return goBack()">
</center>
</body>
</html>