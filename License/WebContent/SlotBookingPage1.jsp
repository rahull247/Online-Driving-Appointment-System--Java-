<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<title>Slot Block </title>
</head>
<%@include file="c_header.jsp" %>

<script>
function confirmCancel()
{
	var check=document.getElementsByName("slotFlag").checked;
	var flag=document.getElementsByName("slotFlag").value;
	var id=document.getElementById("appId").value;
	if(flag.match("LLCancel") || flag.match("DLCancel"))
		{
		if(id)
			{
				var flag1=confirm("Do you really want to cancel your appointment for application no. "+id);
				if(flag1)
				{
				return true;		
				}else
					return false;
			}
		}
	}
</script>
<body>

<div  >
<center>
<br><br>
<form action="SlotServlet1" method=POST>
<h1	>Slot Booking</h1><br>
<table  cellpadding=80 >
<tr>
<td>
<ol >
<li><input type=radio name="slotFlag" value="LLBook">LL SLOT BOOKING</li><br>
<li><input type=radio name="slotFlag" value="DLBook">DL SLOT BOOKING</li><br>
<li>&nbsp;&nbsp;&nbsp;&nbsp;CANCELATION</li><br>
<ol >
<li><input type=radio name="slotFlag" value="LLCancel">CANCEL LL TEST APPOINTMENTS</li><br>
<li><input type=radio name="slotFlag" value="DLCancel">CANCEL DL TEST APPOINTMENTS</li>
</ul>
</ul>
</td>
<td>


Enter application no. : &nbsp;&nbsp;<input type=text name="appId" id="appId" required>
<input type=submit value="Submit">
</td>
</tr>
</table>
</form>
</center>
</div>
</body>
</html>