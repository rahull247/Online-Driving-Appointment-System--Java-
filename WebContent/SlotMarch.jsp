<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Slot Booking</title>
</head>

<%@include file="c_header.jsp" %>
<body>
<%
String id=request.getParameter("appId");
String l_type=request.getParameter("l_type");%>
 
 
 
<center><h1><font color=blue >Booking Appoinment For LL Test</font></h1></center>
<u>Calender Indicators</u><br>

<ul>
<li><font color=blue>Holiday</font></li><br>
<li><font color=green>Slots Available</font></li><br>
</ul>

<center>


<table border=1 width="50%">
<tr>
<td colspan="3"><center>Slots Available...Click on date to Book the Slot</center> </td>
</tr>
<tr>
<td><font color="#b3005a"> <a href="SlotFeb.jsp?appId=<%=id%>&l_type=<%=l_type%>">Previous Month </a></font></td>
<td><b> March 2016 </b></td>
<td> <font color="#b3005a"><a href="SlotApril.jsp?appId=<%=id%>&l_type=<%=l_type%>">Next Month-> </a></font></td>
</tr>
</table>


<table border=3 width="50%">
<tr>
<th>Sun</th>
<th>Mon</th>
<th>Tue</th>
<th>Wed</th>
<th>Thu</th>
<th>Fri</th>
<th>Sat</th>
</tr>

<tr>
<td></td>
<td></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=1/3/2016">1</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=2/3/2016">2</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=3/3/2016">3</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=4/3/2016">4</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=5/3/2016">5</a></font></td>
</tr>
<tr>
<td><font color=blue>6</font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=7/3/2016">7</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=8/3/2016">8</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=9/3/2016">9</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=10/3/2016">10</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=11/3/2016">11</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=12/3/2016">12</a></font></td>
</tr>
<tr>
<td><font color=blue>13</font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=14/3/2016">14</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=15/3/2016">15</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=16/3/2016">16</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=17/3/2016">17</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=18/3/2016">18</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=19/3/2016">19</a></font></td>
</tr><tr>
<td><font color=blue>20</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=21/3/2016">21</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=22/3/2016">22</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=23/3/2016">23</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=24/3/2016">24</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=25/3/2016">25</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=26/3/2016">26</a></font></td>
</tr>
<tr>
<td><font color=blue>27</font><v/td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=28/3/2016"">28</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=29/3/2016"">29</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=30/3/2016"">30</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=31/3/2016"">31</a></font></td>
</tr>




</table>
</center>


 
</body>
</html>