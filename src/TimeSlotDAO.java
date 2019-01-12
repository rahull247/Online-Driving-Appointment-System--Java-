import java.sql.*;
import java.util.*;

public class TimeSlotDAO {

	private PreparedStatement ps;
	private ResultSet Res;
	ConnectionDAO c = new ConnectionDAO();

	public boolean insertTimeSlot(String date,String time){

		try{
			Connection con=c.getConnection();
			ps=con.prepareStatement("select * from timeslot where slot_date=? and slot_time=?");
			ps.setString(1,date);
			ps.setString(2,time);
			Res=ps.executeQuery();
			if(!Res.next()){
				ps.close();
				Res.close();
				ps=con.prepareStatement("insert into timeslot(slot_date,slot_time,count) values(?,?,?)");
				ps.setString(1, date);
				ps.setString(2, time);
				ps.setInt(3, 1);
				int i=ps.executeUpdate();
				if(i<=0){
					return false;
				}
				return true;
			}
			else{
				int id=Res.getInt("id");
				int count=Res.getInt("count");
				if(count!=75)
				{
					ps.close();
					Res.close();	
					ps=con.prepareStatement("update timeslot set count=? where id=?");
					ps.setInt(1,(count+1));
					ps.setInt(2, id);
					int i=ps.executeUpdate();
					if(i<=0)
					{
						return false;
					}
					return true;

				}
			}
		}catch(SQLException ex)
		{
			ex.printStackTrace();
			closeConnection();
			c.closeConnection();
		}finally{
			closeConnection();
			c.closeConnection();
		}
		return false;
	}

	public ArrayList getTimeSlots(String slot_date)
	{
		ArrayList a=null;
		try
		{
			Connection con=c.getConnection();
			ps=con.prepareStatement("select * from timeslot where slot_date=?");
			ps.setString(1,slot_date);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return a;
			}
			a=new ArrayList();
			do{
				int id=Res.getInt("id");
				String date=Res.getString("slot_date");
				String time=Res.getString("slot_time");
				int count =Res.getInt("count");
				
				ArrayList f=new ArrayList();
				f.add(id);
				f.add(date);
				f.add(time);
				f.add(count);
				a.add(f);				
			}while(Res.next());
		}catch(SQLException ex)
		{
			ex.printStackTrace();
			closeConnection();
			c.closeConnection();
		}finally{
			closeConnection();
			c.closeConnection();
		}


		return a;
	}

	public int getTotalCount(String slot_date)
	{
		int totalCount=0;
		try
		{
			Connection con=c.getConnection();
			ps=con.prepareStatement("select * from timeslot where slot_date=?");
			ps.setString(1,slot_date);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return totalCount;
			}

			do{
				int count=Res.getInt("count");
				totalCount+=count;

			}while(Res.next());
		}catch(SQLException ex)
		{
			ex.printStackTrace();
			closeConnection();
			c.closeConnection();
		}finally{
			closeConnection();
			c.closeConnection();
		}
		return totalCount;
	}

	public boolean allocateSlot(int appl_id,int slot_id)
	{
		
		try {
	
			Connection con=c.getConnection();
			String query="select count from timeslot where id=?";
			ps=con.prepareStatement(query);
			ps.setInt(1, slot_id);
			Res=ps.executeQuery();
			if(Res!=null)
			{	
				Res.next();
				int count=Res.getInt("count");
				
				if(count<40)
				{
					TestDAO dao=new TestDAO();
					if(dao.insertSlotId(appl_id, slot_id) && incCount(slot_id,count))
						return true;
					else 
						return false;
					
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
public boolean incCount(int slot_id, int count)
{
	Connection con=c.getConnection();
	String query="update timeslot set count=? where id=?";
	try {
		ps=con.prepareStatement(query);
		ps.setInt(1,(count+1));
		ps.setInt(2, slot_id);
		int status=ps.executeUpdate();
		if(status<=0)
			return false;
		else 
			return true;
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return false;
}
	public boolean cancelSlot(int appl_id)
	{
		
		try {
			
			Connection con=c.getConnection();
			String query="update test set slot_id=0 where appl_id=?";
			ps=con.prepareStatement(query);
			ps.setInt(1, appl_id);
			int count=ps.executeUpdate();
			if(count>0)
			{
				if(decCount(appl_id))
					return true;
				
			}else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
		
	}
	
	boolean decCount(int appl_id)
	{
		Connection con=c.getConnection();
		String query="select timeslot.id,timeslot.count from test,timeslot where test.appl_id=? and test.slot_id=timeslot.id ";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, appl_id);
			Res=ps.executeQuery();
			if(Res!=null);
			{
				Res.next();
				int id= Res.getInt("id");
				int count= Res.getInt("count");
				Res.close();
				ps.close();
				query="update timeslot set count=? where id=?";
				ps=con.prepareStatement(query);
				ps.setInt(1,(count-1));
				ps.setInt(2, id);
				int status=ps.executeUpdate();
				if(status>0)
				{
					return true;
				}
				else 
					return false;
				
			}
			
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
