import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static void main(String args[])
	{
		Statement s;
		Connection c;
		ResultSet rs;
		String q="select * from admin";
		try
	    {
	            Class.forName("org.postgresql.Driver");
	            c=DriverManager.getConnection("jdbc:postgresql:ollicence","postgres","postgres");
	            if(c==null)
	            {
	                    System.out.println("Connection Cannot Created");
	            }
	            else
	            {
	                    s=c.createStatement();
	                    rs=s.executeQuery(q);
	                    while(rs.next())
	                    {
	                            System.out.println("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\n");
	                    }
	            }
	            c.close();
	    }
	    catch(Exception e)
	    {
	    	
	    }
	}
}
