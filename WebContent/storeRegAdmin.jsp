<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String uname=request.getParameter("txtuser");
String pass=request.getParameter("txtpass");
try
{
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection("jdbc:postgresql:ollicence","postgres","postgres");
	PreparedStatement ps=con.prepareStatement("insert into admin values(?,?)");
	ps.setString(2,uname);
	ps.setString(3,pass);
	int result=ps.executeUpdate();
	if(result>=1)
	{
		out.println("Regestered :-)");
		out.println("<a href='login'>Click Here To LogIn</a>");
	}
	out.println("Database Error");
	
}
catch(Exception e)
{
	e.printStackTrace();
}

%>
</body>
</html>