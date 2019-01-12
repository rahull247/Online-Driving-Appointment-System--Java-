

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LinkPrintFrom
 */
@WebServlet("/LinkPrintFrom")
public class LinkPrintFrom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ApplicantDAO appl=new ApplicantDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LinkPrintFrom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String appId1=request.getParameter("appId");
			int appId=Integer.parseInt(appId1);
			System.out.println(appId);
				ArrayList details=appl.getPrintDetails(appId);
				
				
				
				for(int i=0;i<details.size();i++)
				{
					System.out.println(details.get(i));
				}
				request.setAttribute("details", details);
				RequestDispatcher rs = request.getRequestDispatcher("PrintForm.jsp");
				rs.forward(request,response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
