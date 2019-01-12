

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertApplicantDetail
 */
@WebServlet("/InsertApplicantDetail")
public class InsertApplicantDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertApplicantDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			response.setContentType("text/html");
			
			String l_type=request.getParameter("l_type");		
			int appId=Integer.parseInt(request.getParameter("appId"));
			String fName=request.getParameter("fName");
			String mName=request.getParameter("mName");
			String lName=request.getParameter("lName");
			String dob=request.getParameter("birthday");
			String gender=request.getParameter("gender");
			String phone=request.getParameter("phone");
			String mobile=request.getParameter("mobile");
			String email=request.getParameter("email");
			String place_of_birth=request.getParameter("birth_place");
			String flatNo=request.getParameter("flatNo");
			String houseName=request.getParameter("houseName");
			String houseNo=request.getParameter("houseNo");
			String street=request.getParameter("street");
			String locality=request.getParameter("locality");
			String city=request.getParameter("city");
			String taluka=request.getParameter("taluka");
			String district=request.getParameter("district");
			String state=request.getParameter("addrstate");
			String pinCode=request.getParameter("pincode");		
			
			String perflatNo=request.getParameter("perflatNo");
			String perhouseName=request.getParameter("perhouseName");
			String perhouseNo=request.getParameter("perhouseNo");
			String perstreet=request.getParameter("perstreet");
			String perlocality=request.getParameter("perlocality");
			String percity=request.getParameter("percity");
			String pertaluka=request.getParameter("pertaluka");
			String perdistrict=request.getParameter("perdistrict");
			String perstate=request.getParameter("peraddrstate");
			String perpinCode=request.getParameter("perpincode");	
			
			String nationality=request.getParameter("nationality");
			String citizenship_type=request.getParameter("citizenship_type");
			String education=request.getParameter("education");
			String identification_mark=request.getParameter("identify_mark");
			String blood_group=request.getParameter("blood_grp");
			String licenceNo=null;
			if(l_type.equals("DL"))
				licenceNo=request.getParameter("liceceNo");
			int parentFlag=Integer.parseInt(request.getParameter("parentFlag"));
			String pFname=request.getParameter("parentName");
			String pMname=request.getParameter("fmname");
			String pLname=request.getParameter("flname");
			String parentName=pFname+" "+pMname+" "+pLname;
			int v_id=Integer.parseInt(request.getParameter("cov"));
			int rtoId=Integer.parseInt(request.getParameter("rtoId"));
			ApplicantDAO app=new ApplicantDAO();
			TestDAO test=new TestDAO();
			
			boolean result=app.insert(appId,fName, mName, lName, dob, gender, phone, mobile, email,place_of_birth, flatNo, houseName, houseNo, street, locality, city, taluka, district,state, pinCode, perflatNo, perhouseName, perhouseNo, perstreet, perlocality, percity, pertaluka, perdistrict,perstate, perpinCode,nationality, citizenship_type, education, identification_mark, blood_group, licenceNo, parentFlag, parentName);
			if(result)
			{
				boolean result1=test.insert(v_id,appId,rtoId,l_type);
				if(result1)
				{
					
					request.setAttribute("appId",appId);
					RequestDispatcher rs = request.getRequestDispatcher("ForPrinting");
					rs.forward(request,response);
					}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
