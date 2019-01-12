import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDAO
{
	private PreparedStatement ps;
	private ResultSet Res;
	ConnectionDAO c = new ConnectionDAO();

	public boolean insert(int v_id, int appl_id,int rtoId, String l_type)
	{
		try
		{
			Connection con=c.getConnection();
			ps=con.prepareStatement("insert into test( appl_id, slot_id,v_id,rto_id, status,count,l_type) values(?,?,?,?,?,?,?)");

			ps.setInt(1,appl_id);
			ps.setInt(2, 0);
			ps.setInt(3,v_id);
			ps.setInt(4,rtoId);
			ps.setInt(5,0);
			ps.setInt(6, 0);
			ps.setString(7,l_type);
			
			int i=ps.executeUpdate();


			if(i>0)
			{
				System.out.println("Test details successfully inserted");
				return true;
			}
			else
			{
				return false;
			}

		}catch(SQLException e)
		{
			e.printStackTrace();

		}
		finally
		{
			closeConnection();
			c.closeConnection();
		}
		return false;

	}

	public ArrayList getDetails(int appl_id)
	{
		ArrayList a=null;
		try
		{
			Connection con=c.getConnection();
			

			String query="select * from test where appl_id=?";
			ps=con.prepareStatement(query);
			ps.setInt(1,appl_id);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return a;
			}
			a=new ArrayList();
			do
			{
				int id=Res.getInt("id");
				int appl_id1=Res.getInt("appl_id");
				int v_id=Res.getInt("v_id");
				int status=Res.getInt("status");

				ArrayList f=new ArrayList();
				f.add(new Integer(id));
				f.add(appl_id1);
				f.add(v_id);
				f.add(status);
				a.add(f);
			}while(Res.next());
					
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
		//	closeConnection();
			c.closeConnection();
		}
		return a;	
	}
	
	
	public ArrayList getAllDetails()
	{
		ArrayList a=null;
		try
		{
			Connection con=c.getConnection();
			

			String query="select * from test";
			ps=con.prepareStatement(query);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return a;
			}
			a=new ArrayList();
			do
			{
				int id=Res.getInt("t_id");
				int appl_id1=Res.getInt("appl_id");
				int slotId=Res.getInt("slot_id");
				int v_id=Res.getInt("v_id");
				int rtoId=Res.getInt("rto_id");
				int status=Res.getInt("status");
				int count=Res.getInt("count");

				ArrayList f=new ArrayList();
				f.add(new Integer(id));
				f.add(appl_id1);
				f.add(slotId);
				f.add(v_id);
				f.add(rtoId);
				f.add(status);
				f.add(count);
				a.add(f);
			}while(Res.next());
					
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
		//	closeConnection();
			c.closeConnection();
		}
		return a;	
	}

	
	

	public boolean updateStatus(int applId)
	{

		try{
			Connection oConnect = c.getConnection();
			String query="update test set status=1 where appl_id=?";
			ps=oConnect.prepareStatement(query);
			ps.setInt(1,applId);
			int res=ps.executeUpdate();

			if(res>0)
			{
				return true;
			}
			else{
				return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return false;
	}
	public boolean updateCount(int appl_id)
	{
		try{
			Connection oConnect = c.getConnection();
			String query="select count from test where appl_id=?";
			ps=oConnect.prepareStatement(query);
			ps.setInt(1,appl_id);
			Res=ps.executeQuery();
			if(Res.next())
			{
				int count=Res.getInt("count");
				if((++count)==3)
				{
					new ApplicantDAO().delete(appl_id);
					return true;
				}else
				{
					ps.close();
					Res.close();
					query="update test set count=? where appl_id=?";
					ps=oConnect.prepareStatement(query);
					ps.setInt(1,count);
					ps.setInt(2,appl_id);
					int res=ps.executeUpdate();
	
					if(res>0)
					{
						return true;
					}
					else{
						return false;
					}
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return false;
	}
	
	public boolean insertSlotId(int appId,int slotId)
	{
		
		try {
		 Connection con=c.getConnection();
		 String query="update test set slot_id=? where appl_id=?";
		ps=con.prepareStatement(query);
		ps.setInt(1, slotId);
		ps.setInt(2, appId);
		int count=ps.executeUpdate();
		
		if(count<=0)
			return false;
		else 
			return true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
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
		e.printStackTrace();
		}
	}
}
