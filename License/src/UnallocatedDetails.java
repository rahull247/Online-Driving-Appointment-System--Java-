

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UnallocatedDetails
 */
@WebServlet("/UnallocatedDetails")
public class UnallocatedDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnallocatedDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int appl_id=Integer.parseInt(request.getParameter("appl_id"));
		ArrayList list=(ArrayList)new ApplicantDAO().getApplDetails(appl_id);
		if(list!=null)
		{
			request.setAttribute("applDetails",list);
			RequestDispatcher rs = request.getRequestDispatcher("UnallocatedDetails.jsp");
			rs.forward(request,response);
		}else
		{
			request.setAttribute("unallocatedFlag", new Integer(1));
			request.setAttribute("allocatedFlag", new Integer(0));
			RequestDispatcher rs = request.getRequestDispatcher("NODETAILS.jsp");
			rs.forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
