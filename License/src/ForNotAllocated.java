

import java.io.IOException;
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
 * Servlet implementation class ForNotAllocated
 */
@WebServlet("/ForNotAllocated")
public class ForNotAllocated extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ApplicantDAO app=new ApplicantDAO();
	ConnectionDAO c = new ConnectionDAO();


	private PreparedStatement ps;
	private ResultSet Res;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForNotAllocated() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{

		ArrayList th=new ArrayList();
		th.add("Application ID");
		th.add("Name");
		th.add("Address");
		th.add("State");
		th.add("RTO");
		th.add("Test Date");
		th.add("Time Slot");
		th.add("Class Of Vehicle");
		th.add("Count");

		ArrayList applicantDetail=app.getApplicantDetails();
		if(applicantDetail!=null)
		{
			for(int i=0;i<applicantDetail.size();i++)
			{
				System.out.println("values "+applicantDetail.get(i));
			}
			req.setAttribute("details", applicantDetail);
			req.setAttribute("th", th);
			req.setAttribute("unallocatedFlag", new Integer(1));
			req.setAttribute("allocatedFlag", new Integer(0));
			RequestDispatcher rs = req.getRequestDispatcher("DisplayApplDetails.jsp");
			rs.forward(req,resp);
		}
		else
		{
			req.setAttribute("unallocatedFlag", new Integer(0));
			req.setAttribute("allocatedFlag", new Integer(1));
			RequestDispatcher rs = req.getRequestDispatcher("NODETAILS.jsp");
			rs.forward(req,resp);
		}
	}
}
