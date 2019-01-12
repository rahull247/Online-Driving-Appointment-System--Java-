import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.sql.*;
import java.util.*;

import com.sun.imageio.plugins.common.InputStreamAdapter;


public class AdminDAO 
{
	
	private PreparedStatement ps;
	private ResultSet Res;
	ConnectionDAO c = new ConnectionDAO();
	
	boolean logIn(String username,String password)
	{
		Connection con = c.getConnection();

		try
		{
			
			String qry="select id from admin where username=? and password=?";
			ps=con.prepareStatement(qry);
			ps.setString(1,username);
			ps.setString(2,password);
			//System.out.println(ps.executeQuery());
			Res=ps.executeQuery();
			//System.out.println(Res.next());
			if(Res.next()!=false)
			{
				return true;
			}
			else
			{
				closeConnection();
				return false;
				
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	boolean insert(String username,String password) throws SQLException
	{
		try
		{
			Connection con = c.getConnection();
			if(username!=null && password!=null)
			{
				ps=con.prepareStatement("insert into admin(username,password) values(?,?)");
				ps.setString(1,username);
				ps.setString(2,password);
				int i=ps.executeUpdate();

				if(i>0)
				{
					System.out.println(i);
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public void closeConnection()
	{
		try
		{
			if(Res != null)
			{
				Res.close();
			}
			if(ps != null)
			{
				ps.close();
			}
		}
		catch(SQLException e)
		{

		}
	}	
	public static void main(String args[])
	{
		AdminDAO ad=new AdminDAO();
		ad.logIn("Chetan", "Jusslin@123");
	}
}
