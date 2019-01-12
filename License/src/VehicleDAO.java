import java.sql.*;
import java.util.*;

public class VehicleDAO
{
	private PreparedStatement ps;
	private ResultSet Res;
	ConnectionDAO c = new ConnectionDAO();
	public ArrayList dispVehicle()
	{
		Connection Con = c.getConnection();
		if(Con!=null)
			System.out.println("not null");
		ArrayList a=null;
		try
		{
			String query="select * from vehicle";
			ps=Con.prepareStatement(query);

			Res=ps.executeQuery();
			if(!Res.next())
			{
				return a;
			}
			a=new ArrayList();
			do
			{
				int v_id=Res.getInt("v_id");
				String cov=Res.getString("cov");
				String v_disc=Res.getString("v_disc");

				ArrayList f=new ArrayList();
				f.add(new Integer(v_id));
				f.add(cov);
				f.add(v_disc);
				a.add(f);
			}while(Res.next());
		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
			c.closeConnection();
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
	public static void main(String arg[])
	{
		VehicleDAO obj= new VehicleDAO();
		obj.dispVehicle();
	}

}
