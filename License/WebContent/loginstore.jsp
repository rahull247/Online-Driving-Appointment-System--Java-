<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
response.setContentType("text/html");
String un=request.getParameter("uname");
String pass=request.getParameter("pass");
try
{
Class.forName("org.postgresql.Driver");
Connection con=DriverManager.getConnection("jdbc:postgresql:ollicence","postgres","postgres");
Statement s=con.createStatement();
String qry="select * from admin";
ResultSet rs=s.executeQuery(qry);
boolean flag=false;
while(rs.next())
{
	if(un.equals(rs.getString(2)) && pass.equals(rs.getString(3)))
	{
		flag=true;
	}
	
}
if(flag)
{
	out.println("Valid Admin");
}
else
{
	out.println("Invalid Username or passowrd");
}
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
</body>
</html>