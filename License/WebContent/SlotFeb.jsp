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

<%String id=request.getAttribute("appId").toString();
String l_type=request.getAttribute("l_type").toString();%>


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
<td><font color="#b3005a"><a href=""> Previous Month </a></font></td>
<td><b> February 2016 </b></td>
<td> <font color="#b3005a"><a href="SlotMarch.jsp?appId=<%=id%>&l_type=<%=l_type%>">Next Month-></a> </font></td>
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
<td><font color=green>1</font></td>
<td><font color=green>2</font></td>
<td><font color=green>3</font></td>
<td><font color=green>4</font></td>
<td><font color=green>5</font></td>
<td><font color=green>6</font></td>
</tr>
<tr>
<td><font color=blue>7</font></td>
<td><font color=green>8</font></td>
<td><font color=green>9</font></td>
<td><font color=green>10</font></td>
<td><font color=green>11</font></td>
<td><font color=green>12</font></td>
<td><font color=green>13</font></td>
</tr>
<tr>
<td><font color=blue>14</font></td>
<td><font color=green>15</font></td>
<td><font color=green>16</font></td>
<td><font color=green>17</font></td>
<td><font color=green>18</font></td>
<td><font color=green>19</font></td>
<td><font color=green>20</font></td>
</tr>
<tr>
<td><font color=blue>21</font></td>
<td><font color=green>22</font></td>
<td><font color=green>23</font></td>
<td><font color=green>24</font></td>
<td><font color=green>25</font></td>
<td><font color=green>26</font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=27/2/2016">27</a></font></td>
</tr>
<tr>
<td><font color=blue><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date=28/2/2016">28</a></font></td>
<td><font color=green><a href="TimeSlotServlet?appId=<%=id%>&l_type=<%=l_type%>&date= 29/2/2016">29</a></font></td>
</tr>




</table>
</center>

</body>
</html>