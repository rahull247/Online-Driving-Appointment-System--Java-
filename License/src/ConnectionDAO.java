import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDAO
{	
	public	Connection con;
	public Connection getConnection()
		{

			try
				{
					Class.forName("org.postgresql.Driver");
				}	
			catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			try
				{
    					con=DriverManager.getConnection("jdbc:postgresql:ollicence","postgres","postgres");
    					
				}
			catch(SQLException e)
				{
					e.printStackTrace();			
				}
			return con;
		}
	public void closeConnection()
		{
			try
				{
					if(con != null)
						{
							con.close();
						}
				}
			catch(SQLException e)
				{

				}	
		}
}
