import java.io.IOException;
import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ApplicantDAO
{
	private PreparedStatement ps;
	private ResultSet Res;
	ConnectionDAO c = new ConnectionDAO();

	public boolean insert(int appId, String fName,String mName,String lName,String dob,String gender,String phone,String mobile,String email,String birth_place,String flatNo,String houseName,String houseNo,String street,String locality,String city,String taluka,String district,String state,String pinCode,String perflatNo, String perhouseName, String perhouseNo, String perstreet, String perlocality, String percity, String pertaluka,String  perdistrict,String perstate,String  perpinCode,String nationality, String citizenship_type,String education,String identify_mark, String blood_group,String licence_no, int parentFlag, String parentName)	
	{
		Connection con = c.getConnection();
		boolean bFlag = false;
		try
		{
			System.out.println("In function insert Applicant");
			String address;
			String peraddress;
			if(flatNo!=null)                                       
				address= houseName+" Flat No:"+ flatNo +" "+houseNo+" "+ street+" "+locality+" "+city+" "+taluka+" "+district+" "+ state+" "+pinCode;
			else
			{
				address= houseName+" "+houseNo+" "+ street+" "+locality+" "+city+" "+taluka+" "+district+" "+ state+" "+pinCode;
			}
			
			if(perflatNo!=null)                                       
				peraddress= perhouseName+" Flat No:"+ perflatNo +" "+perhouseNo+" "+ perstreet+" "+perlocality+" "+percity+" "+pertaluka+" "+perdistrict+" "+ perstate+" "+perpinCode;
			else
			{
				peraddress= perhouseName+" "+perhouseNo+" "+ perstreet+" "+perlocality+" "+percity+" "+pertaluka+" "+perdistrict+" "+ perstate+" "+perpinCode;
			}
			
			ps=con.prepareStatement("insert into applicant(appId, fname, mname, lname, dob, gender, phone, mobile,email, place_of_birth, address, peraddress, nationality,  citizenship_type, education, identification_mark, blood_group , licence_no, parentFlag, parentName,status, created_at) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,appId);
			ps.setString(2,fName);
			ps.setString(3,mName);
			ps.setString(4,lName);
			ps.setString(5,dob);
			ps.setString(6,gender);
			ps.setString(7,phone);
			ps.setString(8,mobile);
			ps.setString(9,email);
			ps.setString(10,birth_place);
			ps.setString(11,address);
			ps.setString(12,peraddress);
			ps.setString(13,nationality);
			ps.setString(14,citizenship_type);
			ps.setString(15,education);
			ps.setString(16,identify_mark);
			ps.setString(17,blood_group);
			ps.setString(18,licence_no);
			ps.setInt(19,parentFlag);
			ps.setString(20,parentName);
			ps.setInt(21,0);
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd'/'mm'/'yyyy");
			ps.setString(22,sdf.format(date));

			int i=ps.executeUpdate();


			if(i>0)
			{
				System.out.println("Applicant details successfully inserted");
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
		return bFlag;
	}

	public ArrayList dispCust(int appId)
	{
		Connection oConnect = c.getConnection();
		ArrayList a=null;
		System.out.println("appId"+appId);
		try
		{
			String query="select * from applicant where appId=?";
			ps=oConnect.prepareStatement(query);
			ps.setInt(1,appId);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return a;
			}
			a=new ArrayList();
			do
			{
				int app_id=Res.getInt("appId");
				String fname=Res.getString("fname");
				String mname=Res.getString("mname");
				String lname=Res.getString("lname");
				String dob=Res.getString("dob");
				String gender=Res.getString("gender");
				String phone=Res.getString("phone");
				String mobile=Res.getString("mobile");
				String birth_place=Res.getString("birth_place");
				String address=Res.getString("address");
				String citizenship_type=Res.getString("citizenship_type");
				String identify_mark=Res.getString("identify_mark");
				String education=Res.getString("education");
				String blood_grp=Res.getString("blood_grp");
				String adharNo=Res.getString("adharNo");
				int parentFlag=Res.getInt("parentFlag");
				String parentName=Res.getString("parentName");
				int status =Res.getInt("status");

				ArrayList f=new ArrayList();
				f.add(new Integer(app_id));
				f.add(fname.toUpperCase());
				f.add(mname.toUpperCase());
				f.add(lname.toUpperCase());
				f.add(dob);
				f.add(gender.toUpperCase());
				f.add(phone);
				f.add(mobile);
				f.add(birth_place.toUpperCase());
				f.add(address.toUpperCase());
				f.add(citizenship_type.toUpperCase());
				f.add(identify_mark.toUpperCase());
				f.add(education.toUpperCase());
				f.add(blood_grp.toUpperCase());
				f.add(adharNo);
				f.add(parentFlag);
				f.add(parentName.toUpperCase());
				f.add(status);
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
		}
		return a;
	}
	
	
	
	
	public ArrayList getApplicantDetails()
	{
		Connection oConnect = c.getConnection();
		ArrayList a=null;
		
		try
		{
			String query="select appl_id,fname,mname,lname,address,state,cov,rto_code,rto_name,slot_date,slot_time,test.count " +
					"from applicant,vehicle,test,rto,timeslot where applicant.appid=test.appl_id and vehicle.v_id=test.v_id and " +
					"rto.id=test.rto_id and test.slot_id=timeslot.id and applicant.status=0";
			ps=oConnect.prepareStatement(query);
			
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return null;
			}
			a=new ArrayList();
			do{
				int app_id=Res.getInt("appl_id");
				String fname=Res.getString("fname");
				String mname=Res.getString("mname");
				String lname=Res.getString("lname");
				String address=Res.getString("address");
				String state=Res.getString("state");
				String rto_code=Res.getString("rto_code");
				String rto_name=Res.getString("rto_name");
				String slot_date=Res.getString("slot_date");
				String slot_time=Res.getString("slot_time");
				String count=Res.getString("count");
				String cov=Res.getString("cov");
				

				ArrayList f=new ArrayList();
				f.add(app_id);
				f.add(fname+" "+mname+" "+lname);
				f.add(address);
				f.add(state);
				f.add(rto_code+"-"+rto_name);
				if(slot_date.equals("21-2-2016"))
				{
					f.add("-");
					f.add("-");
				}else{
					f.add(slot_date);
					f.add(slot_time);
				}
				f.add(cov);
				f.add(count);
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
		}
		return a;
	}

	public ArrayList getPrintDetails(int appId) throws SQLException,IOException
	{
		Connection oConnect = c.getConnection();
		
		
		try
		{
			String query="select appid,fname,mname,lname,address,peraddress,cov,dob,place_of_birth,education," +
					"identification_mark,citizenship_type,blood_group from applicant,vehicle,test " +
					"where applicant.appid=test.appl_id and vehicle.v_id=test.v_id and applicant.appid=?";
			ps=oConnect.prepareStatement(query);
			ps.setInt(1,appId);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return null;
			}
			
				int app_id=Res.getInt("appid");
				String fname=Res.getString("fname");
				String mname=Res.getString("mname");
				String lname=Res.getString("lname");
				String address=Res.getString("address");
				String peraddress=Res.getString("peraddress");
				String cov=Res.getString("cov");
				String dob=Res.getString("dob");
				String birth_place=Res.getString("place_of_birth");
				String eduction=Res.getString("education");
				String identify_mark=Res.getString("identification_mark");
				String citizenship=Res.getString("citizenship_type");
				String blood_grp=Res.getString("blood_group");
				

				ArrayList f=new ArrayList();
				f.add(app_id);
				f.add(fname+" "+mname+" "+lname);
				f.add(mname);
				f.add(address);
				f.add(peraddress);
				f.add(dob);
				f.add(birth_place);
				f.add(eduction);
				f.add(identify_mark);
				f.add(citizenship);
				f.add(blood_grp);
				f.add(cov);
				return f;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return null;
	}

	
	public ArrayList getApplDetails1(int appl_id)
	{
		Connection oConnect = c.getConnection();
			
		try
		{
			String query="select appl_id,fname,mname,lname,address,state,cov,rto_code,rto_name,slot_date,slot_time " +
					"from applicant,vehicle,test,rto,timeslot where applicant.appid=? and applicant.appid=test.appl_id and vehicle.v_id=test.v_id and " +
					"rto.id=test.rto_id and test.slot_id=timeslot.id ";
			ps=oConnect.prepareStatement(query);
			ps.setInt(1, appl_id);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return null;
			}
			
			
				int app_id=Res.getInt("appl_id");
				String fname=Res.getString("fname");
				String mname=Res.getString("mname");
				String lname=Res.getString("lname");
				String address=Res.getString("address");
				String state=Res.getString("state");
				String rto_code=Res.getString("rto_code");
				String rto_name=Res.getString("rto_name");
				String slot_date=Res.getString("slot_date");
				String slot_time=Res.getString("slot_time");
				String cov=Res.getString("cov");
				

				ArrayList f=new ArrayList();
				f.add(app_id);
				f.add(fname+" "+mname+" "+lname);
				f.add(address);
				f.add(state);
				f.add(rto_code+"-"+rto_name);
				f.add(slot_date);
				f.add(slot_time);
				f.add(cov);
			return f;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return null;
	}
	
	public ArrayList getApplDetails(int appl_id)
	{
		Connection oConnect = c.getConnection();
		
		try
		{
			String query="select applicant.appid,fname,mname,lname,address,state,rto_code,rto_name,slot_date,slot_time,test.l_type,cov,test.count " +
					"from applicant,vehicle,test,rto,timeslot where applicant.appid=? and " +
					"applicant.appid=test.appl_id and vehicle.v_id=test.v_id and rto.id=test.rto_id and timeslot.id=test.slot_id";
			ps=oConnect.prepareStatement(query);
			ps.setInt(1,appl_id);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return null;
			}
			
				int app_id=Res.getInt("appid");
				String fname=Res.getString("fname");
				String mname=Res.getString("mname");
				String lname=Res.getString("lname");
				String address=Res.getString("address");
				String state=Res.getString("state");
				String rto_code=Res.getString("rto_code");
				String rto_name=Res.getString("rto_name");
				String l_type=Res.getString("l_type");
				String cov=Res.getString("cov");
				String slot_date=Res.getString("slot_date");
				String slot_time=Res.getString("slot_time");
				String count=Res.getString("count");
				

				ArrayList f=new ArrayList();
				f.add(app_id);
				f.add(fname+" "+mname+" "+lname);
				f.add(address);
				f.add(state);
				f.add(rto_code+"-"+rto_name);
				f.add(slot_date);
				f.add(slot_time);
				f.add(l_type);
				f.add(cov);
				f.add(count);
				return f;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return null;
	}
		
	
	public boolean delete(int appl_id)
	{
		Connection oConnect = c.getConnection();
		try{
			String query="delete from test where appl_id=?; delete from licence where appl_id=?; delete from applicant where appid=?";
			ps=oConnect.prepareStatement(query);
			ps.setInt(1, appl_id);
			ps.setInt(2, appl_id);
			ps.setInt(3, appl_id);
			int result=ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
		
	}
	
	
	public ArrayList getApplicantDetails1()
	{
		Connection oConnect = c.getConnection();
		ArrayList a=null;
		
		try
		{
			String query="select applicant.appid,fname,mname,lname,address,state,cov,rto_code,rto_name,l_no,licence.l_type,expiry_date,doi " +
					"from applicant,vehicle,test,rto,licence where " +
					"applicant.appid=test.appl_id and vehicle.v_id=test.v_id and rto.id=test.rto_id and test.appl_id=licence.appl_id and applicant.status=1; ";
			ps=oConnect.prepareStatement(query);
			
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return a;
			}
			a=new ArrayList();
			do
			{
				int app_id=Res.getInt("appid");
				String fname=Res.getString("fname");
				String mname=Res.getString("mname");
				String lname=Res.getString("lname");
				String address=Res.getString("address");
				String state=Res.getString("state");
				String rto_code=Res.getString("rto_code");
				String rto_name=Res.getString("rto_name");
				String l_no=Res.getString("l_no");
				String l_type=Res.getString("l_type");
				String expiry_date=Res.getString("expiry_date");
				String doi=Res.getString("doi");
				

				ArrayList f=new ArrayList();
				f.add(app_id);
				f.add(fname+" "+mname+" "+lname);
				f.add(address);
				f.add(state);
				f.add(rto_code+"-"+rto_name);
				f.add(l_no);
				f.add(l_type);
				f.add(expiry_date);
				f.add(doi);
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
		}
		return a;
	}
	
	
	
	public int searchWebId(String fname,String lname,String dob) throws SQLException,IOException
	{
		Connection oConnect = c.getConnection();
		
		
		try
		{
			String query="select appid from applicant where fname=? and lname=? and dob=?";
			ps=oConnect.prepareStatement(query);
			ps.setString(1,fname);
			ps.setString(2,lname);
			ps.setString(3,dob);
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return 0;
			}
			
				int app_id=Res.getInt("appid");
				return app_id;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return 0;
	}
	
	
	
	

	public ArrayList dispAllCust()
	{
		Connection oConnect = c.getConnection();
		ArrayList a=null;
		
		try
		{
			String query="select * from applicant";
			ps=oConnect.prepareStatement(query);
			
			Res=ps.executeQuery();
			if(!Res.next())
			{
				return a;
			}
			a=new ArrayList();
			do
			{
				int app_id=Res.getInt("appId");
				String fname=Res.getString("fname");
				String mname=Res.getString("mname");
				String lname=Res.getString("lname");
				String dob=Res.getString("dob");
				String gender=Res.getString("gender");
				String phone=Res.getString("phone");
				String mobile=Res.getString("mobile");
				String birth_place=Res.getString("place_of_birth");
				String address=Res.getString("address");
				String citizenship_type=Res.getString("citizenship_type");
				String identify_mark=Res.getString("identification_mark");
				String education=Res.getString("education");
				String blood_grp=Res.getString("blood_group");
				String adharNo=Res.getString("adhar_no");
				int parentFlag=Res.getInt("parentflag");
				String parentName=Res.getString("parentname");
				int status =Res.getInt("status");

				ArrayList f=new ArrayList();
				f.add(new Integer(app_id));
				f.add(fname);
				f.add(mname);
				f.add(lname);
				f.add(dob);
				f.add(gender);
				f.add(phone);
				f.add(mobile);
				f.add(birth_place);
				f.add(address);
				f.add(citizenship_type);
				f.add(identify_mark);
				f.add(education);
				f.add(blood_grp);
				f.add(adharNo);
				f.add(parentFlag);
				f.add(parentName);
				f.add(status);
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
		}
		return a;
	}

	public boolean updateStatus(int appId)
	{

		try{
			Connection oConnect = c.getConnection();
			String query="update applicant set status=1 where appId=?";
			ps=oConnect.prepareStatement(query);
			ps.setInt(1,appId);
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


	public static void main(String arg[])
	{
		ApplicantDAO obj= new ApplicantDAO();

		//obj.insert();
	}
}


