import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Random;


public class LicenceDAO {

	
	private PreparedStatement ps;
	private ResultSet Res;
	ConnectionDAO c = new ConnectionDAO();
	//appl_id l_no l_type expiry_date doi 

	public boolean insert(int appl_id, String rto_code,String l_type)
	{
		String l_no=createLicenceNo(rto_code);
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Calendar cal = Calendar.getInstance();
		System.out.print("Licence: "+l_no);
		System.out.print("date: "+dateFormat.format(cal.getTime()));
		String doi=""+dateFormat.format(cal.getTime());
		String expiryDate=null;
		if(l_type.equals("LL"))
		{
			cal.add(Calendar.MONTH, 3);
			expiryDate=dateFormat.format(cal.getTime());
			System.out.println(expiryDate);
		}else if(l_type.equals("DL"))
		{
			cal.add(Calendar.YEAR, 20);
			expiryDate=dateFormat.format(cal.getTime());
			System.out.println(expiryDate);
		}
		
		Connection con = c.getConnection();
		String query="insert into licence(appl_id,l_no,l_type,expiry_date,doi) values(?,?,?,?,?)";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, appl_id);
			ps.setString(2, l_no);
			ps.setString(3, l_type);
			ps.setString(4, expiryDate);
			ps.setString(5, doi);
			int count=ps.executeUpdate();
			if(count<=0)
			{
				return false;
			}
			else
			{
				if(new ApplicantDAO().updateStatus(appl_id))
					return true;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	public String createLicenceNo(String RTOCode)
	{
		int no=randomInteger(100000001, 999999999);
		
		return RTOCode+" "+no;
	}
	public int randomInteger(int min, int max) {

	    Random rand = new Random();

	    // nextInt excludes the top value so we have to add 1 to include the top value
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
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
}
