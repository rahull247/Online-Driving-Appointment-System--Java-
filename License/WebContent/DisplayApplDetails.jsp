<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Applicant Details</title>
<script type="text/javascript">
function Select(elm)
{
window.location = elm.value;
}

function deleteAppl(id)
{
	var flag=confirm("Do you really want to delete this record?");
	if(flag)
		{
			window.location="DeleteApplicant?appl_id="+id;		
		}else
			{
				return false;
			}
}

function unallocatedEdit(id)
{
	window.location = "UnallocatedDetails?appl_id="+id;
}
</script>

</head>
<%@include file="a_header.jsp"%>
<body>
<div id=forAllocated>

<select name="formal" onchange="javascript:Select(this)">

<%
int flag=(Integer)request.getAttribute("unallocatedFlag");
if((Integer)request.getAttribute("allocatedFlag")==1)
{%>
	<option value="ForAllocated" selected>Allocated</option>
<%}
else{
%>
<option value="ForAllocated">Allocated</option>

<%}
if(flag==1)
{
%>
	<option value="ForNotAllocated" selected>Unallocated</option>
<%}
else
{%>
<option value="ForNotAllocated">Unallocated</option>
<%} %>
</select>

<br>
<br>
<table border=5>

<%ArrayList th=(ArrayList)request.getAttribute("th");%> 
<tr><%
for(int i=0;i<th.size();i++)
{
%>
<th cellpadding=5>
<%= th.get(i)%>
</th>
<%} %>
</tr>



<%ArrayList applicants=(ArrayList)request.getAttribute("details"); 
for(int i=0;i<applicants.size();i++)
{	
ArrayList applDetails=(ArrayList)applicants.get(i);
%>
<tr>
<%for(int j=0;j<applDetails.size();j++) 
{
 %>

<td>
<%= applDetails.get(j)%>
</td>
<%} %>
<td>
<input type=button name=delete value=Delete onClick="return deleteAppl(<%=applDetails.get(0) %>)">
</td>

<% 

if(flag==1)
{ %>
<td><input type=button name=edit value=Edit onClick="return unallocatedEdit(<%=applDetails.get(0) %>)"></td>
<%}
else
{%>

<% }%>

</tr>
<%}%>
</table>
</div>
</body>
</html>