

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForAllocated
 */
@WebServlet("/ForAllocated")
public class ForAllocated extends HttpServlet 
{
	private static final long serialVersionUID = 1L;


	ApplicantDAO app=new ApplicantDAO();
	ConnectionDAO c = new ConnectionDAO();


	private PreparedStatement ps;
	private ResultSet Res;


	public ForAllocated() 
	{
		super();
	}
	@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList th=new ArrayList();
		th.add("Application ID");
		th.add("Name");
		th.add("Address");
		th.add("State");
		th.add("RTO");		
		th.add("Licanece NO");
		th.add("Licence Type");
		th.add("Expiry Date");
		th.add("Date Of Essue");

		ArrayList applicantDetail=app.getApplicantDetails1();
	
		if(applicantDetail!=null)
		{
			request.setAttribute("details",applicantDetail);
			request.setAttribute("th",th);
			request.setAttribute("unallocatedFlag", new Integer(0));
			request.setAttribute("allocatedFlag", new Integer(1));
			RequestDispatcher rs = request.getRequestDispatcher("DisplayApplDetails.jsp");
			rs.forward(request,response);
		}
		else
		{
			request.setAttribute("unallocatedFlag", new Integer(0));
			request.setAttribute("allocatedFlag", new Integer(1));
			RequestDispatcher rs = request.getRequestDispatcher("NODETAILS.jsp");
			rs.forward(request,response);
		}
	}	
}
