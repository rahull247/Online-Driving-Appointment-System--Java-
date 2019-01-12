<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Print Application Form</title>
</head>

<%@ include file="c_header.jsp" %>
<script>
function formPrint()
{
	var id=document.getElementById("appId").value;
	if(id)
		{
		window.location="LinkPrintFrom?appId="+id;
		}
	else
		{
		alert("Please enter application id");
		}
	}

</script>
<body>
<center>
<h2>Print Application Form </h2>
<br>
Enter application no. : <input type=text name="appId" id="appId">
<input type=submit value=Submit onClick="return formPrint()" > 

</center>
</body>
</html>