import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RtoDAO {
	private PreparedStatement ps;
	private ResultSet Res;
	ConnectionDAO c = new ConnectionDAO();
	public ArrayList<String> getState()
	{
		Connection Con = c.getConnection();
		ArrayList a=null;
		try
		{
			String query="select distinct(state) from rto";
			ps=Con.prepareStatement(query);

			Res=ps.executeQuery();
			if(!Res.next())
			{
				return a;
			}
			a=new ArrayList();
			do
			{
				String state=Res.getString("state");
				ArrayList f=new ArrayList();
				f.add(state);
				a.add(f);
			}while(Res.next());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
	public ArrayList<String> getRtoDetails(String state)
	{
		Connection Con = c.getConnection();
		ArrayList a=null;
		try
		{
			String query="select * from rto where state=?";
			ps=Con.prepareStatement(query);
			ps.setString(1,state);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return a;
			}
			a=new ArrayList();
			do
			{
				int id=Res.getInt("id");
				String rto_code=Res.getString("rto_code");
				String rto_name=Res.getString("rto_name");
				String rto_addr=Res.getString("rto_addr");
				String pincode=Res.getString("pincode");
				String rto_phone=Res.getString("rto_phone");
				
				ArrayList f=new ArrayList();
				f.add(id);
				f.add(rto_code);
				f.add(rto_name);
				f.add(rto_addr);
				f.add(pincode);
				f.add(rto_phone);
				a.add(f);
				
			}while(Res.next());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
	public boolean insertRtoDetails(String state,String rto_code,String rto_name,String rto_addr,String rto_pin,String rto_phone)
	{
		Connection Con = c.getConnection();
		
		try
		{
			String query="insert into rto(state,rto_code,rto_name,rto_addr,pincode,rto_phone) values(?,?,?,?,?,?)";
			ps=Con.prepareStatement(query);
			ps.setString(1,state);
			ps.setString(2,rto_code);
			ps.setString(3,rto_name);
			ps.setString(4,rto_addr);
			ps.setString(5,rto_pin);
			ps.setString(6,rto_phone);
			
			int res=ps.executeUpdate();
			if(res<=0)
			{
				return false;
			}
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<String> getAllRtoDetails()
	{
		Connection Con = c.getConnection();
		ArrayList a=null;
		try
		{
			String query="select * from rto";
			ps=Con.prepareStatement(query);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return a;
			}
			a=new ArrayList();
			do
			{
				int id=Res.getInt("id");
				String rto_code=Res.getString("rto_code");
				String rto_name=Res.getString("rto_name");
				String rto_addr=Res.getString("rto_addr");
				String pincode=Res.getString("pincode");
				String rto_phone=Res.getString("rto_phone");
				String state=Res.getString("state");
				ArrayList f=new ArrayList();
				f.add(id);
				f.add(rto_code);
				f.add(rto_name);
				f.add(rto_addr);
				f.add(pincode);
				f.add(rto_phone);
				f.add(state);
				a.add(f);
				
			}while(Res.next());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
	public ArrayList<String> giveRtos(String state)
	{
		Connection Con = c.getConnection();
		ArrayList a=null;
		try
		{
			String query="select rto_name,id from rto where state=?";
			ps=Con.prepareStatement(query);
			ps.setString(1,state);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return a;
			}
			a=new ArrayList();
			do
			{
				int id=Res.getInt("id");
				String rto_name=Res.getString("rto_name");
				
				
				ArrayList f=new ArrayList();
				f.add(rto_name);
				f.add(id);
				a.add(f);
				
			}while(Res.next());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
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
			e.printStackTrace();
		}
	}
}
