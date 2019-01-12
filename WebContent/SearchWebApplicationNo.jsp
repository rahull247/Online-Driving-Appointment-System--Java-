<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Search Application No.</title>
<script type="text/javascript">
	function checkwebid(form) {
		var fname = document.getElementById("fname");
		var lname = document.getElementById("lname");
		var dob = document.getElementById("dob");
		
		if (fname.value == "" || fname.value == null) {
			alert("Enter The First Name");
			form.fname.focus();
			return false;
		} else
			
		re = /[!@#$%^&*()]/;
		if (re.test(fname.value)) {
			alert("Special Character will not work");
			fname.focus();
			return false;
		} else 
			
			if (lname.value == "" || lname.value == null) {
			alert("Enter The Last Name");
			return false;
		} else
			
			re = /[!@#$%^&*()]/;
		    if (re.test(lname.value)) {
			alert("Special Character will not work");
			lname.focus();
			return false;
		} else 
			
			if (dob.value == "" || dob.value == null || dob.value < 6) {
			alert("Check DOB(Date of Birth");
			return false;
		} else
			
			return true;	
	}
</script>
</head>
<%@include file="c_header.jsp"%>
<body >
	<form method="post" action="SearchWebApplicationNo" onsubmit="return checkwebid(this);">
		<center>
			<b>
				<table border="2" cellpadding="5">
					<tr>
						<th>Search Your Web Application ID:</th>
					</tr>
					<tr>
						<td>Enter Your First Name:&nbsp;&nbsp;&nbsp;&nbsp; <input
							type="text" name="fname" id="fname"></td>
					</tr>
					<tr>
						<td>Enter Your Last Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							type="text" name="lname" id="lname"></td>
					</tr>
					<tr>
						<td>Select Your Date Of Birth: <input type=date max="2000-01-01" name=dob required></td>
					</tr>
					<tr>
						<td>
							<center>
								<input type="submit" value="submit">
							</center>
						</td>
					</tr>
				</table>
			</b>
		</center>
	</form>
</body>
</html>